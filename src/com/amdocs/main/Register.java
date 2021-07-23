package com.amdocs.main;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.amdocs.admin.Admin;
import com.amdocs.user.User;

public class Register {
	
	public static int registerUser(User user) throws ClassNotFoundException{
		
		String INSERT_USERS_SQL = "INSERT INTO user1" +
	            "  (user_id,name,phone_no,email,address,reg_date,password,upload_photo) VALUES " +
	            " (userid.nextval,?, ?, ?, ?, ?,?,?)" + 
	            "returning user_id into :l_user_id;;";
		
		int result = 0;
		
		try (Connection con = DBconnect.dbconn();
		
		PreparedStatement preparedStatement = con.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getPhone());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getAddress());
            preparedStatement.setDate(5, (Date) user.getReg_date());
            preparedStatement.setString(6, user.getPassword());
            preparedStatement.setString(7, user.getUpload_photo());

            result = preparedStatement.executeUpdate();
            
		}catch (SQLException e) {
			printSQLException(e);
		}
		return result;
	}
	
	public static int registerAdmin(Admin admin) throws ClassNotFoundException{
			
			String INSERT_USERS_SQL = "INSERT INTO admin" +
		            "  (name,email,password) VALUES " +
		            " (?, ?, ?);";
			
			int result = 0;
			
			try (Connection con = DBconnect.dbconn();
			
			PreparedStatement preparedStatement = con.prepareStatement(INSERT_USERS_SQL)) {
	            preparedStatement.setString(1, admin.getName());
	            preparedStatement.setString(2, admin.getEmail());
	            preparedStatement.setString(3, admin.getPassword());
	
	            result = preparedStatement.executeUpdate();
		}
			catch (SQLException e) {
	        printSQLException(e);
	    }
	    return result;
	}

    private static void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
    
}
