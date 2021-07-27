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
	void usertest5() throws SQLException {
		login ln = new login(String.valueOf(100),"");
		assertEquals(2,ln.loginUser());
	}
	@Test
	void userincorrecttest1() throws SQLException {
		login ln = new login(String.valueOf(100),"fail");
		assertEquals(2,ln.loginUser());
	}
	@Test
	void userincorrecttest2() throws SQLException {
		login ln = new login(String.valueOf(104),"");
		assertEquals(2,ln.loginUser());
	}
	@Test
	void userincorrecttest3() throws SQLException {
		login ln = new login(String.valueOf(106),"TEST");
		assertEquals(2,ln.loginUser());
	}
	@Test
	void userincorrecttest4() throws SQLException {
		login ln = new login(String.valueOf(120),"Pagal");
		assertEquals(2,ln.loginUser());
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
	@Test
	void admintest3() throws SQLException {
		login ln = new login(String.valueOf(108),"");
		assertEquals(3,ln.loginUser());
	}
	@Test
	void adminincorrecttest1() throws SQLException {
		login ln = new login(String.valueOf(107),"TEST");
		assertEquals(3,ln.loginUser());
	}
	@Test
	void adminincorrecttest2() throws SQLException {
		login ln = new login(String.valueOf(108),"Testsuccess");
		assertEquals(3,ln.loginUser());
	}
	@Test
	void adminincorrecttest3() throws SQLException {
		login ln = new login(String.valueOf(107),"");
		assertEquals(3,ln.loginUser());
	}
	@Test
	void adminincorrecttest4() throws SQLException {
		login ln = new login(String.valueOf(108),"wrong");
		assertEquals(3,ln.loginUser());
	}
	@Test
	void nousertest1() throws SQLException {
		login ln = new login(String.valueOf(1),"wrong");
		assertEquals(5,ln.loginUser());
	}
	@Test
	void nousertest2() throws SQLException {
		login ln = new login("","wrong");
		assertEquals(5,ln.loginUser());
	}
	@Test
	void nousertest3() throws SQLException {
		login ln = new login("","");
		assertEquals(5,ln.loginUser());
	}
}
