package com.project.dazzleb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.project.dazzleb.dao.OrderDao;
import com.project.dazzleb.model.OrederModel;
import com.project.dazzleb.model.Response;

@CrossOrigin("*")
@RestController
@RequestMapping("/order")
public class OrderController {
	@Autowired
	private OrderDao dao;

	@PostMapping("/insertorder/{s_no}")
	public ResponseEntity<Response> insertOrder(@PathVariable String s_no, @RequestBody OrederModel datas) {
		return ResponseEntity.ok(dao.insertOrder(s_no, datas));
	}
	

	@GetMapping("/getoneorder/{s_no}")
	public ResponseEntity<Response> getoneorder(@PathVariable String s_no) {
		return ResponseEntity.ok(dao.getoneorder(s_no ));
	}
	

	@DeleteMapping("/deleteorder/{s_no}")
	public ResponseEntity<Response> delete(@PathVariable String s_no ) {
		return ResponseEntity.ok(dao.delete(s_no));
	}


}
