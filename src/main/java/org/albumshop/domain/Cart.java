package org.albumshop.domain;

import java.time.LocalDate;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.*;

@Getter
@Setter
@ToString
@Entity
@Table(name="cart")
@Builder
@EqualsAndHashCode(of = "Id")
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	@OneToOne(cascade = CascadeType.ALL)
	@NotNull
	private User user;

	public static Cart createCart(User user) {
		Cart cart = Cart.builder()
				.user(user)
				.build();
		return cart;
	}
}
