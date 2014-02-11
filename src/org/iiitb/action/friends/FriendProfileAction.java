package org.iiitb.action.friends;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.iiitb.action.dao.StudentDAO;
import org.iiitb.action.dao.impl.StudentDAOImpl;
import org.iiitb.model.StudentInfo;
import org.iiitb.model.User;
import org.iiitb.util.Constants;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author prashanth
 * 
 */
public class FriendProfileAction extends ActionSupport implements SessionAware
{
	private String friendNo;

	private String rollNo;

	public String getRollNo()
	{
		return rollNo;
	}

	public void setRollNo(String rollNo)
	{
		this.rollNo = rollNo;
	}

	StudentInfo myProfile;

	public StudentInfo getMyProfile()
	{
		return myProfile;
	}

	public void setMyProfile(StudentInfo myProfile)
	{
		this.myProfile = myProfile;
	}

	List<StudentInfo> students;

	public List<StudentInfo> getStudents()
	{
		return students;
	}

	public void setStudents(List<StudentInfo> students)
	{
		this.students = students;
	}

	String isFriend;

	public String getIsFriend()
	{
		return isFriend;
	}

	public void setIsFriend(String isFriend)
	{
		this.isFriend = isFriend;
	}

	public String getFriendNo()
	{
		return friendNo;
	}

	public void setFriendNo(String friendNo)
	{
		this.friendNo = friendNo;
	}

	StudentInfo friendProfile;

	public StudentInfo getFriendProfile()
	{
		return friendProfile;
	}

	public void setFriendProfile(StudentInfo friendProfile)
	{
		this.friendProfile = friendProfile;
	}

	public String execute()
	{
		String result = SUCCESS;

		StudentDAO studentDao = new StudentDAOImpl();

		StudentInfo studentInfo = studentDao.getStudentByRollNo(friendNo);
		if (studentInfo == null)
		{
			result = ERROR;
		}
		else
		{

			User user = (User) session.get("user");

			setFriendProfile(studentInfo);

			if (studentInfo.getStudentId() == Integer.parseInt(user.getUserId()))
			{
				setIsFriend(Constants.FRIEND);
			}
			else

				setIsFriend(studentDao.findRelationShip(user.getUserId(), friendNo));

		}
		return result;
	}

	public String update()
	{

		User user = (User) session.get("user");
		StudentDAO studentDao = new StudentDAOImpl();
		studentDao.addFriend(user.getUserId(), friendNo);

		setMyProfile(studentDao.getStudentByUserId(user.getUserId()));

		setStudents(studentDao.getFriends(user.getUserId()));

		return SUCCESS;
	}

	Map<String, Object> session;

	public Map<String, Object> getSession()
	{
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session)
	{
		this.session = session;

	}
}
