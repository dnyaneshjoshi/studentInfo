package org.iiitb.action.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
	private static final String GET_SEMESTER_ID = "SELECT " +
			"semester_id " +
			"FROM semester " +
			"WHERE term = ? " +
			"AND year = ?";
	
	private static final String GET_FACULTY_ID = "SELECT " +
			"user_id " +
			"FROM user " +
			"WHERE name = ? " +
			"AND user_type = 'F'";
		
	private static final String SET_COURSE = "INSERT INTO course" +
			"(course_id, code, name, credits, lastdate, faculty_id, semester_id) " +
			"VALUES " +
			"(course_id, ?, ?, ?, ?, ?, ?)";
	
	private static final String GET_COURSE_ID = "SELECT " +
			"course_id " +
			"FROM course " +
			"WHERE code = ?";
	
	private static final String SET_SYLLABUS = "INSERT INTO syllabus " +
			"(syllabus_id, course_id) " +
			"VALUES " +
			"(syllabus_id, ?)";
	
	private static final String GET_SYLLABUS_ID = "SELECT " +
			"syllabus_id " +
			"FROM syllabus " +
			"WHERE course_id = ?";
	
	private static final String SET_TOPIC = "INSERT INTO topic " +
			"(topic_id, name, syllabus_id) " +
			"VALUES " +
			"(topic_id, ?, ?)";
	
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
	
	public boolean setCourseAndSyllabus(Connection connection, String code,
			String courseName, String credits, String lastDate,
			String semester, String year, String facultyName, String syllabus) {
		
		int index, is;
		String semester_id = null, faculty_id = null, course_id = null, syllabus_id = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Date lastDateForEnrollnment = null;
		
		try {
			
			// Get semester ID
	    	ps = connection.prepareStatement(GET_SEMESTER_ID);
	    	
	    	index = 1;
	    	ps.setInt(index, Integer.parseInt(semester));
	    	index = 2;
	    	ps.setInt(index, Integer.parseInt(year));
	    	rs = ps.executeQuery();
	    	
	    	if (!rs.next()) {
	    		System.out.println("Unable to get Semester ID");
	    		return false;
	    	}
	    	
	    	while (rs.next()) {
		    	semester_id = rs.getString("semester_id");
		    	System.out.println("semester_id::" + semester_id);
	    	}
	    	
	    	/*
	   		Validations are not present.
	   		Faculty Name is NULL case.
	   		Invalid Faculty Name case etc.
	   		Hence commenting.
	   		
	    	// Get Faculty ID
	    	ps = connection.prepareStatement(GET_FACULTY_ID);
	    	
	    	if (facultyName != null) {
		    	index = 1;
		    	ps.setString(index, facultyName);
		    	rs = ps.executeQuery();
		    	if (!rs.next()) {
		    		System.out.println("Unable to get Faculty ID");
		    		return false;
		    	}
		    	
		    	while (rs.next()) {
			    	faculty_id = rs.getString("user_id");
			    	System.out.println("faculty_id::" + faculty_id);
		    	}
	    	} else facultyName = "";
	    	
	
	    	
	    	// Insert Course Details
	    	ps = connection.prepareStatement(SET_COURSE);
	    	
	    	index = 1;
	    	ps.setString(index, code);
	    	index = 2;
	    	ps.setString(index, courseName);
	    	index = 3;
	    	ps.setInt(index, Integer.parseInt(credits));
	    	index = 4;
	    	if (lastDate == null) lastDate = "31-12-2014";
	    	SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy");
	    	try {
				lastDateForEnrollnment = new Date( format.parse(lastDate).getTime() );
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	ps.setDate(index, lastDateForEnrollnment);
	    	index = 5;
	    	ps.setInt(index, Integer.parseInt(faculty_id));
	    	index = 6;
	    	ps.setInt(index, Integer.parseInt(semester_id));
	    	is = ps.executeUpdate();
	    	
	    	if (is != 1) {
	    		System.out.println("Insert of course failed");
	    		return false; 
	    	}
	    	
	    	// Get Course ID for the Course
	    	ps = connection.prepareStatement(GET_COURSE_ID);
	    	
	    	index = 1;
	    	ps.setString(index, code);
	    	rs = ps.executeQuery();
	    	
	    	while (rs.next()) {
	    		course_id = rs.getString("course_id");
		    	System.out.println("course_id::" + course_id);
	    	}
	    	
	    	// Insert Syllabus details for the Course ID
	    	ps = connection.prepareStatement(SET_SYLLABUS);
	    	
	    	index = 1;
	    	ps.setInt(index, Integer.parseInt(course_id));

	    	is = ps.executeUpdate();
	    	
	    	// Get Syllabus ID for the Course ID
	    	ps = connection.prepareStatement(GET_SYLLABUS_ID);
	    	
	    	index = 1;
	    	ps.setInt(index, Integer.parseInt(course_id));
	    	rs = ps.executeQuery();
	    	
	    	while (rs.next()) {
	    		syllabus_id = rs.getString("syllabus_id");
		    	System.out.println("syllabus_id::" + syllabus_id);
	    	}
	    	
	    	// Insert Topic for the Syllabus ID
	    	ps = connection.prepareStatement(SET_TOPIC);
	    	
	    	index = 1;
	    	ps.setString(index, syllabus);
	    	index = 2;
	    	ps.setInt(index, Integer.parseInt(syllabus_id));

	    	is = ps.executeUpdate();
	    	
	    	if (is != 1) return false; 
	    	
	    	*/
	    	
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
		return true;
	}

}
