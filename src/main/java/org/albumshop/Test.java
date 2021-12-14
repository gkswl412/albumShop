package org.albumshop;

import org.albumshop.domain.ArtistGroup;

public class Test {
	 public static void main(String[] args) {
		
		 ArtistGroup artistgroup = new ArtistGroup();
		 artistgroup.setId(100L);
		 artistgroup.setName("AA");
		 System.out.println(artistgroup.getArtist());
	 }
}
