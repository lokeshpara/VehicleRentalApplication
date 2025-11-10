package com.keane.training.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.keane.dbfw.ResultMapper;
import com.keane.training.domain.AdminDetails;
import com.keane.training.domain.BookingDetails;
import com.keane.training.domain.DiscountDetails;
import com.keane.training.domain.FeedbackDetails;
import com.keane.training.domain.User;
import com.keane.training.domain.UserDetails;
import com.keane.training.domain.VehicleDetails;

public class SqlMapper {

	public static final String FETCH_ADMIN = "select * from admin_details where adminName=?";
	public static final String FETCH_LOGIN_USER = "select * from user_details where userName=? ";
	public static final String FETCH_USER_ID = "select * from user_details where userID=? ";
	public static final String FETCH_USER = "select * from user_details";
	public static final String FETCH_VEHICLE = "select * from vehicle_details";
	public static final String FETCH_VEHICLE_ID = "select * from vehicle_details where vehicleID=?";
	public static final String FETCH_BOOKINGDETAILS = "select * from booking_details";
	public static final String FETCH_STATUS_BOOKED_VEHICLE = "select * from booking_details where vehicle_return_status=?";
	public static final String FETCH_DISCOUNT = "select * from discount";
	public static final String FETCH_FEEDBACK = "select * from feedback";
	public static final String FETCH_SELECTEDVEHICLE = "select * from vehicle_details where ((vehicleName=?) and (vehicleRegNo=?) and (vehiclePrice=?))";
	public static final String FETCH_USERBOOKEDVEHICLE = "select * from booking_details where (userID=?)";
	public static final String FETCH_SELECTEDDISCOUNT = "select * from discount where days<=? and no_of_vehicle<=?";
	public static final String FETCH_AVAILABLE_VEHICLE = "select * from vehicle_details where vehicleAvailableStatus=?";
	public static final String FETCH_USERFEEDBACK = "select * from feedback where userID=?";
	public static final String FETCH_BOOKING_ID = "select * from booking_details where bookingID=?";
	public static final String FETCH_VEHICLE_NAME = "select * from vehicle_details where vehicleName=?";
	
	public static final String ADD_ADMIN = "insert into admin_details(adminName,adminPassword) values(?,?)";   
	public static final String ADD_USER = "insert into user_details(userName,userPassword,city,email,phoneNumber) values(?,?,?,?,?)";
	public static final String ADD_VEHICLE = "insert into vehicle_details(vehicleName,vehicleType,vehicleRegNo,vehiclePrice) values(?,?,?,?)";
	public static final String ADD_BOOKING = "insert into booking_details(userID,vehicleID,purchasedDate,no_of_Days,bookedPrice,vehicle_return_status,quantity) values(?,?,?,?,?,?,?) ";
	public static final String ADD_DISCOUNT = "insert into discount values(?,?,?)";
	public static final String ADD_FEEDBACK = "insert into feedback values (?,?,?)";
	
	public static final String DELETE_BOOKING = "delete from booking_details where ((userID=?) and (bookingID=?))";
	public static final String DELETE_DISCOUNT = "delete from discount where (days=? and no_of_vehicle=?)";
	public static final String DELETE_FEEDBACK = "delete from feedback where (userID=? and vehicleID=?)";
	
	public static final String UPDATE_VEHICLE_STATUS = "update vehicle_details set vehicleAvailableStatus = ? where vehicleID = ?";
	public static final String UPDATE_BOOKING_STATUS = "update booking_details set vehicle_return_status = ? where vehicleID = ? and userID=?";
	public static final String UPDATE_DISCOUNT = "update discount set discount=? where days=? and no_of_vehicle=?";
	public static final String UPDATE_FEEDBACK = "update feedback set feedback=? where userID=? and vehicleID=?";
	
	
	public static final ResultMapper ADMIN_MAPPER = new ResultMapper() {

		@Override
		public Object mapRows(ResultSet rs) throws SQLException {
			AdminDetails admin = new AdminDetails();
			admin.setAdminPassword(rs.getString("adminPassword"));
			admin.setAdminID(rs.getInt("adminID"));
			admin.setAdminName(rs.getString("adminName"));
			return admin;
			
		}
	};
	
	public static final ResultMapper USER_MAPPER = new ResultMapper() {

		@Override
		public Object mapRows(ResultSet rs) throws SQLException {
			UserDetails user = new UserDetails();
			user.setUserID(rs.getInt("userID"));
			user.setUserName(rs.getString("userName"));
			user.setUserPassword(rs.getString("userPassword"));
			user.setCity(rs.getString("city"));
			user.setEmail(rs.getString("email"));
			user.setPhoneNumber(rs.getString("phoneNumber"));
			return user;
			
		}
	};
	
	public static final ResultMapper VEHICLE_MAPPER = new ResultMapper() {

		@Override
		public Object mapRows(ResultSet rs) throws SQLException {
			VehicleDetails vehicle = new VehicleDetails();
			vehicle.setVehicleType(rs.getString("vehicleType"));
			vehicle.setVehicleID(rs.getInt("vehicleID"));
			vehicle.setVehicleName(rs.getString("vehicleName"));
			vehicle.setVehicleRegNo(rs.getString("vehicleRegNo"));
			vehicle.setVehiclePrice(rs.getFloat("vehiclePrice"));
			vehicle.setVehicleAvailableStatus(rs.getString("vehicleAvailableStatus"));
			return vehicle;
			
		}
	};
	
	public static final ResultMapper BOOKING_MAPPER = new ResultMapper() {

		@Override
		public Object mapRows(ResultSet rs) throws SQLException {
			BookingDetails booking = new BookingDetails();
			booking.setUserID(rs.getInt("userID"));
			booking.setBookingID(rs.getInt("bookingID"));
			booking.setVehicleID(rs.getInt("vehicleID"));
			booking.setPurchasedDate(rs.getString("purchasedDate"));
			booking.setNo_of_Days(rs.getInt("no_of_Days"));
			booking.setBookedPrice(rs.getFloat("bookedPrice"));
			booking.setVehicle_return_status(rs.getString("vehicle_return_status"));
			booking.setQuantity(rs.getInt("quantity"));
			return booking;
			
		}
	};
	
	public static final ResultMapper DISCOUNT_MAPPER = new ResultMapper() {

		@Override
		public Object mapRows(ResultSet rs) throws SQLException {
			DiscountDetails discount = new DiscountDetails();
			discount.setDays(rs.getInt("days"));
			discount.setNo_of_vehicle(rs.getInt("no_of_vehicle"));
			discount.setDiscount(rs.getInt("discount"));
			return discount;
			
		}
	};
	
	public static final ResultMapper FEEDBACK_MAPPER = new ResultMapper() {

		@Override
		public Object mapRows(ResultSet rs) throws SQLException {
			FeedbackDetails feedback = new FeedbackDetails();
			feedback.setUserID(rs.getInt("userID"));
			feedback.setVehicleID(rs.getInt("vehicleID"));
			feedback.setFeedback(rs.getString("feedback"));
			return feedback;
			
		}
	};
	
	
	
	
	
	
	
	
	
	
	/*
	 * pStmt.setInt(1, user.getPortalID());
				pStmt.setString(2, user.getName());
				pStmt.setInt(3, user.getEmployeeId());
				pStmt.setString(4, user.getTechnology());
				pStmt.setString(5, user.getPassword());
	 * 
	 */

	
	

}
/*
<Context docBase="FrontControllerApp" path="/FrontControllerApp" reloadable="true" source="org.eclipse.jst.jee.server:FrontControllerApp">
			<Resource name="jdbc/MyDB"
			auth="container"
			driverClassName="oracle.jdbc.driver.OracleDriver"
			url="jdbc:oracle:thin:@localhost:1521:XE"
			username="TRDB"
			password="TRDB"
			maxActive="20"
			maxIdle="10"
			maxWait="-1"
			/>
			</Context>
*/