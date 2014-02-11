package org.iiitb.action.subjects;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.iiitb.action.dao.CourseDAO;
import org.iiitb.action.dao.impl.CourseDAOImpl;
import org.iiitb.model.User;
import org.iiitb.util.ConnectionPool;

import com.opensymphony.xwork2.ActionSupport;

public class SubjectsAction extends ActionSupport implements SessionAware {

  /**
   * serial id
   */
  private static final long serialVersionUID = 3193702317572110684L;

  private static final String SHOW_ALL_COURSES = "Show All Courses";
  private static final String SHOW_ENROLLED_COURSES = "Show Enrolled Courses";

  private static final String USER = "user";
  private List<SubjectInfo> subjectInfoList;
  private List<String> subjectDisplayList;
  private String subjectDisplayChoice;
  private CourseDAO courseDAO = new CourseDAOImpl();
  private Map<String, Object> session;

  {
    subjectDisplayList = new ArrayList<String>();
    subjectDisplayList.add(SHOW_ALL_COURSES);
    subjectDisplayList.add(SHOW_ENROLLED_COURSES);
  }

  public List<String> getSubjectDisplayList() {
    return subjectDisplayList;
  }

  public void setSubjectDisplayList(List<String> subjectDisplayList) {
    this.subjectDisplayList = subjectDisplayList;
  }

  public String getSubjectDisplayChoice() {
    return subjectDisplayChoice;
  }

  public void setSubjectDisplayChoice(String subjectDisplayChoice) {
    this.subjectDisplayChoice = subjectDisplayChoice;
  }

  public List<SubjectInfo> getSubjectInfoList() {
    return subjectInfoList;
  }

  public void setSubjectInfoList(List<SubjectInfo> subjectInfoList) {
    this.subjectInfoList = subjectInfoList;
  }

  public String execute() {
    Connection connection = ConnectionPool.getConnection();
    User loggedInUser = (User) this.session.get(USER);
    if (null != loggedInUser) {
      if (null == subjectDisplayChoice
          || subjectDisplayChoice.equals(SHOW_ALL_COURSES)) {
        subjectInfoList = courseDAO.getAllCourses(connection,
            Integer.parseInt(loggedInUser.getUserId()));
      } else {
        subjectInfoList = courseDAO.getEnrolledCourses(connection,
            Integer.parseInt(loggedInUser.getUserId()));
      }

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

}
