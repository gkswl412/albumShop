package org.albumshop.service;

import java.util.List;

import org.albumshop.domain.Album;
import org.albumshop.persistence.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class GenreService {

	@Autowired
	private AlbumRepository arRepo;
	
	//장르별 리스트
	public List<Album> getAlbumListByGenre(String genre){
		return arRepo.findByGenreContaining(genre);
	}
	
	//앨범 정보 얻기
	public List<Album> getAlbumInfo(String genre) {
		return arRepo.findByGenreContaining(genre);
	}
	
	
}
