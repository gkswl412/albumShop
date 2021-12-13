package org.albumshop.controller;

import java.util.List;

import org.albumshop.domain.Album;
import org.albumshop.persistence.AlbumArtistRepository;
import org.albumshop.persistence.AlbumRepository;
import org.albumshop.persistence.ArtistGroupRepository;
import org.albumshop.persistence.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AlbumControllre {

	@Autowired
	AlbumRepository abRepo;
	@Autowired
	AlbumArtistRepository aaRepo;
	@Autowired
	ArtistGroupRepository agRepo;
	@Autowired
	ArtistRepository aRepo;
	
	
	@RequestMapping("/albumlist")
	public String test(Long id, Model model){
		System.out.println("앨범리스트 출력");
		List<Album> albumlist = (List<Album>) abRepo.findAll();
		System.out.println(albumlist);
		model.addAttribute("albumlist",albumlist);
		return "albumlist";
	}
	
}
