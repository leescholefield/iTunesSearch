package model.track;

/**
 *
 */
abstract class Audio extends Track {
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

    @Override
    public boolean equals(Object o) {
        if(o == this)
          return true;

        if (!(o instanceof Audio)){
            return false;
        }

        Audio other = (Audio)o;

        return super.equals(o) && other.collectionId == collectionId
                && other.artistId == artistId
                && other.collectionCensoredName.equals(collectionCensoredName)
                && other.collectionName.equals(collectionName)
                && other.artistViewUrl.equals(artistViewUrl)
                && other.collectionViewUrl.equals(collectionViewUrl)
                && other.trackCount == trackCount;
    }
}
