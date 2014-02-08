package org.iiitb.action.subjects;

import com.opensymphony.xwork2.ActionSupport;

public class SubjectsAction extends ActionSupport {

  /**
   * serial id
   */
  private static final long serialVersionUID = 3193702317572110684L;

  private SubjectInfo subjectInfo;

  {

  }

  public SubjectInfo getSubjectInfo() {
    return subjectInfo;
  }

  public void setSubjectInfo(SubjectInfo subjectInfo) {
    this.subjectInfo = subjectInfo;
  }

  public String execute() {
    return SUCCESS;
  }

}
