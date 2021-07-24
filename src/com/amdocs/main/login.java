package com.amdocs.main;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class login {
	String userid =null;
	static String password = null;
	
	public String getUserid() {
		return userid;
	}
	public String getPassword() {
		return password;
	}
	public login(String userid, String password) {
		super();
		this.userid = userid;
		login.password = password;
	}
	public int loginUser() {
				
		try {
			Connection con = DBconnect.dbconn();			
            CallableStatement stmt=con.prepareCall("{?= call getStudent(?)}");
            stmt.setInt(2,2);
            stmt.registerOutParameter(1,Types.VARCHAR);
            stmt.execute();
            
            //Verify UserId with password
			
			if(password.equals(stmt.getString(1)) ) {
				return 0;  
			}
			
			return 1;
		} catch (SQLException e) {
			return -1;
		}
	}
}
