package org.albumshop.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.albumshop.domain.Album;
import org.albumshop.domain.MyList;
import org.albumshop.domain.Song;
import org.albumshop.domain.User;
import org.albumshop.service.AlbumService;
import org.albumshop.service.CartService;
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
	@Autowired
	private CartService cartService;
	
	@GetMapping(value="albumdetail")
	public String albumDetail(Model model, Long albumId) {
		
		//앨범정보 저장
		Album album = albumService.getAlbumDetailInfo(albumId);
		model.addAttribute("album",album);
		
		//노래정보 저장
		List<Song> songs = albumService.getSongsOfAlbum(album);
		model.addAttribute("songs",songs);
		
		//마이리스트 정보 저장
		List<Object[]> myLists = myListService.getAllMyLists(albumId);
		model.addAttribute("myLists",myLists);

		// CartId 저장
		User user = (User) session.getAttribute("user");
		String userId;
		if (user == null) {
			userId = "comet";
		} else {
			userId = user.getId();
		}

		Long cartId = cartService.cartIdFindByUserId(userId);
		model.addAttribute("cartId", cartId);
		return "albumDetail";
	}
	
	@PostMapping(value="makeMyList")
	@ResponseBody
	public MyList makeMyList(String myListTitle){
		return myListService.makeMyList(myListTitle);
	}
}
