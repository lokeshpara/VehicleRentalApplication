package com.keane.training.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.keane.dbcon.ConnectionHolder;
import com.keane.dbcon.DBConnectionException;
import com.keane.dbfw.DBFWException;
import com.keane.dbfw.DBHelper;
import com.keane.dbfw.ParamMapper;
import com.keane.training.domain.User;

// EmployeeDao
// employee login
// register,
// deletion
// updation .. 

public class RegisterDAO {
	
	
	public int registerUser(final User user) throws DAOAppException {
		ConnectionHolder ch = null;
		Connection con = null;
		int res = -1;
		
		ParamMapper mapper = new ParamMapper() 
		{
			@Override
			public void mapParams(PreparedStatement pStmt) throws SQLException
			{
				pStmt.setInt(1, user.getPortalID());
				pStmt.setString(2, user.getName());
				pStmt.setInt(3, user.getEmployeeId());
				pStmt.setString(4, user.getTechnology());
				pStmt.setString(5, user.getPassword());
				
			}
		};
		  		try {
			ch = ConnectionHolder.getInstance();
			con = ch.getConnection();
			res = DBHelper.executeUpdate(con, SqlMapper.ADD_USER, mapper);

		} catch (DBConnectionException e) {
			throw new DAOAppException(e);
		} catch (DBFWException e) {
			throw new DAOAppException(e);
		}
		return res;
	}

	
	public boolean validateUser(final int portalId) throws DAOAppException {
		ConnectionHolder ch = null;
		Connection con = null;
		List users = null;

		ParamMapper paramMapper = new ParamMapper() {

			@Override
			public void mapParams(PreparedStatement pStmt) throws SQLException {
				pStmt.setInt(1, portalId);
			}
		};
		try {
			ch = ConnectionHolder.getInstance();
			con = ch.getConnection();
			users = DBHelper.executeSelect(con, SqlMapper.FETCH_USER,
					paramMapper, SqlMapper.USER_MAPPER);

		} catch (DBConnectionException e) {
			throw new DAOAppException(e);
		} catch (DBFWException e) {
			throw new DAOAppException(e);
		}

		return (users != null && users.size() > 0);

	}
}
