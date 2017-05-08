package model.artist;

import model.Item;

/**
 * Represents an Artist.
 */
public class Artist extends Item {

    private String artistLinkUrl;
    private String artistName;
    private String artistType;

    private long artistId;
    private long amgArtistId;

    private String primaryGenreName;
    private long primaryGenreId;

    @Override
    protected ItemType getType() {
        return ItemType.ARTIST;
    }

    public String getArtistLinkUrl() {
        return artistLinkUrl;
    }

    public String getArtistName() {
        return artistName;
    }

    public String getArtistType() {
        return artistType;
    }

    public long getArtistId() {
        return artistId;
    }

    public String getPrimaryGenreName() {
        return primaryGenreName;
    }

    public long getPrimaryGenreId() {
        return primaryGenreId;
    }

    public long getAmgArtistId() {
        return amgArtistId;
    }
}
