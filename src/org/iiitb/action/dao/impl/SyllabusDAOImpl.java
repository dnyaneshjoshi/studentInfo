package org.iiitb.action.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.iiitb.action.dao.SyllabusDAO;
import org.iiitb.action.syllabus.SyllabusInfo;

public class SyllabusDAOImpl implements SyllabusDAO {

	private static final String GET_SYLLABUS_QUERY = "SELECT " +
			"topic.topic_id as topicId, " +
			"topic.name as topicName " +
			"FROM " +
			"(topic INNER JOIN syllabus ON topic.syllabus_id = syllabus.syllabus_id) " +
			"INNER JOIN course ON course.course_id = syllabus.course_id " +
			"AND course.code = ?"; 
	
	  private void createSyllabusInfoListFromResultSet(ResultSet rs, List<SyllabusInfo> syllabusInfoList) throws SQLException {
		    while (rs.next()) {
		      
		    	String topicId = rs.getString("topicId");
		    	String topicName = rs.getString("topicName");
		      
		    	SyllabusInfo syllabusInfo = new SyllabusInfo(topicId, topicName);
		    	syllabusInfoList.add(syllabusInfo);
		    }
		    if (syllabusInfoList.isEmpty()) {
		    	SyllabusInfo syllabusInfo = new SyllabusInfo("0", "Sorry! Syllabus is not updated for this subject.");
		    	syllabusInfoList.add(syllabusInfo);
		    }
		  }
	
	 
	@Override
	public List<SyllabusInfo> getSyllabus(Connection connection, String subjectCode) {
		// TODO Auto-generated method stub
		List<SyllabusInfo> syllabusInfoList = null;
	    PreparedStatement ps = null;
	    try {
	    	syllabusInfoList = new ArrayList<SyllabusInfo>();
	    	ps = connection.prepareStatement(GET_SYLLABUS_QUERY);
	    	int index = 1;
	    	ps.setString(index, subjectCode);
	    	ResultSet rs = ps.executeQuery();
	    	createSyllabusInfoListFromResultSet(rs, syllabusInfoList);
	    	

	    } 	catch (SQLException e) {
	    		e.printStackTrace();
	    } 	finally {
	    		if (null != ps) {
	    			try {
	    				ps.close();
	    			} catch (SQLException e) {
	    				e.printStackTrace();
	    			}
	    		}
	    }
	    return syllabusInfoList;
	}

}
