package com.project.dazzleb.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import java.util.UUID;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Component;
import com.project.dazzleb.model.Response;
import com.project.dazzleb.model.SignUpModel;
import com.project.dazzleb.service.SignUpService;

@Component
public class SignUpDao implements SignUpService {

	Response res = new Response();

	String url = "jdbc:mysql://127.0.0.1:3306/boutique";
	String username = "root";
	String password = "Kamali@123";

	@Override
	public Response createUser(SignUpModel datas) {

		String uuid = UUID.randomUUID().toString();
		datas.setsNo(uuid);
		datas.setCreatedBy(uuid);
		datas.setUpdatedBy(uuid);

		Date date = new Date(Calendar.getInstance().getTime().getTime());
		datas.setCreatedDate(date);
		datas.setUpdatedDate(date);
//		datas.setIsDesigner(1);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try (Connection conn = DriverManager.getConnection(url, username, password);
					Statement st = conn.createStatement()) {
				System.out.println(datas.getFirstName());

				String insertquery = "INSERT INTO boutique.reg_details"
						+ "(s_no,first_name,last_name,age,email,password,phone_number,location,is_designer,created_by,updated_by,created_date,updated_date)VALUES('"
						+ datas.getsNo() + "','" + datas.getFirstName() + "','" + datas.getLastName() + "',"
						+ datas.getAge() + ",'" + datas.getEmail() + "','" + datas.getPassword() + "',"
						+ datas.getPhoneNumber() + ",'" + datas.getLocation() + "','" + datas.getIsDesigner() + "','"
						+ datas.getCreatedBy() + "','" + datas.getUpdatedBy() + "','" + datas.getCreatedDate() + "','"
						+ datas.getUpdatedDate() + "')";

				System.out.println(insertquery);
				st.executeUpdate(insertquery);
				res.setResponseCode(200);
				res.setResponseMgs("success");
				res.setData("user created successfully !");

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

	@Override
	public Response editDedails(SignUpModel datas) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try (Connection conn = DriverManager.getConnection(url, username, password);
					Statement st = conn.createStatement()) {
				String editquery = "UPDATE boutique.reg_details SET first_name = '" + datas.getFirstName()
						+ "' ,last_name = '" + datas.getLastName() + "',age = " + datas.getAge() + " ,email = '"
						+ datas.getEmail() + "' ,password = '" + datas.getPassword() + "' ,phone_number ="
						+ datas.getPhoneNumber() + " ,location ='" + datas.getLocation() + "' ,updated_date = '"
						+ datas.getUpdatedDate() + "'WHERE s_no ='" + datas.getsNo() + "';";
				System.out.println(editquery);
				st.executeUpdate(editquery);
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

	@Override
	public Response deleteDetails(String sNo) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try (Connection conn = DriverManager.getConnection(url, username, password);
					Statement st = conn.createStatement()) {
				String deletequery = "UPDATE  boutique.reg_details SET is_designer = 0 WHERE s_no = '" + sNo + "';";
				System.out.println(deletequery);
				st.executeUpdate(deletequery);
				res.setResponseCode(200);
				res.setResponseMgs("success");
				res.setData("user deleted successfully !");

			} catch (Exception e) {
				e.printStackTrace();
				res.setResponseCode(500);
				res.setResponseMgs("failed");
				res.setData("user delete to failed ! ");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return res;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Response login(SignUpModel datas) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println(datas.getEmail());
			System.out.println(datas.getPassword());
			String selectquery = "SELECT * FROM boutique.reg_details WHERE email='" + datas.getEmail()
					+ "' AND password = '" + datas.getPassword() + "'";
			try (Connection conn = DriverManager.getConnection(url, username, this.password);
					PreparedStatement pst = conn.prepareStatement(selectquery)) {
				ResultSet rs = pst.executeQuery(selectquery);

				JSONObject jsonObject = new JSONObject();

				if (rs.next()) {
					if (String.valueOf(rs.getInt("is_designer")).equalsIgnoreCase("1")) {
						res.setData("Designer");
						jsonObject.put("sNo", rs.getString("s_no"));
						jsonObject.put("isDesigner", rs.getInt("is_designer"));

						res.setjData(jsonObject);
					} else if (String.valueOf(rs.getInt("is_designer")).equalsIgnoreCase("0")) {
						res.setData("Customer");
						jsonObject.put("sNo", rs.getString("s_no"));
						jsonObject.put("isDesigner", rs.getInt("is_designer"));

						res.setjData(jsonObject);
					}
				} else {
					res.setData("User Does Not Exist!");
				}

				res.setResponseCode(200);
				res.setResponseMgs("success");

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
	public Response getoneData(String sNo) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String getAllquery = "SELECT s_no,first_name,email  FROM  boutique.reg_details WHERE s_no='" + sNo + "'";
			try (Connection conn = DriverManager.getConnection(url, username, password);
					Statement st = conn.createStatement();
					ResultSet rs = st.executeQuery(getAllquery);) {

				JSONObject jsonObject = new JSONObject();

				while (rs.next()) {
					jsonObject.put("sNo", rs.getString("s_no"));
					jsonObject.put("firstName", rs.getString("first_name"));
					jsonObject.put("email", rs.getString("email"));
				}
				res.setResponseCode(200);
				res.setResponseMgs("success");
				res.setData("get one  successfully !");
				res.setjData(jsonObject);

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
