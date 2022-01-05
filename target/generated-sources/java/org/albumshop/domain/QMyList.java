package org.albumshop.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMyList is a Querydsl query type for MyList
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMyList extends EntityPathBase<MyList> {

    private static final long serialVersionUID = -27651167L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMyList myList = new QMyList("myList");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath myListTitle = createString("myListTitle");

    public final QUser user;

    public QMyList(String variable) {
        this(MyList.class, forVariable(variable), INITS);
    }

    public QMyList(Path<? extends MyList> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMyList(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMyList(PathMetadata metadata, PathInits inits) {
        this(MyList.class, metadata, inits);
    }

    public QMyList(Class<? extends MyList> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user")) : null;
    }

}

