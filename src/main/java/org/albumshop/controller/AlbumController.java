package org.albumshop.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.albumshop.domain.Album;
import org.albumshop.domain.Artist;
import org.albumshop.domain.ArtistGroup;
import org.albumshop.domain.Song;
import org.albumshop.persistence.AlbumArtistRepository;
import org.albumshop.persistence.AlbumRepository;
import org.albumshop.persistence.ArtistGroupRepository;
import org.albumshop.persistence.ArtistRepository;
import org.albumshop.persistence.ReviewRepository;
import org.albumshop.persistence.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
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
	@Autowired
	ReviewRepository reRepo;
	
	

	@RequestMapping("/albumlist")
	public String test(Long id, Model model) {
		
		List<Album> albumlist = (List<Album>) abRepo.findAll();		
		model.addAttribute("albumlist", albumlist);
		Map<Long, List<Object>> m = new HashMap<>();

		
		for(Album album: albumlist) {
			Long rcount = reRepo.countRatingByAlbumId(album.getId());
			Double ravg = reRepo.avgRatingByAlbumId(album.getId());
			List<Object> a = new ArrayList<>();
			a.add(rcount);
			a.add(ravg);
			m.put(album.getId(), a);	
		}
		
		model.addAttribute("rlist", m);
		
		Long albumcount = abRepo.countAllById();
		Long artistcount = aRepo.countAllById();
		Long artisgroupcount = agRepo.countAllById();
		Long reviewcount = reRepo.countAllById();
		
		model.addAttribute("albumcount", albumcount);
		model.addAttribute("artistcount", artistcount);
		model.addAttribute("artisgroupcount", artisgroupcount);
		model.addAttribute("reviewcount", reviewcount);
		
		
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
		} else if (searchType.equals("Genre")) {
			List<Album> album1 = abRepo.findByGenreContaining(searchKeyword);
			model.addAttribute("Album", album1);
		}else if (searchType.equals("SongTitle")) {
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
	public String test3(String genre, Model model) {
		List<Album> glist = abRepo.findAllByGenre();
		model.addAttribute("glist", glist);
		return "/Genre";
	}
	@RequestMapping("/test")
	public String test4() {
		return "/test";
	}
	@RequestMapping("/userInfo/userDetail")
	public String test5() {
		return "/userInfo/userDetail";
	}
	
}
