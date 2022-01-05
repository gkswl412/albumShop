package org.albumshop.security.oauth;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QUserDTO is a Querydsl query type for UserDTO
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUserDTO extends EntityPathBase<UserDTO> {

    private static final long serialVersionUID = 396356450L;

    public static final QUserDTO userDTO = new QUserDTO("userDTO");

    public final StringPath email = createString("email");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final StringPath picture = createString("picture");

    public final EnumPath<UserRole> role = createEnum("role", UserRole.class);

    public QUserDTO(String variable) {
        super(UserDTO.class, forVariable(variable));
    }

    public QUserDTO(Path<? extends UserDTO> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUserDTO(PathMetadata metadata) {
        super(UserDTO.class, metadata);
    }

}

