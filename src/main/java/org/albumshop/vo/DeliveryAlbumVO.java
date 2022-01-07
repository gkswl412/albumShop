package org.albumshop.vo;

import lombok.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryAlbumVO {
    private Long albumId;
    private String cover;
    private int price;
    private String title;
    private String artistName;
    private int orderAmount;
}
