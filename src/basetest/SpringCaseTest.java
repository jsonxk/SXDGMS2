package basetest;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/** 
 * 功能概要： 
 */  
//指定bean注入的配置文件  
@ContextConfiguration(locations={ "classpath:config/applicationContext.xml" })  
//使用标准的JUnit @RunWith注释来告诉JUnit使用Spring TestRunner  
@RunWith(SpringJUnit4ClassRunner.class)  
public abstract class SpringCaseTest extends AbstractJUnit4SpringContextTests{  
    protected Logger logger = LoggerFactory.getLogger(getClass());  
} 
