package com.keane.training.domain;

public class User {
	private int portalID;
	private String name;
	private int employeeId;
	private String technology;
	private String password;

	public int getPortalID() {
		return portalID;
	}

	public void setPortalID(int portalID) {
		this.portalID = portalID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [portalID=");
		builder.append(portalID);
		builder.append(", name=");
		builder.append(name);
		builder.append(", employeeId=");
		builder.append(employeeId);
		builder.append(", technology=");
		builder.append(technology);
		builder.append(", password=");
		builder.append(password);
		builder.append("]");
		return builder.toString();
	}

}
