package org.iiitb.action.grades;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.iiitb.model.User;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * @author Abhijith Madhav (MT2013002)
 * 
 */
public class GradesAction extends ActionSupport implements SessionAware
{
	/**
	 * serial id
	 */
	private static final long serialVersionUID = -3927650660405287420L;

	private final static String DEFAULT_TERM = "Semester";
	private final static String DEFAULT_COURSE = "Subject";

	private String termDisplayChoice = DEFAULT_TERM;
	private List<String> termList;

	private String courseDisplayChoice = DEFAULT_COURSE;
	private List<String> courseList;

	private List<GradeInfo> resultList;

	private Map<String, Object> session;
	private static final String USER = "user";

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
		User loggedInUser = (User) this.session.get(USER);
		if (loggedInUser != null)
		{
			termList.addAll(new SemesterDao().getTerms(Integer
					.parseInt(loggedInUser.getUserId())));

			if (!termDisplayChoice.equals(DEFAULT_TERM))
				courseList.addAll(new CourseDao().getNames(
						Integer.parseInt(loggedInUser.getUserId()),
						Integer.parseInt(termDisplayChoice)));

			if (!termDisplayChoice.equals(DEFAULT_TERM)
					&& !courseDisplayChoice.equals(DEFAULT_COURSE))
				resultList.addAll(new ResultDao().getGrades(
						Integer.parseInt(loggedInUser.getUserId()),
						Integer.parseInt(termDisplayChoice),
						courseDisplayChoice));
			else if (termDisplayChoice.equals(DEFAULT_TERM))
				resultList.addAll(new ResultDao().getGrades(Integer
						.parseInt(loggedInUser.getUserId())));
			else if (!termDisplayChoice.equals(DEFAULT_TERM)
					&& courseDisplayChoice.equals(DEFAULT_COURSE))
				resultList.addAll(new ResultDao().getGrades(
						Integer.parseInt(loggedInUser.getUserId()),
						Integer.parseInt(termDisplayChoice)));

			return SUCCESS;
		}
		else
			return LOGIN;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.apache.struts2.interceptor.SessionAware#setSession(java.util.Map)
	 */
	@Override
	public void setSession(Map<String, Object> session)
	{
		this.session = session;

	}
}
