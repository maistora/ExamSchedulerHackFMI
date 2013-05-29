package com.maistora.spring.demo.database.transformers;

import com.maistora.spring.demo.database.entities.UserDB;
import com.maistora.spring.demo.web.dto.UserDTO;

public class UserTransformer extends UserDTO {

	public UserDTO transform(UserDB user) {
		if (user == null) {
			return null;
		}
		
		final UserDTO userDTO = new UserDTO();
		userDTO.setUserId(user.getUserId());
		userDTO.setName(user.getName());
		userDTO.setEmail(user.getEmail());
		userDTO.setUsername(user.getUsername());
		
		return userDTO;
	}

}
