package com.xk.ActivitiUtil;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
@WebService
public interface WebServiceimp {
	
	@WebMethod
	String Say(@WebParam(name="id") String id);
	@WebMethod
	List<Object> getlist();
	@WebMethod
	List<Object> ProcessEngine();
}
