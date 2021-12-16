package org.albumshop.security;




import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;


//import groovy.transform.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//@EqualsAndHashCode
public class SecurityUser extends User{
	private static final long serialVersionUID = 1L;
	private static final Collection<? extends GrantedAuthority> authorities = null;
    private org.albumshop.domain.User user;   
	public SecurityUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
	}
	
	public SecurityUser(org.albumshop.domain.User user) {	
		super( user.getId(), user.getPass(), authorities );
		this.user = user;
		System.out.println("SecurityUser member:" + user);
	}
	
}
