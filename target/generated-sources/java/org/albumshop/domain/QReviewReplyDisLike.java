package org.albumshop.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QReviewReplyDisLike is a Querydsl query type for ReviewReplyDisLike
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QReviewReplyDisLike extends EntityPathBase<ReviewReplyDisLike> {

    private static final long serialVersionUID = -2138800342L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QReviewReplyDisLike reviewReplyDisLike = new QReviewReplyDisLike("reviewReplyDisLike");

    public final QMultiIdUserReviewReply multiId;

    public QReviewReplyDisLike(String variable) {
        this(ReviewReplyDisLike.class, forVariable(variable), INITS);
    }

    public QReviewReplyDisLike(Path<? extends ReviewReplyDisLike> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QReviewReplyDisLike(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QReviewReplyDisLike(PathMetadata metadata, PathInits inits) {
        this(ReviewReplyDisLike.class, metadata, inits);
    }

    public QReviewReplyDisLike(Class<? extends ReviewReplyDisLike> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.multiId = inits.isInitialized("multiId") ? new QMultiIdUserReviewReply(forProperty("multiId"), inits.get("multiId")) : null;
    }

}

