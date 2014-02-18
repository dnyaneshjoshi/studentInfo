package org.iiitb.action.subjects;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.SessionAware;
import org.iiitb.util.Constants;

import com.opensymphony.xwork2.ActionSupport;

public class ManageSubjectsAction extends ActionSupport implements SessionAware {
	
	private Map<String, Object> session;
	
	private String code;
	private String name;
	private String term;
	private String year;
	private String faculty;
	private String lastDate;
	
	
	@Override
	public void setSession(Map<String, Object> arg0) {
		this.session = session;
		
	}
	
	public void validate() {
		if (StringUtils.isEmpty(code)) {
			addActionError("Course Code cannot be empty");
		}
		if (StringUtils.isEmpty(name)) {
			addActionError("Course Name cannot be empty");
		}
		if (StringUtils.isEmpty(term)) {
			addActionError("Semester cannot be empty");
		}
		if (StringUtils.isEmpty(year)) {
			addActionError("Year cannot be empty");
		}
		if (StringUtils.isEmpty(faculty)) {
			addActionError("Faculty cannot be empty");
		}
		if (StringUtils.isEmpty(lastDate)) {
			addActionError("Last date of enrollnment cannot be empty");
		}
	}
	
	public String execute() {
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

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
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
	
	

}
