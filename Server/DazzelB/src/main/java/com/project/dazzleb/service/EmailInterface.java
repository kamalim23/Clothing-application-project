package com.project.dazzleb.service;

import org.springframework.stereotype.Service;
import com.project.dazzleb.model.Response;
import com.project.dazzleb.model.SignUpModel;

@Service
public interface EmailInterface {

	public Response email(String sNo, SignUpModel data);

}