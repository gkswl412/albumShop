package org.albumshop.vo;

import lombok.*;
import org.albumshop.domain.MultiIdCartAlbum;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CartDetailVO {
    private Long cartId;
    private String userId;
    private Long albumId;
    private int quantity;
    //private int albumId2;
    //private MultiIdCartAlbum multiIdCartAlbum; // cartId, albumId;
    private String cover;
    private int price;
    private int remaining;
    private String albumTitle;
    private String artistId;
    private String artistGroupId;
    //private Long albumArtist;
    private String artistName;
    //private String artistGroupName;
}
