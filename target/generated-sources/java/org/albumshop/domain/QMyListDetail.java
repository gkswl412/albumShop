package org.albumshop.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMyListDetail is a Querydsl query type for MyListDetail
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMyListDetail extends EntityPathBase<MyListDetail> {

    private static final long serialVersionUID = 668605266L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMyListDetail myListDetail = new QMyListDetail("myListDetail");

    public final QMultiIdMyListAlbum multiId;

    public QMyListDetail(String variable) {
        this(MyListDetail.class, forVariable(variable), INITS);
    }

    public QMyListDetail(Path<? extends MyListDetail> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMyListDetail(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMyListDetail(PathMetadata metadata, PathInits inits) {
        this(MyListDetail.class, metadata, inits);
    }

    public QMyListDetail(Class<? extends MyListDetail> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.multiId = inits.isInitialized("multiId") ? new QMultiIdMyListAlbum(forProperty("multiId"), inits.get("multiId")) : null;
    }

}

