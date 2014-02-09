package org.iiitb.action.grades;

import java.util.LinkedList;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;

/**
 * 
 * @author Abhijith Madhav (MT2013002)
 * 
 */
public class GradesAction1
{
	private int studentID;
	private int term;
	private List<Integer> courseList;
	
	public GradesAction1()
	{
		studentID = 2; // for testing purposes. 
		courseList = new LinkedList<Integer>();
	}

	public String execute() throws Exception
	{
		System.out.println();
		return "success";
	}

	public int getStudentID()
	{
		return studentID;
	}

	public void setStudentID(int studentID)
	{
		this.studentID = studentID;
	}

	public List<Integer> getCourseList()
	{
		return courseList;
	}

	public void setCourseList(List<Integer> courseList)
	{
		this.courseList = courseList;
	}

	public int getTerm()
	{
		return term;
	}

	public void setTerm(int term)
	{
		this.term = term;
	}
}
