package com.amdocs.main;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class login {

	public static int loginUser(String userid ,String password) {
				
		try {
			Connection con = DBconnect.dbconn();			
			
            CallableStatement stmt=con.prepareCall("{?= call getStudent(?)}");
            stmt.setInt(2,2);
            stmt.registerOutParameter(1,Types.VARCHAR);
            stmt.execute();
			
			if(password.equals(stmt.getString(1)) ) {
				return 0;  
			}
			
			return 1;
		} catch (SQLException e) {
			return -1;
		}
		
		
	}
}
