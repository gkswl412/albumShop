package org.albumshop.service;

import java.util.List;

import org.albumshop.domain.Album;
import org.albumshop.domain.Song;
import org.albumshop.persistence.AlbumArtistRepository;
import org.albumshop.persistence.AlbumRepository;
import org.albumshop.persistence.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlbumService {
	
	@Autowired
	AlbumRepository albumRepo;
	@Autowired
	AlbumArtistRepository albumArtistRepo;
	@Autowired
	SongRepository songRepo;
	
	public Album getAlbumDetailInfo(Long albumId) {
		Album album = albumRepo.findById(albumId).orElse(null);
		return album;
	}
	
	public List<Song> getSongsOfAlbum(Album album) {
		List<Song> songs = songRepo.findByAlbum(album);
		return songs;
	}
}
