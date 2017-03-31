package com.spring.app;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.spring.app.bean.Loginbean;
import com.spring.app.bean.UserDetailsBean;
import com.spring.app.model.User;
import com.spring.app.service.Occupied_apartmentService;
import com.spring.app.service.UserService;

@Controller
@SessionAttributes("user")
public class UserController {
	
	private UserService userService;
	
	@Autowired
	private Occupied_apartmentService occService;
	
	@Autowired(required=true)
	@Qualifier(value = "userService")
	public void setUserService(UserService ps){
		this.userService = ps;
	}
	
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String listPersons(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("listUsers", this.userService.listUsers());
		return "user";
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
			UserDetailsBean userinfo = this.userService.validate(loginBean);
			if(userinfo!=null){
				userinfo.setLease_start(this.getLeaseStart(userinfo.getUnit()));
				userinfo.setLease_end(this.getLeaseEnd(userinfo.getUnit()));
				model = new ModelAndView("welcome");
				model.addObject("user",userinfo);
				return model;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		model = new ModelAndView("login");
		return model;
	}
	
	@RequestMapping(value = "/complaint", method = RequestMethod.GET)
	public String gotoComplaint(Model model) {
		//create complaint bean and add it to this page
		return "complain";
	}
	
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String gotoWelcome(Model model) {
		//create complaint bean and add it to this page
		return "welcome";
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
}
