/**
 * 
 */
package org.iiitb.action.dao.impl;

import java.util.LinkedList;
import java.util.List;

import org.iiitb.action.dao.ResultDAO;
import org.iiitb.action.grades.GradeInfo;
import org.iiitb.util.ConnectionPool;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author kempa
 * 
 */
public class ResultDAOImpl implements ResultDAO
{
	private List<GradeInfo> resultList = new LinkedList<GradeInfo>();
	
	private List<String> gradeList = new LinkedList<String>();
	
	private static final String GET_GRADES_QUERY1 = "select course.code, grade.name, "
			+ "grade.status "
			+ "from course, result, grade, semester "
			+ "where course.course_id = result.course_id "
			+ "and result.grade_id = grade.grade_id "
			+ "and course.semester_id = semester.semester_id "
			+ "and result.student_id = ? "
			+ "and semester.term = ? "
			+ " and course.name = ?";
	private static final String GET_GRADES_QUERY2 = "select "
			+ "course.name, course.code, grade.name, grade.status "
			+ "from "
			+ "course, result, grade, semester "
			+ "where "
			+ "course.course_id = result.course_id "
			+ "and "
			+ "result.grade_id = grade.grade_id "
			+ "and "
			+ "course.semester_id = semester.semester_id "
			+ "and "
			+ "result.student_id = ?";
	private static final String GET_GRADES_QUERY3 = "select "
			+ "course.name, course.code, grade.name, grade.status "
			+ "from "
			+ "course, result, grade, semester "
			+ "where "
			+ "course.course_id = result.course_id "
			+ "and "
			+ "result.grade_id = grade.grade_id "
			+ "and "
			+ "course.semester_id = semester.semester_id "
			+ "and "
			+ "result.student_id = ? "
			+ "and semester.term = ? ";
	
	private static final String GET_GRADES_QUERY4 = "select "
			+ "distinct name "
			+ "from grade";

	public List<GradeInfo> getGrades(int studentID, int term, String subjectName)
	{
		Connection con = ConnectionPool.getConnection();
		PreparedStatement ps = null;
		ResultSet rs;
		try
		{
			ps = con.prepareStatement(GET_GRADES_QUERY1);
			ps.setInt(1, studentID);
			ps.setInt(2, term);
			ps.setString(3, subjectName);
			rs = ps.executeQuery();
			while (rs.next())
			{
				String subjectCode = rs.getString(1);
				String grade = rs.getString(2);
				String result = rs.getString(3);
				resultList.add(new GradeInfo(subjectName, subjectCode, grade,
						result));
			}
			con.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (ps != null)
				try
				{
					ps.close();
				}
				catch (SQLException e)
				{
					e.printStackTrace();
				}
		}

		return resultList;
	}

	public List<GradeInfo> getGrades(int studentID)
	{
		Connection con = ConnectionPool.getConnection();
		PreparedStatement ps = null;
		ResultSet rs;
		try
		{
			ps = con.prepareStatement(GET_GRADES_QUERY2);
			ps.setInt(1, studentID);
			rs = ps.executeQuery();
			while (rs.next())
			{
				String subjectName = rs.getString(1);
				String subjectCode = rs.getString(2);
				String grade = rs.getString(3);
				String result = rs.getString(4);
				resultList.add(new GradeInfo(subjectName, subjectCode, grade,
						result));
			}
			con.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (ps != null)
				try
				{
					ps.close();
				}
				catch (SQLException e)
				{
					e.printStackTrace();
				}
		}

		
		return resultList;
	}
	
	public List<GradeInfo> getGrades(int studentID, int term)
	{
		Connection con = ConnectionPool.getConnection();
		PreparedStatement ps = null;
		ResultSet rs;
		try
		{
			ps = con.prepareStatement(GET_GRADES_QUERY3);
			ps.setInt(1, studentID);
			ps.setInt(2, term);
			rs = ps.executeQuery();
			while (rs.next())
			{
				String subjectName = rs.getString(1);
				String subjectCode = rs.getString(2);
				String grade = rs.getString(3);
				String result = rs.getString(4);
				resultList.add(new GradeInfo(subjectName, subjectCode, grade,
						result));
			}
			con.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (ps != null)
				try
				{
					ps.close();
				}
				catch (SQLException e)
				{
					e.printStackTrace();
				}
		}

		return resultList;
	}
	
	public List<String> getGrades() {
		Connection con = ConnectionPool.getConnection();
		PreparedStatement ps = null;
		ResultSet rs;
		try {
			ps = con.prepareStatement(GET_GRADES_QUERY4);
			rs = ps.executeQuery();
			while (rs.next()) {
				String gradeName = rs.getString(1);
				gradeList.add(gradeName);
			}
			con.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			if (ps != null)
				try {
					ps.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
		}

		return gradeList;
	}
}
