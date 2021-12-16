package org.albumshop.controller;

import java.util.List;

import org.albumshop.domain.Album;
import org.albumshop.domain.Song;
import org.albumshop.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AlbumDetailController {
	
	@Autowired
	private AlbumService albumService;
	
	@GetMapping(value="albumdetail")
	public String albumDetail(Model model, Long albumId) {
		
		//앨범정보 저장
		Album album = albumService.getAlbumDetailInfo(albumId);
		model.addAttribute("album",album);
		
		//노래정보 저장
		List<Song> songs = albumService.getSongsOfAlbum(album);
		model.addAttribute("songs",songs);
		
		return "albumDetail";
	}

}
