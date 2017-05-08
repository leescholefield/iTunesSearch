package model.audiobook;

import java.math.BigDecimal;

/**
 *
 */
public class Audiobook {

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
}
