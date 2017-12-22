package com.xk.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.xk.DaoImpl.AllDao;
import com.xk.orm.Unit;
import com.xk.orm.User;
import com.xk.service.AllService;
@Controller
@SessionAttributes({"userid","name"})
@RequestMapping("/Login")
public class UserLogin {
	@Autowired 
	AllService allService;
	@Autowired
	AllDao alldao;
	@RequestMapping(value="/userLogin",method=RequestMethod.POST)
	public String UserLogin(HttpServletRequest req,HttpSession session,ModelMap map){
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		List<Unit> unitinfo=null;
		User user=allService.getuserMapperBLL().LoginJudgy(username, password);
		if(user!=null)
		{
			//map.addAttribute("userid",1+"");
			//map.addAttribute("name",username);
			session=req.getSession();
			//session.setAttribute("userid", 1);
			session.setAttribute("userid", user.getUserid()+"");
			session.setAttribute("loginname", username);
			unitinfo=alldao.getunitMapperImpl().selectAllUnitName();
			session.setAttribute("unitname","未找到信息");
			for(Unit unit:unitinfo)
			{
				if(user.getUnitid()==unit.getUnitid())
				{
					session.setAttribute("unitname", unit.getUnitname());
					session.setAttribute("unitid", unit.getUnitid());
				}
			}
			return "index";
		}
		else{
			return "login";
		}	
		
	}
}
