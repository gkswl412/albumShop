package org.albumshop.security.oauth;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import groovy.transform.ToString;
import groovy.transform.builder.Builder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter@Setter@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "social_user")
public class UserDTO    {
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String email;
	@Column
	private String picture;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private UserRole role;
	
	
	 
	
	
	public UserDTO update(String name, String picture) {
		this.name=name;
		this.picture=picture;
		return this;
	}
	public String getRolKey() {
		return this.role.getKey();
	}
	 
	
	
}
