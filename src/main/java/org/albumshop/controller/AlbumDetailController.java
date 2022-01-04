package org.albumshop.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.albumshop.domain.Album;
import org.albumshop.domain.Song;
import org.albumshop.service.AlbumService;
import org.albumshop.service.MyListService;
import org.albumshop.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AlbumDetailController {
	
	@Autowired
	private AlbumService albumService;
	@Autowired
	private ReviewService reviewService;
	@Autowired
	private HttpSession session;
	@Autowired
	private MyListService myListService;
	
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
	
	@PostMapping(value="makeMyList")
	@ResponseBody
	public String  makeMyList(String myListTitle) {
		myListService.makeMyList(myListTitle);
		return myListTitle;
	}

}
