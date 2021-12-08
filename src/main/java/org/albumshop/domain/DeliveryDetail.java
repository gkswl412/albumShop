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
@Table(name="deliveryDetail")
public class DeliveryDetail {
	
	@EmbeddedId
	MultiIdDeliveryAlbum multiId;
	
	@NotNull
	private int orderAmount;
	
}
