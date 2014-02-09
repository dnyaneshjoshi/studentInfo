package org.iiitb.action.dao;

import java.util.List;

import org.iiitb.model.StudentInfo;

/**
 * @author prashanth
 *
 */
public interface StudentDAO
{
	
	public StudentInfo getStudent(String rollNo);

	public List<StudentInfo> getFriends(String rollno);

	public String findRelationShip(String rollNo, String friendNo);

	public boolean addFriend(String rollNo, String friendNo);
}
