package org.albumshop.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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
@Table(name="purchaseReview")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseReview implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	Long id;
	@MapsId
	@OneToOne
	@JoinColumn(name = "delivery_id")
	private Delivery delivery;
	@NotNull
	private String title;
	@NotNull
	private String content;
	@CreationTimestamp
	@NotNull
	private Timestamp regDate;
	@UpdateTimestamp
	@NotNull
	private Timestamp updateDate;
	
}
