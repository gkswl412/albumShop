package org.albumshop.domain;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name="cart")
public class Cart {
	
	@EmbeddedId
	MultiIdUserAlbum multiId;
	
	@NotNull
	private Integer quantity;
	
}
