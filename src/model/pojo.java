package model;

public class pojo {
	private String uid;
	private String uname;
	private String ugen;
	private String udob;
	private String uemail;
	private String upass;
	
	public pojo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public pojo(String uid, String uname, String ugen, String udob, String uemail, String upass) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.ugen = ugen;
		this.udob = udob;
		this.uemail = uemail;
		this.upass = upass;
	}
	public pojo( String uname, String ugen, String udob, String uemail, String upass) {
		super();
		this.uname = uname;
		this.ugen = ugen;
		this.udob = udob;
		this.uemail = uemail;
		this.upass = upass;
	}
	
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUgen() {
		return ugen;
	}
	public void setUgen(String ugen) {
		this.ugen = ugen;
	}
	public String getUdob() {
		return udob;
	}
	public void setUdob(String udob) {
		this.udob = udob;
	}
	public String getUemail() {
		return uemail;
	}
	public void setUemail(String uemail) {
		this.uemail = uemail;
	}
	public String getUpass() {
		return upass;
	}
	public void setUpass(String upass) {
		this.upass = upass;
	}
	


}
