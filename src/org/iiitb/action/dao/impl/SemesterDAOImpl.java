package org.iiitb.action.dao.impl;

import java.util.LinkedList;
import java.util.List;

import org.iiitb.action.dao.SemesterDAO;
import org.iiitb.util.ConnectionPool;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author kempa
 * 
 */
public class SemesterDAOImpl implements SemesterDAO
{
	private List<String> termList;
	
	private static final String GET_TERMS_QUERY = "select distinct term"
			+ " from semester,course,result"
			+ " where course.semester_id = semester.semester_id "
			+ "and course.course_id = result.course_id "
			+ "and result.student_id=?";

	public SemesterDAOImpl()
	{
		termList = new LinkedList<String>();
	}

	public List<String> getTerms(int studentID)
	{
		Connection con = ConnectionPool.getConnection();
		PreparedStatement ps = null;
		ResultSet rs;
		try
		{
			ps = con.prepareStatement(GET_TERMS_QUERY);
			ps.setInt(1, studentID);
			rs = ps.executeQuery();
			while(rs.next())
				termList.add(new Integer((rs.getInt(1))).toString());

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
		return termList;
	}
}
