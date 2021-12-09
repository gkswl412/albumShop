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

    @NotNull
    private int quantity;
}
