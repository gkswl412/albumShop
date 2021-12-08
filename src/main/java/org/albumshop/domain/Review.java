package org.albumshop.domain;

import java.sql.Timestamp;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name="review")
public class Review {
	
	@EmbeddedId
	MultiIdUserAlbum multiId;
	
	@NotNull
	private float rating;
	private String content;
	@CreationTimestamp
	@NotNull
	private Timestamp regDate;
	private Integer likeCount;
	@UpdateTimestamp
	@NotNull
	private Timestamp updateDate;
}
