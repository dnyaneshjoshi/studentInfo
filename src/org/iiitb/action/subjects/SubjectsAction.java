package org.iiitb.action.subjects;

import java.sql.Connection;
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

  private List<SubjectInfo> subjectInfoList;
  private List<SubjectInfo> selectedSubjectInfoList;
  private CourseDAO courseDAO = new CourseDAOImpl();

  {
    Connection connection = ConnectionPool.getConnection();
    subjectInfoList = courseDAO.getAllCourses(connection, 2);
    selectedSubjectInfoList = courseDAO.getEnrolledCourses(connection, 2);
    ConnectionPool.freeConnection(connection);
  }

  public List<SubjectInfo> getSelectedSubjectInfoList() {
    return selectedSubjectInfoList;
  }

  public void setSelectedSubjectInfoList(
      List<SubjectInfo> selectedSubjectInfoList) {
    this.selectedSubjectInfoList = selectedSubjectInfoList;
  }

  public List<SubjectInfo> getSubjectInfoList() {
    return subjectInfoList;
  }

  public void setSubjectInfoList(List<SubjectInfo> subjectInfoList) {
    this.subjectInfoList = subjectInfoList;
  }

  public String execute() {
    return SUCCESS;
  }

}
