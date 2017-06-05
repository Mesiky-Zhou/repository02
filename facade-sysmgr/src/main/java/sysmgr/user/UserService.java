package sysmgr.user;

import java.io.Serializable;
import java.util.List;

public interface UserService extends Serializable{
	
	public List<User> getUserList(int userSize);

}
