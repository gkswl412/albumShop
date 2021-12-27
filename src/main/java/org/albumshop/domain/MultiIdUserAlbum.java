package org.albumshop.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

@Getter
@Setter
@ToString
@Embeddable
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MultiIdUserAlbum implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManyToOne(cascade = CascadeType.ALL)
	private User user;
	
	@ManyToOne
	private Album album;
	
	public void setId(String userId, Long albumId) {
		this.user = User.builder().id(userId).build();
		this.album = Album.builder().id(albumId).build();
	}
}
