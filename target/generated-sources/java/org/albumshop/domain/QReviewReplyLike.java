package org.albumshop.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QReviewReplyLike is a Querydsl query type for ReviewReplyLike
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QReviewReplyLike extends EntityPathBase<ReviewReplyLike> {

    private static final long serialVersionUID = -270584878L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QReviewReplyLike reviewReplyLike = new QReviewReplyLike("reviewReplyLike");

    public final QMultiIdUserReviewReply multiId;

    public QReviewReplyLike(String variable) {
        this(ReviewReplyLike.class, forVariable(variable), INITS);
    }

    public QReviewReplyLike(Path<? extends ReviewReplyLike> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QReviewReplyLike(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QReviewReplyLike(PathMetadata metadata, PathInits inits) {
        this(ReviewReplyLike.class, metadata, inits);
    }

    public QReviewReplyLike(Class<? extends ReviewReplyLike> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.multiId = inits.isInitialized("multiId") ? new QMultiIdUserReviewReply(forProperty("multiId"), inits.get("multiId")) : null;
    }

}

