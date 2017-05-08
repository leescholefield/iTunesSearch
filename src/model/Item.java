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
        AUDIOBOOK
    }

    public abstract ItemType getType();


}
