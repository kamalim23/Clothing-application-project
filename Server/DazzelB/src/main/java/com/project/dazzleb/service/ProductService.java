package com.project.dazzleb.service;

import org.springframework.stereotype.Service;
import com.project.dazzleb.model.ProductModel;
import com.project.dazzleb.model.Response;

@Service
public interface ProductService {

	public Response createProduct(String sNo, ProductModel datas);

//	public Response editProduct(ProductModel datas);
	public Response editProduct(String sNo, ProductModel datas);

	public Response deleteProduct(ProductModel datas);

	public Response getAllProduct();

	public Response getOneProduct(String sNo);

	public Response getonedata(String s_no);

	public Response getallproductbyspecificdes(String sNo);

}