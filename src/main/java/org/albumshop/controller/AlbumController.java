package org.albumshop.controller;

import java.util.List;

import org.albumshop.domain.Album;
import org.albumshop.domain.Artist;
import org.albumshop.domain.ArtistGroup;
import org.albumshop.domain.Song;
import org.albumshop.persistence.AlbumArtistRepository;
import org.albumshop.persistence.AlbumRepository;
import org.albumshop.persistence.ArtistGroupRepository;
import org.albumshop.persistence.ArtistRepository;
import org.albumshop.persistence.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AlbumController {

	@Autowired
	AlbumRepository abRepo;
	@Autowired
	AlbumArtistRepository aaRepo;
	@Autowired
	ArtistGroupRepository agRepo;
	@Autowired
	ArtistRepository aRepo;
	@Autowired
	SongRepository sRepo;

	@RequestMapping("/albumlist")
	public String test(Long id, Model model) {
		List<Album> albumlist = (List<Album>) abRepo.findAll();
		model.addAttribute("albumlist", albumlist);
		return "albumlist";
	}

	@RequestMapping("/SearchResult")
	public String test2(String searchKeyword, String searchType, Model model) {

		model.addAttribute("searchKeyword", searchKeyword);
		model.addAttribute("searchType", searchType);
		if (searchType.equals("Artist")) {
			List<Artist> artist1 = aRepo.findByNameContaining(searchKeyword);
			model.addAttribute("Artist", artist1);
		} else if (searchType.equals("ArtistGroup")) {
			List<ArtistGroup> artistgroup1 = agRepo.findByNameContaining(searchKeyword);
			model.addAttribute("ArtistGroup", artistgroup1);
		} else if (searchType.equals("AlbumTitle")) {
			List<Album> album1 = abRepo.findByTitleContaining(searchKeyword);
			model.addAttribute("Album", album1);
		} else if (searchType.equals("SongTitle")) {
			List<Song> song1 = sRepo.findByTitleContaining(searchKeyword);
			model.addAttribute("Song", song1);
		} else if (searchType.equals("Lyrics")) {
			List<Song> song3 = sRepo.findByLyricsContaining(searchKeyword);
			model.addAttribute("Song", song3);
		}else{
			List<Album> album2 = abRepo.findByTitleContaining(searchKeyword);
			model.addAttribute("Album", album2);

			List<Artist> artist2 = aRepo.findByNameContaining(searchKeyword);
			model.addAttribute("Artist", artist2);

			List<ArtistGroup> artistgroup2 = agRepo.findByNameContaining(searchKeyword);
			model.addAttribute("ArtistGroup", artistgroup2);

			List<Song> song2 = sRepo.findByTitleContaining(searchKeyword);
			model.addAttribute("Song", song2);
		}

		return "/SearchResult";
	}

	@RequestMapping("/Genre")
	public String test3() {
		
		return "/Genre";
	}
	@RequestMapping("/test")
	public String test4() {
		
		return "/test";
	}
}
