package com.spring.app;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.spring.app.bean.AllocateBean;
import com.spring.app.bean.ComplaintBean;
import com.spring.app.bean.ComplaintOut;
import com.spring.app.bean.Loginbean;
import com.spring.app.bean.RenewLeaseBean;
import com.spring.app.bean.UserDetailsBean;
import com.spring.app.model.Available_apartment;
import com.spring.app.model.Complaint;
import com.spring.app.model.Otp;

import com.spring.app.model.RenewLeaseModel;

import com.spring.app.model.User;

import com.spring.app.service.ApartmentService;

import com.spring.app.service.ApartmentServiceImpl;

import com.spring.app.service.ComplaintService;
import com.spring.app.service.Occupied_apartmentService;

import com.spring.app.service.OtpService;

import com.spring.app.service.RenewLeaseService;

import com.spring.app.service.UserService;

@Controller
@SessionAttributes("user")
public class UserController {
	
	private UserService userService;
	UserDetailsBean userinfo;
	
	@Autowired
	private Occupied_apartmentService occService;
	
	
	@Autowired
	@Qualifier(value = "renewService")
	private RenewLeaseService renewlease;
	
	@Autowired
	private ApartmentService apartmentService;
	
	@Autowired
	private ComplaintService complaintService;
	
	@Autowired
	private OtpService otpService;
	
	@Autowired(required=true)
	@Qualifier(value = "userService")
	public void setUserService(UserService ps){
		this.userService = ps;
	}
	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage(Model model) {
		Loginbean loginBean=new Loginbean();
		model.addAttribute("loginBean", loginBean);
		return "login";
	}
	
	@RequestMapping(value="/login.submit", method = RequestMethod.POST)
	public ModelAndView executeLogin(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("loginBean")Loginbean loginBean)
	{
		ModelAndView model= null;
		try
		{
			userinfo = this.userService.validate(loginBean);
			if(userinfo!=null){
				System.out.println("user name"+userinfo.getName() + userinfo.getType());
				if(userinfo.getType()==2){
					//resident login
					userinfo.setLease_start(this.getLeaseStart(userinfo.getUnit()));
					userinfo.setLease_end(this.getLeaseEnd(userinfo.getUnit()));
					model = new ModelAndView("welcome");
					model.addObject("user",userinfo);
					return model;
				}else if(userinfo.getType()==1){
					//staff login
					//available fields --> lease_start,lease_end,unit
					model = new ModelAndView("s_welcome");
					model.addObject("complaintout",new ComplaintOut());
					model.addObject("user",userinfo);
					model.addObject("listcomplaints",this.complaintService.listComplaints());
					System.out.println("got list sending to view");
					return model;
				}else if(userinfo.getType()==0){
					//manager login
					//available fields --> lease_start,lease_end,unit
					model = new ModelAndView("m_welcome");
					model.addObject("allocateBean",new AllocateBean());
					model.addObject("listcomplaints",this.complaintService.SLAbreachedComplaints());
					model.addObject("listapartment",this.getUnAllocatedApartments());
					model.addObject("user",userinfo);
					return model;
				}
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		model = new ModelAndView("login");
		model.addObject("result", "Incorrect credentials");
		return model;
	}
	//below method just opens the complaint page so that user can lodge the complaint
	@RequestMapping(value = "/complaint", method = RequestMethod.POST)
	public ModelAndView gotoComplaint(Model model) {
		ModelAndView model1=null;
		model1 = new ModelAndView("complain");
		return model1;
	}
	
	//when the complaint is lodged 
	@RequestMapping(value="/complaint.submit", method = RequestMethod.POST)
	public ModelAndView executeComplaint(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("ComplaintBean")ComplaintBean ComplaintBean )
	{			
				ComplaintBean.setUnit(userinfo.getUnit());
				ModelAndView model= null;
				this.complaintService.addComplaint(ComplaintBean);
				model=new ModelAndView("welcome");
				return model;	
	}
	
	@RequestMapping(value ="/complain_res", params = {"complaint_id","user"}, method = RequestMethod.GET)
	public ModelAndView resolveRequest(@RequestParam(value = "complaint_id") int complaint_id,@RequestParam(value = "user") String user, HttpServletRequest request) {
		System.out.println("In complain resolve function");
		Complaint c = new Complaint();
		//get the complaint by ID
		c = this.getComplaintById(complaint_id);
		//Update this complaint
		c.setResolved(1);
		c.setResolved_by(user);
		c.setResolved_time(System.currentTimeMillis());
		//Save this complaint in the Database
		this.UpdateComplaint(c);
		ModelAndView model = new ModelAndView("s_welcome");
		model.addObject("complaintout",new ComplaintOut());
		model.addObject("user",userinfo);
		model.addObject("listcomplaints",this.complaintService.listComplaints());
		System.out.println("got list sending to view");
		return model;
	}
	
	
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String gotoWelcome(Model model) {
		//create complaint bean and add it to this page
		return "welcome";
	}
	
	@RequestMapping(value="/allocate", method = RequestMethod.POST)
	public ModelAndView allocateApartment(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("allocateBean")AllocateBean allocateBean)
	{
		ModelAndView model= null;
		System.out.println(" "+allocateBean.getStart()+"  "+allocateBean.getEnd()+"  "+allocateBean.getUnit());
		model = new ModelAndView("m_welcome");
		Random r = new Random();
		int randNo = r.nextInt(99999)+100000;
		System.out.println(" "+randNo);

		model.addObject("otp", randNo);
		return model;
	}
	
	public Complaint getComplaintById(int id){
		return this.complaintService.getComplaint(id);
	}
	
	public void UpdateComplaint(Complaint c){
		this.complaintService.updateComplaint(c);
	}
	
	public Date getLeaseStart(String unit){
		return this.occService.getLeaseStaetDate(unit);
	}
	
	public Date getLeaseEnd(String unit){
		return this.occService.getLeasendDate(unit);
	}
	
	public float getBill(String unit){
		return this.occService.getBill(unit);
	}
	
	public List<Otp> getAllOTP(){
		return otpService.listOtp();
	}

	@Autowired(required=true)
	@Qualifier(value = "renewService")
	public void setRenewLeaseService(RenewLeaseService rs){
		this.renewlease = rs;
	}
	
	public List<Available_apartment> getUnAllocatedApartments(){
		List<Otp> otpList = this.getAllOTP();
		System.out.println("you are here in the inportant method != ");
		
		int flag=0;
		ArrayList<Available_apartment> list = (ArrayList<Available_apartment>) this.apartmentService.listApartments();
		ArrayList<Available_apartment> Sendlist = new ArrayList<Available_apartment>();
		for (Available_apartment available_apartment : list) {
			flag =0;
			for (Otp otp : otpList) {
				System.out.println(otp.getUnit()+ " != "+ available_apartment.getUnit());
				if(otp.getUnit().equals(available_apartment.getUnit())){
					System.out.println(otp.getUnit()+ " != "+ available_apartment.getUnit());
					flag=1;
				}
			}
			if(flag==0){
				Sendlist.add(available_apartment);
			}
		}
		return Sendlist;
	}

	@RequestMapping(value = "/renewlease",method = RequestMethod.POST)
	@Transactional
	public String renewLeasereq(@ModelAttribute("SpringWeb")RenewLeaseBean renewleasereq,Model model){
      RenewLeaseModel renew = new RenewLeaseModel();
      if(userinfo.getEmail()!=renew.getEmail()){
      renew.setApproval_status(true);
        renew.setEmail(userinfo.getEmail());
        renew.setExtenion_period(renewleasereq.getExtension_period());
        renew.setUnit(userinfo.getUnit());
        this.renewlease.addRenewLease(renew);
		return "welcome";
	}else{
		return "welcome";
	}
      }
}

