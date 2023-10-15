package com.project.dazzleb.model;

public class OrederModel {
	private String sNo;
	private String customerName;
	private String registerMobileNumber;
	private String customerLocation;
	private String dressModel;
	private String descriptionAboutDress;
	private String orderBy;
	private String orderTo;
	private String isCustomer;


	public String getIsCustomer() {
		return isCustomer;
	}

	public void setIsCustomer(String isCustomer) {
		this.isCustomer = isCustomer;
	}

	public String getOrderTo() {
		return orderTo;
	}

	public void setOrderTo(String orderTo) {
		this.orderTo = orderTo;
	}

	public String getsNo() {
		return sNo;
	}

	public void setsNo(String sNo) {
		this.sNo = sNo;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public String getRegisterMobileNumber() {
		return registerMobileNumber;
	}

	public void setRegisterMobileNumber(String registerMobileNumber) {
		this.registerMobileNumber = registerMobileNumber;
	}

	public String getCustomerLocation() {
		return customerLocation;
	}

	public void setCustomerLocation(String customerLocation) {
		this.customerLocation = customerLocation;
	}

	public String getDressModel() {
		return dressModel;
	}

	public void setDressModel(String dressModel) {
		this.dressModel = dressModel;
	}

	public String getDescriptionAboutDress() {
		return descriptionAboutDress;
	}

	public void setDescriptionAboutDress(String descriptionAboutDress) {
		this.descriptionAboutDress = descriptionAboutDress;
	}

}
