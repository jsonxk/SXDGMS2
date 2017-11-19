package com.xk.ActivitiUtil;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
@WebService
public interface WebServiceimp {
	@WebMethod
	void RepositoryStart();
	@WebMethod
	List<Object> ProcessEngine();
	/**
	 * 启动流程
	 * @return
	 */
	@WebMethod
	List<Object> Playruntime();
	/**
	 * @return
	 */
	@WebMethod
	List<Object> TaskListen();
}
