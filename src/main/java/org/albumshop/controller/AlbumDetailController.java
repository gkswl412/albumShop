package org.albumshop.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.albumshop.domain.Album;
import org.albumshop.domain.Song;
import org.albumshop.domain.User;
import org.albumshop.service.AlbumService;
import org.albumshop.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AlbumDetailController {
	
	@Autowired
	private AlbumService albumService;
	@Autowired
	private ReviewService reviewService;
	@Autowired
	private HttpSession session;
	
	@GetMapping(value="albumdetail")
	public String albumDetail(Model model, Long albumId) {
		
		//임시 유저 정보 생성
		User user = reviewService.getUserInfo("kosta4");
		session.setAttribute("user", user);
		//model.addAttribute("user",user);
		
		//앨범정보 저장
		Album album = albumService.getAlbumDetailInfo(albumId);
		model.addAttribute("album",album);
		
		//노래정보 저장
		List<Song> songs = albumService.getSongsOfAlbum(album);
		model.addAttribute("songs",songs);
	
		
		return "albumDetail";
	}

}
