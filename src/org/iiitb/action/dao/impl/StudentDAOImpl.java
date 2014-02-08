package org.iiitb.action.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.iiitb.action.dao.StudentDAO;
import org.iiitb.model.StudentInfo;
import org.iiitb.util.ConnectionPool;
import org.iiitb.util.Constants;

public class StudentDAOImpl implements StudentDAO
{

	@Override
	public StudentInfo getStudent(String rollNo)
	{

		StudentInfo user = null;

		Connection conn = ConnectionPool.getConnection();

		try
		{
			PreparedStatement stmt = conn.prepareStatement(Constants.GET_STUDENT_QRY);
			stmt.setString(1, rollNo);

			ResultSet rs = stmt.executeQuery();

			if (rs.next())
			{
				user = new StudentInfo();
				user.setDob(rs.getString("dob"));
				user.setName(rs.getString("name"));
				user.setPhoto(rs.getString("photo"));
				user.setRollNo(rollNo);

			}

		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			ConnectionPool.freeConnection(conn);
		}
		return user;

	}

	@Override
	public List<StudentInfo> getFriends(String rollno)
	{

		List<StudentInfo> friends = null;
		StudentInfo studentDao = null;
		Connection conn = ConnectionPool.getConnection();

		try
		{
			PreparedStatement stmt = conn.prepareStatement(Constants.GET_FREINDS_QRY);
			stmt.setString(1, rollno);
			stmt.setString(2, rollno);

			ResultSet rs = stmt.executeQuery();

			if (rs.next())
			{
				friends = new ArrayList<StudentInfo>();
			}
			else
			{
				return friends;
			}
			do
			{
				studentDao = new StudentInfo();
				studentDao.setDob(rs.getString("dob"));
				studentDao.setName(rs.getString("name"));
				studentDao.setPhoto(rs.getString("photo"));
				studentDao.setRollNo(rs.getString("roll_no"));

				friends.add(studentDao);
			}
			while (rs.next());

		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			ConnectionPool.freeConnection(conn);
		}

		return friends;

	}

	@Override
	public String findRelationShip(String rollNo, String friendNo)
	{

		Connection conn = ConnectionPool.getConnection();
		String result = Constants.NOT_A_FRIEND;
		try
		{
			PreparedStatement stmt = conn.prepareStatement(Constants.ARE_THEY_FRIENDS_QRY);
			stmt.setString(1, rollNo);
			stmt.setString(2, friendNo);
			stmt.setString(3, rollNo);
			stmt.setString(4, friendNo);

			ResultSet rs = stmt.executeQuery();

			if (rs.next())
			{
				result = Constants.FRIEND;
			}

		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			ConnectionPool.freeConnection(conn);
		}

		return result;

	}

	@Override
	public boolean addFriend(String rollNo, String friendNo)
	{

		Connection conn = ConnectionPool.getConnection();
		boolean result = false;
		try
		{
			PreparedStatement stmt = conn.prepareStatement(Constants.ADD_FRIENDS_QRY);
			stmt.setString(1, rollNo);
			stmt.setString(2, friendNo);

			if (stmt.executeUpdate() == 1)
			{
				result = true;
			}

		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			ConnectionPool.freeConnection(conn);
		}

		return result;

	}

}
