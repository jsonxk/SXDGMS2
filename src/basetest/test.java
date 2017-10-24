package basetest;

import net.sf.json.JSONArray;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.xk.orm.UserInfo;
import com.xk.service.AllService;

public class test extends SpringCaseTest{
	@Autowired
	private AllService allService;
	Logger logger=Logger.getLogger(test.class);
	@Test
	public void test(){
		//JSONArray fun=allService.getuserRoleFunctionBLL().SelectFunByUserid(1);
		//User fun=allService.getuserMapperBLL().LoginJudgy("xk", "123");
		UserInfo info=new UserInfo();
		info.setType("管理者");
		info.setUnitname("供电局");
		info.setName("xk");
		//JSONArray funlist=allService.getuserMapperBLL().selectallUser(info);
		//JSONArray funlist=allService.getuniBll().selectAllUnitName();
		System.out.println(allService.getroleMapperBLL().selectByUserid(1));
	}
}
