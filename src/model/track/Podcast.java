package model.track;

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
}
