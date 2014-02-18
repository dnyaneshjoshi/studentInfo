package org.iiitb.action.subjects;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.SessionAware;
import org.iiitb.action.dao.CourseDAO;
import org.iiitb.action.dao.SemesterDAO;
import org.iiitb.action.dao.impl.CourseDAOImpl;
import org.iiitb.action.dao.impl.SemesterDAOImpl;
import org.iiitb.util.ConnectionPool;
import org.iiitb.util.Constants;

import com.opensymphony.xwork2.ActionSupport;

public class ManageSubjectsAction extends ActionSupport implements SessionAware {
	
	private Map<String, Object> session;
	
	private String code;
	private String name;
	private String semester;
	private String year;
	private String faculty;
	private String lastDate;
	
	private List<String> semesterList;
	
	@Override
	public void setSession(Map<String, Object> arg0) {
		this.session = session;
		
	}
	
	public String execute() {
		return SUCCESS;
	}
	
	public String initSubjects() {
		SemesterDAO semesterDAO = new SemesterDAOImpl();
		semesterList = new ArrayList<String>();

		Connection connection = ConnectionPool.getConnection();
		semesterList = semesterDAO.getSemester(connection, 1, null);
		ConnectionPool.freeConnection(connection);
		
		return SUCCESS;
	}
	
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getFaculty() {
		return faculty;
	}

	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}

	public String getLastDate() {
		return lastDate;
	}

	public void setLastDate(String lastDate) {
		this.lastDate = lastDate;
	}
	
	public List<String> getSemesterList() {
		return semesterList;
	}

	public void setSemesterList(List<String> semesterList) {
		this.semesterList = semesterList;
	}
}
