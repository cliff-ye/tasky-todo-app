package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.LoginBean;
import dao.LoginDAO;

//mapping servlet to url
@WebServlet("/login")
public class LoginController extends HttpServlet{
	
	private LoginDAO loginDAO;
	
	//pre defined initializer. dont need initialize new instance for each request
	@Override
	public void init() throws ServletException {
		loginDAO = new LoginDAO();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userName = req.getParameter("username");
		String password = req.getParameter("password");
		
		LoginBean loginBean = new LoginBean();
		loginBean.setUsername(userName);
		loginBean.setPassword(password);
		
		String forwardUrl;
		
		if(loginDAO.login(loginBean)) {
			req.setAttribute("username", userName);
			forwardUrl ="/getItems";
		}
		else {
			forwardUrl ="/view/login.jsp";
		}
		RequestDispatcher dispatcher = req.getRequestDispatcher(forwardUrl);
		dispatcher.forward(req, resp);
	}
}
