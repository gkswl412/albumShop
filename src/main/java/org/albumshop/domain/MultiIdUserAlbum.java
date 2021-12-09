package org.albumshop.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

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

	@ManyToOne
	private User user;
	
	@ManyToOne
	private Album album;
	
}
