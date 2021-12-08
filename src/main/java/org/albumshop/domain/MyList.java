package org.albumshop.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name="myList")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MyList {
	
	@Id
	private Long id;
	@ManyToOne
	@NotNull
	private User user;
	@NotNull
	private String myListTitle;
	
}
