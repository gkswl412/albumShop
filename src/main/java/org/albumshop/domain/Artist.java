package org.albumshop.domain;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@ToString(exclude = "artistGroup")
@Entity
@Table(name="artist")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Artist {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	private ArtistGroup artistGroup;
	private LocalDate debutDate;
	private LocalDate birth;
	@NotNull
	private String name;
	private String gender;
	private String photo;
	
	@OneToMany
	@JoinColumn(name="artist_id")
	List<AlbumArtist> albumartist;
	
}
