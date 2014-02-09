package org.iiitb.action.subjects;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.iiitb.action.dao.CourseDAO;
import org.iiitb.action.dao.impl.CourseDAOImpl;
import org.iiitb.util.ConnectionPool;

import com.opensymphony.xwork2.ActionSupport;

public class SubjectsAction extends ActionSupport {

  /**
   * serial id
   */
  private static final long serialVersionUID = 3193702317572110684L;

  private static final String SHOW_ALL_COURSES = "Show All Courses";
  private static final String SHOW_ENROLLED_COURSES = "Show Enrolled Courses";
  private List<SubjectInfo> subjectInfoList;
  private List<String> subjectDisplayList;
  private String subjectDisplayChoice;
  private CourseDAO courseDAO = new CourseDAOImpl();

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
    if (null == subjectDisplayChoice
        || subjectDisplayChoice.equals(SHOW_ALL_COURSES)) {
      subjectInfoList = courseDAO.getAllCourses(connection, 2);
    } else {
      subjectInfoList = courseDAO.getEnrolledCourses(connection, 2);
    }

    ConnectionPool.freeConnection(connection);
    return SUCCESS;
  }

}
