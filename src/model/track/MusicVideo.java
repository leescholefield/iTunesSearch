package model.track;

import model.Item;

/**
 * Represents a Music Video
 */
public class MusicVideo extends Record {

    private String contentAdvisoryRating;

    @Override
    public ItemType getType() {
        return ItemType.MUSIC_VIDEO;
    }

    public String getContentAdvisoryRating() {
        return contentAdvisoryRating;
    }
}
