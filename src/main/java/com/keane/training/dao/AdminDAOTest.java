package com.keane.training.dao;


import org.junit.Test;


import com.keane.training.domain.AdminDetails;
import static org.junit.Assert.*;

public class AdminDAOTest {
	AdminDetails admin = new AdminDetails(1,"lokesh","999");
	@Test
	public void testgetAdminID() throws DAOAppException {
		int presentID=1;
		assertEquals(presentID,admin.getAdminID());
	}
	
	@Test
	public void testgetAdminName() throws DAOAppException {
		String presentName="lokesh";
		assertEquals(presentName,admin.getAdminName());
	}
	
	@Test
	public void testgetAdminPassword() throws DAOAppException {
		String presentPassword="999";
		assertEquals(presentPassword,admin.getAdminPassword());
	}
	
//	@Test
//	public void testValidateAdmin() throws DAOAppException {
//		AdminDetails admindetails=null;
//		List adminList = AdminDAO.validateAdmin("lokesh");
//		for(Object object:adminList) {
//			admindetails = (AdminDetails) object;
//		}
//		assertEquals("999",admindetails.getAdminPassword());
//	}
}
