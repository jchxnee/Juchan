package kh.jdbc.model.vo;

/*
 * VO(Value Object)
 * DB의 테이블정보를 Java에서 사용하기위해 담아주는 객체
 * 한명의 회원(db테이블의 한 행의 데이터)에 대한 데이터를 기록할 수 있는 저장용 객체
 */
public class Member {
	//필드는 기본적으로 db컬럼명과 유사하게 작업
	private String userId;
	private String userPwd;
	private String userName;
	private char gender;
	private String phone;
	private String email;
	private String newPwd;

	
	public Member() {
		super();
	}


	public Member(String userId, String userPwd, String userName, char gender, String email, String phone) {
		super();
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.gender = gender;
		this.email = email;
		this.phone = phone;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getUserPwd() {
		return userPwd;
	}
	

	public Member(String newPwd) {
		super();
		this.newPwd = newPwd;
	}


	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public char getGender() {
		return gender;
	}


	public void setGender(char gender) {
		this.gender = gender;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	@Override
	public String toString() {
		return "Member [userId=" + userId + ", userPwd=" + userPwd + ", userName=" + userName + ", gender=" + gender
				+ ", email=" + email + ", phone=" + phone + "]";
	}
	
	
}
	