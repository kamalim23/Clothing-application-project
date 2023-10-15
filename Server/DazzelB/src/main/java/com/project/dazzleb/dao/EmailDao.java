package com.project.dazzleb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import com.project.dazzleb.model.Response;
import com.project.dazzleb.model.SignUpModel;
import com.project.dazzleb.service.EmailInterface;

@Component
public class EmailDao implements EmailInterface {

	@Autowired(required = true)
	private JavaMailSender mailSender;

	String url = "jdbc:mysql://127.0.0.1:3306/boutique";
	String username = "root";
	String password = "Kamali@123";

	StringBuilder otp = new StringBuilder();
	String OTP;
	String toEmail;

	Response res = new Response();

	@SuppressWarnings("unchecked")
	@Override
	public Response email(String sNo, SignUpModel data) {
		try {
			Random random = new Random();
			for (int i = 0; i < 4; i++) {
				otp.append(random.nextInt(10));
				OTP = otp.toString();
			}

			System.out.println(OTP);

			Class.forName("com.mysql.cj.jdbc.Driver");
			String getAllquery = "SELECT s_no,first_name,email  FROM  boutique.reg_details WHERE s_no='" + sNo + "'";
			System.out.println(getAllquery);
			
			try (Connection conn = DriverManager.getConnection(url, username, password);
					Statement st = conn.createStatement();
					ResultSet rs = st.executeQuery(getAllquery);) {

				JSONObject jsonObject = new JSONObject();
				while (rs.next()) {
					jsonObject.put("sNo", rs.getString("s_no"));
					jsonObject.put("otp", OTP);
					jsonObject.put("designerSNo", data.getsNo());
					toEmail = rs.getString("email");
					System.out.println(toEmail);
				}

				System.out.println(data.getsNo());
				
				
				String fromMail = "manikamali02@gmail.com";
				String sendSubject = "New Customer Booked You!";
				String sendMessage = "Dear Customer, \n\n Thanks for using Sora's Collection. Kindly fill the below link and add your details. \n\nLink : http://localhost:3000/cusform/"+ data.getsNo() + " \n\nRegards, \n\nSora's Collections";
				SimpleMailMessage message = new SimpleMailMessage();
				message.setFrom(fromMail);
				message.setSubject(sendSubject);
				message.setText(sendMessage);
				message.setTo(toEmail);

				mailSender.send(message);
				res.setResponseMgs("SUCCESS");
				res.setResponseCode(200);
				res.setData("OTP sent successfully");
				res.setjData(jsonObject);

			} catch (Exception e) {
				e.printStackTrace();
				res.setResponseMgs("ERROR");
				res.setResponseCode(500);
				res.setData("Invalid Email");
			}

		} catch (Exception e) {
			e.printStackTrace();
			res.setResponseCode(500);
			res.setResponseMgs("faild");
			res.setData("Internal server error!");
		}

		return res;
	}

}
