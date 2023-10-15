package com.project.dazzleb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.project.dazzleb.dao.DesignerDao;
import com.project.dazzleb.model.DesignerModel;
import com.project.dazzleb.model.Response;

@CrossOrigin("*")
@RestController
@RequestMapping("/designer")
public class DesignerController {
	@Autowired
	private DesignerDao dao;

	@PostMapping("/createDesigner")
	public ResponseEntity<Response> createDesigner(@RequestBody DesignerModel datas) {
		return ResponseEntity.ok(dao.createDesigner(datas));
	}

	@PutMapping("/editDesigner")
	public ResponseEntity<Response> editDesigner(@RequestBody DesignerModel datas) {
		return ResponseEntity.ok(dao.editDesigner(datas));

	}

	@PostMapping("/getAllDesigner")
	public ResponseEntity<Response> getAllDesignert() {
		return ResponseEntity.ok(dao.getAllDesigner());

	}

	@GetMapping("/getOneDesigner/{s_no}")
	public ResponseEntity<Response> getOneDesigner(@PathVariable String s_no) {
		return ResponseEntity.ok(dao.getOneDesigner(s_no));

	}

	@GetMapping("/getOneDesignerProduct/{s_no}")
	public ResponseEntity<Response> getOneDesignerProduct(@PathVariable String s_no) {
		return ResponseEntity.ok(dao.getOneDesignerProduct(s_no));

	}
}
