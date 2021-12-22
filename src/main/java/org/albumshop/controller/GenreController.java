package org.albumshop.controller;

import java.util.List;

import org.albumshop.domain.Album;
import org.albumshop.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/Genre/*")
@Slf4j
public class GenreController {

	@Autowired
	private GenreService genreservice;
	
	//Gerne 리스트 요청
	@GetMapping("/{genre}")
	public ResponseEntity<List<Album>> getGenreList(@PathVariable("genre") String genre){
		List<Album> glist = genreservice.getAlbumListByGenre(genre);
		return new ResponseEntity<>(glist, HttpStatus.CREATED);
		
	}
}
