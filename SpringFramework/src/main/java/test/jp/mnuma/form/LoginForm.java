package test.jp.mnuma.form;

public class LoginForm {
	
	private String userId;
	private String userName;
	private String userPassword;
	
	public LoginForm() {
		
	}

	//LoginFormコンストラクタ
	public LoginForm(String userId, String userpPassword, String userName) {
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userpPassword;
	}
	
	//toString
	public String toString() {
		return "userName:" + userName + "userPassword:" + userPassword;	
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
}
