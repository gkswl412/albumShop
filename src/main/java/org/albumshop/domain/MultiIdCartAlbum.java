package org.albumshop.domain;

import lombok.*;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class MultiIdCartAlbum implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @ManyToOne
    private Cart cart;

    @ManyToOne
    private Album album;
}
