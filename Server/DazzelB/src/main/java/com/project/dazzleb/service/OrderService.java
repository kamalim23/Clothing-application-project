package com.project.dazzleb.service;

import com.project.dazzleb.model.OrederModel;
import com.project.dazzleb.model.Response;

public interface OrderService {
	public Response insertOrder(String sNo, OrederModel datas);
	public Response getoneorder(String s_no);
	public Response delete(String sNo) ;

}
