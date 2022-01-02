package org.albumshop.security.oauth;

import java.io.Serializable;

import groovy.transform.ToString;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@ToString
public class SessionUser implements Serializable {

	private String name;
	private String email;
	private String picture;
	
	
	public SessionUser(UserDTO user) {
		this(user.getName(), user.getEmail(), user.getPicture());
	}


	public SessionUser(String name, String email, String picture) {
		super();
		this.name = name;
		this.email = email;
		this.picture = picture;
	}
}
