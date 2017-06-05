package sysmgr.user;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial") 
public class User implements Serializable{
	private int id;
	private String username;
	private String password;
	private Date created;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	

	
}
