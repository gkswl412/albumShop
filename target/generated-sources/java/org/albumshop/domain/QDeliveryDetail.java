package org.albumshop.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QDeliveryDetail is a Querydsl query type for DeliveryDetail
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QDeliveryDetail extends EntityPathBase<DeliveryDetail> {

    private static final long serialVersionUID = -1534211684L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QDeliveryDetail deliveryDetail = new QDeliveryDetail("deliveryDetail");

    public final QMultiIdDeliveryAlbum multiId;

    public final NumberPath<Integer> orderAmount = createNumber("orderAmount", Integer.class);

    public QDeliveryDetail(String variable) {
        this(DeliveryDetail.class, forVariable(variable), INITS);
    }

    public QDeliveryDetail(Path<? extends DeliveryDetail> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QDeliveryDetail(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QDeliveryDetail(PathMetadata metadata, PathInits inits) {
        this(DeliveryDetail.class, metadata, inits);
    }

    public QDeliveryDetail(Class<? extends DeliveryDetail> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.multiId = inits.isInitialized("multiId") ? new QMultiIdDeliveryAlbum(forProperty("multiId"), inits.get("multiId")) : null;
    }

}

