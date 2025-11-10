package com.keane.training.domain;

public class AdminDetails {
	
	private int adminID;
	private String adminName;
	private String adminPassword;
	
	public AdminDetails() {
		
	}
	
	public AdminDetails(int adminID, String adminName, String adminPassword) {
		super();
		this.adminID = adminID;
		this.adminName = adminName;
		this.adminPassword = adminPassword;
	}

	public int getAdminID() {
		return adminID;
	}

	public void setAdminID(int adminID) {
		this.adminID = adminID;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Admin [adminID=");
		builder.append(adminID);
		builder.append(", adminName=");
		builder.append(adminName);
		builder.append(", adminPassword=");
		builder.append(adminPassword);
		builder.append("]");
		return builder.toString();
	}
	
	
}
