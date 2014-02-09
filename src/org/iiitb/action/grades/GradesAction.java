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
	private int studentID = 2;
	private final static String DEFAULT_TERM = "Semester";
	private final static String DEFAULT_COURSE = "Subject";

	private String termDisplayChoice = DEFAULT_TERM;
	private List<String> termList;

	private String courseDisplayChoice = DEFAULT_COURSE;
	private List<String> courseList;

	private List<GradeInfo> resultList;

	public GradesAction()
	{
		termList = new LinkedList<String>();
		termList.add(DEFAULT_TERM);

		courseList = new LinkedList<String>();
		courseList.add(DEFAULT_COURSE);

		setResultList(new LinkedList<GradeInfo>());
	}

	public String execute() throws Exception
	{
		termList.addAll(new SemesterDao().getTerms(studentID));

		if (!termDisplayChoice.equals(DEFAULT_TERM))
			courseList.addAll(new CourseDao().getNames(studentID,
					Integer.parseInt(termDisplayChoice)));

		if (!termDisplayChoice.equals(DEFAULT_TERM)
				&& !courseDisplayChoice.equals(DEFAULT_COURSE))
		{
			System.out.println(termDisplayChoice + " : " + courseDisplayChoice);
			System.out.println("Data for table");
			resultList.addAll(new ResultDao().getGrades(studentID,
					Integer.parseInt(termDisplayChoice), courseDisplayChoice));
		}
		else if (termDisplayChoice.equals(DEFAULT_TERM))
		{
			resultList.addAll(new ResultDao().getGrades(studentID));
		}
		else if (!termDisplayChoice.equals(DEFAULT_TERM)
				&& courseDisplayChoice.equals(DEFAULT_COURSE))
			resultList.addAll(new ResultDao().getGrades(studentID,
					Integer.parseInt(termDisplayChoice)));

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

	public String getTermDisplayChoice()
	{
		return termDisplayChoice;
	}

	public void setTermDisplayChoice(String termDisplayChoice)
	{
		this.termDisplayChoice = termDisplayChoice;
	}

	public String getCourseDisplayChoice()
	{
		return courseDisplayChoice;
	}

	public void setCourseDisplayChoice(String courseDisplayChoice)
	{
		this.courseDisplayChoice = courseDisplayChoice;
	}

	public List<String> getCourseList()
	{
		return courseList;
	}

	public void setCourseList(List<String> courseList)
	{
		this.courseList = courseList;
	}

	public List<GradeInfo> getResultList()
	{
		return resultList;
	}

	public void setResultList(List<GradeInfo> resultList)
	{
		this.resultList = resultList;
	}

}
