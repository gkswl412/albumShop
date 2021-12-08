package org.albumshop.domain;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name="myListDetail")
public class MyListDetail {
	
	@EmbeddedId
	private MultiIdMyListAlbum multiId;
}
