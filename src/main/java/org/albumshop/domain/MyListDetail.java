package org.albumshop.domain;

import java.time.LocalDate;

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

@Getter
@Setter
@ToString
@Entity
@Table(name="myListDetail")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MyListDetail {
	
	@EmbeddedId
	@OnDelete(action = OnDeleteAction.CASCADE)
	private MultiIdMyListAlbum multiId;
}
