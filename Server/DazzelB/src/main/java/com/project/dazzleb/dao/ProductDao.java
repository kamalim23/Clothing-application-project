package com.project.dazzleb.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import java.util.UUID;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Component;
import com.project.dazzleb.model.ProductModel;
import com.project.dazzleb.model.Response;
import com.project.dazzleb.service.ProductService;

@Component
public class ProductDao implements ProductService {

	Response res = new Response();
	String url = "jdbc:mysql://127.0.0.1:3306/boutique";
	String username = "root";
	String password = "Kamali@123";

	@Override
	public Response createProduct(String sNo, ProductModel datas) {
		String uuid = UUID.randomUUID().toString();
		datas.setsNo(uuid);
		datas.setCreatedBy(sNo);
		datas.setUpdatedBy(sNo);

		Date date = new Date(Calendar.getInstance().getTime().getTime());
		datas.setCreatedDate(date);
		datas.setUpdatedDate(date);

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try (Connection conn = DriverManager.getConnection(url, username, password);
					Statement st = conn.createStatement()) {
				String productquery = "INSERT INTO boutique.product_details"
						+ "(product_name,product_description,product_image,product_price,designer_description,created_by,updated_by,created_date,updated_date,s_no,designer_name)"
						+ "VALUES" + "( '" + datas.getProductName() + "','" + datas.getProductDescription() + "','"
						+ datas.getProductImage() + "','" + datas.getProductRate() + "','"
						+ datas.getDesignerDescription() + "','" + datas.getCreatedBy() + "','" + datas.getUpdatedBy()
						+ "','" + datas.getCreatedDate() + "','" + datas.getUpdatedDate() + "','" + datas.getsNo()
						+ "','" + datas.getDesignerName() + "')";
				System.out.println(productquery);
				st.executeUpdate(productquery);
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

	@SuppressWarnings("unchecked")
	@Override
	public Response editProduct(String sNo, ProductModel datas) {

		Date date = new Date(Calendar.getInstance().getTime().getTime());
		datas.setUpdatedDate(date);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try (Connection conn = DriverManager.getConnection(url, username, password);
					Statement st = conn.createStatement()) {
				String editquery = "UPDATE boutique.product_details SET product_name='" + datas.getProductName()
						+ "',product_description='" + datas.getProductDescription() + "',product_image='"
						+ datas.getProductImage() + "',product_price='" + datas.getProductRate()
						+ "',designer_description='" + datas.getDesignerDescription() + "',updated_date='"
						+ datas.getUpdatedDate() + "',designer_name='" + datas.getUpdatedDate() + "' WHERE s_no='"
						+ datas.getsNo() + "';";
				String getquery = "SELECT * FROM  boutique.product_details WHERE s_no= '" + sNo + "' ";
				ResultSet rs = st.executeQuery(getquery);
				JSONArray jsonArry = new JSONArray();
				while (rs.next()) {
					JSONObject jsonObject = new JSONObject();
					jsonObject.put("createdBy", rs.getString("created_by"));
					jsonArry.add(jsonObject);
				}

				System.out.println(editquery);
				System.out.println(getquery);
				st.executeUpdate(editquery);
				st.executeQuery(getquery);
				res.setResponseCode(200);
				res.setResponseMgs("success");
				res.setData("updated successfully !");
				res.setjData(jsonArry);

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
	public Response deleteProduct(ProductModel datas) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try (Connection conn = DriverManager.getConnection(url, username, password);
					Statement st = conn.createStatement()) {
				String deletequery = "DELETE FROM boutique.product_details  WHERE s_no = '" + datas.getsNo() + "'";
				System.out.println(deletequery);
				st.executeUpdate(deletequery);
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

	@SuppressWarnings("unchecked")
	@Override
	public Response getAllProduct() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String getAllquery = "SELECT * FROM  boutique.product_details";
			try (Connection conn = DriverManager.getConnection(url, username, password);
					Statement st = conn.createStatement();
					ResultSet rs = st.executeQuery(getAllquery);) {
				JSONArray jsonArry = new JSONArray();
				while (rs.next()) {
					JSONObject jsonObject = new JSONObject();
					jsonObject.put("productName", rs.getString("product_name"));
					jsonObject.put("productDescription", rs.getString("product_description"));
					jsonObject.put("productImage", rs.getString("product_image"));
					jsonObject.put("productRate", rs.getString("product_price"));
					jsonObject.put("designerDescription", rs.getString("designer_description"));
					jsonObject.put("designerName", rs.getString("designer_name"));

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
	public Response getOneProduct(String sNo) {
		System.out.println(sNo);

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String getOnequery = "SELECT * FROM  boutique.product_details WHERE created_by = '" + sNo + "' ";
			try (Connection conn = DriverManager.getConnection(url, username, password);
					Statement st = conn.createStatement();
					ResultSet rs = st.executeQuery(getOnequery);) {
				JSONArray jsonArry = new JSONArray();
				while (rs.next()) {
					JSONObject jsonObject = new JSONObject();

					jsonObject.put("productName", rs.getString("product_name"));
					jsonObject.put("productDescription", rs.getString("product_description"));
					jsonObject.put("productImage", rs.getString("product_image"));
					jsonObject.put("productRate", rs.getString("product_price"));
					jsonObject.put("designerDescription", rs.getString("designer_description"));
					jsonObject.put("designerName", rs.getString("designer_name"));
					jsonObject.put("sNo", rs.getString("s_no"));

					jsonArry.add(jsonObject);
				}
				res.setResponseCode(200);
				res.setResponseMgs("success");
				res.setData("get the product successfully !");
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
	public Response getonedata(String sNo) {

		System.out.println(sNo);

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String getOnequery = "SELECT * FROM  boutique.product_details WHERE s_no= '" + sNo + "' ";
			try (Connection conn = DriverManager.getConnection(url, username, password);
					Statement st = conn.createStatement();
					ResultSet rs = st.executeQuery(getOnequery);) {
				JSONArray jsonArry = new JSONArray();
				while (rs.next()) {
					JSONObject jsonObject = new JSONObject();

					jsonObject.put("productName", rs.getString("product_name"));
					jsonObject.put("productDescription", rs.getString("product_description"));
					jsonObject.put("productImage", rs.getString("product_image"));
					jsonObject.put("productRate", rs.getString("product_price"));
					jsonObject.put("designerDescription", rs.getString("designer_description"));
					jsonObject.put("designerName", rs.getString("designer_name"));
					jsonObject.put("sNo", rs.getString("s_no"));
					jsonObject.put("createdBy", rs.getString("created_by"));

					jsonArry.add(jsonObject);
				}
				res.setResponseCode(200);
				res.setResponseMgs("success");
				res.setData("get the product successfully !");
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
	public Response getallproductbyspecificdes(String sNo) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
//			String getOnequery = "SELECT * FROM  boutique.reg_details left join boutique.product_details on boutique.reg_details.s_no =boutique.product_details.created_by where boutique.reg_details.s_no = '"+sNo+"'";
			String getOnequery = "select * from boutique.product_details where created_by='" + sNo + "'";
			try (Connection conn = DriverManager.getConnection(url, username, password);
					Statement st = conn.createStatement();
					ResultSet rs = st.executeQuery(getOnequery);) {
				JSONArray jsonArry = new JSONArray();
				while (rs.next()) {
					JSONObject jsonObject = new JSONObject();

					jsonObject.put("productName", rs.getString("product_name"));
					jsonObject.put("productDescription", rs.getString("product_description"));
					jsonObject.put("productImage", rs.getString("product_image"));
					jsonObject.put("productRate", rs.getString("product_price"));
					jsonObject.put("designerDescription", rs.getString("designer_description"));
					jsonObject.put("designerName", rs.getString("designer_name"));
//					jsonObject.put("sNo", rs.getString("s_no"));
					jsonObject.put("createdBy", rs.getString("created_by"));

					jsonArry.add(jsonObject);
				}
				res.setResponseCode(200);
				res.setResponseMgs("success");
				res.setData("get the product successfully !");
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
