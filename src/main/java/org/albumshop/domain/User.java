package org.albumshop.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name="user")
public class User {
	
	@Id
	private String id;
	@NotNull
	private String name;
	@NotNull
	private String nickName;
	@NotNull
	private String pass;
	private String address;
	private String email;
	@NotNull
	private String phone;
	private String photo;
	@NotNull
	private String grade;
	@NotNull
	private Integer score;
	@NotNull
	private LocalDate birth;
	private String gender;
	
}
