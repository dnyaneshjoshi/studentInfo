package org.iiitb.action.enrollment;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.iiitb.action.dao.LayoutDAO;
import org.iiitb.action.dao.impl.LayoutDAOImpl;
import org.iiitb.action.dao.impl.SemesterDAOImpl;
import org.iiitb.model.User;
import org.iiitb.model.layout.AnnouncementsItem;
import org.iiitb.model.layout.NewsItem;
import org.iiitb.util.ConnectionPool;
import org.iiitb.util.Constants;
import com.opensymphony.xwork2.ActionSupport;

public class EnrollmentAction extends ActionSupport implements SessionAware {

  /**
   * serial id
   */
  private static final long serialVersionUID = 3193702317572110684L;
  private static final String USER = "user";
  private Map<String, Object> session;

  private List<String> semester;
  private List<NewsItem> allNews;
  private List<AnnouncementsItem> announcements;
  private LayoutDAO layoutDAO = new LayoutDAOImpl();
  
  public List<String> getSemester() {
    return semester;
  }

  public void setSemester(List<String> semester) {
    this.semester = semester;
  }

  private String lastLoggedOn;

  public String execute() throws SQLException {
    User loggedInUser = (User) this.session.get(USER);
    if (null != loggedInUser) {
      semester = new SemesterDAOImpl().getTerms();
      setLastLoggedOn((String) this.session.get(Constants.LAST_LOGGED_ON));
      Connection connection = ConnectionPool.getConnection();
      allNews = layoutDAO.getAllNews(connection);
      announcements = layoutDAO.getAnnouncements(connection,
          Integer.parseInt(loggedInUser.getUserId()));
      ConnectionPool.freeConnection(connection);
      return SUCCESS;
    } else {
      return LOGIN;
    }
  }

  @Override
  public void setSession(Map<String, Object> session) {
    this.session = session;
  }

  public String getLastLoggedOn() {
    return lastLoggedOn;
  }

  public void setLastLoggedOn(String lastLoggedOn) {
    this.lastLoggedOn = lastLoggedOn;
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

}
