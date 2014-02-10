package org.iiitb.action.home;

import java.util.List;
import java.sql.Connection;
import java.sql.SQLException;

import com.opensymphony.xwork2.ActionSupport;

import org.iiitb.util.ConnectionPool;
import org.iiitb.action.dao.LayoutDAO;
import org.iiitb.action.dao.impl.LayoutDAOImpl;
import org.iiitb.model.layout.*;

public class HomeAction extends ActionSupport
{
	private String picUrl;
	private List<NewsItem> allNews;
	private List<AnnouncementsItem> announcements;
	
	private LayoutDAO layoutDAO=new LayoutDAOImpl();
	
	public String execute() throws SQLException
	{
		Connection cn=ConnectionPool.getConnection();
		allNews=layoutDAO.getAllNews(cn);
		announcements=layoutDAO.getAnnouncements(cn, 2);
		ConnectionPool.freeConnection(cn);
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

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
}
