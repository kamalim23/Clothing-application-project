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
import com.project.dazzleb.dao.ProductDao;
import com.project.dazzleb.model.ProductModel;
import com.project.dazzleb.model.Response;

@CrossOrigin("*")
@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductDao dao;

	@PostMapping("/createProduct/{s_no}")
	public ResponseEntity<Response> createProduct(@PathVariable String s_no, @RequestBody ProductModel datas) {
		return ResponseEntity.ok(dao.createProduct(s_no, datas));

	}

	@PutMapping("/editProduct/{s_no}")
	public ResponseEntity<Response> editProduct(@PathVariable String s_no, @RequestBody ProductModel datas) {
		return ResponseEntity.ok(dao.editProduct(s_no, datas));

	}

	@PostMapping("/deleteProduct")
	public ResponseEntity<Response> deleteProduct(@RequestBody ProductModel datas) {
		return ResponseEntity.ok(dao.deleteProduct(datas));

	}

	@PostMapping("/getAllProduct")
	public ResponseEntity<Response> getAllProduct() {
		return ResponseEntity.ok(dao.getAllProduct());

	}

	@GetMapping("/getOneProduct/{s_no}")
	public ResponseEntity<Response> getOneProduct(@PathVariable String s_no) {
		return ResponseEntity.ok(dao.getOneProduct(s_no));
	}

	@GetMapping("/getonedata/{s_no}")
	public ResponseEntity<Response> getonedata(@PathVariable String s_no) {
		return ResponseEntity.ok(dao.getonedata(s_no));

	}

	@GetMapping("/getallproductbyspecificdes/{s_no}")
	public ResponseEntity<Response> getallproductbyspecificdes(@PathVariable String s_no) {
		return ResponseEntity.ok(dao.getallproductbyspecificdes(s_no));

	}

}
