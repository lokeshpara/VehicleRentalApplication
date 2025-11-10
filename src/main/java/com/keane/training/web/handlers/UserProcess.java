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
import com.keane.training.dao.UserDAO;
import com.keane.training.domain.AdminDetails;
import com.keane.training.domain.BookingDetails;
import com.keane.training.domain.DiscountDetails;
import com.keane.training.domain.FeedbackDetails;
import com.keane.training.domain.User;
import com.keane.training.domain.UserDetails;
import com.keane.training.domain.VehicleDetails;

public class UserProcess implements HttpRequestHandler {

	public static Logger log = Logger.getLogger(UserProcess.class);

	@SuppressWarnings("null")
	public void handle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		PrintWriter out = response.getWriter();
		String action = request.getParameter("action");
		
		switch(action) {
			case "Login": {

				String username = request.getParameter("UserName");
				String password = request.getParameter("password");
				int flag = -1;
				List users = null;
				UserDetails userDetails = new UserDetails();
				try {
					users = UserDAO.loginUser(username);
					log.info(users);
					for (Object object : users) {
						UserDetails user = (UserDetails) object;
						if (user.getUserPassword().equals(password)) {
							flag = 0;
							userDetails.setUserName(user.getUserName());
							break;
						}
					}
					
					
					log.info("Flag in login " + flag);
					if (flag == 0) {
						RequestDispatcher dispatcher = request.getRequestDispatcher("UserHome.jsp");
						request.setAttribute("details", username);
						dispatcher.forward(request, response);

					} else {
						RequestDispatcher dispatcher = request.getRequestDispatcher("UserLogin.jsp");
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
			
			case "Register":{
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
				boolean valid = false;
				try {
					if(username.length()!=0) {
					valid = UserDAO.validateUser(username);
					if(valid) {
						log.info("User already registered");
						RequestDispatcher dispatcher = request.getRequestDispatcher("UserRegister.jsp");
						request.setAttribute("Err",	"User already registered with the system");
						dispatcher.forward(request, response);
					}else {
						int finalRes = UserDAO.registerUser(user);
						if (finalRes > 0) {
							RequestDispatcher dispatcher = request.getRequestDispatcher("UserRegister.jsp");
							request.setAttribute("success","User succesfully registered with the system");
							dispatcher.forward(request, response);
						}
					
					}
					}else {
						RequestDispatcher dispatcher = request.getRequestDispatcher("UserRegister.jsp");
						request.setAttribute("Err",	"Invaild details");
						dispatcher.forward(request, response);
					}
				} catch (DAOAppException e) {
					RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
					request.setAttribute("Err", e.getMessage());
					dispatcher.forward(request, response);
				}
				break;
			}
			
			case "Book Vehicle":{
				int flag = 0;
				String username = request.getParameter("userName");
				List availableVehicles = null;
				try {
					availableVehicles=UserDAO.AvailableVehicles();
					if(availableVehicles.size()!=0) {
						log.info(availableVehicles);
						flag=0;
					}
					
					log.info("Flag in login " + flag);
					if(flag==0) {
						RequestDispatcher dispatcher = request.getRequestDispatcher("UserAvailableVehicle.jsp");
						request.setAttribute("vehicleList", availableVehicles);
						request.setAttribute("details", username);
						dispatcher.forward(request, response);
					}else {
						RequestDispatcher dispatcher = request.getRequestDispatcher("invalidDetails.jsp");
						request.setAttribute("Err","No Users details present");
						request.setAttribute("details", username);
						dispatcher.forward(request, response);
					}
				} catch (DAOAppException e) {
					RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
					request.setAttribute("Err", e.getMessage());
					dispatcher.forward(request, response);
				}
				break;
			}
			
			case "Add to cart": {
				int flag=-1;
				String username = request.getParameter("userName");
				String vehicleID = request.getParameter("vehicleID");
				String bookingDate = request.getParameter("bookingdate");
				String no_of_days = request.getParameter("no_of_days");
				String quantity = request.getParameter("quantity");
				try {
					
					String vehicleName=null;
					float vehicleCost= 0;
					List<VehicleDetails> vehicle=new ArrayList<VehicleDetails>();
					
					BookingDetails booking = new BookingDetails();
					if(vehicleID.length()!=0) {
					vehicle = UserDAO.vehicleDetailsWithID(Integer.parseInt(vehicleID));
					}
					booking.setUserName(username);
					for(Iterator vehicles = vehicle.iterator();vehicles.hasNext();) {
						VehicleDetails vehicleDetails =(VehicleDetails) vehicles.next();
						vehicleName = vehicleDetails.getVehicleName();
						vehicleCost = (float) vehicleDetails.getVehiclePrice();
					}
					booking.setVehicleName(vehicleName);
					booking.setPurchasedDate(bookingDate);
					booking.setNo_of_Days(Integer.parseInt(no_of_days));
					booking.setQuantity(Integer.parseInt(quantity));
					vehicleCost = UserDAO.UserDiscount(Integer.parseInt(no_of_days), Integer.parseInt(quantity), vehicleCost);
					booking.setBookedPrice(Integer.parseInt(quantity)*vehicleCost);
					if(vehicleCost!=0) {
						flag=0;
					}
					if(flag==0 && vehicle.size()!=0) {
					RequestDispatcher dispatcher = request.getRequestDispatcher("UserBookingConfirmation.jsp");
					request.setAttribute("bookingList", booking);
					request.setAttribute("details", username);
					request.setAttribute("detail", vehicleID);
					dispatcher.forward(request, response);
					}else {
						RequestDispatcher dispatcher = request.getRequestDispatcher("invalidDetails.jsp");
						request.setAttribute("Err", "Invalid data");;
						request.setAttribute("details", username);
						dispatcher.forward(request, response);
					}
				} catch (DAOAppException e) {
					RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
					request.setAttribute("Err", e.getMessage());
					request.setAttribute("details", username);
					dispatcher.forward(request, response);
				}catch(Exception e) {
					RequestDispatcher dispatcher = request.getRequestDispatcher("UserBookingConfirmation.jsp");
					request.setAttribute("err", "Invalid data");;
					request.setAttribute("details", username);
					dispatcher.forward(request, response);
				}
				break;
			}
			
			case "Confirm Booking":{
				try {
				int userID=0;
				int count=0;
				int count1=0;
				List userDetails = null;
				String username = request.getParameter("userName");
				String vehicleID = request.getParameter("vehicleID");
				String bookingDate = request.getParameter("bookingDate");
				String no_of_days = request.getParameter("no_of_days");
				String quantity = request.getParameter("quantity");
				String bookingPrice = request.getParameter("bookingPrice");
				userDetails = UserDAO.loginUser(username);
				for(Iterator users=userDetails.iterator();users.hasNext();) {
					UserDetails user= (UserDetails) users.next();
					userID=user.getUserID();
				}
				BookingDetails bookingDetails = new BookingDetails();
				if(no_of_days.length()!=0 && quantity.length()!=0 && bookingPrice.length()!=0) {
				bookingDetails.setUserID(userID);
				bookingDetails.setVehicleID(Integer.parseInt(vehicleID));
				bookingDetails.setPurchasedDate(bookingDate);
				bookingDetails.setNo_of_Days(Integer.parseInt(no_of_days));
				bookingDetails.setQuantity(Integer.parseInt(quantity));
				bookingDetails.setBookedPrice(Float.parseFloat(bookingPrice));
				bookingDetails.setVehicle_return_status("no");
				count = UserDAO.addBookVehicle(bookingDetails);
				count1= UserDAO.updateVehicleStatus(Integer.parseInt(vehicleID), "no");
				}
				if(count!=0 && count1!=0) {
					RequestDispatcher dispatcher = request.getRequestDispatcher("UserBookingConfirmation.jsp");
					request.setAttribute("success", "Booking is Confirmed");
					request.setAttribute("details", username);
					dispatcher.forward(request, response);
				}else {
					RequestDispatcher dispatcher = request.getRequestDispatcher("invalidDetails.jsp");
					request.setAttribute("Err","Invalid details present");
					request.setAttribute("details", username);
					dispatcher.forward(request, response);
				}
				}catch (DAOAppException e) {
					RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
					request.setAttribute("Err", e.getMessage());
					dispatcher.forward(request, response);
				}
				break;
				
			}
			
			case "Discounts": {
				int flag = -1;
				List discountDetails = null;
				String username = request.getParameter("userName");
				try {
					discountDetails=AdminDAO.allDiscounts();
					if(discountDetails.size()!=0) {
						log.info(discountDetails);
						flag=0;
					}
					
					log.info("Flag in login " + flag);
					if(flag==0) {
						RequestDispatcher dispatcher = request.getRequestDispatcher("UserViewDiscounts.jsp");
						request.setAttribute("discountList", discountDetails);
						request.setAttribute("details", username);
						dispatcher.forward(request, response);
					}else {
						RequestDispatcher dispatcher = request.getRequestDispatcher("invalidDetails.jsp");
						request.setAttribute("Err","No Users details present");
						request.setAttribute("details", username);
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
				int userID=0;
				List finalBookingDetails = new ArrayList<>();
				
				String username = request.getParameter("userName");
				try {
					userDetails = UserDAO.loginUser(username);
					for(Iterator users=userDetails.iterator();users.hasNext();) {
						UserDetails user= (UserDetails) users.next();
						userID=user.getUserID();
					}
					BookingVehicles=UserDAO.userBookedVehicles(userID);
					if(BookingVehicles.size()!=0) {
						log.info(BookingVehicles);
						flag=0;
						for(Iterator bookings=BookingVehicles.iterator();bookings.hasNext();) {
							BookingDetails booking = (BookingDetails) bookings.next();
							userDetails = UserDAO.userDetailsWithID(booking.getUserID());
							vehicleDetails = UserDAO.vehicleDetailsWithID(booking.getVehicleID());

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
						RequestDispatcher dispatcher = request.getRequestDispatcher("UserAllBookedVehicles.jsp");
						request.setAttribute("bookingList", finalBookingDetails);
						request.setAttribute("details", username);
						dispatcher.forward(request, response);
					}else {
						RequestDispatcher dispatcher = request.getRequestDispatcher("invalidDetails.jsp");
						request.setAttribute("Err","No Users details present");
						request.setAttribute("details", username);
						dispatcher.forward(request, response);
					}
				} catch (DAOAppException e) {
					RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
					request.setAttribute("Err", e.getMessage());
					dispatcher.forward(request, response);
				}
				break;
			}
			
			case "Cancel Booking": {
				List userDetails = null;
				List BookingVehicles = null;
				int book = 0;
				List vehicleDetails = null;
				int count = 0;
				int count1 = 0;
				List finalBookingDetails = new ArrayList<>();
				int userID=0;
				int vehicleData=0;
				String username = request.getParameter("userName");
				String bookingID = request.getParameter("bookingID");
				try {
					if(bookingID.length()!=0) {
					book = UserDAO.bookingDetailsWithID(Integer.parseInt(bookingID));
					count1=UserDAO.updateVehicleStatus(book, "yes");
					}
					if(count1!=0) {
						userDetails = UserDAO.loginUser(username);
						for(Iterator users=userDetails.iterator();users.hasNext();) {
							UserDetails user= (UserDetails) users.next();
							userID=user.getUserID();
						}
						count=UserDAO.deleteUserBooking(userID, Integer.parseInt(bookingID));
					}
					if(count!=0) {
						BookingVehicles=UserDAO.userBookedVehicles(userID);
						if(BookingVehicles.size()!=0) {
							log.info(BookingVehicles);
							for(Iterator bookings=BookingVehicles.iterator();bookings.hasNext();) {
								BookingDetails booking = (BookingDetails) bookings.next();
								userDetails = UserDAO.userDetailsWithID(booking.getUserID());
								vehicleDetails = UserDAO.vehicleDetailsWithID(booking.getVehicleID());

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
						RequestDispatcher dispatcher = request.getRequestDispatcher("UserAllBookedVehicles.jsp");
						request.setAttribute("bookingList", finalBookingDetails);
						request.setAttribute("details", username);
						dispatcher.forward(request, response);
					}else {
						RequestDispatcher dispatcher = request.getRequestDispatcher("invalidDetails.jsp");
						request.setAttribute("Err","Invalid details present");
						request.setAttribute("details", username);
						dispatcher.forward(request, response);
					}
					
				}catch (DAOAppException e) {
					RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
					request.setAttribute("Err", e.getMessage());
					dispatcher.forward(request, response);
				}
				break;
			}
			
			case "Feedback": {
				int count=0;
				int userID=0;
				List userDetails = null;
				List vehicleDetails = null;
				List feedbackDetails = null;
				int flag=-1;
				int finals=-1;
				try {
					String username = request.getParameter("userName");
					String vehicleID = request.getParameter("vehicleID");
					String feedback = request.getParameter("feedback");
					userDetails = UserDAO.loginUser(username);
					for(Iterator users=userDetails.iterator();users.hasNext();) {
						UserDetails user= (UserDetails) users.next();
						userID=user.getUserID();
					}
					if(vehicleID.length()!=0 && feedback.length()!=0) {
					count=UserDAO.addUserFeedback(userID, Integer.parseInt(vehicleID), feedback);
					finals=0;
					}
					if(count!=0) {
						feedbackDetails=UserDAO.UserFeedback(userID);
						if(feedbackDetails.size()!=0) {
							log.info(feedbackDetails);
							flag=0;
						}
					}
						if(flag==0 && finals==0) {
							RequestDispatcher dispatcher = request.getRequestDispatcher("UserFeedback.jsp");
							request.setAttribute("feedbackList", feedbackDetails);
							request.setAttribute("details", username);
							dispatcher.forward(request, response);
						}else {
							RequestDispatcher dispatcher = request.getRequestDispatcher("invalidDetails.jsp");
							request.setAttribute("Err","Invalid details present");
							request.setAttribute("details", username);
							dispatcher.forward(request, response);
						}
					
				}catch (DAOAppException e) {
					RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
					request.setAttribute("Err", e.getMessage());
					dispatcher.forward(request, response);
				}
				break;
			}
			
			case "Home": {
				String username = request.getParameter("userName");
				RequestDispatcher dispatcher = request.getRequestDispatcher("UserHome.jsp");
				request.setAttribute("details", username);
				dispatcher.forward(request, response);
			}
			
			case "Log Out": {
				HttpSession sessionobj =request.getSession(); // existing session object 
				sessionobj.invalidate();	
				response.sendRedirect("UserLogin.jsp");
				break;
			}
		}
	}
}
