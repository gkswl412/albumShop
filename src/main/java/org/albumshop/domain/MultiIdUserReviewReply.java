package org.albumshop.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
public class MultiIdUserReviewReply implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private User user;
	
	@ManyToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
	private ReviewReply reviewReply;
	
	public void setId(String userId, Long replyId) {
		this.user = User.builder().id(userId).build();
		this.reviewReply = ReviewReply.builder().id(replyId).build();
	}
	
}
