package org.albumshop.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QQuestionReply is a Querydsl query type for QuestionReply
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QQuestionReply extends EntityPathBase<QuestionReply> {

    private static final long serialVersionUID = -1851485299L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QQuestionReply questionReply = new QQuestionReply("questionReply");

    public final StringPath content = createString("content");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QQuestion question;

    public final DateTimePath<java.sql.Timestamp> regDate = createDateTime("regDate", java.sql.Timestamp.class);

    public final DateTimePath<java.sql.Timestamp> updateDate = createDateTime("updateDate", java.sql.Timestamp.class);

    public QQuestionReply(String variable) {
        this(QuestionReply.class, forVariable(variable), INITS);
    }

    public QQuestionReply(Path<? extends QuestionReply> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QQuestionReply(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QQuestionReply(PathMetadata metadata, PathInits inits) {
        this(QuestionReply.class, metadata, inits);
    }

    public QQuestionReply(Class<? extends QuestionReply> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.question = inits.isInitialized("question") ? new QQuestion(forProperty("question"), inits.get("question")) : null;
    }

}

