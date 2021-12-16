package org.albumshop.domain;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

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
	MultiIdUserReviewReply multiId;
	
}
