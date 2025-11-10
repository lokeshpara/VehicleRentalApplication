package com.keane.training.web.handlers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.keane.mvc.HttpRequestHandler;
import com.keane.training.dao.AdminDAO;
import com.keane.training.dao.DAOAppException;
import com.keane.training.dao.LoginDAO;
import com.keane.training.dao.RegisterDAO;
import com.keane.training.domain.AdminDetails;
import com.keane.training.domain.BookingDetails;
import com.keane.training.domain.DiscountDetails;
import com.keane.training.domain.FeedbackDetails;
import com.keane.training.domain.User;
import com.keane.training.domain.UserDetails;
import com.keane.training.domain.VehicleDetails;

public class AdminProcess implements HttpRequestHandler {

	public static Logger log = Logger.getLogger(AdminProcess.class);

	@SuppressWarnings("null")
	public void handle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		PrintWriter out = response.getWriter();
		String action = request.getParameter("action");
		
		switch(action) {
			case "Login": {
				String username = request.getParameter("admin_userName");
				String password = request.getParameter("admin_password");
				int flag = -1;
				List users = null;
				try {
					users = AdminDAO.validateAdmin(username);
					log.info(users);
					for (Object object : users) {
						AdminDetails user = (AdminDetails) object;
						if (user.getAdminPassword().equals(password)) {
							flag = 0;
							break;
						}
					}
					
					log.info("Flag in login " + flag);
					if (flag == 0) {
						RequestDispatcher dispatcher = request.getRequestDispatcher("Adminhome.jsp");
						request.setAttribute("Name", username);
						dispatcher.forward(request, response);

					} else {
						RequestDispatcher dispatcher = request.getRequestDispatcher("AdminLogin.jsp");
						request.setAttribute("Err","username are password is incorrect");
						dispatcher.forward(request, response);
					}
				} catch (DAOAppException e) {
					RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
					request.setAttribute("Err", e.getMessage());
					dispatcher.forward(request, response);
				}
				break;
			}
			
			case "Customer Details": {
				int flag = 0;
				List users = null;
				try {
					String username = request.getParameter("Name");
					users=AdminDAO.allUser();
					if(users.size()!=0) {
						log.info(users);
						flag=0;
					}
					
					log.info("Flag in login " + flag);
					if(flag==0) {
						RequestDispatcher dispatcher = request.getRequestDispatcher("AllUserDetails.jsp");
						request.setAttribute("userList", users);
						request.setAttribute("Name", username);
						dispatcher.forward(request, response);
					}else {
						RequestDispatcher dispatcher = request.getRequestDispatcher("AdminLogin.jsp");
						request.setAttribute("Err","No Users details present");
						dispatcher.forward(request, response);
					}
				} catch (DAOAppException e) {
					RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
					request.setAttribute("Err", e.getMessage());
					dispatcher.forward(request, response);
				}
				break;
			}
			
			case "Vehicles Details": {
				int flag = 0;
				List vehicles = null;
				try {
					String username = request.getParameter("Name");
					vehicles=AdminDAO.allVehicles();
					if(vehicles.size()!=0) {
						log.info(vehicles);
						flag=0;
					}
					
					log.info("Flag in login " + flag);
					if(flag==0) {
						RequestDispatcher dispatcher = request.getRequestDispatcher("AllVehiclesDetails.jsp");
						request.setAttribute("vehicleList", vehicles);
						request.setAttribute("Name", username);
						dispatcher.forward(request, response);
					}else {
						RequestDispatcher dispatcher = request.getRequestDispatcher("AdminLogin.jsp");
						request.setAttribute("Err","No Users details present");
						dispatcher.forward(request, response);
					}
				} catch (DAOAppException e) {
					RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
					request.setAttribute("Err", e.getMessage());
					dispatcher.forward(request, response);
				}
				break;
			}
			
			case "Available Vehicles":{
				int flag = 0;
				List availableVehicles = null;
				try {
					String username = request.getParameter("Name");
					availableVehicles=AdminDAO.AvailableVehicles();
					if(availableVehicles.size()!=0) {
						log.info(availableVehicles);
						flag=0;
					}
					
					log.info("Flag in login " + flag);
					if(flag==0) {
						RequestDispatcher dispatcher = request.getRequestDispatcher("AvailableVehicles.jsp");
						request.setAttribute("vehicleList", availableVehicles);
						request.setAttribute("Name", username);
						dispatcher.forward(request, response);
					}else {
						RequestDispatcher dispatcher = request.getRequestDispatcher("Adminhome.jsp");
						request.setAttribute("Err","No Users details present");
						dispatcher.forward(request, response);
					}
				} catch (DAOAppException e) {
					RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
					request.setAttribute("Err", e.getMessage());
					dispatcher.forward(request, response);
				}
				break;
			}
			
			case "Unavailable Vehicles": {
				int flag = 0;
				List unavailableVehicles = null;
				try {
					String username = request.getParameter("Name");
					unavailableVehicles=AdminDAO.unavailableVehicles();
					if(unavailableVehicles.size()!=0) {
						log.info(unavailableVehicles);
						flag=0;
					}
					
					log.info("Flag in login " + flag);
					if(flag==0) {
						RequestDispatcher dispatcher = request.getRequestDispatcher("UnavailableVehicles.jsp");
						request.setAttribute("vehicleList", unavailableVehicles);
						request.setAttribute("Name", username);
						dispatcher.forward(request, response);
					}else {
						RequestDispatcher dispatcher = request.getRequestDispatcher("Adminhome.jsp");
						request.setAttribute("Err","No Users details present");
						dispatcher.forward(request, response);
					}
				} catch (DAOAppException e) {
					RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
					request.setAttribute("Err", e.getMessage());
					dispatcher.forward(request, response);
				}
				break;
			}
			
			case "Booking Details": {
				int flag = 0;
				List BookingVehicles = null;
				List userDetails = null;
				List vehicleDetails = null;
				List finalBookingDetails = new ArrayList<>();
				try {
					String username = request.getParameter("Name");
					BookingVehicles=AdminDAO.AllbookedVehicles();
					if(BookingVehicles.size()!=0) {
						
						log.info(BookingVehicles);
						flag=0;
						for(Iterator bookings=BookingVehicles.iterator();bookings.hasNext();) {
							BookingDetails booking = (BookingDetails) bookings.next();
							userDetails = AdminDAO.userDetailsWithID(booking.getUserID());
							vehicleDetails = AdminDAO.vehicleDetailsWithID(booking.getVehicleID());

							for(Iterator users=userDetails.iterator();users.hasNext();) {
								UserDetails  user = (UserDetails) users.next();
								booking.setUserName(user.getUserName());

							}
							for(Iterator vehicles=vehicleDetails.iterator();vehicles.hasNext();) {
								VehicleDetails  vehicle = (VehicleDetails) vehicles.next();
								booking.setVehicleName(vehicle.getVehicleName());

							}
							finalBookingDetails.add(booking);
						}
					}
					log.info("Flag in login " + flag);
					if(flag==0) {
						RequestDispatcher dispatcher = request.getRequestDispatcher("AllBookingDetails.jsp");
						request.setAttribute("bookingList", finalBookingDetails);
						request.setAttribute("Name", username);
						dispatcher.forward(request, response);
					}else {
						RequestDispatcher dispatcher = request.getRequestDispatcher("Adminhome.jsp");
						request.setAttribute("Err","No Users details present");
						dispatcher.forward(request, response);
					}
				} catch (DAOAppException e) {
					RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
					request.setAttribute("Err", e.getMessage());
					dispatcher.forward(request, response);
				}
				break;
			}
			
			case "Discounts": {
				int flag = 0;
				List discountDetails = null;
				try {
					String username = request.getParameter("Name");
					discountDetails=AdminDAO.allDiscounts();
					if(discountDetails.size()!=0) {
						log.info(discountDetails);
						flag=0;
					}
					
					log.info("Flag in login " + flag);
					if(flag==0) {
						RequestDispatcher dispatcher = request.getRequestDispatcher("AllDiscountDetails.jsp");
						request.setAttribute("discountList", discountDetails);
						request.setAttribute("Name", username);
						dispatcher.forward(request, response);
					}else {
						RequestDispatcher dispatcher = request.getRequestDispatcher("Adminhome.jsp");
						request.setAttribute("Err","No Users details present");
						dispatcher.forward(request, response);
					}
				} catch (DAOAppException e) {
					RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
					request.setAttribute("Err", e.getMessage());
					dispatcher.forward(request, response);
				}
				break;
			}
			
			case "Feedbacks": {
				String username = request.getParameter("Name");
				int flag = 0;
				List feedbackDetails = null;
				List userDetails = null;
				List vehicleDetails = null;
				List finalFeedbackDetails = new ArrayList<>();
				try {
					feedbackDetails=AdminDAO.allFeedback();
					if(feedbackDetails.size()!=0) {
						log.info(feedbackDetails);
						flag=0;
						for(Iterator feedbacks=feedbackDetails.iterator();feedbacks.hasNext();) {
							FeedbackDetails feedback = (FeedbackDetails) feedbacks.next();
							userDetails = AdminDAO.userDetailsWithID(feedback.getUserID());
							vehicleDetails = AdminDAO.vehicleDetailsWithID(feedback.getVehicleID());

							for(Iterator users=userDetails.iterator();users.hasNext();) {
								UserDetails  user = (UserDetails) users.next();
								feedback.setUserName(user.getUserName());

							}
							for(Iterator vehicles=vehicleDetails.iterator();vehicles.hasNext();) {
								VehicleDetails  vehicle = (VehicleDetails) vehicles.next();
								feedback.setVehicleName(vehicle.getVehicleName());

							}
							finalFeedbackDetails.add(feedback);
						}
					}
					
					log.info("Flag in login " + flag);
					if(flag==0) {
						RequestDispatcher dispatcher = request.getRequestDispatcher("AllFeedbackDetails.jsp");
						request.setAttribute("feedbackList", finalFeedbackDetails);
						request.setAttribute("Name", username);
						dispatcher.forward(request, response);
					}else {
						RequestDispatcher dispatcher = request.getRequestDispatcher("Adminhome.jsp");
						request.setAttribute("Err","No Users details present");
						dispatcher.forward(request, response);
					}
				} catch (DAOAppException e) {
					RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
					request.setAttribute("Err", e.getMessage());
					dispatcher.forward(request, response);
				}
				break;
			}
			
			case "Add User": {
				String username1 = request.getParameter("Name");
				String username = request.getParameter("userName");
				String password = request.getParameter("password");
				String city = request.getParameter("city");
				String email = request.getParameter("email");
				String phoneNumber = request.getParameter("phoneNumber");
				UserDetails user = new UserDetails();
				user.setUserName(username);
				user.setUserPassword(password);
				user.setCity(city);
				user.setEmail(email);
				user.setPhoneNumber(phoneNumber);
				
				int flag = -1;
				int count = 0;
				List users = null;
				try {
					count = AdminDAO.addCustomer(user);
					log.info(count);
					if(count!=0) {
						flag=0;
					}
					users=AdminDAO.allUser();
					if(users.size()!=0) {
						log.info(users);
						flag=0;
					}
					
					log.info("Flag in login " + flag);
					if (flag == 0) {
						RequestDispatcher dispatcher = request.getRequestDispatcher("AllUserDetails.jsp");
						request.setAttribute("userList", users);
						request.setAttribute("Name", username1);
						dispatcher.forward(request, response);

					} else {
						RequestDispatcher dispatcher = request.getRequestDispatcher("AdminLogin.jsp");
						request.setAttribute("Err","username are password is incorrect");
						dispatcher.forward(request, response);
					}
				} catch (DAOAppException e) {
					RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
					request.setAttribute("Err", e.getMessage());
					dispatcher.forward(request, response);
				}
				break;
			}
			
			case "Modify": {
				String username = request.getParameter("Name");
				int flag = -1;
				int count=0;
				String status = "no";
				List vehicles = null;
				String vehicleID = request.getParameter("vehicleID");
				
				try {
					count = AdminDAO.updateVehicleStatus(Integer.parseInt(vehicleID), status);
					if(count!=0) {
						log.info(count);
						flag=0;
					}
					vehicles=AdminDAO.allVehicles();
					
					
					log.info("Flag in login " + flag);
					if(flag==0) {
						RequestDispatcher dispatcher = request.getRequestDispatcher("AllVehiclesDetails.jsp");
						request.setAttribute("vehicleList", vehicles);
						request.setAttribute("Name", username);
						dispatcher.forward(request, response);
					}else {
						RequestDispatcher dispatcher = request.getRequestDispatcher("AdminLogin.jsp");
						request.setAttribute("Err","No Users details present");
						dispatcher.forward(request, response);
					}
				} catch (DAOAppException e) {
					RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
					request.setAttribute("Err", e.getMessage());
					dispatcher.forward(request, response);
				}
				break;
			}
			
			case "Modify Available": {
				String username = request.getParameter("Name");
				int flag = -1;
				int count=0;
				String status = "yes";
				List vehicles = null;
				String vehicleID = request.getParameter("vehicleID");
				
				try {
					count = AdminDAO.updateVehicleStatus(Integer.parseInt(vehicleID), status);
					if(count!=0) {
						log.info(count);
						flag=0;
					}
					vehicles=AdminDAO.allVehicles();
					
					
					log.info("Flag in login " + flag);
					if(flag==0) {
						RequestDispatcher dispatcher = request.getRequestDispatcher("AllVehiclesDetails.jsp");
						request.setAttribute("vehicleList", vehicles);
						request.setAttribute("Name", username);
						dispatcher.forward(request, response);
					}else {
						RequestDispatcher dispatcher = request.getRequestDispatcher("AdminLogin.jsp");
						request.setAttribute("Err","No Users details present");
						dispatcher.forward(request, response);
					}
				} catch (DAOAppException e) {
					RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
					request.setAttribute("Err", e.getMessage());
					dispatcher.forward(request, response);
				}
				break;
			}
			
			case "Add Vehicle": {
				String username1 = request.getParameter("Name");
				String username = request.getParameter("vehicleName");
				String type = request.getParameter("vehicleType");
				String regno = request.getParameter("vehicleRegNo");
				String price = request.getParameter("price");
				VehicleDetails vehicle = new VehicleDetails();
				vehicle.setVehicleName(username);
				vehicle.setVehicleType(type);
				vehicle.setVehicleRegNo(regno);
				vehicle.setVehiclePrice(Float.parseFloat(price));
				
				int flag = -1;
				int count = 0;
				List vehicleList = null;
				try {
					count = AdminDAO.addVehicle(vehicle);
					log.info(count);
					if(count!=0) {
						flag=0;
					}
					vehicleList=AdminDAO.allVehicles();
					
					
					log.info("Flag in login " + flag);
					if (flag == 0) {
						RequestDispatcher dispatcher = request.getRequestDispatcher("AllVehiclesDetails.jsp");
						request.setAttribute("vehicleList", vehicleList);
						request.setAttribute("Name", username1);
						dispatcher.forward(request, response);

					} else {
						RequestDispatcher dispatcher = request.getRequestDispatcher("AdminLogin.jsp");
						request.setAttribute("Err","username are password is incorrect");
						dispatcher.forward(request, response);
					}
				} catch (DAOAppException e) {
					RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
					request.setAttribute("Err", e.getMessage());
					dispatcher.forward(request, response);
				}
				break;
			}
			
			case "Add Discount": {
				String username = request.getParameter("Name");
				String days = request.getParameter("days");
				String quantity = request.getParameter("no_of_vehicles");
				String regno = request.getParameter("discount");
				DiscountDetails discount = new DiscountDetails();
				discount.setDays(Integer.parseInt(days));
				discount.setNo_of_vehicle(Integer.parseInt(quantity));
				discount.setDiscount(Integer.parseInt(regno));
				
				int flag = -1;
				int count = 0;
				List discountList = null;
				try {
					count = AdminDAO.addDiscount(discount);
					log.info(count);
					if(count!=0) {
						flag=0;
					}
					discountList=AdminDAO.allDiscounts();
					
					
					log.info("Flag in login " + flag);
					if (flag == 0) {
						RequestDispatcher dispatcher = request.getRequestDispatcher("AllDiscountDetails.jsp");
						request.setAttribute("discountList", discountList);
						request.setAttribute("Name", username);
						dispatcher.forward(request, response);

					} else {
						RequestDispatcher dispatcher = request.getRequestDispatcher("AdminLogin.jsp");
						request.setAttribute("Err","username are password is incorrect");
						dispatcher.forward(request, response);
					}
				} catch (DAOAppException e) {
					RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
					request.setAttribute("Err", e.getMessage());
					dispatcher.forward(request, response);
				}
				break;
			}
			
			case "Update Discount": {
				String username = request.getParameter("Name");
				request.setAttribute("Name", username);
				String days = request.getParameter("days");
				String quantity = request.getParameter("no_of_vehicles");
				String regno = request.getParameter("discount");
				DiscountDetails discount = new DiscountDetails();
				discount.setDays(Integer.parseInt(days));
				discount.setNo_of_vehicle(Integer.parseInt(quantity));
				discount.setDiscount(Integer.parseInt(regno));
				
				int flag = -1;
				int count = 0;
				List discountList = null;
				try {
					count = AdminDAO.updateDiscount(discount);
					log.info(count);
					if(count!=0) {
						flag=0;
					}
					discountList=AdminDAO.allDiscounts();
					
					
					log.info("Flag in login " + flag);
					if (flag == 0) {
						RequestDispatcher dispatcher = request.getRequestDispatcher("AllDiscountDetails.jsp");
						request.setAttribute("discountList", discountList);
						dispatcher.forward(request, response);

					} else {
						RequestDispatcher dispatcher = request.getRequestDispatcher("AdminLogin.jsp");
						request.setAttribute("Err","username are password is incorrect");
						dispatcher.forward(request, response);
					}
				} catch (DAOAppException e) {
					RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
					request.setAttribute("Err", e.getMessage());
					dispatcher.forward(request, response);
				}
				break;
			}
			
			case "Add Customer":{
				String username = request.getParameter("Name");
				RequestDispatcher dispatcher = request.getRequestDispatcher("AdminAddCustomer.jsp");
				request.setAttribute("Name", username);
				dispatcher.forward(request, response);
				break;
			}
			
			case "Add vehicles": {
				String username = request.getParameter("Name");
				RequestDispatcher dispatcher = request.getRequestDispatcher("AdminAddVehicle.jsp");
				request.setAttribute("Name", username);
				dispatcher.forward(request, response);
				break;
			}
			
			case "Modify Details":{
				String username = request.getParameter("Name");
				RequestDispatcher dispatcher = request.getRequestDispatcher("ModifyVehicleAvailableStatus.jsp");
				request.setAttribute("Name", username);
				dispatcher.forward(request, response);
				break;
			}
			
			case "Modify Detail":{
				String username = request.getParameter("Name");
				RequestDispatcher dispatcher = request.getRequestDispatcher("ModifyVehicleUnavailableStatus.jsp");
				request.setAttribute("Name", username);
				dispatcher.forward(request, response);
				break;
			}
			
			case "Add Discounts":{
				String username = request.getParameter("Name");
				RequestDispatcher dispatcher = request.getRequestDispatcher("AdminAddDiscount.jsp");
				request.setAttribute("Name", username);
				dispatcher.forward(request, response);
				break;
			}
			
			case "Update Discounts":{
				String username = request.getParameter("Name");
				RequestDispatcher dispatcher = request.getRequestDispatcher("AdminUpdateDiscount.jsp");
				request.setAttribute("Name", username);
				dispatcher.forward(request, response);
				break;
			}
			
			case "Home": {
				String username = request.getParameter("Name");
				RequestDispatcher dispatcher = request.getRequestDispatcher("Adminhome.jsp");
				request.setAttribute("Name", username);
				dispatcher.forward(request, response);
				break;
			}
			
			case "Log Out":
			{ 
				HttpSession sessionobj =request.getSession(); // existing session object 
				sessionobj.invalidate();	
				response.sendRedirect("index.jsp");
				break;
			
			}
		}
		

	}
}
