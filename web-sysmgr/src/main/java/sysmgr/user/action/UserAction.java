package sysmgr.user.action;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sysmgr.user.UserService;

@Controller
@RequestMapping("/user")
public class UserAction {
	
	@Autowired
	private UserService userService;

	@RequestMapping("/userList")
	public String userList(@RequestParam("userSizeP") int userSize, Map<String,Object> map){
		
		map.put("users", userService.getUserList(userSize));
		return "user/userList";
	}
}
