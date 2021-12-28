package org.albumshop.controller;

import java.util.List;

import org.albumshop.domain.Album;
import org.albumshop.persistence.AlbumRepository;
import org.albumshop.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GenreListFormController {

	@Autowired
	GenreService genreservice;
	@Autowired
	AlbumRepository abRepo;
	
	@GetMapping("/GenreListForm")
	public String getGenreListForm(Model model, String genre) {
		List<Album> glist= abRepo.findByGenreContaining(genre);
		model.addAttribute("g",glist);
		return "Genre/GenreListForm";
	}
	
}
