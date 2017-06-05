package sysmgr.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

@SuppressWarnings("serial")
@Service("userService")
public class UserServiceImpl implements UserService {

	@Override
	public List<User> getUserList(int userSize) {
		List<User> list = new ArrayList<User>();
		for(int i=1;i<=userSize;i++){
			User user = new User();
			user.setId(i);
			user.setUsername("user " + i);
			user.setCreated(new Date());
			user.setPassword("password" + i);
			list.add(user);
		}
		
		return list;
	}

}
