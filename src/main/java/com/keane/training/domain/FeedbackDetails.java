package com.keane.training.domain;

public class FeedbackDetails {
	private int userID;
	private String userName;
	private int vehicleID;
	private String vehicleName;
	private String feedback;
	
	

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public int getVehicleID() {
		return vehicleID;
	}

	public void setVehicleID(int vehicleID) {
		this.vehicleID = vehicleID;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	@Override
	public String toString() {
		return "FeedbackDetails [userID=" + userID + ", userName=" + userName + ", vehicleID=" + vehicleID
				+ ", vehicleName=" + vehicleName + ", feedback=" + feedback + "]";
	}

	
	
	
}
