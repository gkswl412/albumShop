package org.albumshop.service;

import java.util.ArrayList;
import java.util.List;

import org.albumshop.domain.Album;
import org.albumshop.persistence.AlbumArtistRepository;
import org.albumshop.persistence.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlbumService {
	
	@Autowired
	AlbumRepository albumRepo;
	@Autowired
	AlbumArtistRepository albumArtistRepo;
	
	public Album getAlbumById(Long albumId) {
		System.out.println("service : albumId-->" + albumId);
		Album album = albumRepo.findById(albumId).orElse(null);
		return album;
	}
	
	public List<Album> getAlbumList(){
		List<Album> albumList = new ArrayList<>();
		albumRepo.findAll().forEach(album->{
			albumList.add(album);
		});
		return albumList;
	}
	
	public List<String> getAlbumArtist(Long albumId){
		List<String> albumArtists = albumArtistRepo.findAlbumArtistByAlbumId(albumId);
		return albumArtists;
	}
}
