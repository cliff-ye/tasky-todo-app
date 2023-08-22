package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.UserBean;

import dao.UserDAO;

@WebServlet("/register")
public class UserController extends HttpServlet{
	
	private UserDAO userDAO;
	
	@Override
	public void init() throws ServletException {
		userDAO = new UserDAO();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String firstName = req.getParameter("firstname");
		String lastName = req.getParameter("lastname");
		String userName = req.getParameter("username");
		String password = req.getParameter("password");
		
	   UserBean userBean = new UserBean();
	   userBean.setFirstName(firstName);
	   userBean.setLastName(lastName);
	   userBean.setUsername(userName);
	   userBean.setPassword(password);
	   
	   boolean result = userDAO.registerUser(userBean);
	   
	   if(result)
	   {
		   RequestDispatcher dispatcher = req.getRequestDispatcher("/view/login.jsp");
		   dispatcher.forward(req, resp);
	   }


	
	}

}
