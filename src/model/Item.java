package model;


/**
 * Base class for a deserialized result.
 */
public abstract class Item {

    protected enum ItemType{
        SONG,
        MUSIC_VIDEO,
        PODCAST,
        FEATURE_MOVIE,
        ARTIST,
        AUDIOBOOK
    }

    protected abstract ItemType getType();


}
