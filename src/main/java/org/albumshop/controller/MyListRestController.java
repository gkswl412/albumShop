package org.albumshop.controller;

import org.albumshop.domain.Album;
import org.albumshop.service.MyListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mylist/")
public class MyListRestController {
	
	@Autowired
	MyListService myListService;
	
/*	@PostMapping("/insert-album/{albumId}/{myListId}")
	public Album insertAlbum(@PathVariable Long albumId, @PathVariable Long myListId) {
		return myListService.insertAlbum(albumId, myListId);
	}
	
	@DeleteMapping("/delete-album/{albumId}/{myListId}")
	public Album deleteAlbum(@PathVariable Long albumId, @PathVariable Long myListId) {
		return myListService.deleteAlbum(albumId, myListId);
	}*/
}
