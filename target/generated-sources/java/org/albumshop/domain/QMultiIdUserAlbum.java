package org.albumshop.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMultiIdUserAlbum is a Querydsl query type for MultiIdUserAlbum
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QMultiIdUserAlbum extends BeanPath<MultiIdUserAlbum> {

    private static final long serialVersionUID = -1371951609L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMultiIdUserAlbum multiIdUserAlbum = new QMultiIdUserAlbum("multiIdUserAlbum");

    public final QAlbum album;

    public final QUser user;

    public QMultiIdUserAlbum(String variable) {
        this(MultiIdUserAlbum.class, forVariable(variable), INITS);
    }

    public QMultiIdUserAlbum(Path<? extends MultiIdUserAlbum> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMultiIdUserAlbum(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMultiIdUserAlbum(PathMetadata metadata, PathInits inits) {
        this(MultiIdUserAlbum.class, metadata, inits);
    }

    public QMultiIdUserAlbum(Class<? extends MultiIdUserAlbum> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.album = inits.isInitialized("album") ? new QAlbum(forProperty("album")) : null;
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user")) : null;
    }

}

