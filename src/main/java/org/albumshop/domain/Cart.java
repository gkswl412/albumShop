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

	@OneToOne
	@NotNull
	private User user;
}
