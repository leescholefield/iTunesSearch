package model.audiobook;

import model.Item;

import java.math.BigDecimal;

/**
 *
 */
public class Audiobook extends Item {

    private String artistName;
    private String collectionName;
    private String artistViewUrl;
    private String collectionViewUrl;
    private String collectionCensoredName;
    private String previewUrl;

    private long collectionId;
    private long artistId;
    private long amgArtistId;

    private String currency;
    private BigDecimal collectionPrice;


    private String releaseDate;


    private String artworkUrl60;
    private String artworkUrl100;

    private int trackCount;

    private boolean collectionExplicitness;

    private String primaryGenreName;
    private String copyright;
    private String country;

    @Override
    protected ItemType getType() {
        return ItemType.AUDIOBOOK;
    }

    public String getArtistName() {
        return artistName;
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

    public String getCollectionCensoredName() {
        return collectionCensoredName;
    }

    public String getPreviewUrl() {
        return previewUrl;
    }

    public long getCollectionId() {
        return collectionId;
    }

    public long getArtistId() {
        return artistId;
    }

    public long getAmgArtistId() {
        return amgArtistId;
    }

    public String getCurrency() {
        return currency;
    }

    public BigDecimal getCollectionPrice() {
        return collectionPrice;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getArtworkUrl60() {
        return artworkUrl60;
    }

    public String getArtworkUrl100() {
        return artworkUrl100;
    }

    public int getTrackCount() {
        return trackCount;
    }

    public boolean isCollectionExplicitness() {
        return collectionExplicitness;
    }

    public String getPrimaryGenreName() {
        return primaryGenreName;
    }

    public String getCopyright() {
        return copyright;
    }

    public String getCountry() {
        return country;
    }
}
