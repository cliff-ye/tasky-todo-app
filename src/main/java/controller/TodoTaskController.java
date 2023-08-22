package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TodotaskDAO;
import model.TodoItemBean;

@WebServlet(urlPatterns = {"/insert","/delete","/getItems"})
public class TodoTaskController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}

	private TodotaskDAO todoTaskDao;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//return path of url calling the method
		String url = req.getServletPath();
		
		switch(url) {
		case "/insert":
			addTodoItem(req,resp);
		break;
		case "/delete":
			deleteItem(req,resp);
			break;
		case "/getItems":
			getItems(req,resp);
		break;
		}
	}

	private void getItems(HttpServletRequest req, HttpServletResponse resp) {
		String username = req.getParameter("username");
		List<TodoItemBean> todoItems = todoTaskDao.getTodoItems(username);
		
		req.setAttribute("todoList",todoItems);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/index.jsp");
		try {
			dispatcher.forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void deleteItem(HttpServletRequest req, HttpServletResponse resp) {
		int id=Integer.parseInt(req.getParameter("id"));
		todoTaskDao.deleteItem(id);
		req.setAttribute("username",req.getParameter("username"));
		try {
			RequestDispatcher rd = req.getRequestDispatcher("/getItems");
			rd.forward(req, resp);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void addTodoItem(HttpServletRequest req, HttpServletResponse resp) {
		//req.setAttribute("username", req.getParameter(getServletInfo()));
		String title = req.getParameter("title");
		String username = req.getParameter("username");
		boolean isDone = Boolean.valueOf(req.getParameter("isDone"));
		LocalDate targetDate = LocalDate.parse(req.getParameter("targetDate"));
		
		TodoItemBean newTodoItem = new TodoItemBean();
		newTodoItem.setTitle(title);
		newTodoItem.setTargetDate(targetDate);
		newTodoItem.setDone(isDone);
		newTodoItem.setUsername(username);
		
		todoTaskDao.addTask(newTodoItem);
		try {
			req.setAttribute("username",username);
			RequestDispatcher rd = req.getRequestDispatcher("/getItems");
			rd.forward(req, resp);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void init() throws ServletException {
		todoTaskDao = new TodotaskDAO();
	}
	
	

}
