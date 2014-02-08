package org.iiitb.action.friends;

import java.util.List;

import org.iiitb.action.dao.StudentDAO;
import org.iiitb.action.dao.impl.StudentDAOImpl;
import org.iiitb.model.StudentInfo;

import com.opensymphony.xwork2.Action;

/**
 * @author prashanth
 * 
 */
public class MyFriendsAction implements Action
{
	/**
	 * 
	 */
	private String rollNo;
	private StudentInfo myProfile;
	private List<StudentInfo> students;

	public String getRollNo()
	{
		return rollNo;
	}

	public void setRollNo(String rollNo)
	{
		this.rollNo = rollNo;
	}

	public StudentInfo getMyProfile()
	{
		return myProfile;
	}

	public void setMyProfile(StudentInfo myProfile)
	{
		this.myProfile = myProfile;
	}

	public List<StudentInfo> getStudents()
	{
		return students;
	}

	public void setStudents(List<StudentInfo> students)
	{
		this.students = students;
	}

	public String execute()
	{
		StudentDAO studentDao = new StudentDAOImpl();
		setMyProfile(studentDao.getStudent(rollNo));

		setStudents(studentDao.getFriends(rollNo));

		return SUCCESS;
	}

}
