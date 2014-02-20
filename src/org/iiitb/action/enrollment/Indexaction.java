package org.iiitb.action.enrollment;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.struts2.interceptor.SessionAware;
import org.iiitb.model.User;

public class Indexaction implements SessionAware {
	private int semester;
	private ArrayList<DataConectivity> al;
	private ArrayList<Integer> delete = new ArrayList<Integer>();
	public static StringBuffer s = new StringBuffer();
	String displayString;

	public String getDisplayString() {
		return displayString;
	}

	public void setDisplayString(String displayString) {
		this.displayString = displayString;
	}

	private ArrayList<Integer> selected;
	private static HashMap<Integer, String> hm = new HashMap<Integer, String>();
	public static HashMap<Integer, String> sub = new HashMap<Integer, String>();
	

	// private static ArrayList<Interger,String> DateComp=new
	// ArrayList<String>();
	public String Update() {

		// for (Integer value : selected) {
		// System.out.println(value
		// + "############################################");
		// }
		for (Entry<Integer, String> entry : hm.entrySet()) {

			Integer key = entry.getKey();
			if (!selected.contains(key)) {
				delete.add(key);

			}
		}

		for (Integer a : delete) {
			hm.remove(a);
		}

		for (Entry<Integer, String> entry : hm.entrySet()) {
			Integer key = entry.getKey();
			String value = entry.getValue();
			// System.out.println(key + " " + value);
		}

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		// get current date time with Date()
		Date date = new Date();
		System.out.println(dateFormat.format(date));

		for (Entry<Integer, String> entry : hm.entrySet()) {
			DateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
			Date date2;
			try {
				date2 = dateFormat1.parse(entry.getValue());
			
			if (date.after(date2)) {
				String f = sub.get( entry.getKey())+"  course"+"    enrollment is not allowed"
						+"and since last is date "
						+ entry.getValue()+System.getProperty("line.separator")+"\n"+"....,";
				System.out
						.println(" course enrollment is not allowed for course id"
								+ entry.getKey()
								+ " and since last is date "
								+ entry.getValue());
				s.append(f);
				selected.remove(entry.getKey());
				// for (Integer value : selected) {
				// System.out.println(value
				// + "checking ############################################");
				// }
			}
			if (date.before(date2)) {
				String r = sub.get(entry.getKey())+"    course "+" enrollment is done since last date is " + date2+System.getProperty("line.separator");
				s.append(r);
				System.out.println(" enrollment is allowed " + date2);

			}
			if (date.equals(date2)) {
				String q = " date is equal so enrollment allowed " + date2+"\n";
				s.append(q);
				System.out.println(" date is equal so enrollment allowed "
						+ date2);

			}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		User user = (User) session.get("user");
		//System.out.println("!!!!!!!!!!"+user.getName()+user.getUserId());
		DataConectivity.CourseUpdate(Integer.parseInt(user.getUserId()),
				selected);
		//System.out.println("final message"+s);

		setDisplayString(s.toString());
	//	System.out.println(displayString);
		//System.out.println("DSFDFSFGS"+getDisplayString());
		return "success";
	}

	public String execute() {
		int semester = getSemester();
		System.out.println("execute called semester" + semester);
		al = new ArrayList<DataConectivity>();
		ArrayList<DataConectivity> ALDC = DataConectivity
				.CourseDisplay(semester);
		for (int i = 0; i < ALDC.size(); i++) {

			// System.out.println("ALDC" + ALDC.get(i).getCoursename());
			al.add(ALDC.get(i));
			System.out.println(al.get(i).getCoursename());
			hm.put(al.get(i).getCourse_id(), al.get(i).getLastdate());
			sub.put(al.get(i).getCourse_id(), al.get(i).getCoursename());
			// System.out.println("hashmap#########################"+hm.get(key));

		}

		for (Entry<Integer, String> entry : hm.entrySet()) {
			Integer key = entry.getKey();
			String value = entry.getValue();
			System.out.println(key + " " + value);
		}
		return "success";

	}

	public int getSemester() {
		return semester;
	}

	public ArrayList<Integer> getSelected() {
		return selected;
	}

	public void setSelected(ArrayList<Integer> selected) {
		this.selected = selected;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

	public ArrayList<DataConectivity> getAl() {
		return al;
	}

	public void setAl(ArrayList<DataConectivity> al) {
		this.al = al;
	}

	Map<String, Object> session;

	private Map<String, Object> getSession() {
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
