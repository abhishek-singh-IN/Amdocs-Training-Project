package com.amdocs.test;

import static org.junit.jupiter.api.Assertions.*;
import java.sql.SQLException;
import org.junit.jupiter.api.Test;
import com.amdocs.main.login;

class UserTypeDetectionTest {

	@Test
	void usertest1() throws SQLException {
		login ln = new login(String.valueOf(100),"ankit");
		assertEquals(0,ln.loginUser());
	}
	@Test
	void usertest2() throws SQLException {
		login ln = new login(String.valueOf(104),"rahul");
		assertEquals(0,ln.loginUser());
	}
	@Test
	void usertest3() throws SQLException {
		login ln = new login(String.valueOf(106),"test");
		assertEquals(0,ln.loginUser());
	}
	@Test
	void usertest4() throws SQLException {
		login ln = new login(String.valueOf(120),"pagal");
		assertEquals(0,ln.loginUser());
	}
	@Test
	void admintest1() throws SQLException {
		login ln = new login(String.valueOf(107),"test");
		assertEquals(1,ln.loginUser());
	}
	@Test
	void admintest2() throws SQLException {
		login ln = new login(String.valueOf(108),"testsuccess");
		assertEquals(1,ln.loginUser());
	}
}
