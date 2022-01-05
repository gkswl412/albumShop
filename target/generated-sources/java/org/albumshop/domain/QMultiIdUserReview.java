package org.albumshop.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMultiIdUserReview is a Querydsl query type for MultiIdUserReview
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QMultiIdUserReview extends BeanPath<MultiIdUserReview> {

    private static final long serialVersionUID = 899988160L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMultiIdUserReview multiIdUserReview = new QMultiIdUserReview("multiIdUserReview");

    public final QReview review;

    public final QUser user;

    public QMultiIdUserReview(String variable) {
        this(MultiIdUserReview.class, forVariable(variable), INITS);
    }

    public QMultiIdUserReview(Path<? extends MultiIdUserReview> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMultiIdUserReview(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMultiIdUserReview(PathMetadata metadata, PathInits inits) {
        this(MultiIdUserReview.class, metadata, inits);
    }

    public QMultiIdUserReview(Class<? extends MultiIdUserReview> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.review = inits.isInitialized("review") ? new QReview(forProperty("review"), inits.get("review")) : null;
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user")) : null;
    }

}

