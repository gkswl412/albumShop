package org.albumshop.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCartDetail is a Querydsl query type for CartDetail
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCartDetail extends EntityPathBase<CartDetail> {

    private static final long serialVersionUID = 1160563528L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCartDetail cartDetail = new QCartDetail("cartDetail");

    public final QMultiIdCartAlbum multiId;

    public final NumberPath<Integer> quantity = createNumber("quantity", Integer.class);

    public QCartDetail(String variable) {
        this(CartDetail.class, forVariable(variable), INITS);
    }

    public QCartDetail(Path<? extends CartDetail> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCartDetail(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCartDetail(PathMetadata metadata, PathInits inits) {
        this(CartDetail.class, metadata, inits);
    }

    public QCartDetail(Class<? extends CartDetail> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.multiId = inits.isInitialized("multiId") ? new QMultiIdCartAlbum(forProperty("multiId"), inits.get("multiId")) : null;
    }

}

