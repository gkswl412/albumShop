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
    private String userId;
    private MultiIdCartAlbum multiIdCartAlbum;
    private String albumTitle;
    private int price;
    private String cover;
    private Long artistId;
    private Long artistGroupId;
    private Long albumArtist;
    private String artistName;
    private String artistGroupName;
}
