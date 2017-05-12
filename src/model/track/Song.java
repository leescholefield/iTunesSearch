package model.track;

import model.Item;

/**
 * Represents a song
 */
public class Song extends Record {

    private boolean isStreamable;

    private String collectionArtistName;
    private long collectionArtistId;
    private String collectionArtistViewUrl;

    @Override
    public ItemType getType() {
        return ItemType.SONG;
    }

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

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if(!(o instanceof Song))
            return false;

        Song other = (Song)o;

        return super.equals(o) && other.isStreamable == isStreamable
                && (other.collectionArtistName == null || other.collectionArtistName.equals(collectionArtistName))
                && other.collectionArtistId == collectionArtistId
                && (other.collectionArtistName == null || other.collectionArtistViewUrl.equals(collectionArtistViewUrl));
    }
}
