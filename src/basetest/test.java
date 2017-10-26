package basetest;

import net.sf.json.JSONArray;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.xk.orm.UserInfo;
import com.xk.orm.UserRole;
import com.xk.service.AllService;

public class test extends SpringCaseTest{
	@Autowired
	private AllService allService;
	Logger logger=Logger.getLogger(test.class);
	@Test
	public void test(){
		//JSONArray fun=allService.getuserRoleFunctionBLL().SelectFunByUserid(1);
		//User fun=allService.getuserMapperBLL().LoginJudgy("xk", "123");
		UserRole info=new UserRole();
		info.setUserid(1);
		info.setRoleid(3);
		//JSONArray funlist=allService.getuserMapperBLL().selectallUser(info);
		//JSONArray funlist=allService.getuniBll().selectAllUnitName();
		//System.out.println(JSONArray.fromObject(allService.getroleMapperBLL().SelectAllRole("")));
		System.out.println(allService.getfunctionBLL().selectFuncByRoleid(1));
	}
}
