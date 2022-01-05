package org.albumshop.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMultiIdUserReviewReply is a Querydsl query type for MultiIdUserReviewReply
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QMultiIdUserReviewReply extends BeanPath<MultiIdUserReviewReply> {

    private static final long serialVersionUID = 1653940234L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMultiIdUserReviewReply multiIdUserReviewReply = new QMultiIdUserReviewReply("multiIdUserReviewReply");

    public final QReviewReply reviewReply;

    public final QUser user;

    public QMultiIdUserReviewReply(String variable) {
        this(MultiIdUserReviewReply.class, forVariable(variable), INITS);
    }

    public QMultiIdUserReviewReply(Path<? extends MultiIdUserReviewReply> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMultiIdUserReviewReply(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMultiIdUserReviewReply(PathMetadata metadata, PathInits inits) {
        this(MultiIdUserReviewReply.class, metadata, inits);
    }

    public QMultiIdUserReviewReply(Class<? extends MultiIdUserReviewReply> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.reviewReply = inits.isInitialized("reviewReply") ? new QReviewReply(forProperty("reviewReply"), inits.get("reviewReply")) : null;
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user")) : null;
    }

}

