package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.LoginBean;
import utils.DBConnection;

public class LoginDAO {
	
	public boolean login(LoginBean loginBean) {
		boolean isLoggedIn = false;
		
		Connection connection = DBConnection.getConnection();
		
		try {
			PreparedStatement ps = connection.prepareStatement("select * from users where username=? and password=?");
			ps.setString(1, loginBean.getUsername());
			ps.setString(2, loginBean.getPassword());
			
			ResultSet rs = ps.executeQuery();
			
			isLoggedIn = rs.next();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isLoggedIn;
	}

}
