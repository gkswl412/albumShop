package org.albumshop.domain;

import java.time.LocalDate;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name="cart")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
	
	@EmbeddedId
	MultiIdUserAlbum multiId;
	
	@NotNull
	private Integer quantity;
	
}
