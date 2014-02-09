/**
 * 
 */
package org.iiitb.action.grades;

import java.util.LinkedList;
import java.util.List;

import org.iiitb.util.ConnectionPool;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author kempa
 * 
 */
public class ResultDao
{
	private List<GradeInfo> resultList;

	public ResultDao()
	{
		resultList = new LinkedList<GradeInfo>();
	}

	public List<GradeInfo> getGrades(int studentID, int term, String subjectName)
	{
		Connection con = ConnectionPool.getConnection();
		PreparedStatement ps;
		ResultSet rs;
		try
		{
			ps = con.prepareStatement("select course.code, grade.name, grade.status from course, result, grade, semester where course.course_id = result.course_id and result.grade_id = grade.grade_id and course.semester_id = semester.semester_id and result.student_id = "
					+ studentID
					+ " and semester.term = "
					+ term
					+ " and course.name = \"" + subjectName + "\"");
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return resultList;
	}

	public List<GradeInfo> getGrades(int studentID)
	{
		Connection con = ConnectionPool.getConnection();
		PreparedStatement ps;
		ResultSet rs;
		try
		{
			ps = con.prepareStatement("select course.name, course.code, grade.name, grade.status from course, result, grade, semester where course.course_id = result.course_id and result.grade_id = grade.grade_id and course.semester_id = semester.semester_id and result.student_id = "
					+ studentID);
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		return resultList;
	}
	
	public List<GradeInfo> getGrades(int studentID, int term)
	{
		Connection con = ConnectionPool.getConnection();
		PreparedStatement ps;
		ResultSet rs;
		try
		{
			ps = con.prepareStatement("select course.name, course.code, grade.name, grade.status from course, result, grade, semester where course.course_id = result.course_id and result.grade_id = grade.grade_id and course.semester_id = semester.semester_id and result.student_id = "
					+ studentID
					+ " and semester.term = "
					+ term);
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return resultList;
	}

}
