package com.project.dazzleb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.project.dazzleb.dao.EmailDao;
import com.project.dazzleb.model.Response;
import com.project.dazzleb.model.SignUpModel;

@CrossOrigin("*")
@RestController
@RequestMapping("/mail")
public class EmailController {

	@Autowired(required = true)
	private EmailDao dao;

	@PostMapping("/designer-booking/{s_no}")
	public ResponseEntity<Response> email(@PathVariable String s_no, @RequestBody SignUpModel data) {
		return ResponseEntity.ok(dao.email(s_no, data));

	}

}
