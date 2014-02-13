package org.iiitb.action;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

import org.apache.struts2.interceptor.SessionAware;
import org.iiitb.action.dao.LayoutDAO;
import org.iiitb.action.dao.impl.LayoutDAOImpl;
import org.iiitb.model.User;
import org.iiitb.util.ConnectionPool;

public class LogoutAction extends ActionSupport implements SessionAware
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7751903212229027485L;
	private Map<String, Object> session;
	
	private LayoutDAO layoutDAO = new LayoutDAOImpl();

	public Map<String, Object> getSession()
	{
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session)
	{
		this.session = session;

	}

	@Override
	public String execute() throws NumberFormatException, SQLException
	{
		System.out.println("logout called");
		User loggedInUser = (User) this.session.get("user");
		Connection connection = ConnectionPool.getConnection();
		layoutDAO.setLastLoggedOn(connection,
				Integer.parseInt(loggedInUser.getUserId()));
		ConnectionPool.freeConnection(connection);
		session.remove("user");
		return SUCCESS;
	}

}
