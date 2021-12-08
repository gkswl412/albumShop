package org.albumshop.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name="myList")
public class MyList {
	
	@Id
	private Long id;
	@ManyToOne
	@NotNull
	private User user;
	@NotNull
	private String myListTitle;
	
}
