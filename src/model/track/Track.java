package model.track;

import model.Item;

import java.math.BigDecimal;

/**
 * Base class containing all attributes shared by 'Track' subclasses
 */
public class Track extends Item {

    private String artistName;
    private String trackName;
    private String trackCensoredName;
    private String primaryGenreName;

    private String trackViewUrl;
    private long trackId;

    private boolean trackExplicitness;
    private boolean collectionExplicitness;

    private String artworkUrl30;
    private String artworkUrl60;
    private String artworkUrl100;

    private String releaseDate;

    private String currency;
    private BigDecimal trackPrice;
    private BigDecimal collectionPrice;
    private String country;

    @Override
    public String toString(){
        return trackName + " by " + artistName;
    }

    /*
       Getters
     */

    public String getArtistName() {
        return artistName;
    }

    public String getTrackName() {
        return trackName;
    }

    public String getTrackCensoredName() {
        return trackCensoredName;
    }

    public String getPrimaryGenreName() {
        return primaryGenreName;
    }

    public String getTrackViewUrl() {
        return trackViewUrl;
    }

    public long getTrackId() {
        return trackId;
    }

    public boolean isTrackExplicitness() {
        return trackExplicitness;
    }

    public boolean isCollectionExplicitness() {
        return collectionExplicitness;
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

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getCurrency() {
        return currency;
    }

    public BigDecimal getTrackPrice() {
        return trackPrice;
    }

    public BigDecimal getCollectionPrice() {
        return collectionPrice;
    }

    public String getCountry() {
        return country;
    }
}
