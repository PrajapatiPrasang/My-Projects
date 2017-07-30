package VO;

import java.io.Serializable;

public class loginVO implements Serializable{
	private static final long serialVersionUID = 1L;
	private int login_id;
	private String Email;
	private String Password;
	public int getLogin_id() {
		return login_id;
	}
	public void setLogin_id(int login_id) {
		this.login_id = login_id;
	}
	
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		this.Password = password;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
		
	
}
