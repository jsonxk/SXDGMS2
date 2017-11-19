package basetest;



import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.xk.DaoImpl.AllDao;
import com.xk.orm.PublicEntity;
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
		PublicEntity en=new PublicEntity();
		en.setStatus(1);
		en.setOffset(0);
		en.setPageSize(5);
		en.setStarttime("2017-05-01");
		en.setFinishtime("2017-12-01");
		System.out.println(allService.getApplyMapperBLL().SelectApplyInfo(en));
		//String str="2017-11-15 00:00:00.0";
		//SimpleDateFormat simFormat=new SimpleDateFormat("yyyy-MM-dd");
		//System.out.println(simFormat.format(simFormat.parse(str)));
	}
}
