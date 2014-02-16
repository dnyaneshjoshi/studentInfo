package org.iiitb.action.dao;
import org.iiitb.util.ConnectionPool;

import java.util.LinkedList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MyProfileDAO {
	private String rollno;
	private String userid;
	List<String> interests;
	public MyProfileDAO()
	{
		rollno=null;
		interests=null;
	}
	public MyProfileDAO(String userid)
	{
		this.userid=userid;
		rollno=null;
		interests=null;
	}
	public String getRollno() {
		Connection con = ConnectionPool.getConnection();
		PreparedStatement ps;
		ResultSet rs;
		try
		{
			ps=con.prepareStatement("select roll_no from student where student_id=?");
			ps.setString(1, userid);
			rs=ps.executeQuery();
			
			if(rs.next()){
			rollno=rs.getString("roll_no");
			}
			
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rollno;
		
	}
	public void setRollno(String rollno) {
		this.rollno = rollno;
	}
	
	public String getUserid() {
		return userid;
		
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public List<String> getInterests() {
		Connection con = ConnectionPool.getConnection();
		PreparedStatement ps;
		ResultSet rs;
		interests=new LinkedList<String>();
		try
		{
		ps=con.prepareStatement( "select name from interest i, student_interest si where i.interest_id=si.interest_id and si.student_id=?");
		ps.setString(1,userid);
		rs=ps.executeQuery();
		while(rs.next())
		{
			String s= rs.getString("name");
			interests.add(s);
		}
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return interests;
			
	}
	public void setInterests(List interests) {
		this.interests = interests;
	}
	

}
