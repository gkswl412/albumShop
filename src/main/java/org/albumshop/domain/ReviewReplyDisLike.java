package org.albumshop.domain;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@Table(name="reviewReplyDisLike")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReviewReplyDisLike {
	
	@EmbeddedId
	@OnDelete(action = OnDeleteAction.CASCADE)
	MultiIdUserReviewReply multiId;
	
}
