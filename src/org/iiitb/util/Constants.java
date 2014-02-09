package org.iiitb.util;

public interface Constants
{
	String GET_PASSWORD_QRY = "select * from user where username=?";

	
	String INVALID_PASSWORD_ERROR = "username, password doesn't match";
	String INVALID_USER_ERROR = "user doesnt exits";

	String USER_NAME_BLANK = "username is blank";

	String PASSWORD_BLANK = "password is blank";

	String DB_USERNAME = "username";
	String DB_PASSWORD = "password";

	String NOT_A_FRIEND = "not_a_friend";
	String FRIEND = "friend";

}
