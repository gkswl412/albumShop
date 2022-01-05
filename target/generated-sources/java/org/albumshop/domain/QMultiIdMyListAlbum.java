package org.albumshop.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMultiIdMyListAlbum is a Querydsl query type for MultiIdMyListAlbum
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QMultiIdMyListAlbum extends BeanPath<MultiIdMyListAlbum> {

    private static final long serialVersionUID = 1481182216L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMultiIdMyListAlbum multiIdMyListAlbum = new QMultiIdMyListAlbum("multiIdMyListAlbum");

    public final QAlbum album;

    public final QMyList myList;

    public QMultiIdMyListAlbum(String variable) {
        this(MultiIdMyListAlbum.class, forVariable(variable), INITS);
    }

    public QMultiIdMyListAlbum(Path<? extends MultiIdMyListAlbum> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMultiIdMyListAlbum(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMultiIdMyListAlbum(PathMetadata metadata, PathInits inits) {
        this(MultiIdMyListAlbum.class, metadata, inits);
    }

    public QMultiIdMyListAlbum(Class<? extends MultiIdMyListAlbum> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.album = inits.isInitialized("album") ? new QAlbum(forProperty("album")) : null;
        this.myList = inits.isInitialized("myList") ? new QMyList(forProperty("myList"), inits.get("myList")) : null;
    }

}

