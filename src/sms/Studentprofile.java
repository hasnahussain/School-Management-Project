package sms;

public class Studentprofile 
{

public String getStudent_name() {
	return student_name;
}
public void setStudent_name(String student_name) {
	this.student_name = student_name;
}
public String getStudent_dob() {
	return student_dob;
}
public void setStudent_dob(String student_dob) {
	this.student_dob = student_dob;
}
public String getGuardian_name() {
	return guardian_name;
}
public void setGuardian_name(String guardian_name) {
	this.guardian_name = guardian_name;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
private int adm_no;
public int getAdm_no() {
	return adm_no;
}
public void setAdm_no(int adm_no) {
	this.adm_no = adm_no;
}
private String student_name;
private String student_dob;
private String guardian_name;
private String role;
private String email;
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
}
