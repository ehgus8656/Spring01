package spring01;

public class RegisterRequest {
	private String email;
	private String pw;
	private String confirmpw;
	private String name;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getConfirmpw() {
		return confirmpw;
	}
	public void setConfirmpw(String confirmpw) {
		this.confirmpw = confirmpw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isPasswordEqualToConfirmPassword() {
		return pw.equals(confirmpw);
	}
}
