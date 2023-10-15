package com.project.dazzleb.service;

import org.springframework.stereotype.Service;

import com.project.dazzleb.model.Response;
import com.project.dazzleb.model.SignUpModel;


@Service
public interface SignUpService {
	public Response createUser(SignUpModel datas);

	public Response editDedails(SignUpModel datas);

	public Response deleteDetails(String sNo);

	public Response login(SignUpModel datas);
	

	
	public Response getoneData(String sNo);


}
