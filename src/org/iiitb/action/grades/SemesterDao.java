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
public class SemesterDao
{
	private List<String> termList;

	public SemesterDao()
	{
		termList = new LinkedList<String>();
	}

	public List<String> getTerms(int studentID)
	{
		Connection con = ConnectionPool.getConnection();
		PreparedStatement ps;
		ResultSet rs;
		try
		{
			ps = con
					.prepareStatement("select distinct term from semester,course,result where course.semester_id = semester.semester_id and course.course_id = result.course_id and result.student_id = "
							+ studentID);
			rs = ps.executeQuery();
			while(rs.next())
				termList.add(new Integer((rs.getInt(1))).toString());

			con.close();
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return termList;
	}
}
