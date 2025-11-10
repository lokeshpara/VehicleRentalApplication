package com.keane.training.domain;

public class VehicleDetails {
	private int vehicleID;
	private String vehicleName;
	private String vehicleType;
	private String vehicleRegNo;
	private float vehiclePrice;
	private String vehicleAvailableStatus;

	public int getVehicleID() {
		return vehicleID;
	}

	public void setVehicleID(int vehicleID) {
		this.vehicleID = vehicleID;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getVehicleRegNo() {
		return vehicleRegNo;
	}

	public void setVehicleRegNo(String vehicleRegNo) {
		this.vehicleRegNo = vehicleRegNo;
	}

	public float getVehiclePrice() {
		return vehiclePrice;
	}

	public void setVehiclePrice(float f) {
		this.vehiclePrice = f;
	}

	public String getVehicleAvailableStatus() {
		return vehicleAvailableStatus;
	}

	public void setVehicleAvailableStatus(String vehicleAvailableStatus) {
		this.vehicleAvailableStatus = vehicleAvailableStatus;
	}

	@Override
	public String toString() {
		return "VehicleDetails [vehicleID=" + vehicleID + ", vehicleName=" + vehicleName + ", vehicleType="
				+ vehicleType + ", vehicleRegNo=" + vehicleRegNo + ", vehiclePrice=" + vehiclePrice
				+ ", vehicleAvailableStatus=" + vehicleAvailableStatus + "]";
	}
	
	
}
