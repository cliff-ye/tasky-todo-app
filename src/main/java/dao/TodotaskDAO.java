package dao;

import utils.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.TodoItemBean;
import model.UserBean;

import java.sql.Date;

public class TodotaskDAO {
	private static final String insertQry = "insert into tasks(title,targetDate,isDone,username) values(?,?,?,?)";
	private static final String deleteQry = "delete from tasks where id=?";
	private static final String retrieveQry = "select * from tasks where username = ?";
			
	public boolean addTask(TodoItemBean todoBean) {
		boolean isAdded = false;
		Connection connection = DBConnection.getConnection();
		
		try {
			PreparedStatement ps = connection.prepareStatement(insertQry);
			ps.setString(1, todoBean.getTitle());
			ps.setDate(2, Date.valueOf(todoBean.getTargetDate()));
			ps.setBoolean(3, todoBean.getIsDone());
			ps.setString(4, todoBean.getUsername());
			
			int result = ps.executeUpdate();
			
			isAdded = (result > 0);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isAdded;
	}

	public boolean deleteItem(int id) {
		boolean isDeleted = false;
		
		Connection connection = DBConnection.getConnection();
		
		try {
			PreparedStatement ps = connection.prepareStatement(deleteQry);
			ps.setLong(1, id);
			
			int result = ps.executeUpdate();
			
			isDeleted = (result > 0);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isDeleted;
	}
	
	public List<TodoItemBean> getTodoItems(String username){
		List<TodoItemBean> todoList = new ArrayList<>();
		
		Connection connection = DBConnection.getConnection();
		
		try {
			PreparedStatement ps = connection.prepareStatement(retrieveQry);
			ps.setString(1, username);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Long id = rs.getLong(1);
				String title = rs.getString(2);
				LocalDate targetDate = rs.getDate(3).toLocalDate();
				boolean isDone = rs.getBoolean(4);
				String userName = rs.getString(5);
				
				TodoItemBean newtodoItem = new TodoItemBean();
				newtodoItem.setId(id);
				newtodoItem.setTitle(title);
				newtodoItem.setTargetDate(targetDate);
				newtodoItem.setDone(isDone);
				newtodoItem.setUsername(userName);
				
				todoList.add(newtodoItem);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return todoList;
	}
}
