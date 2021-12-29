package org.albumshop.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(exclude="multiId")
@Entity
@Table(name="review")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Review {
	
	@EmbeddedId
	MultiIdUserAlbum multiId;
	
	@NotNull
	private float rating;
	private String content;

	@CreationTimestamp
	@Column(updatable = false)
	private Timestamp regDate;
	
	@UpdateTimestamp
	private Timestamp updateDate;
}
