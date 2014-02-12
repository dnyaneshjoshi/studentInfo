package org.iiitb.action.dao;

import java.sql.Connection;
import java.util.List;

import org.iiitb.action.syllabus.SyllabusInfo;

public interface SyllabusDAO {
	
	public List<SyllabusInfo> getSyllabus(Connection connection, String subjectCode);
	
}
