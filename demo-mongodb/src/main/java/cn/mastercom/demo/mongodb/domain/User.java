package cn.mastercom.demo.mongodb.domain;

import java.io.Serializable;

//@Document(collection = "users")
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1388318336764852893L;
//	@Id
	private Long id;
	private String userName;
	private String passWord;

	public User() {
		super();
	}

	public User(Long id, String userName, String passWord) {
		super();
		this.id = id;
		this.userName = userName;
		this.passWord = passWord;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	@Override
	public String toString() {
		return "User{" + "id=" + id + ", userName='" + userName + '\'' + ", passWord='" + passWord + '\'' + '}';
	}
}
