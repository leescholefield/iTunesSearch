package model.track;

/**
 * Represents a song
 */
public class Song extends Record {

    private boolean isStreamable;

    private String collectionArtistName;
    private long collectionArtistId;
    private String collectionArtistViewUrl;

    public boolean isStreamable() {
        return isStreamable;
    }

    public String getCollectionArtistName() {
        return collectionArtistName;
    }

    public long getCollectionArtistId() {
        return collectionArtistId;
    }

    public String getCollectionArtistViewUrl() {
        return collectionArtistViewUrl;
    }
}
