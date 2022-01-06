package org.albumshop.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.albumshop.domain.Album;
import org.albumshop.domain.MultiIdMyListAlbum;
import org.albumshop.domain.MyList;
import org.albumshop.domain.MyListDetail;
import org.albumshop.domain.User;
import org.albumshop.persistence.AlbumRepository;
import org.albumshop.persistence.MyListDetailRepository;
import org.albumshop.persistence.MyListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyListService {
	
	@Autowired
	MyListRepository myListRepo;
	@Autowired
	MyListDetailRepository myListDetailRepo;
	@Autowired
	AlbumRepository albumRepo;
	@Autowired
	HttpSession session;
	
	public List<Object[]> getAllMyLists(Long albumId){
		User user = (User) session.getAttribute("user");
		if(user==null) {
			return new ArrayList<>();
		}
		return myListRepo.getAllMyList(albumId, user.getId());
	}
	
	public MyList makeMyList(String myListTitle){
		User tempUser = (User) session.getAttribute("user");
		/* User user = User.builder().id(tempUser.getId()).build(); */
		MyList mylist = MyList.builder().user(tempUser).myListTitle(myListTitle).build();
		myListRepo.save(mylist);
		return mylist;
	}
	
	public Album insertAlbum(Long albumId, Long myListId) {
		MultiIdMyListAlbum multiId = new MultiIdMyListAlbum();
		multiId.setId(albumId, myListId);
		MyListDetail myListDetail = MyListDetail.builder().multiId(multiId).build();
		myListDetailRepo.save(myListDetail);
		return albumRepo.findById(albumId).get();
	}
	
	public Album deleteAlbum(Long albumId, Long myListId) {
		MultiIdMyListAlbum multiId = new MultiIdMyListAlbum();
		multiId.setId(albumId, myListId);
		myListDetailRepo.findById(multiId).ifPresent(myListDetail->{
			myListDetailRepo.delete(myListDetail);
		});
		return albumRepo.findById(albumId).get();
	}
}
