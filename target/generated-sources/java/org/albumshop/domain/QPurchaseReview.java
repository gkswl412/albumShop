package org.albumshop.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPurchaseReview is a Querydsl query type for PurchaseReview
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPurchaseReview extends EntityPathBase<PurchaseReview> {

    private static final long serialVersionUID = -2069572624L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPurchaseReview purchaseReview = new QPurchaseReview("purchaseReview");

    public final StringPath content = createString("content");

    public final QDelivery delivery;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DateTimePath<java.sql.Timestamp> regDate = createDateTime("regDate", java.sql.Timestamp.class);

    public final StringPath title = createString("title");

    public final DateTimePath<java.sql.Timestamp> updateDate = createDateTime("updateDate", java.sql.Timestamp.class);

    public QPurchaseReview(String variable) {
        this(PurchaseReview.class, forVariable(variable), INITS);
    }

    public QPurchaseReview(Path<? extends PurchaseReview> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPurchaseReview(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPurchaseReview(PathMetadata metadata, PathInits inits) {
        this(PurchaseReview.class, metadata, inits);
    }

    public QPurchaseReview(Class<? extends PurchaseReview> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.delivery = inits.isInitialized("delivery") ? new QDelivery(forProperty("delivery"), inits.get("delivery")) : null;
    }

}

