package com.xk.Util;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
@WebService(endpointInterface="com.xk.Util.WebServiceimp")
public class WebServiceImpl implements WebServiceimp{
	@WebMethod
	@Override
	public List<Object> getlist() {
		// TODO Auto-generated method stub
		List<Object> list=new ArrayList<Object>();
		list.add("ss");
		list.add("bb");
		return list;
	}
	@WebMethod
	@Override
	public String Say(String id) {
		// TODO Auto-generated method stub
		System.out.println(id);
		return id;
	}
}
