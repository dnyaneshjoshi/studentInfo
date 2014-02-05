package org.iiitb.action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;

import org.apache.commons.lang3.StringUtils;
import org.iiitb.util.ConnectionPool;
import org.iiitb.util.Constants;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport
{

	private String username;

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	private String password;

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String execute() throws NamingException, SQLException
	{

		String resultStr = SUCCESS;
		Connection conn = ConnectionPool.getConnection();

		PreparedStatement preStmt = conn.prepareStatement(Constants.GET_PASSWORD_QRY);
		preStmt.setString(1, username);
		ResultSet result = preStmt.executeQuery();

		if (result.first())
		{
			if (!password.equals(result.getString(Constants.DB_PASSWORD)))
			{
				addFieldError(Constants.DB_PASSWORD, Constants.INVALID_PASSWORD_ERROR);
				resultStr = INPUT;
			}

		}
		else
		{
			addFieldError(Constants.DB_USERNAME, Constants.INVALID_USER_ERROR);
			resultStr = INPUT;
		}
		ConnectionPool.freeConnection(conn);

		return resultStr;
	}

	public void validate()
	{

		if (StringUtils.isEmpty(username))
		{
			addFieldError(Constants.DB_USERNAME, Constants.USER_NAME_BLANK);
		}

		if (StringUtils.isEmpty(password))
		{
			addFieldError(Constants.DB_PASSWORD, Constants.PASSWORD_BLANK);
		}
	}

}
