package org.albumshop.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Embeddable
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MultiIdUserReview implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private User user;
	
	@ManyToOne
	private Review review;
	
	public void setId(String userId, String reviewUserId, Long albumId) {
		this.user = User.builder().id(userId).build();
		MultiIdUserAlbum multiId = new MultiIdUserAlbum();
		multiId.setId(reviewUserId, albumId);
		this.review = Review.builder().multiId(multiId).build();
	}
}
