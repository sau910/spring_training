package com.zensar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zensar.utility.DBUtil;

public class LoginRepository {
	
	public boolean checkLogin(String userName,String password) {
		boolean result= false;
		Connection con = DBUtil.getMySqlDbConnection();
		String sql = "select * from log_in where user_id=?";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, userName);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				String passwordDB = rs.getString("password");
				if(password.equals(passwordDB)) {
					result = true;
				}
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
}
