package com.project.dazzleb.model;

import java.sql.Date;

public class ProductModel {
	
	private String productName;
	private String productDescription;
	private String productImage;
	private float productRate;  
	private String designerDescription;
	private String createdBy;
	private String updatedBy;
	private Date  createdDate;
	private Date updatedDate;
	private String sNo;
	private String designerName;
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public String getProductImage() {
		return productImage;
	}
	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}
	public String getDesignerDescription() {
		return designerDescription;
	}
	public void setDesignerDescription(String designerDescription) {
		this.designerDescription = designerDescription;
	}
	public String getsNo() {
		return sNo;
	}
	public void setsNo(String sNo) {
		this.sNo = sNo;
	}
	public  float  getProductRate() {
		return productRate;
	}
	public void setProductRate( float productRate) {
		this.productRate = productRate;
	}
	public String getDesignerName() {
		return designerName;
	}
	public void setDesignerName(String designerName) {
		this.designerName = designerName;
	}

}
