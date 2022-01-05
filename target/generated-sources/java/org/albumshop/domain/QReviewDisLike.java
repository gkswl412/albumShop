package org.albumshop.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QReviewDisLike is a Querydsl query type for ReviewDisLike
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QReviewDisLike extends EntityPathBase<ReviewDisLike> {

    private static final long serialVersionUID = 1916668854L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QReviewDisLike reviewDisLike = new QReviewDisLike("reviewDisLike");

    public final QMultiIdUserReview multiId;

    public QReviewDisLike(String variable) {
        this(ReviewDisLike.class, forVariable(variable), INITS);
    }

    public QReviewDisLike(Path<? extends ReviewDisLike> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QReviewDisLike(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QReviewDisLike(PathMetadata metadata, PathInits inits) {
        this(ReviewDisLike.class, metadata, inits);
    }

    public QReviewDisLike(Class<? extends ReviewDisLike> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.multiId = inits.isInitialized("multiId") ? new QMultiIdUserReview(forProperty("multiId"), inits.get("multiId")) : null;
    }

}

