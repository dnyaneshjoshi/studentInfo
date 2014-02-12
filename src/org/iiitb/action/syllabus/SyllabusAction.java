package org.iiitb.action.syllabus;

import java.sql.Connection;
import java.util.List;

import org.iiitb.action.dao.SyllabusDAO;
import org.iiitb.action.dao.impl.SyllabusDAOImpl;
import org.iiitb.util.ConnectionPool;

import com.opensymphony.xwork2.ActionSupport;

public class SyllabusAction extends ActionSupport {
		
	private List<SyllabusInfo> syllabusInfoList;
	private SyllabusDAO syllabusDAO = new SyllabusDAOImpl();
	
	private String subjectCode = "SE101";
	
	// subjectCode to be send as a request parameter from Subjects page.
	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}

	public String execute() {
		Connection connection = ConnectionPool.getConnection();
		syllabusInfoList = syllabusDAO.getSyllabus(connection, subjectCode);
	    ConnectionPool.freeConnection(connection);
	    return SUCCESS;
	  }

	public List<SyllabusInfo> getSyllabusInfoList() {
		return syllabusInfoList;
	}

	public void setSyllabusInfoList(List<SyllabusInfo> syllabusInfoList) {
		this.syllabusInfoList = syllabusInfoList;
	}
}
