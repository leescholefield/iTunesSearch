package model.track;

import model.Item;

import java.math.BigDecimal;

/**
 * Created by lee on 06/05/17.
 */
public class Podcast extends Audio {
    // link to the RSS feed for the entire podcast
    private String feedUrl;

    private BigDecimal trackRentalPrice;
    private BigDecimal trackHdPrice;
    private BigDecimal trackHdRentalPrice;
    private BigDecimal collectionHdPrice;

    private int[] genreIds;
    private String[] genres;

    private String contentAdvisoryRating;

    @Override
    protected ItemType getType() {
        return ItemType.PODCAST;
    }

    public String getFeedUrl() {
        return feedUrl;
    }

    public BigDecimal getTrackRentalPrice() {
        return trackRentalPrice;
    }

    public BigDecimal getTrackHdPrice() {
        return trackHdPrice;
    }

    public BigDecimal getTrackHdRentalPrice() {
        return trackHdRentalPrice;
    }

    public BigDecimal getCollectionHdPrice() {
        return collectionHdPrice;
    }

    public int[] getGenreIds() {
        return genreIds;
    }

    public String[] getGenres() {
        return genres;
    }

    public String getContentAdvisoryRating() {
        return contentAdvisoryRating;
    }
}
