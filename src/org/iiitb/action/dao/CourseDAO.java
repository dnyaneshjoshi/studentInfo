package org.iiitb.action.dao;

import java.sql.Connection;
import java.util.List;

import org.iiitb.action.subjects.SubjectInfo;

public interface CourseDAO {

  /**
   * Gets all the courses
   * 
   * @param connection
   * @param userId
   * @return list of subjectInfo objects
   */
  public List<SubjectInfo> getAllCourses(Connection connection, int userId);

  /**
   * Get Enrolled Courses
   * 
   * @param connection
   * @param userId
   * @return list of subjectInfo objects
   */
  public List<SubjectInfo> getEnrolledCourses(Connection connection, int userId);

}
