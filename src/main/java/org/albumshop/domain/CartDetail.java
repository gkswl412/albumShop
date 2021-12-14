package org.albumshop.domain;

import lombok.*;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
@Entity
@Table(name="cartDetail")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CartDetail {
    @EmbeddedId
    MultiIdCartAlbum multiId;

    private int quantity;

    public static CartDetail createCartDetail(Cart cart, Album album, int amount) {
        MultiIdCartAlbum multiId = MultiIdCartAlbum.builder()
                .cart(cart).album(album)
                .build();

        CartDetail cartDetail = CartDetail.builder()
                .multiId(multiId).quantity(amount)
                .build();

        return cartDetail;
    }

    public void addQuantity(int amount) {
        this.quantity += amount;
    }
}
