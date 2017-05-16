package model.collection;

import model.Item;

import java.math.BigDecimal;

/**
 *
 */
public class Album extends Item{
    private String collectionType;

    private long collectionId;
    private long artistId;
    private long amgArtistId;

    private String artistViewUrl;
    private String collectionViewUrl;

    private String collectionName;
    private String collectionCensoredName;
    private String artistName;

    private int trackCount;
    private BigDecimal collectionPrice;
    private String primaryGenreName;
    private boolean collectionExplicitness;

    private String releaseDate;
    private String copyright;
    private String country;
    private String currency;

    private String artworkUrl30;
    private String artworkUrl60;
    private String artworkUrl100;

    public String getCollectionType() {
        return collectionType;
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

    public String getArtistViewUrl() {
        return artistViewUrl;
    }

    public String getCollectionViewUrl() {
        return collectionViewUrl;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public String getCollectionCensoredName() {
        return collectionCensoredName;
    }

    public String getArtistName() {
        return artistName;
    }

    public int getTrackCount() {
        return trackCount;
    }

    public BigDecimal getCollectionPrice() {
        return collectionPrice;
    }

    public String getPrimaryGenreName() {
        return primaryGenreName;
    }

    public boolean isCollectionExplicitness() {
        return collectionExplicitness;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getCopyright() {
        return copyright;
    }

    public String getCountry() {
        return country;
    }

    public String getCurrency() {
        return currency;
    }

    public String getArtworkUrl30() {
        return artworkUrl30;
    }

    public String getArtworkUrl60() {
        return artworkUrl60;
    }

    public String getArtworkUrl100() {
        return artworkUrl100;
    }

    @Override
    public ItemType getType() {
        return ItemType.ALBUM;
    }

    @Override
    public String toString() {
        return collectionName + " by " + artistName;
    }
}
