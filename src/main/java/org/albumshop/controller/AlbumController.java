package org.albumshop.controller;

import java.util.List;

import org.albumshop.domain.Album;
import org.albumshop.persistence.AlbumRepository;
import org.albumshop.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AlbumController {
	
	@Autowired
	AlbumRepository albumRepo;
	@Autowired
	AlbumService albumService;
	
	@GetMapping(value="/albumDetail")
	public void albumDetail(Model model, Long albumId) {
		Album album = albumService.getAlbumById(albumId);
		List<String> albumArtists = albumService.getAlbumArtist(albumId);
		model.addAttribute("album", album);
		model.addAttribute("albumArtists", albumArtists);
	}
	
	@GetMapping(value="/albumListTest")
	public void albumList(Model model) {
		List<Album> albumList = albumService.getAlbumList();
		model.addAttribute("albumList",albumList);
	}
	
}
