package model.track;

import model.Item;

import java.math.BigDecimal;

/**
 *
 */
public class FeatureMovie extends Track {

    private String contentAdvisoryRating;
    private long trackTimeMillis;
    private String previewUrl;

    private BigDecimal trackHdRentalPrice;
    private BigDecimal trackHdPrice;
    private BigDecimal trackRentalPrice;
    private BigDecimal collectionHdPrice;

    private String shortDescription;
    private String longDescription;
    private boolean hasITunesExtras;

    @Override
    public ItemType getType() {
        return ItemType.FEATURE_MOVIE;
    }

    public String getContentAdvisoryRating() {
        return contentAdvisoryRating;
    }

    public long getTrackTimeMillis() {
        return trackTimeMillis;
    }

    public String getPreviewUrl() {
        return previewUrl;
    }

    public BigDecimal getTrackHdRentalPrice() {
        return trackHdRentalPrice;
    }

    public BigDecimal getTrackHdPrice() {
        return trackHdPrice;
    }

    public BigDecimal getTrackRentalPrice() {
        return trackRentalPrice;
    }

    public BigDecimal getCollectionHdPrice() {
        return collectionHdPrice;
    }

    /**
     * Returns the shortDescription if it has one, returns the longDescription if not. If it has neither it will return
     * null.
     */
    public String getDescription() {
        if (shortDescription == null || shortDescription.equals("")){
            return longDescription;
        }

        return  shortDescription;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public boolean isHasITunesExtras() {
        return hasITunesExtras;
    }
}
