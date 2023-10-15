package com.project.dazzleb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Component;
import com.project.dazzleb.model.DesignerModel;
import com.project.dazzleb.model.Response;
import com.project.dazzleb.service.DesignerService;

@Component
public class DesignerDao implements DesignerService {

	Response res = new Response();
	String url = "jdbc:mysql://127.0.0.1:3306/boutique";
	String username = "root";
	String password = "Kamali@123";

	@Override
	public Response createDesigner(DesignerModel datas) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try (Connection conn = DriverManager.getConnection(url, username, password);
					Statement st = conn.createStatement()) {
				
				String desigenrquery = "INSERT INTO boutique.designer_details"
						+ "(designer_name,location,qualification,designer_image,designer_certification,s_no)VALUES('"
						+ datas.getDesignerName() + "','" + datas.getLocation() + "','"

						+ datas.getQualification() + "','" + datas.getDesignerImage() + "','" + datas.getCertification()
						+ "','" + datas.getsNo() + "');";
				System.out.println(desigenrquery);
				st.executeUpdate(desigenrquery);
				res.setResponseCode(200);
				res.setResponseMgs("success");
				res.setData("uploaded successfully");

			} catch (Exception e) {
				e.printStackTrace();
				res.setResponseCode(500);
				res.setResponseMgs("failed");
				res.setData("uploaded failed");

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public Response editDesigner(DesignerModel datas) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try (Connection conn = DriverManager.getConnection(url, username, password);
					Statement st = conn.createStatement()) {
				String editdesignerquery = "UPDATE boutique.designer_details SET designer_name ='"
						+ datas.getDesignerName() + "' ,location = '" + datas.getLocation() + "',qualification = '"
						+ datas.getQualification() + "',designer_image = '" + datas.getDesignerImage()
						+ "',designer_certification = '" + datas.getCertification() + "'WHERE s_no ='" + datas.getsNo()
						+ "'";

				System.out.println(editdesignerquery);
				st.executeUpdate(editdesignerquery);
				res.setResponseCode(200);
				res.setResponseMgs("success");
				res.setData("updated successfully !");

			} catch (Exception e) {
				e.printStackTrace();
				res.setResponseCode(500);
				res.setResponseMgs("failed");
				res.setData("Internal server error ! ");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return res;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Response getAllDesigner() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String getAllquery = "SELECT * FROM  boutique.designer_details";
			try (Connection conn = DriverManager.getConnection(url, username, password);
					Statement st = conn.createStatement();
					ResultSet rs = st.executeQuery(getAllquery);) {
				JSONArray jsonArry = new JSONArray();
				while (rs.next()) {
					JSONObject jsonObject = new JSONObject();
					jsonObject.put("designerName", rs.getString("designer_name"));
					jsonObject.put("location", rs.getString("location"));
					jsonObject.put("qualification", rs.getString("qualification"));
					jsonObject.put("designerImage", rs.getString("designer_image"));
					jsonObject.put("certification", rs.getString("designer_certification"));
					jsonObject.put("sNo", rs.getString("s_no"));

					jsonArry.add(jsonObject);
				}
				res.setResponseCode(200);
				res.setResponseMgs("success");
				res.setData("get all the user successfully !");
				res.setjData(jsonArry);

			} catch (Exception e) {
				e.printStackTrace();
				res.setResponseCode(500);
				res.setResponseMgs("faild");
				res.setData("Internal server error  !");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return res;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Response getOneDesigner(String sNo) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String getAllquery = "SELECT * FROM  boutique.designer_details WHERE s_no='" + sNo + "'";
			try (Connection conn = DriverManager.getConnection(url, username, password);
					Statement st = conn.createStatement();
					ResultSet rs = st.executeQuery(getAllquery);) {
				JSONArray jsonArry = new JSONArray();
				while (rs.next()) {
					JSONObject jsonObject = new JSONObject();
					jsonObject.put("designerName", rs.getString("designer_name"));
					jsonObject.put("location", rs.getString("location"));
					jsonObject.put("qualification", rs.getString("qualification"));
					jsonObject.put("designerImage", rs.getString("designer_image"));
					jsonObject.put("certification", rs.getString("designer_certification"));
					jsonObject.put("sNo", rs.getString("s_no"));
					jsonArry.add(jsonObject);
				}
				res.setResponseCode(200);
				res.setResponseMgs("success");
				res.setData("get one  successfully !");
				res.setjData(jsonArry);

			} catch (Exception e) {
				e.printStackTrace();
				res.setResponseCode(500);
				res.setResponseMgs("faild");
				res.setData("Internal server error  !");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return res;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Response getOneDesignerProduct(String s_no) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String getAllquery = "SELECT * FROM boutique.product_details where created_by ='" + s_no + "';";
			try (Connection conn = DriverManager.getConnection(url, username, password);
					Statement st = conn.createStatement();
					ResultSet rs = st.executeQuery(getAllquery);) {
				JSONArray jsonArry = new JSONArray();
				while (rs.next()) {
					JSONObject jsonObject = new JSONObject();
					jsonObject.put("productName", rs.getString("product_name"));
					jsonObject.put("productDescription", rs.getString("product_description"));
					jsonObject.put("productImage", rs.getString("product_image"));
					jsonObject.put("productPrice", rs.getString("product_price"));
					jsonObject.put("designerName", rs.getString("designer_name"));
					jsonArry.add(jsonObject);

				}
				res.setResponseCode(200);
				res.setResponseMgs("success");
				res.setData("get one  successfully !");
				res.setjData(jsonArry);

			} catch (Exception e) {
				e.printStackTrace();
				res.setResponseCode(500);
				res.setResponseMgs("faild");
				res.setData("Internal server error  !");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return res;
	}
}
