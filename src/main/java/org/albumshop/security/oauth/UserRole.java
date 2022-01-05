package org.albumshop.security.oauth;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum UserRole {

    SOCIAL("ROLE_SOCIAL", "소셜사용자"),
	USER("ROLE_USER", "일반사용자");
	
	private final String key;
	private final String title;
	
}
