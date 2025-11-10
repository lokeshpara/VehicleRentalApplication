package com.keane.training.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.keane.dbcon.ConnectionHolder;
import com.keane.dbcon.DBConnectionException;
import com.keane.dbfw.DBFWException;
import com.keane.dbfw.DBHelper;
import com.keane.dbfw.ParamMapper;
import com.keane.training.domain.DiscountDetails;
import com.keane.training.domain.UserDetails;
import com.keane.training.domain.VehicleDetails;

public class AdminDAO {
	static Logger log = Logger.getLogger(LoginDAO.class);
	
	public static List validateAdmin(final String adminName) throws DAOAppException {
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
					pStmt.setString(1, adminName);
				}
			};
			res = DBHelper.executeSelect(con, SqlMapper.FETCH_ADMIN,paramMapper, SqlMapper.ADMIN_MAPPER);

		} catch (DBConnectionException e) {
			log.error(e);
			throw new DAOAppException(e);
		} catch (DBFWException e) {
			throw new DAOAppException(e);
		}
		return res;
	}
	
	public static List allUser() throws DAOAppException {
		List res = null;
		ConnectionHolder ch = null;
		Connection con = null;
		try {
			ch = ConnectionHolder.getInstance();
			con = ch.getConnection();
			res = DBHelper.executeSelect(con, SqlMapper.FETCH_USER, SqlMapper.USER_MAPPER);
			
		} catch (DBConnectionException e) {
			log.error(e);
			throw new DAOAppException(e);
		} catch (DBFWException e) {
			throw new DAOAppException(e);
		}
		return res;
	}
	
	public static List allVehicles() throws DAOAppException {
		List res = null;
		ConnectionHolder ch = null;
		Connection con = null;
		try {
			ch = ConnectionHolder.getInstance();
			con = ch.getConnection();
			res = DBHelper.executeSelect(con, SqlMapper.FETCH_VEHICLE, SqlMapper.VEHICLE_MAPPER);
			
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
	
	public static List unavailableVehicles() throws DAOAppException {
		List res = null;
		ConnectionHolder ch = null;
		Connection con = null;
		String unavailable = "no";
		try {
			ch = ConnectionHolder.getInstance();
			con = ch.getConnection();
			ParamMapper paramMapper = new ParamMapper() {

				@Override
				public void mapParams(PreparedStatement pStmt)
						throws SQLException {
					pStmt.setString(1, unavailable);
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
	
	public static List AllbookedVehicles() throws DAOAppException {
		List res = null;
		ConnectionHolder ch = null;
		Connection con = null;
		try {
			ch = ConnectionHolder.getInstance();
			con = ch.getConnection();
			res = DBHelper.executeSelect(con, SqlMapper.FETCH_BOOKINGDETAILS, SqlMapper.BOOKING_MAPPER);
			
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
	
	public static List allFeedback() throws DAOAppException {
		List res = null;
		ConnectionHolder ch = null;
		Connection con = null;
		try {
			ch = ConnectionHolder.getInstance();
			con = ch.getConnection();
			res = DBHelper.executeSelect(con, SqlMapper.FETCH_FEEDBACK, SqlMapper.FEEDBACK_MAPPER);
			
		} catch (DBConnectionException e) {
			log.error(e);
			throw new DAOAppException(e);
		} catch (DBFWException e) {
			throw new DAOAppException(e);
		}
		return res;
	}
	
	public static int addCustomer(final UserDetails user) throws DAOAppException {
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
	
	public static int addVehicle(final VehicleDetails vehicle) throws DAOAppException {
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
					pStmt.setString(1, vehicle.getVehicleName());
					pStmt.setString(2, vehicle.getVehicleType());
					pStmt.setString(3, vehicle.getVehicleRegNo());
					pStmt.setFloat(4, vehicle.getVehiclePrice());
				}
			};
			res = DBHelper.executeUpdate(con, SqlMapper.ADD_VEHICLE,paramMapper);

		} catch (DBConnectionException e) {
			log.error(e);
			throw new DAOAppException(e);
		} catch (DBFWException e) {
			throw new DAOAppException(e);
		}
		return res;
	}
	
	public static int addDiscount(final DiscountDetails discount) throws DAOAppException {
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
					pStmt.setInt(1, discount.getDays());
					pStmt.setInt(2, discount.getNo_of_vehicle());
					pStmt.setInt(3, discount.getDiscount());
				}
			};
			res = DBHelper.executeUpdate(con, SqlMapper.ADD_DISCOUNT,paramMapper);

		} catch (DBConnectionException e) {
			log.error(e);
			throw new DAOAppException(e);
		} catch (DBFWException e) {
			throw new DAOAppException(e);
		}
		return res;
	}
	
	public static int updateDiscount(DiscountDetails discount) throws DAOAppException {
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
					pStmt.setInt(1, discount.getDiscount());
					pStmt.setInt(2, discount.getDays());
					pStmt.setInt(3, discount.getNo_of_vehicle());
				}
			};
			res = DBHelper.executeUpdate(con, SqlMapper.UPDATE_DISCOUNT,paramMapper);

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
	
}
