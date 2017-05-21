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

    private String artworkUrl30;
    private String artworkUrl60;
    private String artworkUrl100;

    private int trackCount;

    private boolean collectionExplicitness;

    private String primaryGenreName;
    private String copyright;
    private String country;

    @Override
    public ItemType getType() {
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

    public String getArtworkUrl30() {return artworkUrl30; }

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

    @Override
    public String toString() {
        return collectionName + " by " + artistName;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Audiobook))
            return false;

        Audiobook other = (Audiobook)o;

        return other.artistName.equals(artistName)
                && other.collectionName.equals(collectionName)
                && other.artistViewUrl.equals(artistViewUrl)
                && other.collectionViewUrl.equals(collectionViewUrl)
                && other.collectionCensoredName.equals(collectionCensoredName)
                && other.previewUrl.equals(previewUrl)
                && other.collectionId == collectionId
                && other.artistId == artistId
                && other.amgArtistId == amgArtistId
                && other.currency.equals(currency)
                && other.collectionPrice.equals(collectionPrice)
                && other.releaseDate.equals(releaseDate)
                && other.artworkUrl60.equals(artworkUrl60)
                && other.artworkUrl30.equals(artworkUrl30)
                && other.artworkUrl100.equals(artworkUrl100)
                && other.trackCount == trackCount
                && other.collectionExplicitness == collectionExplicitness
                && other.primaryGenreName.equals(primaryGenreName)
                && other.copyright.equals(copyright)
                && other.country.equals(country);
    }
}
