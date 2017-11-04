package com.xk.ActivitiUtil;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
@WebService
public interface WebServiceimp {
	@WebMethod
	List<Object> ProcessEngine();
}
