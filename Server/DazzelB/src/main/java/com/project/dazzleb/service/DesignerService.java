package com.project.dazzleb.service;

import org.springframework.stereotype.Service;
import com.project.dazzleb.model.DesignerModel;
import com.project.dazzleb.model.Response;

@Service
public interface DesignerService {

//	public Response createDesigner(DesignerModel datas);

	public Response createDesigner(DesignerModel datas);

	public Response editDesigner(DesignerModel datas);

	public Response getAllDesigner();

	public Response getOneDesigner(String sNo);

	public Response getOneDesignerProduct(String s_no);

}
