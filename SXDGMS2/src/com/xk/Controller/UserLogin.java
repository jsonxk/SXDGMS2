package com.xk.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.xk.service.AllService;
@Controller
@SessionAttributes({"userid","name"})
@RequestMapping("/Login")
public class UserLogin {
	@Autowired 
	AllService allService;
	@RequestMapping(value="/userLogin",method=RequestMethod.POST)
	public String UserLogin(HttpServletRequest req,HttpSession session,ModelMap map){
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		if(allService.getuserMapperBLL().LoginJudgy(username, password)!=null)
		{
			map.addAttribute("userid",1+"");
			map.addAttribute("name",username);
			/*session=req.getSession();
			//session.setAttribute("userid", 1);
			session.setAttribute("userid", "jjjj");*/
			return "index";
		}
		else{
			return "Login";
		}	
		
	}
}
