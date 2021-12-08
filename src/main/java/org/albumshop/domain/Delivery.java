package org.albumshop.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name="delivery")
public class Delivery implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@NotNull
	private User user;
	@NotNull
	private String destinationAddress;
	private String deliveryRequest;
	@CreationTimestamp
	@NotNull
	private Timestamp deliveryRegDate;
	@UpdateTimestamp
	@NotNull
	private Timestamp deliveryUpdateDate;
	@NotNull
	private String orderState;
	
}
