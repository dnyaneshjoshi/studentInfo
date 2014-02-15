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
import org.iiitb.util.Constants;

import com.opensymphony.xwork2.ActionSupport;

public class SyllabusAction extends ActionSupport implements SessionAware{
		
	private List<SyllabusInfo> syllabusInfoList;
	private SyllabusDAO syllabusDAO = new SyllabusDAOImpl();
	private String subjectCode;
	
	private String code;
	private String courseName;
	private String credits;
	private String lastDate;
	private String semester;
	private String year;
	private String facultyName;
	private String syllabus;
	
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
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCredits() {
		return credits;
	}

	public void setCredits(String credits) {
		this.credits = credits;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getFacultyName() {
		return facultyName;
	}

	public String getLastDate() {
		return lastDate;
	}

	public void setLastDate(String lastDate) {
		this.lastDate = lastDate;
	}

	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}

	public String getSyllabus() {
		return syllabus;
	}

	public void setSyllabus(String syllabus) {
		this.syllabus = syllabus;
	}

	public String execute() throws SQLException {
	  User user = (User) session.get("user");
    Connection connection = ConnectionPool.getConnection();
    syllabusInfoList = syllabusDAO.getSyllabus(connection, subjectCode);
    allNews = layoutDAO.getAllNews(connection);
    announcements = layoutDAO.getAnnouncements(connection,
        Integer.parseInt(user.getUserId()));
	setLastLoggedOn((String) this.session.get(Constants.LAST_LOGGED_ON));
    ConnectionPool.freeConnection(connection);
	    return SUCCESS;
	  }
	
	public String setCourseAndSyllabus() throws SQLException {
		  User user = (User) session.get("user");
		  Connection connection = ConnectionPool.getConnection();
		  
		  boolean result = syllabusDAO.setCourseAndSyllabus(connection, code, courseName, credits, lastDate, 
					semester, year, facultyName, syllabus);
		  
		  
		  allNews = layoutDAO.getAllNews(connection);
		  announcements = layoutDAO.getAnnouncements(connection,Integer.parseInt(user.getUserId()));
		
		  setLastLoggedOn(layoutDAO.getLastLoggedOn(connection, Integer.parseInt(user.getUserId())));
		    
		  ConnectionPool.freeConnection(connection);
		  
		  if (result)
			  return SUCCESS;
		  else 
			  return ERROR;
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
