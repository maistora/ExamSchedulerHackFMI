package com.maistora.hackfmi.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.maistora.hackfmi.web.dto.UserDTO;
import com.maistora.hackfmi.web.services.UserService;

@Controller
@RequestMapping("/users")
public class UsersController {

	@Autowired
	private UserService userService;

	/**
	 * Takes information about user such as userId, name, username, password, email.
	 * The way to reach it in the AJAX request is by Path Variable like in this example:
	 * .../getUserInfo/222
	 * See what the 'three dots' mean in the web.xml - the mapping to the spring servlet dispatcher.
	 * (In our case they mean /resources/)  
	 * 
	 * @param userId
	 * @return UserInfo as JSON
	 */
	@RequestMapping(value = "/getUserInfo/{userId}", method = RequestMethod.GET)
	public @ResponseBody UserDTO getUserInfoByPathVar(@PathVariable("userId") Long userId) {
		return userService.getUserById(userId);
	}
	
	
	/**
	 * Almost the same with the one above. The difference is that this one uses Request parameter 
	 * so in the AJAX request we will have for example .../users/getUserInfo?userId=222
	 * 
	 * @param userId
	 * @return UserInfo as JSON 
	 */
	@RequestMapping(value = "/getUserInfo", method = RequestMethod.GET)
	public @ResponseBody UserDTO getUserInfoByRequestParam(@RequestParam("userId") Long userId) {
		return userService.getUserById(userId);
	}
	
	@RequestMapping(value = "/getUsers", method = RequestMethod.GET)
	public @ResponseBody List<UserDTO> getUsers() {
		return userService.getUsers();
	}
}
