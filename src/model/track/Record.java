package model.track;

/**
 *
 */
abstract class Record extends Audio {

    private String previewUrl;

    // depend on being part of a collection.
    private int discCount;
    private int discNumber;
    private int trackNumber;

    private long trackTimeMillis;

    public String getPreviewUrl() {
        return previewUrl;
    }

    public int getDiscCount() {
        return discCount;
    }

    public int getDiscNumber() {
        return discNumber;
    }

    public int getTrackNumber() {
        return trackNumber;
    }

    public long getTrackTimeInMillis() {
        return trackTimeMillis;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this){
            return true;
        }
        if (!(o instanceof Record))
            return false;

        Record other = (Record)o;

        return super.equals(o) && other.previewUrl.equals(previewUrl)
                && other.discCount == discCount
                && other.discNumber == discNumber
                && other.trackNumber == trackNumber
                && other.trackTimeMillis == trackTimeMillis;
    }
}
