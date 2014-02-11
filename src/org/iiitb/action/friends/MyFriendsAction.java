package org.iiitb.action.friends;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.iiitb.action.dao.StudentDAO;
import org.iiitb.action.dao.impl.StudentDAOImpl;
import org.iiitb.model.StudentInfo;
import org.iiitb.model.User;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author prashanth
 * 
 */
public class MyFriendsAction extends ActionSupport implements SessionAware
{
	/**
	 * 
	 */
	private StudentInfo myProfile;
	private List<StudentInfo> students;
	private Map<String, Object> session;

	

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

		User user = (User) session.get("user");
		if (user != null)
		{

			StudentDAO studentDao = new StudentDAOImpl();

			StudentInfo studentInfo = studentDao.getStudentByUserId(user.getUserId());

			if (studentInfo != null)
			{

				setMyProfile(studentInfo);

				setStudents(studentDao.getFriends(user.getUserId()));
			}
			else
			{
				return ERROR;
			}
		}

		return SUCCESS;
	}

	@Override
	public void setSession(Map<String, Object> session)
	{
		this.session = session;

	}

}
