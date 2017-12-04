package basetest;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import net.sf.json.JSONArray;

import org.apache.cxf.jaxrs.model.UserOperation;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.xk.ActivitiUtil.EnumData;
import com.xk.DaoImpl.AllDao;
import com.xk.orm.HangLine;
import com.xk.orm.PublicEntity;
import com.xk.orm.Role;
import com.xk.orm.UserRole;
import com.xk.service.AllService;

/**
 * @author: xk
 * @date:2017年11月9日 下午6:34:28
 * @version :
 * 
 */
public class test2 extends SpringCaseTest{
	@Autowired
	private AllService allService;
	@Autowired
	private AllDao allDao;
	Logger log=Logger.getLogger(test2.class);
	@Test
	public void  test() throws ParseException {
		/*PublicEntity en=new PublicEntity();
		en.setStatus(1);
		en.setOffset(0);
		en.setPageSize(5);
		en.setStarttime("2017-05-01");
		en.setFinishtime("2017-12-01");
		System.out.println(allService.getApplyMapperBLL().SelectApplyInfo(en));*/
		//String str="2017-11-15 00:00:00.0";
		//SimpleDateFormat simFormat=new SimpleDateFormat("yyyy-MM-dd");
		//System.out.println(simFormat.format(simFormat.parse(str)));
		/*List<Role> repairUser=allDao.getRoleMapperImpl().selectAllRole();
		int RepairId=0;
		for(Role role:repairUser)
		{
			if(role.getName().equals(EnumData.RepairUsers))
			{
				RepairId=role.getRoleid();
			}
		}
		List<UserRole> userinfo=allDao.getuserRoleMapperLmpl().SelectRepairUsers(RepairId);
		for(UserRole role:userinfo)
		{
			System.out.println(role.getUserid());
		}*/
		PublicEntity en=new PublicEntity();
		//en.setStatus(0);
		//en.setOffset(0);
		//en.setPageSize(40);
		en.setStarttime("2017-05-01");
		en.setFinishtime("2017-12-01");
		//en.setUserid(1);
		//en.setUnitid(1);
		//en.setStarttime("");
		en.setStatus(0);
		en.setType(0);
		//List<HangLine> list=allDao.getHangLineMapperImpl().SelectAllHangLine(en);
		//System.out.println(JSONArray.fromObject(allService.getFaultBLL().SelectAllFaultInfo(en)));
		//System.out.println(allDao.getHangLineMapperImpl().SelectAllHangLineCount(en));
		System.out.println(allService.getLinePoleBLL().SelectAllInfo(""));
	}
}
