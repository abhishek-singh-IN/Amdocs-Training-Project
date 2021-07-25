package com.amdocs.main;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Types;

import com.amdocs.admin.Admin;
import com.amdocs.user.User;

public class Register {

	public static int registerUser(User user) throws ClassNotFoundException, SQLException {

		Connection con = DBconnect.dbconn();
		CallableStatement preparedStatement;

		preparedStatement = con.prepareCall("{?= call insertUSER1(?,?,?,?,?,?,?)}");
		preparedStatement.setString(2, user.getName());
		preparedStatement.setString(3, user.getPhone());
		preparedStatement.setString(4, user.getEmail());
		preparedStatement.setString(5, user.getAddress());
		preparedStatement.setDate(6, (Date) user.getReg_date());
		preparedStatement.setString(7, user.getPassword());
		preparedStatement.setString(8, user.getUpload_photo());
		preparedStatement.registerOutParameter(1, Types.INTEGER);
		preparedStatement.execute();

		con.close();
		return preparedStatement.getInt(1);
	}

	public static int registerAdmin(Admin admin) throws ClassNotFoundException, SQLException {
		
		Connection con = DBconnect.dbconn();
		CallableStatement preparedStatement;

		preparedStatement = con.prepareCall("{?= call insertADMIN1(?,?,?)}");
		
		preparedStatement.setString(2, admin.getName());
		preparedStatement.setString(3, admin.getEmail());
		preparedStatement.setString(4, admin.getPassword());
		preparedStatement.registerOutParameter(1, Types.INTEGER);
		preparedStatement.execute();

		con.close();
		return preparedStatement.getInt(1);
	}

}
