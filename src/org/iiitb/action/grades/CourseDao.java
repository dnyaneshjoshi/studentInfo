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
public class CourseDao
{
	private List<String> courseList;

	public CourseDao()
	{
		courseList = new LinkedList<String>();
	}

	public List<String> getNames(int studentID)
	{
		Connection con = ConnectionPool.getConnection();
		PreparedStatement ps;
		ResultSet rs;
		try
		{		
			ps = con.prepareStatement("select distinct course.name from result, course where result.course_id = course.course_id and result.student_id = " + studentID);
			rs = ps.executeQuery();
			while(rs.next())
				courseList.add(rs.getString(1));

			con.close();
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return courseList;
	}
	
	public List<String> getNames(int studentID, int term)
	{
		Connection con = ConnectionPool.getConnection();
		PreparedStatement ps;
		ResultSet rs;
		try
		{		
			ps = con.prepareStatement("select distinct course.name from result, course, semester where result.course_id = course.course_id and course.semester_id = semester.semester_id and result.student_id = " + studentID + " and semester.term = " + term);
			rs = ps.executeQuery();
			while(rs.next())
				courseList.add(rs.getString(1));

			con.close();
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return courseList;
	}
	
}
