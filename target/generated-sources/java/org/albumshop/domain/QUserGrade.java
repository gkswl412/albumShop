package org.albumshop.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QUserGrade is a Querydsl query type for UserGrade
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUserGrade extends EntityPathBase<UserGrade> {

    private static final long serialVersionUID = -1634036683L;

    public static final QUserGrade userGrade = new QUserGrade("userGrade");

    public final StringPath grade = createString("grade");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Integer> number = createNumber("number", Integer.class);

    public QUserGrade(String variable) {
        super(UserGrade.class, forVariable(variable));
    }

    public QUserGrade(Path<? extends UserGrade> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUserGrade(PathMetadata metadata) {
        super(UserGrade.class, metadata);
    }

}

