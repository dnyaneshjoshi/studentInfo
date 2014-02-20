package org.iiitb.action.editprofile;
import java.sql.Connection;
import java.util.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.dispatcher.mapper.ActionMapping;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.commons.io.FileUtils;
import org.iiitb.action.dao.EditProfileDAO;
import org.iiitb.action.dao.LayoutDAO;
import org.iiitb.action.dao.impl.LayoutDAOImpl;
import org.iiitb.model.User;
import org.iiitb.model.layout.AnnouncementsItem;
import org.iiitb.model.layout.NewsItem;
import org.iiitb.util.ConnectionPool;
import org.iiitb.util.Constants;

import com.opensymphony.xwork2.ActionSupport;
public class EditProfileAction extends ActionSupport implements SessionAware,ServletRequestAware
{
	String name;
	String rollno;
	String password;
	File fileUpload;
	String fileUploadContentType;
	String fileUploadFileName;
	List<String> interests;
	private Map<String, Object> session;
    private HttpServletRequest servletRequest;
	public String getFileUploadContentType() {
		return fileUploadContentType;
	}
 
	public void setFileUploadContentType(String fileUploadContentType) {
		this.fileUploadContentType = fileUploadContentType;
	}
 
	public String getFileUploadFileName() {
		return fileUploadFileName;
	}
 
	public void setFileUploadFileName(String fileUploadFileName) {
		this.fileUploadFileName = fileUploadFileName;
	}
 
	public File getFileUpload() {
		return fileUpload;
	}
 
	public void setFileUpload(File fileUpload) {
		this.fileUpload = fileUpload;
	}
	
	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getRollno()
	{
		return rollno;
	}

	public void setRollno(String rollno)
	{
		this.rollno = rollno;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public List<String> getInterests()
	{
		return interests;
	}

	public void setInterests(List<String> interests)
	{
		this.interests = interests;
	}

	public Map<String, Object> getSession()
	{
		return session;
	}

	public void setSession(Map<String, Object> session)
	{
		this.session = session;
	}

	private List<NewsItem> allNews;
	private List<AnnouncementsItem> announcements;
	private LayoutDAO layoutDAO = new LayoutDAOImpl();
	private String lastLoggedOn = "";

	public String execute() throws Exception
	{
		User user = (User) session.get("user");
		EditProfileDAO edp = new EditProfileDAO(user.getUserId());
		if(fileUploadFileName!=null)
		{
		String destpath=servletRequest.getSession().getServletContext().getRealPath("/");		
		System.out.println("Server path:" + destpath);
		File destFile  = new File(destpath, fileUploadFileName);
    	try {
			FileUtils.copyFile(fileUpload, destFile);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ERROR;
		}      	
    	FileInputStream inputStream= new FileInputStream(destFile);
    	edp.setPhoto(inputStream);
    	//user.setPhoto(inputStream);
		}
		edp.setName(name);
		edp.setPassword(password);
		if(interests!=null)
		edp.setInterests(interests);
		user.setName(name);
		if(fileUploadFileName!=null)		
		user.setPassword(password);
		
		Connection connection = ConnectionPool.getConnection();
		allNews = layoutDAO.getAllNews(connection);
		announcements = layoutDAO.getAnnouncements(connection,
				Integer.parseInt(user.getUserId()));
		setLastLoggedOn((String) this.session.get(Constants.LAST_LOGGED_ON));
		ConnectionPool.freeConnection(connection);
		
		return SUCCESS;
	}

	@Override
	public void setServletRequest(HttpServletRequest req) {
		this.servletRequest=req;
		
	}

	public String getLastLoggedOn()
	{
		return lastLoggedOn;
	}

	public void setLastLoggedOn(String lastLoggedOn)
	{
		this.lastLoggedOn = lastLoggedOn;
	}

	

}