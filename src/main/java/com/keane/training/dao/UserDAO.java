package com.keane.training.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

import com.keane.dbcon.ConnectionHolder;
import com.keane.dbcon.DBConnectionException;
import com.keane.dbfw.DBFWException;
import com.keane.dbfw.DBHelper;
import com.keane.dbfw.ParamMapper;
import com.keane.training.domain.BookingDetails;
import com.keane.training.domain.DiscountDetails;
import com.keane.training.domain.UserDetails;
import com.keane.training.domain.VehicleDetails;

public class UserDAO {
static Logger log = Logger.getLogger(LoginDAO.class);


public static boolean validateUser(final String username) throws DAOAppException {
	ConnectionHolder ch = null;
	Connection con = null;
	List users = null;

	ParamMapper paramMapper = new ParamMapper() {

		@Override
		public void mapParams(PreparedStatement pStmt) throws SQLException {
			pStmt.setString(1, username);
		}
	};
	try {
		ch = ConnectionHolder.getInstance();
		con = ch.getConnection();
		users = DBHelper.executeSelect(con, SqlMapper.FETCH_LOGIN_USER,paramMapper, SqlMapper.USER_MAPPER);

	} catch (DBConnectionException e) {
		throw new DAOAppException(e);
	} catch (DBFWException e) {
		throw new DAOAppException(e);
	}

	return (users != null && users.size() > 0);

}
	
	public static List loginUser(final String userName) throws DAOAppException {
		List res = null;
		ConnectionHolder ch = null;
		Connection con = null;
		try {
			ch = ConnectionHolder.getInstance();
			con = ch.getConnection();
			ParamMapper paramMapper = new ParamMapper() {

				@Override
				public void mapParams(PreparedStatement pStmt)
						throws SQLException {
					pStmt.setString(1, userName);
				}
			};
			res = DBHelper.executeSelect(con, SqlMapper.FETCH_LOGIN_USER,paramMapper, SqlMapper.USER_MAPPER);

		} catch (DBConnectionException e) {
			log.error(e);
			throw new DAOAppException(e);
		} catch (DBFWException e) {
			throw new DAOAppException(e);
		}
		return res;
	}
	
	public static int registerUser(UserDetails user) throws DAOAppException {
		int res = 0;
		ConnectionHolder ch = null;
		Connection con = null;
		try {
			ch = ConnectionHolder.getInstance();
			con = ch.getConnection();
			ParamMapper paramMapper = new ParamMapper() {

				@Override
				public void mapParams(PreparedStatement pStmt)
						throws SQLException {
					pStmt.setString(1, user.getUserName());
					pStmt.setString(2, user.getUserPassword());
					pStmt.setString(3, user.getCity());
					pStmt.setString(4, user.getEmail());
					pStmt.setString(5, user.getPhoneNumber());
				}
			};
			res = DBHelper.executeUpdate(con, SqlMapper.ADD_USER,paramMapper);

		} catch (DBConnectionException e) {
			log.error(e);
			throw new DAOAppException(e);
		} catch (DBFWException e) {
			throw new DAOAppException(e);
		}
		return res;
	}
	
	public static List AvailableVehicles() throws DAOAppException {
		List res = null;
		ConnectionHolder ch = null;
		Connection con = null;
		String available = "yes";
		try {
			ch = ConnectionHolder.getInstance();
			con = ch.getConnection();
			ParamMapper paramMapper = new ParamMapper() {

				@Override
				public void mapParams(PreparedStatement pStmt)
						throws SQLException {
					pStmt.setString(1, available);
				}
			};
			res = DBHelper.executeSelect(con, SqlMapper.FETCH_AVAILABLE_VEHICLE,paramMapper, SqlMapper.VEHICLE_MAPPER);

		} catch (DBConnectionException e) {
			log.error(e);
			throw new DAOAppException(e);
		} catch (DBFWException e) {
			throw new DAOAppException(e);
		}
		return res;
	}
	
	public static List userBookedVehicles(int userID) throws DAOAppException {
		List res = null;
		ConnectionHolder ch = null;
		Connection con = null;
		try {
			ch = ConnectionHolder.getInstance();
			con = ch.getConnection();
			ParamMapper paramMapper = new ParamMapper() {

				@Override
				public void mapParams(PreparedStatement pStmt)
						throws SQLException {
					pStmt.setInt(1, userID);
				}
			};
			res = DBHelper.executeSelect(con, SqlMapper.FETCH_USERBOOKEDVEHICLE,paramMapper, SqlMapper.BOOKING_MAPPER);

		} catch (DBConnectionException e) {
			log.error(e);
			throw new DAOAppException(e);
		} catch (DBFWException e) {
			throw new DAOAppException(e);
		}
		return res;
	}
	
	public static List allDiscounts() throws DAOAppException {
		List res = null;
		ConnectionHolder ch = null;
		Connection con = null;
		try {
			ch = ConnectionHolder.getInstance();
			con = ch.getConnection();
			res = DBHelper.executeSelect(con, SqlMapper.FETCH_DISCOUNT, SqlMapper.DISCOUNT_MAPPER);
			
		} catch (DBConnectionException e) {
			log.error(e);
			throw new DAOAppException(e);
		} catch (DBFWException e) {
			throw new DAOAppException(e);
		}
		return res;
	}
	
	public static List userFeedback(int userID) throws DAOAppException {
		List res = null;
		ConnectionHolder ch = null;
		Connection con = null;
		try {
			ch = ConnectionHolder.getInstance();
			con = ch.getConnection();
			ParamMapper paramMapper = new ParamMapper() {

				@Override
				public void mapParams(PreparedStatement pStmt)
						throws SQLException {
					pStmt.setInt(1, userID);
				}
			};
			res = DBHelper.executeSelect(con, SqlMapper.FETCH_USERFEEDBACK, paramMapper, SqlMapper.FEEDBACK_MAPPER);
			
		} catch (DBConnectionException e) {
			log.error(e);
			throw new DAOAppException(e);
		} catch (DBFWException e) {
			throw new DAOAppException(e);
		}
		return res;
	}
	
	public static List userDetailsWithID(int  userID) throws DAOAppException {
		List res = null;
		ConnectionHolder ch = null;
		Connection con = null;
		try {
			ch = ConnectionHolder.getInstance();
			con = ch.getConnection();
			ParamMapper paramMapper = new ParamMapper() {

				@Override
				public void mapParams(PreparedStatement pStmt)
						throws SQLException {
					pStmt.setInt(1, userID);
				}
			};
			res = DBHelper.executeSelect(con, SqlMapper.FETCH_USER_ID,paramMapper, SqlMapper.USER_MAPPER);

		} catch (DBConnectionException e) {
			log.error(e);
			throw new DAOAppException(e);
		} catch (DBFWException e) {
			throw new DAOAppException(e);
		}
		return res;
	}
	
	public static List vehicleDetailsWithID( int  vehicelID) throws DAOAppException {
		List res = null;
		ConnectionHolder ch = null;
		Connection con = null;
		try {
			ch = ConnectionHolder.getInstance();
			con = ch.getConnection();
			ParamMapper paramMapper = new ParamMapper() {

				@Override
				public void mapParams(PreparedStatement pStmt)
						throws SQLException {
					pStmt.setInt(1, vehicelID);
				}
			};
			res = DBHelper.executeSelect(con, SqlMapper.FETCH_VEHICLE_ID,paramMapper, SqlMapper.VEHICLE_MAPPER);

		} catch (DBConnectionException e) {
			log.error(e);
			throw new DAOAppException(e);
		} catch (DBFWException e) {
			throw new DAOAppException(e);
		}
		return res;
	}
	
	public static int bookingDetailsWithID( int  bookingID) throws DAOAppException {
		List res = null;
		int value=0;
		ConnectionHolder ch = null;
		Connection con = null;
		try {
			ch = ConnectionHolder.getInstance();
			con = ch.getConnection();
			ParamMapper paramMapper = new ParamMapper() {

				@Override
				public void mapParams(PreparedStatement pStmt)
						throws SQLException {
					pStmt.setInt(1, bookingID);
				}
			};
			res = DBHelper.executeSelect(con, SqlMapper.FETCH_BOOKING_ID,paramMapper, SqlMapper.BOOKING_MAPPER);
			for(Iterator id=res.iterator();id.hasNext();) {
				BookingDetails vid = (BookingDetails) id.next();
				value=vid.getVehicleID();
			}
		} catch (DBConnectionException e) {
			log.error(e);
			throw new DAOAppException(e);
		} catch (DBFWException e) {
			throw new DAOAppException(e);
		}
		return value;
	}
	
	public static List vehicleDetailsWithName( String  vehicleName) throws DAOAppException {
		List res = null;
		ConnectionHolder ch = null;
		Connection con = null;
		try {
			ch = ConnectionHolder.getInstance();
			con = ch.getConnection();
			ParamMapper paramMapper = new ParamMapper() {

				@Override
				public void mapParams(PreparedStatement pStmt)
						throws SQLException {
					pStmt.setString(1, vehicleName);
				}
			};
			res = DBHelper.executeSelect(con, SqlMapper.FETCH_VEHICLE_NAME,paramMapper, SqlMapper.VEHICLE_MAPPER);

		} catch (DBConnectionException e) {
			log.error(e);
			throw new DAOAppException(e);
		} catch (DBFWException e) {
			throw new DAOAppException(e);
		}
		return res;
	}
	
	public static int updateVehicleStatus(int ID, String status) throws DAOAppException {
		int res = 0;
		ConnectionHolder ch = null;
		Connection con = null;
		try {
			ch = ConnectionHolder.getInstance();
			con = ch.getConnection();
			ParamMapper paramMapper = new ParamMapper() {

				@Override
				public void mapParams(PreparedStatement pStmt)
						throws SQLException {
					pStmt.setString(1, status);
					pStmt.setInt(2, ID);
				}
			};
			res = DBHelper.executeUpdate(con, SqlMapper.UPDATE_VEHICLE_STATUS,paramMapper);

		} catch (DBConnectionException e) {
			log.error(e);
			throw new DAOAppException(e);
		} catch (DBFWException e) {
			throw new DAOAppException(e);
		}
		return res;
	}
	
	public static float UserDiscount(int days,int quantity,float price) throws DAOAppException {
		List res = null;
		int pvalues=0;
		int hvalue=0;
		float totalPrice=0;
		ConnectionHolder ch = null;
		Connection con = null;
		try {
			ch = ConnectionHolder.getInstance();
			con = ch.getConnection();
			ParamMapper paramMapper = new ParamMapper() {

				@Override
				public void mapParams(PreparedStatement pStmt)
						throws SQLException {
					pStmt.setInt(1, days);
					pStmt.setInt(2, quantity);
				}
			};
			res = DBHelper.executeSelect(con, SqlMapper.FETCH_SELECTEDDISCOUNT,paramMapper, SqlMapper.DISCOUNT_MAPPER);
			if(res.size()!=0) {
				for(Iterator it=res.iterator();it.hasNext();) {
					DiscountDetails c1 = (DiscountDetails) it.next();
					pvalues= c1.getDiscount();
					if(pvalues>hvalue) {
					totalPrice= (float) (price - ((price*c1.getDiscount())/100));
					hvalue=pvalues;
					}
				}
			}else {
				totalPrice=(float) price;
			}
		} catch (DBConnectionException e) {
			log.error(e);
			throw new DAOAppException(e);
		} catch (DBFWException e) {
			throw new DAOAppException(e);
		}
		return totalPrice;
	}
	
	public static int addBookVehicle(BookingDetails book) throws DAOAppException {
		int res = 0;
		ConnectionHolder ch = null;
		Connection con = null;
		try {
			ch = ConnectionHolder.getInstance();
			con = ch.getConnection();
			ParamMapper paramMapper = new ParamMapper() {

				@Override
				public void mapParams(PreparedStatement pStmt)
						throws SQLException {
					pStmt.setInt(1, book.getUserID());
					pStmt.setInt(2, book.getVehicleID());
					pStmt.setString(3, book.getPurchasedDate());
					pStmt.setInt(4, book.getNo_of_Days());
					pStmt.setFloat(5, book.getBookedPrice());
					pStmt.setString(6, book.getVehicle_return_status());
					pStmt.setInt(7, book.getQuantity());
				}
			};
			res = DBHelper.executeUpdate(con, SqlMapper.ADD_BOOKING,paramMapper);

		} catch (DBConnectionException e) {
			log.error(e);
			throw new DAOAppException(e);
		} catch (DBFWException e) {
			throw new DAOAppException(e);
		}
		return res;
	}
	
	public static List UserbookedVehicles(int userID) throws DAOAppException {
		List res = null;
		ConnectionHolder ch = null;
		Connection con = null;
		try {
			ch = ConnectionHolder.getInstance();
			con = ch.getConnection();
			ParamMapper paramMapper = new ParamMapper() {

				@Override
				public void mapParams(PreparedStatement pStmt)
						throws SQLException {
					pStmt.setInt(1, userID);
				}
			};
			res = DBHelper.executeSelect(con, SqlMapper.FETCH_USERBOOKEDVEHICLE, SqlMapper.BOOKING_MAPPER);
			
		} catch (DBConnectionException e) {
			log.error(e);
			throw new DAOAppException(e);
		} catch (DBFWException e) {
			throw new DAOAppException(e);
		}
		return res;
	}
	
	public static int deleteUserBooking(int userID,int bookingID) throws DAOAppException {
		int res = 0;
		ConnectionHolder ch = null;
		Connection con = null;
		try {
			ch = ConnectionHolder.getInstance();
			con = ch.getConnection();
			ParamMapper paramMapper = new ParamMapper() {

				@Override
				public void mapParams(PreparedStatement pStmt)
						throws SQLException {
					pStmt.setInt(1, userID);
					pStmt.setInt(2, bookingID);
				}
			};
			res = DBHelper.executeUpdate(con, SqlMapper.DELETE_BOOKING,paramMapper);

		} catch (DBConnectionException e) {
			log.error(e);
			throw new DAOAppException(e);
		} catch (DBFWException e) {
			throw new DAOAppException(e);
		}
		return res;
	}
	
	public static int addUserFeedback(int userID,int vehicleID,String feedback) throws DAOAppException {
		int res = 0;
		ConnectionHolder ch = null;
		Connection con = null;
		try {
			ch = ConnectionHolder.getInstance();
			con = ch.getConnection();
			ParamMapper paramMapper = new ParamMapper() {

				@Override
				public void mapParams(PreparedStatement pStmt)
						throws SQLException {
					pStmt.setInt(1, userID);
					pStmt.setInt(2, vehicleID);
					pStmt.setString(3, feedback);
				}
			};
			res = DBHelper.executeUpdate(con, SqlMapper.ADD_FEEDBACK,paramMapper);

		} catch (DBConnectionException e) {
			log.error(e);
			throw new DAOAppException(e);
		} catch (DBFWException e) {
			throw new DAOAppException(e);
		}
		return res;
	}
	
	public static int deleteUserFeedback(int userID,int vehicleID) throws DAOAppException {
		int res = 0;
		ConnectionHolder ch = null;
		Connection con = null;
		try {
			ch = ConnectionHolder.getInstance();
			con = ch.getConnection();
			ParamMapper paramMapper = new ParamMapper() {

				@Override
				public void mapParams(PreparedStatement pStmt)
						throws SQLException {
					pStmt.setInt(1, userID);
					pStmt.setInt(2, vehicleID);
				}
			};
			res = DBHelper.executeUpdate(con, SqlMapper.DELETE_FEEDBACK,paramMapper);

		} catch (DBConnectionException e) {
			log.error(e);
			throw new DAOAppException(e);
		} catch (DBFWException e) {
			throw new DAOAppException(e);
		}
		return res;
	}
	
	public static List UserFeedback(int userID) throws DAOAppException {
		List res = null;
		ConnectionHolder ch = null;
		Connection con = null;
		String available = "yes";
		try {
			ch = ConnectionHolder.getInstance();
			con = ch.getConnection();
			ParamMapper paramMapper = new ParamMapper() {

				@Override
				public void mapParams(PreparedStatement pStmt)
						throws SQLException {
					pStmt.setInt(1, userID);
				}
			};
			res = DBHelper.executeSelect(con, SqlMapper.FETCH_USERFEEDBACK,paramMapper, SqlMapper.FEEDBACK_MAPPER);

		} catch (DBConnectionException e) {
			log.error(e);
			throw new DAOAppException(e);
		} catch (DBFWException e) {
			throw new DAOAppException(e);
		}
		return res;
	}
}

