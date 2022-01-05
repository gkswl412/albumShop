package org.albumshop.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = 2073945282L;

    public static final QUser user = new QUser("user");

    public final StringPath address = createString("address");

    public final DatePath<java.time.LocalDate> birth = createDate("birth", java.time.LocalDate.class);

    public final StringPath email = createString("email");

    public final StringPath gender = createString("gender");

    public final StringPath grade = createString("grade");

    public final StringPath id = createString("id");

    public final ListPath<MyList, QMyList> mylists = this.<MyList, QMyList>createList("mylists", MyList.class, QMyList.class, PathInits.DIRECT2);

    public final StringPath name = createString("name");

    public final StringPath nickName = createString("nickName");

    public final StringPath pass = createString("pass");

    public final StringPath phone = createString("phone");

    public final StringPath photo = createString("photo");

    public final NumberPath<Integer> score = createNumber("score", Integer.class);

    public final EnumPath<org.albumshop.security.UserRole> urole = createEnum("urole", org.albumshop.security.UserRole.class);

    public QUser(String variable) {
        super(User.class, forVariable(variable));
    }

    public QUser(Path<? extends User> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUser(PathMetadata metadata) {
        super(User.class, metadata);
    }

}

