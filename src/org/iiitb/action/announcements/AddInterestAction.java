package org.iiitb.action.announcements;

import java.sql.Connection;
import java.sql.SQLException;

import org.iiitb.action.dao.InterestDAO;
import org.iiitb.action.dao.impl.InterestDAOImpl;
import org.iiitb.model.layout.Interest;
import org.iiitb.util.ConnectionPool;

import com.opensymphony.xwork2.ActionSupport;

public class AddInterestAction extends ActionSupport
{
	private String name;
	private String details;
	
	public String execute() throws SQLException
	{
		Connection cn=ConnectionPool.getConnection();
		InterestDAO interestDAO=new InterestDAOImpl();
		interestDAO.addInterest(cn, new Interest(name, details));
		ConnectionPool.freeConnection(cn);
		return "success";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}
}
