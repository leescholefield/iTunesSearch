package model.track;

/**
 *
 */
class Audio extends Track {
    private long artistId;
    private long collectionId;

    private String collectionCensoredName;
    private String collectionName;

    private String artistViewUrl;
    private String collectionViewUrl;

    private int trackCount;


    public long getArtistId() {
        return artistId;
    }

    public long getCollectionId() {
        return collectionId;
    }

    public String getCollectionCensoredName() {
        return collectionCensoredName;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public String getArtistViewUrl() {
        return artistViewUrl;
    }

    public String getCollectionViewUrl() {
        return collectionViewUrl;
    }

    public int getTrackCount() {
        return trackCount;
    }
}
