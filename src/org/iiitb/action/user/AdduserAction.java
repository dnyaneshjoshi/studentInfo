package org.iiitb.action.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

import javax.naming.NamingException;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.SessionAware;
import org.iiitb.util.ConnectionPool;
import org.iiitb.util.Constants;

import com.opensymphony.xwork2.ActionSupport;

public class AdduserAction extends ActionSupport implements SessionAware

{

	private String username;
	private String name;
	private String userType;
	private String emailId;
	private String password;


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	
	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	private Map<String, Object> session;

	public Map<String, Object> getSession() {
		return session;
	}

	public String execute() throws NamingException, SQLException {
		
		String ret = ERROR;
		Connection conn = ConnectionPool.getConnection();

		PreparedStatement preStmt = null;
		try {
			String query = "insert into user(name,username,password,email,user_type) values(?,?,?,?,?)";

			preStmt = conn.prepareStatement(query);
			preStmt.setString(1, name);
			preStmt.setString(2, username);
			preStmt.setString(3, password);
			preStmt.setString(4, emailId);
			preStmt.setString(5, userType);

			if (preStmt.executeUpdate() > 0)
				ret = SUCCESS;
			else
				ret = ERROR;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionPool.freeConnection(conn);
		}
		return ret;

	}

	public void validate() {

		if (StringUtils.isEmpty(username)) {
			addFieldError(Constants.DB_USERNAME, Constants.USER_NAME_BLANK);
		}

		if (StringUtils.isEmpty(password)) {
			addFieldError(Constants.DB_PASSWORD, Constants.PASSWORD_BLANK);
		}

		if (StringUtils.isEmpty(name)) {
			addFieldError("name", "name cannot be blank");
		}

		

		if (StringUtils.isEmpty(emailId)) {
			addFieldError("emailId", "emailId cannot be blank");
		}

		if (StringUtils.isEmpty(userType)) {
			addFieldError("userType", "userType cannot be blank");
		}

	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;

	}
}