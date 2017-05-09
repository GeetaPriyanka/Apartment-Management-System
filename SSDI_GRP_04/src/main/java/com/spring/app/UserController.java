package com.spring.app;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
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
import com.spring.app.bean.deleteApartmentBean;
import com.spring.app.model.Available_apartment;
import com.spring.app.model.Complaint;
import com.spring.app.model.Occupied_apartment;
import com.spring.app.model.Otp;
import com.spring.app.model.Renew_lease;
import com.spring.app.service.ApartmentService;
import com.spring.app.service.ComplaintService;
import com.spring.app.service.Occupied_apartmentService;
import com.spring.app.service.OtpService;
import com.spring.app.service.RenewLeaseService;
import com.spring.app.service.UserService;
import com.spring.mailer.contactMail;


@Controller
@SessionAttributes("user")
@Scope("session")
public class UserController {

	public UserService userService;
	
	UserDetailsBean userinfo;

	@Autowired
	contactMail mailer;
	
	@Autowired
	private Occupied_apartmentService occService;

	
	
	@Autowired
	@Qualifier(value = "renewService")
	private RenewLeaseService renewlease;

	@Autowired
	public ApartmentService apartmentService;

	@Autowired
	private ComplaintService complaintService;

	@Autowired
	public OtpService otpService;
	


	@Autowired(required=true)
	@Qualifier(value = "userService")
	public void setUserService(UserService ps){
		this.userService = ps;
	}


	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage(Model model) {
		Loginbean loginBean=new Loginbean();
		model.addAttribute("loginBean", loginBean);
		//mailer.sendMail("uncc.apartments@gmail.com","hhundiwa@uncc.edu","Thanks", "Its working!");
		return "login";
	}

	
	@RequestMapping(value="/login.submit", method = RequestMethod.POST)
	public ModelAndView executeLogin(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("loginBean")Loginbean loginBean) throws Exception
	{
		ModelAndView model= null;
			userinfo = userService.validate(loginBean);
			request.getSession().setAttribute("user_session", userinfo);
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
					model.addObject("listotp",this.getAllOTP());
					model.addObject("occ_apartment",this.allOccupiedApartment());
					model.addObject("user",userinfo);
					List<Renew_lease> leaseRequests=new ArrayList<Renew_lease>();
					leaseRequests=getLeaseRequest();
					if(leaseRequests!=null){
						System.out.println("lease requests size "+leaseRequests.size());
						model.addObject("leaseRequests",leaseRequests);
					}
					return model;
				}

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
		UserDetailsBean userinfo1 = (UserDetailsBean)request.getSession().getAttribute("user_session");
		System.out.println("1 : "+userinfo1.toString());
		System.out.println("2 : "+userinfo.toString());
		System.out.println("user" + userinfo.getEmail());
		System.out.println("user" + userinfo.getUnit());
		ComplaintBean.setUnit(userinfo.getUnit());
		ModelAndView model= null;
		this.complaintService.addComplaint(ComplaintBean);
		model=new ModelAndView("welcome");
		model.addObject("user",userinfo);
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


	@RequestMapping(value ="/allocates", params = {"start","end","unit"}, method = RequestMethod.GET)
	public ModelAndView allocateapt(@RequestParam(value = "start") Date start,@RequestParam(value = "end") Date end,@RequestParam(value = "unit") String unit, HttpServletRequest request) throws Exception {
		ModelAndView model3= null;
		int flag=0;
		System.out.println(" "+start+"  "+end+"  "+unit);
		model3 = new ModelAndView("otp");
		flag = this.checkOtp(unit);
		if(flag==-1){
			Random r = new Random();
			int randNo = r.nextInt(99999)+100000;
			System.out.println(" "+randNo);
			Otp o = new Otp();
			o.setStartDate(start);
			o.setEndDate(end);
			o.setUnit(unit);
			o.setOtp(randNo);
			this.otpService.addOtp(o);
			String op = "OTP generated for apartment "+ unit + " is :"+ randNo;
			model3.addObject("otp", randNo);
			model3.addObject("start", start);
			model3.addObject("end", end);
			model3.addObject("apartment", unit);
			
		}else{
			model3.addObject("otp", "OTP is already generated for apartment "+ unit + " is :"+ flag);
			model3.addObject("apartment", unit);
		}
//		model3.addObject("listcomplaints",this.complaintService.SLAbreachedComplaints());
//		model3.addObject("listapartment",this.getUnAllocatedApartments());
//		model3.addObject("listotp",this.getAllOTP());
//		model3.addObject("occ_apartment",this.allOccupiedApartment());
//		List<Renew_lease> leaseRequests=new ArrayList<Renew_lease>();
//		leaseRequests=getLeaseRequest();
//		if(leaseRequests!=null){
//			System.out.println("lease requests size "+leaseRequests.size());
//			model3.addObject("leaseRequests",leaseRequests);
//		}
		return model3;	 
	}
	
	
	@RequestMapping(value ="/manager_home", method = RequestMethod.GET)
	public ModelAndView load_manager(HttpServletRequest request) throws Exception {
		ModelAndView model3= null;
		model3 = new ModelAndView("m_welcome");
		model3.addObject("listcomplaints",this.complaintService.SLAbreachedComplaints());
		model3.addObject("listapartment",this.getUnAllocatedApartments());
		model3.addObject("listotp",this.getAllOTP());
		model3.addObject("occ_apartment",this.allOccupiedApartment());
		List<Renew_lease> leaseRequests=new ArrayList<Renew_lease>();
		leaseRequests=getLeaseRequest();
		if(leaseRequests!=null){
			System.out.println("lease requests size "+leaseRequests.size());
			model3.addObject("leaseRequests",leaseRequests);
		}
		return model3;	 
	}
	
	@RequestMapping(value ="/book",params = {"unit"}, method = RequestMethod.GET)
	public ModelAndView book(@RequestParam(value = "unit") String unit,HttpServletRequest request) throws Exception {
		ModelAndView model3= null;
		model3 = new ModelAndView("book");
		model3.addObject("unit",unit);
		return model3;	 
	}

	public int checkOtp(String unit) throws Exception{
		List<Otp> list = this.otpService.listOtp();
		if(list==null){
			return -1;
		}
		for (Otp otp : list) {
			if(otp.getUnit().equals(unit)){
				System.out.println("OTP already exists");
				return otp.getOtp();
			}
		}
		return -1;
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

	public void updateLeaseEndDate(String unit, Date leaseendDate, int months){
		 this.occService.updateLeaseEndDate(months, leaseendDate, unit);
	}

	public Date getLeaseEnd(String unit){
		return this.occService.getLeasendDate(unit);
	}

	public List<Occupied_apartment> allOccupiedApartment(){
		return this.occService.occupiedApartmentsList();
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
		List<Available_apartment> list = this.apartmentService.listApartments();
		List<Available_apartment> Sendlist = new ArrayList<Available_apartment>();
		for (Available_apartment available_apartment : list) {
			flag =0;
			for (Otp otp : otpList) {
				if(otp.getUnit().equals(available_apartment.getUnit())){
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
	public ModelAndView renewLeasereq(@ModelAttribute("SpringWeb")RenewLeaseBean renewleasereq,Model model){
		System.out.println("  -00- "+userinfo.getEmail());
		Renew_lease renew = new Renew_lease();
		ModelAndView model2= null;
		int flag = 0;
		List<Renew_lease> listRenew = this.getLeaseRequest();
		//System.out.println("  -00- "+listRenew.get(0).getEmail());

		for (Renew_lease renewLeaseModel : listRenew) {
			System.out.println(renewLeaseModel.getEmail()+"  -00- "+userinfo.getEmail());
			if(renewLeaseModel.getEmail().equals(userinfo.getEmail())){
				flag=1;
			}
		}
		if(flag==0){
			renew.setApproval_status(false);
			renew.setEmail(userinfo.getEmail());
			renew.setExtenion_period(renewleasereq.getExtension_period());
			renew.setUnit(userinfo.getUnit());
			this.renewlease.addRenewLease(renew);
			mailer.sendMailRequest_submitted(renew.getEmail());
			model2 = new ModelAndView("welcome");
			model2.addObject("result","Thank you for submitting request");
			return model2;
		}else{
			model2 = new ModelAndView("welcome");
			model2.addObject("result","Request is already submitted, it is currently being processed");
			return model2;
		}


	}

	public List<Renew_lease> getLeaseRequest(){
		return this.renewlease.listRenewLease();
	}
	public void updateLeaseStatus(String email){
		 this.renewlease.updateRenewLease(email);
	}
	public void deleteLeaseReq(String email){
		 this.renewlease.deleteRenewLease(email);
	}
//test
	@RequestMapping(value = "/leaseApproval",method = RequestMethod.POST)
	public ModelAndView leaseApproval(@RequestParam("name") String name, @RequestParam("type") String type
			,@RequestParam("unit") String unit,@RequestParam("month") int month){
		ModelAndView model;
		System.out.println("type: "+type);
		if(type.equals("accept")){
			updateLeaseStatus(name);
			Date leaseEnd=getLeaseEnd(unit);
			updateLeaseEndDate(unit, leaseEnd, month);	
			mailer.sendMailRequest_approved(name);
			deleteLeaseReq(name);
		}else if(type.equals("reject")){
			deleteLeaseReq(name);
			mailer.sendMailRequest_rejected(name);
		}
		model = new ModelAndView("m_welcome");
		model.addObject("allocateBean",new AllocateBean());
		model.addObject("listcomplaints",this.complaintService.SLAbreachedComplaints());
		model.addObject("listapartment",this.getUnAllocatedApartments());
		model.addObject("listotp",this.getAllOTP());
		model.addObject("occ_apartment",this.allOccupiedApartment());
		model.addObject("user",userinfo);
		List<Renew_lease> leaseRequests=new ArrayList<Renew_lease>();
		leaseRequests=getLeaseRequest();
		if(leaseRequests!=null){
			System.out.println("lease requests size "+leaseRequests.size());
			model.addObject("leaseRequests",leaseRequests);
		}
		return model;
	
	}


	@RequestMapping(value="/vacate.submit", method = RequestMethod.POST)
	public ModelAndView executevacate(HttpServletRequest request, HttpServletResponse response,@ModelAttribute("deleteApartmentBean")deleteApartmentBean deleteApartmentBean)
	{		
		String d=deleteApartmentBean.getVacate();
		int flag = 0;
		ModelAndView model1=new ModelAndView("m_welcome");
	      for (Available_apartment Available_aptlist: this.apartmentService.listApartments()) {
			if(Available_aptlist.getUnit().equals(d)){
				flag=1;
				System.out.println("Apartment has already been vacated");
			}
		}
	    if(flag==0)
	    {
			
			occService.deleteOccupiedApartment(d);
			apartmentService.addAvailableApartment(d);
			model1.addObject("result","Apartment has been vacated");
			model1.addObject("allocateBean",new AllocateBean());
			model1.addObject("listcomplaints",this.complaintService.SLAbreachedComplaints());
			model1.addObject("listapartment",this.getUnAllocatedApartments());
			model1.addObject("occ_apartment",this.allOccupiedApartment());
			model1.addObject("listotp",this.getAllOTP());
			model1.addObject("user",userinfo);
			List<Renew_lease> leaseRequests=new ArrayList<Renew_lease>();
			leaseRequests=getLeaseRequest();
			if(leaseRequests!=null){
				System.out.println("lease requests size "+leaseRequests.size());
				model1.addObject("leaseRequests",leaseRequests);
			}
			return model1;	 
		}
	    
	    else
	    {
	  		model1.addObject("result","No such occupied Apartment found");
	  		return model1;
	    }
	}
			
	//below method just opens the complaint page so that user can lodge the complaint
	@RequestMapping(value = "/pastReq", method = RequestMethod.GET)
	public ModelAndView gotopastComplaint(Model model) {
		ModelAndView model1=null;
		model1 = new ModelAndView("pastReq");
		model1.addObject("listcomplaints",this.complaintService.ResolvedComplaints());
		return model1;
	}

	
}	

