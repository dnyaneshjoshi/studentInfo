package org.iiitb.action.syllabus;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.iiitb.action.dao.LayoutDAO;
import org.iiitb.action.dao.SyllabusDAO;
import org.iiitb.action.dao.impl.LayoutDAOImpl;
import org.iiitb.action.dao.impl.SyllabusDAOImpl;
import org.iiitb.model.User;
import org.iiitb.model.layout.AnnouncementsItem;
import org.iiitb.model.layout.NewsItem;
import org.iiitb.util.ConnectionPool;

import com.opensymphony.xwork2.ActionSupport;

public class SyllabusAction extends ActionSupport implements SessionAware{
		
	private List<SyllabusInfo> syllabusInfoList;
	private SyllabusDAO syllabusDAO = new SyllabusDAOImpl();
	private String subjectCode;
	
	private List<NewsItem> allNews;
  private List<AnnouncementsItem> announcements;
  private LayoutDAO layoutDAO = new LayoutDAOImpl();
  private Map<String, Object> session;
  
  private String lastLoggedOn;
  
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
  
    public String getSubjectCode() {
    return subjectCode;
  }
  
	// subjectCode to be send as a request parameter from Subjects page.
	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}

	public String execute() throws SQLException {
	  User user = (User) session.get("user");
    Connection connection = ConnectionPool.getConnection();
    syllabusInfoList = syllabusDAO.getSyllabus(connection, subjectCode);
    allNews = layoutDAO.getAllNews(connection);
    announcements = layoutDAO.getAnnouncements(connection,
        Integer.parseInt(user.getUserId()));
	setLastLoggedOn(layoutDAO.getLastLoggedOn(connection,
			Integer.parseInt(user.getUserId())));
    ConnectionPool.freeConnection(connection);
	    return SUCCESS;
	  }

	public List<SyllabusInfo> getSyllabusInfoList() {
		return syllabusInfoList;
	}

	public void setSyllabusInfoList(List<SyllabusInfo> syllabusInfoList) {
		this.syllabusInfoList = syllabusInfoList;
	}

  @Override
  public void setSession(Map<String, Object> session) {
    this.session = session;
    
  }

public String getLastLoggedOn()
{
	return lastLoggedOn;
}

public void setLastLoggedOn(String lastLoggedOn)
{
	this.lastLoggedOn = lastLoggedOn;
}
}
