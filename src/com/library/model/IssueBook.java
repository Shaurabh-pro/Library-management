package com.library.model;

import java.sql.Date;

public class IssueBook {
	private String callno;
	private String studentid;
	private String studentname;
	private String returnstatus;
	private Date issueddate;
	private long studentmobile;
	

	public IssueBook() {}
	public IssueBook(String callno, String studentid, String studentname, long studentmobile,String returnstatus) {
		super();
		this.callno = callno;
		this.studentid = studentid;
		this.studentname = studentname;
		this.studentmobile = studentmobile;
		this.returnstatus = returnstatus;
	}

	public String getReturnstatus() {
		return returnstatus;
	}
	public void setReturnstatus(String returnstatus) {
		this.returnstatus = returnstatus;
	}
	public Date getIssueddate() {
		return issueddate;
	}
	public void setIssueddate(Date issueddate) {
		this.issueddate = issueddate;
	}
	public String getCallno() {
		return callno;
	}
	public void setCallno(String callno) {
		this.callno = callno;
	}
	public String getStudentid() {
		return studentid;
	}
	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}
	public String getStudentname() {
		return studentname;
	}
	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}
	public long getStudentmobile() {
		return studentmobile;
	}
	public void setStudentmobile(long l) {
		this.studentmobile = l;
	}
}
