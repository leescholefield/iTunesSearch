package model;


/**
 * Base class for a deserialized result.
 */
public abstract class Item {

    public enum ItemType{
        SONG,
        MUSIC_VIDEO,
        PODCAST,
        FEATURE_MOVIE,
        ARTIST,
        AUDIOBOOK,
        ALBUM
    }

    public abstract ItemType getType();


}
