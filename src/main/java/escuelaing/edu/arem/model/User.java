package escuelaing.edu.arem.model;

import java.sql.Date;

public class User {
	
	private String name;
	private Date birthday;
	private String document;
	private String phone;
	private String email;
	
	public User(String name, Date birthday, String document, String phone, String email) {
		this.name=name;
		this.birthday=birthday;
		this.document=document;
		this.phone=phone;
		this.email=email;
	}
	
	public User() {
		
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	public Date getBirthday() {
		return this.birthday;
	}
	
	public void setBirthday(Date birthday) {
		this.birthday=birthday;
	}
	
	public String getDocument() {
		return this.document;
	}
	
	public void setDocument(String document) {
		this.document=document;
	}
	
	public String getPhone() {
		return this.phone;
	}
	
	public void setPhone(String phone) {
		this.phone=phone;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String email) {
		this.email=email;
	}
	
}
