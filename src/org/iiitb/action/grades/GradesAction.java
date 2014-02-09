package org.iiitb.action.grades;

import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author Abhijith Madhav (MT2013002)
 * 
 */
public class GradesAction
{
	private String semesterDisplayChoice;
	private int studentID;
	private List<String> termList;
	
	public GradesAction()
	{
		semesterDisplayChoice = "All";
		studentID = 2; // for testing purposes.
		termList = new LinkedList<String>();
		termList.add(semesterDisplayChoice);
	}

	public String execute() throws Exception
	{
		termList = new SemesterDao().getTerms(studentID);
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

	public List<String> getTermList()
	{
		return termList;
	}

	public void setTermList(List<String> termList)
	{
		this.termList = termList;
	}

}
