package dao;

import utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.UserBean;

public class UserDAO {
	private static final String sql = "insert into users(first_name,last_name,username,password) values(?,?,?,?)";

	public boolean registerUser(UserBean userBean) {
		boolean isRegistered = false;
		
		Connection connection = DBConnection.getConnection();
		
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, userBean.getFirstName());
			ps.setString(2, userBean.getLastName());
			ps.setString(3, userBean.getUsername());
			ps.setString(4, userBean.getPassword());
			
			int result = ps.executeUpdate();
			
			isRegistered = (result != 0);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return isRegistered;
	
	}

}
