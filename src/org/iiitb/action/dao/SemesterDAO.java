package org.iiitb.action.dao;

import java.util.List;

/**
 * @author kempa
 * 
 */
public interface SemesterDAO
{
	public List<String> getTerms(int studentID);
}
