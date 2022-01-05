package org.albumshop.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMultiIdCartAlbum is a Querydsl query type for MultiIdCartAlbum
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QMultiIdCartAlbum extends BeanPath<MultiIdCartAlbum> {

    private static final long serialVersionUID = -1498453038L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMultiIdCartAlbum multiIdCartAlbum = new QMultiIdCartAlbum("multiIdCartAlbum");

    public final QAlbum album;

    public final QCart cart;

    public QMultiIdCartAlbum(String variable) {
        this(MultiIdCartAlbum.class, forVariable(variable), INITS);
    }

    public QMultiIdCartAlbum(Path<? extends MultiIdCartAlbum> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMultiIdCartAlbum(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMultiIdCartAlbum(PathMetadata metadata, PathInits inits) {
        this(MultiIdCartAlbum.class, metadata, inits);
    }

    public QMultiIdCartAlbum(Class<? extends MultiIdCartAlbum> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.album = inits.isInitialized("album") ? new QAlbum(forProperty("album")) : null;
        this.cart = inits.isInitialized("cart") ? new QCart(forProperty("cart"), inits.get("cart")) : null;
    }

}

