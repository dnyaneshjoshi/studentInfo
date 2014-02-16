package org.iiitb.action.dao;

import java.sql.Connection;
import java.util.List;

import org.iiitb.action.syllabus.SyllabusInfo;

public interface SyllabusDAO {
	
	public List<SyllabusInfo> getSyllabus(Connection connection, String subjectCode);
	
	public boolean setCourseAndSyllabus(Connection connection, String code, String courseName, String credits, String lastDate, 
			String semester, String year, String facultyName, String syllabus);
	
}
