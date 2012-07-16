package test.jp.mnuma.entity;

public class UserEntity {

	private String userId;
	private String userName;
	private String userPassword;
	
	public UserEntity() {
		
	}
	
	//UserEntityコンストラクタ
	public UserEntity(String userId, String userName, String userPassword) {	
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
	}
	
	//toString
	public String toString() {
		return userId + userName + userPassword;
	}

	//UserEntityアクセッサ
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
