package kh.jdbc.project.model.vo;


/*
  VO(Value Object)
  DB의 테이블정보를 Java에서 사용하기위해 담아주는 객체
  한명의 회원(db테이블의 한 행의 데이터)에 대한 데이터를 기록할 수 있는 저장용 객체
 */
public class Member {

	private String userId;
	private String userPwd;
	private String userName;
	private int age;
	private String email;
	private String phone;
	private String address;


	
	public Member() {
		super();
	}

	public Member(String userId, String userPwd, String userName,int age, String email,
			String phone, String address) {
		super();
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.age = age;
		this.email = email;
		this.phone = phone;
		this.address = address;
	}
	
	
	

	public Member(String userId) {
		super();
		this.userId = userId;
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

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}


	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Member [userId=" + userId + ", userPwd=" + userPwd + ", userName=" + userName + ", age=" + age
				+ ", email=" + email + ", phone=" + phone + ", address=" + address + "]";
	}


	
	
	
	
}
