/**
 * 
 */
package org.iiitb.action.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.iiitb.action.dao.CourseDAO;
import org.iiitb.action.subjects.SubjectInfo;

/**
 * @author arjun
 * 
 */
public class CourseDAOImpl implements CourseDAO {

  private static final String ALL_COURSES_QUERY = "SELECT  "
      + "    SUBJECTS_AVAILABLE.course_id as course_id, "
      + "    subject_code, "
      + "    subject_name, "
      + "    faculty_name, "
      + "    semester_term, "
      + "    student_id, "
      + "    grade_name "
      + "FROM "
      + "    (SELECT  "
      + "        course.course_id as course_id, "
      + "            course.code as subject_code, "
      + "            course.name as subject_name, "
      + "            teacher.name as faculty_name, "
      + "            semester.term as semester_term "
      + "    FROM "
      + "        course course "
      + "    LEFT OUTER JOIN semester semester ON semester.semester_id = course.semester_id "
      + "    LEFT OUTER JOIN faculty faculty ON course.faculty_id = faculty.faculty_id "
      + "    LEFT OUTER JOIN user teacher ON faculty.faculty_id = teacher.user_id) SUBJECTS_AVAILABLE "
      + "        LEFT OUTER JOIN "
      + "    (SELECT  "
      + "        course.course_id, "
      + "            student.user_id as student_id, "
      + "            student.name as student_name, "
      + "            grade.name as grade_name "
      + "    FROM "
      + "        course course "
      + "    LEFT OUTER JOIN faculty faculty ON course.faculty_id = faculty.faculty_id "
      + "    LEFT OUTER JOIN user teacher ON faculty.faculty_id = teacher.user_id "
      + "    LEFT OUTER JOIN result result ON result.course_id = course.course_id "
      + "    LEFT OUTER JOIN user student ON student.user_id = result.student_id "
      + "    LEFT OUTER JOIN grade grade ON grade.grade_id = result.grade_id "
      + "    LEFT OUTER JOIN semester semester ON semester.semester_id = course.semester_id "
      + "    WHERE "
      + "        student.user_id = ?) STUDENT_SELECTION ON STUDENT_SELECTION.course_id = SUBJECTS_AVAILABLE.course_id "
      + "ORDER BY subject_code;";

  private static final String ENROLLED_COURSE_QUERY = "SELECT  "
      + "    course.course_id as course_id, " + "    student.user_id as student_id, "
      + "    student.name as student_name, " + "    grade.name as grade_name, "
      + "    course.code as subject_code, "
      + "    course.name as subject_name, "
      + "    teacher.name as faculty_name, "
      + "    semester.term as semester_term " + "FROM " + "    course course "
      + "        LEFT OUTER JOIN "
      + "    faculty faculty ON course.faculty_id = faculty.faculty_id "
      + "        LEFT OUTER JOIN "
      + "    user teacher ON faculty.faculty_id = teacher.user_id "
      + "        LEFT OUTER JOIN "
      + "    result result ON result.course_id = course.course_id "
      + "        LEFT OUTER JOIN "
      + "    user student ON student.user_id = result.student_id "
      + "        LEFT OUTER JOIN "
      + "    grade grade ON grade.grade_id = result.grade_id "
      + "        LEFT OUTER JOIN "
      + "    semester semester ON semester.semester_id = course.semester_id "
      + "WHERE " + "    student.user_id = ?";

  private void createSubjectInfoListFromResultSet(ResultSet rs,
      List<SubjectInfo> subjectInfoList) throws SQLException {
    while (rs.next()) {
      String courseId = rs.getString("course_id");
      String subjectCode = rs.getString("subject_code");
      String subjectName = rs.getString("subject_name");
      String facultyName = rs.getString("faculty_name");
      int semester = rs.getInt("semester_term");
      String enrolledVal = rs.getString("student_id");
      String enrolled = (null == enrolledVal) ? "N" : "Y";
      String gradeVal = rs.getString("grade_name");
      String grade = (null == gradeVal) ? "NA" : gradeVal;
      SubjectInfo subjectInfo = new SubjectInfo(courseId, subjectCode, subjectName,
          facultyName, semester, enrolled, grade);
      subjectInfoList.add(subjectInfo);
    }
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.iiitb.action.dao.CourseDAO#getAllCourses(java.sql.Connection, int)
   */
  @Override
  public List<SubjectInfo> getAllCourses(Connection connection, int userId) {
    List<SubjectInfo> subjectInfoList = null;
    PreparedStatement ps = null;
    try {
      subjectInfoList = new ArrayList<SubjectInfo>();
      ps = connection.prepareStatement(ALL_COURSES_QUERY);
      int index = 1;
      ps.setInt(index, userId);
      ResultSet rs = ps.executeQuery();
      createSubjectInfoListFromResultSet(rs, subjectInfoList);
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      if (null != ps) {
        try {
          ps.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
    }
    return subjectInfoList;
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.iiitb.action.dao.CourseDAO#getEnrolledCourses(java.sql.Connection,
   * int)
   */
  @Override
  public List<SubjectInfo> getEnrolledCourses(Connection connection, int userId) {
    List<SubjectInfo> subjectInfoList = null;
    PreparedStatement ps = null;
    try {
      subjectInfoList = new ArrayList<SubjectInfo>();
      ps = connection.prepareStatement(ENROLLED_COURSE_QUERY);
      int index = 1;
      ps.setInt(index, userId);
      ResultSet rs = ps.executeQuery();
      createSubjectInfoListFromResultSet(rs, subjectInfoList);

    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      if (null != ps) {
        try {
          ps.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
    }
    return subjectInfoList;
  }

}
