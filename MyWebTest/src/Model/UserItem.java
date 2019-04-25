package Model;

public class UserItem {
	private String username;
	private String password;
	
	
	public UserItem(String username) {
		this(username,"111111");
	}
	
	
	public UserItem(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
