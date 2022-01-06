package org.albumshop.security.oauth;

import java.util.Collections;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CustomOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {

     
    private final UserRepository2  userRepo;
    private final HttpSession httpSession;
    
    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
       
    	OAuth2UserService<OAuth2UserRequest, OAuth2User> delegate = 
    			new DefaultOAuth2UserService();
    	OAuth2User oAuth2User = delegate.loadUser(userRequest);
    	System.out.println("oAuth2User:" + oAuth2User);
    	String registrationId = userRequest.getClientRegistration().getRegistrationId();
    	 
    	String userNameAttributeName = userRequest.getClientRegistration()
    			.getProviderDetails().getUserInfoEndpoint().getUserNameAttributeName();
        //oAuth2User의 속성들:registrationId(네이버인지, 구글인지 구별)
    	//userNameAttributeName:PK...구글은 기본코드는 sub
    	OAuthAttributes attributes = OAuthAttributes.of(registrationId, 
        		userNameAttributeName, oAuth2User.getAttributes()) ;
    	UserDTO user = saveOrUpdate(attributes);
    	httpSession.setAttribute("user", new SessionUser(user));
    	return new DefaultOAuth2User(Collections.singleton(
    			new SimpleGrantedAuthority(user.getRolKey())), attributes.getAttributes(),
    			attributes.getNameAttributeKey());
    }

 
    
    private UserDTO saveOrUpdate(OAuthAttributes attributes) {
		UserDTO user = userRepo.findByEmail(attributes.getEmail())
				.map(entity->entity.update(attributes.getName(), attributes.getPicture()))
				.orElse(attributes.toEntity());
		System.out.println("user:" + user);
		return userRepo.save(user);
	}



	 
}
