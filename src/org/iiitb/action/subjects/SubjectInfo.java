package org.iiitb.action.subjects;

/**
 * Subject Info
 * @author arjun
 *
 */
public class SubjectInfo {

  private String subjectCode;
  private String subjectName;
  private String facultyName;
  private int semester;
  private String enrolled;
  private String grade;

  public SubjectInfo() {
    super();
  }

  public SubjectInfo(String subjectCode, String subjectName,
      String facultyName, int semester, String enrolled, String grade) {
    super();
    this.subjectCode = subjectCode;
    this.subjectName = subjectName;
    this.facultyName = facultyName;
    this.semester = semester;
    this.enrolled = enrolled;
    this.grade = grade;
  }

  public String getSubjectCode() {
    return subjectCode;
  }

  public void setSubjectCode(String subjectCode) {
    this.subjectCode = subjectCode;
  }

  public String getFacultyName() {
    return facultyName;
  }

  public void setFacultyName(String facultyName) {
    this.facultyName = facultyName;
  }

  public int getSemester() {
    return semester;
  }

  public void setSemester(int semester) {
    this.semester = semester;
  }

  public String isEnrolled() {
    return enrolled;
  }

  public void setEnrolled(String enrolled) {
    this.enrolled = enrolled;
  }

  public String getGrade() {
    return grade;
  }

  public void setGrade(String grade) {
    this.grade = grade;
  }

  public String getSubjectName() {
    return subjectName;
  }

  public void setSubjectName(String subjectName) {
    this.subjectName = subjectName;
  }

}
