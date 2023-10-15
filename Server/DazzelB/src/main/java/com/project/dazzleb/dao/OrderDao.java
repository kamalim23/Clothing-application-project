package com.project.dazzleb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.dazzleb.model.OrederModel;
import com.project.dazzleb.model.ProductModel;
import com.project.dazzleb.model.Response;
import com.project.dazzleb.service.OrderService;

@Component
public class OrderDao implements OrderService {

	Response res = new Response();

	String url = "jdbc:mysql://127.0.0.1:3306/boutique";
	String username = "root";
	String password = "Kamali@123";

	String SNO;

	@SuppressWarnings("unchecked")
	public Response insertOrder(String sNo, OrederModel datas) {
		String uuid = UUID.randomUUID().toString();
		datas.setsNo(uuid);
		System.out.println(sNo);

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			try (Connection conn = DriverManager.getConnection(url, username, password);
					Statement st = conn.createStatement()) {

				String selectqury = "select s_no from boutique.reg_details where phone_number ='"
						+ datas.getRegisterMobileNumber() + "'";

				System.out.println(selectqury);

				ResultSet rs = st.executeQuery(selectqury);

				JSONArray jsonArray = new JSONArray();

				while (rs.next()) {

					SNO = rs.getString("s_no");

					JSONObject jsonObject = new JSONObject();
					jsonObject.put("sNo", rs.getString("s_no"));
					jsonArray.add(jsonObject);

				}

				String orderquery = "INSERT INTO boutique.order_details"
						+ "(s_no,cus_name,cus_mobileno,cus_location,dress_model,description,ordered_by,ordered_to)VALUES('"
						+ datas.getsNo() + "','" + datas.getCustomerName() + "','" + datas.getRegisterMobileNumber()
						+ "','" + datas.getCustomerLocation() + "','" + datas.getDressModel() + "','"
						+ datas.getDescriptionAboutDress() + "','" + SNO + "', '" + sNo + "');";
						

				System.out.println(orderquery);

				st.executeUpdate(orderquery);

				res.setResponseCode(200);
				res.setResponseMgs("success");
				res.setData("Order placed  successfully");

			} catch (Exception e) {
				e.printStackTrace();
				res.setResponseCode(500);
				res.setResponseMgs("failed");
				res.setData("Failed to placed");

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return res;
	}

	@SuppressWarnings("unchecked")
	public Response getoneorder(String s_no) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String getOnequery = "SELECT * FROM  boutique.order_details WHERE ordered_to= '" + s_no + "' ";
			try (Connection conn = DriverManager.getConnection(url, username, password);
					Statement st = conn.createStatement();
					ResultSet rs = st.executeQuery(getOnequery);) {
				JSONArray jsonArry = new JSONArray();
				while (rs.next()) {
					JSONObject jsonObject = new JSONObject();

					jsonObject.put("customerName", rs.getString("cus_name"));
					jsonObject.put("registerMobileNumber", rs.getString("cus_mobileno"));
					jsonObject.put("customerLocation", rs.getString("cus_location"));
					jsonObject.put("dressModel", rs.getString("dress_model"));
					jsonObject.put("descriptionAboutDress", rs.getString("description"));
					jsonObject.put("orderBy", rs.getString("ordered_by"));
					jsonObject.put("orderTo", rs.getString("ordered_to"));
					jsonObject.put("sNo", rs.getString("s_no"));

					jsonArry.add(jsonObject);
				}
				res.setResponseCode(200);
				res.setResponseMgs("success");
				res.setData("get the cutomer  successfully !");
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

	@Override
	public Response delete(String sNo) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try (Connection conn = DriverManager.getConnection(url, username, password);
					Statement st = conn.createStatement()) {

				String delete = "DELETE FROM  boutique.order_details  WHERE s_no = '" + sNo + "'";
				st.executeUpdate(delete);
				res.setResponseCode(200);
				res.setResponseMgs("success");
				res.setData("user deleted successfully !");

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
