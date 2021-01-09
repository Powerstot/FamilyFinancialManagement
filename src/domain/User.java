package domain;
/**
 * 用户实体类
 * @author Powers
 *
 */
public class User {
	private int userId;//用户id
	private String userUsername;//用户名
	private String userPassword;//用户密码
	private String userEmail;//用户邮箱
	private int userIsmanager;//是否管理员
	private int userIsvip;//是否会员
	public User(int userId, String userUsername, String userPassword, String userEmail, int userIsmanager,
			int userIsvip) {
		super();
		this.userId = userId;
		this.userUsername = userUsername;
		this.userPassword = userPassword;
		this.userEmail = userEmail;
		this.userIsmanager = userIsmanager;
		this.userIsvip = userIsvip;
	}
	public User(String userUsername, String userPassword, String userEmail, int userIsmanager,
			int userIsvip) {
		super();
		this.userUsername = userUsername;
		this.userPassword = userPassword;
		this.userEmail = userEmail;
		this.userIsmanager = userIsmanager;
		this.userIsvip = userIsvip;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserUsername() {
		return userUsername;
	}
	public void setUserUsername(String userUsername) {
		this.userUsername = userUsername;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public int getUserIsmanager() {
		return userIsmanager;
	}
	public void setUserIsmanager(int userIsmanager) {
		this.userIsmanager = userIsmanager;
	}
	public int getUserIsvip() {
		return userIsvip;
	}
	public void setUserIsvip(int userIsvip) {
		this.userIsvip = userIsvip;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userUsername=" + userUsername + ", userPassword=" + userPassword
				+ ", userEmail=" + userEmail + ", userIsmanager=" + userIsmanager + ", userIsvip=" + userIsvip + "]";
	}
	
}
