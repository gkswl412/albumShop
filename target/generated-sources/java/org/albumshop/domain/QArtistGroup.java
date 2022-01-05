package org.albumshop.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QArtistGroup is a Querydsl query type for ArtistGroup
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QArtistGroup extends EntityPathBase<ArtistGroup> {

    private static final long serialVersionUID = -288690527L;

    public static final QArtistGroup artistGroup = new QArtistGroup("artistGroup");

    public final ListPath<AlbumArtist, QAlbumArtist> albumartist = this.<AlbumArtist, QAlbumArtist>createList("albumartist", AlbumArtist.class, QAlbumArtist.class, PathInits.DIRECT2);

    public final ListPath<Artist, QArtist> artist = this.<Artist, QArtist>createList("artist", Artist.class, QArtist.class, PathInits.DIRECT2);

    public final DatePath<java.time.LocalDate> debutDate = createDate("debutDate", java.time.LocalDate.class);

    public final NumberPath<Long> Id = createNumber("Id", Long.class);

    public final StringPath name = createString("name");

    public final StringPath photo = createString("photo");

    public QArtistGroup(String variable) {
        super(ArtistGroup.class, forVariable(variable));
    }

    public QArtistGroup(Path<? extends ArtistGroup> path) {
        super(path.getType(), path.getMetadata());
    }

    public QArtistGroup(PathMetadata metadata) {
        super(ArtistGroup.class, metadata);
    }

}

