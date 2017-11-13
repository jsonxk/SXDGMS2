package basetest;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

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
	Logger log=Logger.getLogger(test2.class);
	@Test
	public void  test() {
		System.out.println(allService.getuniBll().selectUnitByname("", "55", 10, 0));
	}
}
