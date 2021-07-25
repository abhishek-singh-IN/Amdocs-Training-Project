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
	public int loginUser() throws SQLException {

			Connection con = DBconnect.dbconn();			
            CallableStatement stmt=con.prepareCall("{?= call getStudent(?)}");
            stmt.setInt(2,2);
            stmt.registerOutParameter(1,Types.VARCHAR);
            stmt.execute();
            con.close();
            
            //Verify UserId with password
            /*
             * 		Connection con = DBconnect.dbconn();
					CallableStatement preparedStatement;
			
					preparedStatement = con.prepareCall("{?= verifyLogin(?,?)}");
					preparedStatement.setInt(2, userid);
					preparedStatement.setString(3, password);
					preparedStatement.registerOutParameter(1, Types.INTEGER);
					preparedStatement.execute();
			
					con.close();					
					return preparedStatement.getInt(1);
             */
			
			if(password.equals(stmt.getString(1)) ) {
				return 0;  
			}
			
			return 1;

	}
}
