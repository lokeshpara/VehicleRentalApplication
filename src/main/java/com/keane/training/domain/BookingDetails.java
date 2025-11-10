package com.keane.training.domain;

public class BookingDetails {
	private int bookingID;
	private int userID;
	private int vehicleID;
	private String userName;
	private String vehicleName;
	private String purchasedDate;
	private int no_of_Days;
	private float bookedPrice;
	private String vehicle_return_status;
	private int quantity;

	
	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

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

	public int getBookingID() {
		return bookingID;
	}

	public void setBookingID(int bookingID) {
		this.bookingID = bookingID;
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

	public String getPurchasedDate() {
		return purchasedDate;
	}

	public void setPurchasedDate(String purchasedDate) {
		this.purchasedDate = purchasedDate;
	}

	public int getNo_of_Days() {
		return no_of_Days;
	}

	public void setNo_of_Days(int no_of_Days) {
		this.no_of_Days = no_of_Days;
	}

	public float getBookedPrice() {
		return bookedPrice;
	}

	public void setBookedPrice(float bookedPrice) {
		this.bookedPrice = bookedPrice;
	}

	public String getVehicle_return_status() {
		return vehicle_return_status;
	}

	public void setVehicle_return_status(String vehicle_return_status) {
		this.vehicle_return_status = vehicle_return_status;
	}

	@Override
	public String toString() {
		return "BookingDetails [bookingID=" + bookingID + ", userID=" + userID + ", vehicleID=" + vehicleID
				+ ", userName=" + userName + ", vehicleName=" + vehicleName + ", purchasedDate=" + purchasedDate
				+ ", no_of_Days=" + no_of_Days + ", bookedPrice=" + bookedPrice + ", vehicle_return_status="
				+ vehicle_return_status + ", quantity=" + quantity + "]";
	}

	

	

	
	
}
