package org.albumshop.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMultiIdDeliveryAlbum is a Querydsl query type for MultiIdDeliveryAlbum
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QMultiIdDeliveryAlbum extends BeanPath<MultiIdDeliveryAlbum> {

    private static final long serialVersionUID = -447273474L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMultiIdDeliveryAlbum multiIdDeliveryAlbum = new QMultiIdDeliveryAlbum("multiIdDeliveryAlbum");

    public final QAlbum album;

    public final QDelivery delivery;

    public QMultiIdDeliveryAlbum(String variable) {
        this(MultiIdDeliveryAlbum.class, forVariable(variable), INITS);
    }

    public QMultiIdDeliveryAlbum(Path<? extends MultiIdDeliveryAlbum> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMultiIdDeliveryAlbum(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMultiIdDeliveryAlbum(PathMetadata metadata, PathInits inits) {
        this(MultiIdDeliveryAlbum.class, metadata, inits);
    }

    public QMultiIdDeliveryAlbum(Class<? extends MultiIdDeliveryAlbum> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.album = inits.isInitialized("album") ? new QAlbum(forProperty("album")) : null;
        this.delivery = inits.isInitialized("delivery") ? new QDelivery(forProperty("delivery"), inits.get("delivery")) : null;
    }

}

