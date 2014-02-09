package org.iiitb.util;

public interface Constants
{
	String GET_PASSWORD_QRY = "select * from user where username=?";

	String GET_FREINDS_QRY = "select u.name,s1.roll_no, s1.student_id, s1.dob,s1.photo from user u, student s1,student s, friends f where s.student_id=f.student_id1 and s.roll_no=? and s.student_id !=s1.student_id and s1.student_id=f.student_id2 and u.user_id=s1.student_id union select u.name,s1.roll_no, s1.student_id, s1.dob,s1.photo from user u, student s,student s1, friends f where s.student_id=f.student_id2 and s.roll_no=? and s.student_id !=s1.student_id and s1.student_id=f.student_id1 and u.user_id=s1.student_id";

	String GET_STUDENT_QRY = "select * from student s, user u  where s.student_id= u.user_id and s.roll_no=?";

	String ARE_THEY_FRIENDS_QRY = "select s1.roll_no, s2.roll_no from student s1, student s2, friends f where s1.student_id=f.student_id1 and s2.student_id=f.student_id2 and s1.roll_no=? and s2.roll_no=? union select s1.roll_no, s2.roll_no from student s1, student s2, friends f where s1.student_id=f.student_id1 and s2.student_id=f.student_id2 and s2.roll_no=? and s1.roll_no=?";

	String ADD_FRIENDS_QRY = "insert into friends(student_id1, student_id2)     select s1.student_id, s2.student_id from student s1, student s2 where s1.roll_no=? and s2.roll_no=?";

	String INVALID_PASSWORD_ERROR = "username, password doesn't match";
	String INVALID_USER_ERROR = "user doesnt exits";

	String USER_NAME_BLANK = "username is blank";

	String PASSWORD_BLANK = "password is blank";

	String DB_USERNAME = "username";
	String DB_PASSWORD = "password";

	String NOT_A_FRIEND = "not_a_friend";
	String FRIEND = "friend";

}
