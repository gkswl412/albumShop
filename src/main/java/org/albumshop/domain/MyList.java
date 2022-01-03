package org.albumshop.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators.IntSequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(exclude="user")
@Entity
@Table(name="myList")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = IntSequenceGenerator.class, property = "user")
public class MyList {
	
	@Id
	private Long id;
	@ManyToOne(cascade = CascadeType.ALL)
	@NotNull
	private User user;
	@NotNull
	private String myListTitle;
	
}
