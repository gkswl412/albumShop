package org.albumshop.controller;

import org.albumshop.domain.Artist;
import org.albumshop.domain.ArtistGroup;
import org.albumshop.persistence.AlbumArtistRepository;
import org.albumshop.persistence.AlbumRepository;
import org.albumshop.persistence.ArtistGroupRepository;
import org.albumshop.persistence.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AtAndAtGController {

	@Autowired
	AlbumRepository abRepo;
	@Autowired
	AlbumArtistRepository aaRepo;
	@Autowired
	ArtistGroupRepository agRepo;
	@Autowired
	ArtistRepository aRepo;
	
	@RequestMapping("/ArtistDetail")
	public String selecteArtistById(Long Id, Model model) {
		Artist a = aRepo.findById(Id).orElse(null);
		model.addAttribute("Artist", a);
		System.out.println(a.getAlbumartist().size());
		return "ArtistDetail";		
	}
	
	@RequestMapping("/ArtistGroupDetail")
	public String selecteArtistGroupById(Long Id, Model model) {
		ArtistGroup ag = agRepo.findById(Id).orElse(null);
		model.addAttribute("ArtistGroup", ag);
		return "ArtistGroupDetail";		
	}
}
