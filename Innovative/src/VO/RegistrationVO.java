package VO;

public class RegistrationVO {
	private int registrationid;
	private String FirstName;
	private String LastName;
	private String Email;
	private String Password;
	private String Birthdate;
	private String Gender;
	private loginVO loginvo;

	
	
	public loginVO getLoginvo() {
		return loginvo;
	}
	public void setLoginvo(loginVO loginvo) {
		this.loginvo = loginvo;
	}
	public int getRegistrationid() {
		return registrationid;
	}
	public void setRegistrationid(int registrationid) {
		this.registrationid = registrationid;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
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
		Password = password;
	}
	
	public String getBirthdate() {
		return Birthdate;
	}
	public void setBirthdate(String birthdate) {
		Birthdate = birthdate;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	
	

}
