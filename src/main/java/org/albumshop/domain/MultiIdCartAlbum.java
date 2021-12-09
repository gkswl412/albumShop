package org.albumshop.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Getter
@Setter
@ToString
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
