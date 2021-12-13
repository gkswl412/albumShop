package org.albumshop.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(exclude = "album")
@Entity
@Table(name="albumArtist")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AlbumArtist {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@ManyToOne
	@NotNull
	private Album album;
	@ManyToOne
	private Artist artist;
	@ManyToOne
	private ArtistGroup artistGroup;
}
