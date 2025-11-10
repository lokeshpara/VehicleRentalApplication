package com.keane.training.domain;

public class DiscountDetails {
	private int days;
	private int no_of_vehicle;
	private int discount;
	
	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	public int getNo_of_vehicle() {
		return no_of_vehicle;
	}

	public void setNo_of_vehicle(int no_of_vehicle) {
		this.no_of_vehicle = no_of_vehicle;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	@Override
	public String toString() {
		return "DiscountDetails [days=" + days + ", no_of_vehicle=" + no_of_vehicle + ", discount=" + discount + "]";
	}
	
}
