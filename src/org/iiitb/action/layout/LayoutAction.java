package org.iiitb.action.layout;

import java.util.List;
import java.util.Map;
import java.sql.Connection;
import java.sql.SQLException;

import com.opensymphony.xwork2.ActionSupport;

import org.apache.struts2.interceptor.SessionAware;
import org.iiitb.util.ConnectionPool;
import org.iiitb.action.dao.LayoutDAO;
import org.iiitb.action.dao.impl.LayoutDAOImpl;
import org.iiitb.model.User;
import org.iiitb.model.layout.*;

public class LayoutAction extends ActionSupport implements SessionAware
{
	private Map<String, Object> session;
	private User user;
	private List<NewsItem> allNews;
	private List<AnnouncementsItem> announcements;
	
	private LayoutDAO layoutDAO=new LayoutDAOImpl();
	
	public String execute() throws SQLException
	{
		user = (User)session.get("user");
		if (user != null)
		{
			System.out.println("user id: "+user.getUserId());
			Connection cn=ConnectionPool.getConnection();
			allNews=layoutDAO.getAllNews(cn);
			announcements=layoutDAO.getAnnouncements(cn, Integer.parseInt(user.getUserId()));
			ConnectionPool.freeConnection(cn);	
		}
		return "success";
	}

	public List<NewsItem> getAllNews() {
		return allNews;
	}

	public void setAllNews(List<NewsItem> allNews) {
		this.allNews = allNews;
	}

	public List<AnnouncementsItem> getAnnouncements() {
		return announcements;
	}

	public void setAnnouncements(List<AnnouncementsItem> announcements) {
		this.announcements = announcements;
	}
	
	public User getUser()
	{
		return this.user;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		this.session=arg0;
	}
}
