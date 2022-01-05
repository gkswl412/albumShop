package org.albumshop.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAlbumArtist is a Querydsl query type for AlbumArtist
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAlbumArtist extends EntityPathBase<AlbumArtist> {

    private static final long serialVersionUID = 348310975L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAlbumArtist albumArtist = new QAlbumArtist("albumArtist");

    public final QAlbum album;

    public final QArtist artist;

    public final QArtistGroup artistGroup;

    public final NumberPath<Long> Id = createNumber("Id", Long.class);

    public QAlbumArtist(String variable) {
        this(AlbumArtist.class, forVariable(variable), INITS);
    }

    public QAlbumArtist(Path<? extends AlbumArtist> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QAlbumArtist(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QAlbumArtist(PathMetadata metadata, PathInits inits) {
        this(AlbumArtist.class, metadata, inits);
    }

    public QAlbumArtist(Class<? extends AlbumArtist> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.album = inits.isInitialized("album") ? new QAlbum(forProperty("album")) : null;
        this.artist = inits.isInitialized("artist") ? new QArtist(forProperty("artist"), inits.get("artist")) : null;
        this.artistGroup = inits.isInitialized("artistGroup") ? new QArtistGroup(forProperty("artistGroup")) : null;
    }

}

