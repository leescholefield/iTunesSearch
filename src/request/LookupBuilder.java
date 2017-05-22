package request;

import java.util.HashMap;
import java.util.Map;

/**
 * Utility class for constructing a new {@link Request} class.
 * <p>
 *
 * You can also return a list of songs, albums, etc by combining an artist Id with a {@code entity} value. For example:
 * <pre>
 *     {@code
 *     Request request = new LookupBuilder(LookupBuilder.IdTypes.ITUNES, id).entity("song").limit(10).newRequest();
 *     Response response = request.sendRequest();
 *
 *     ResultList<Item> results = new Parser().parse(response);
 *     }
 * </pre>
 * This will return a list of the 10 most popular songs by the artist matching the given ID. It will also contain an item
 * for the Artist themselves. If you supple multiple IDs and an entity, it will return a list of songs of the specified
 * limit (or 50 by default) for each artist Id given, along with an Item for each Artist.
 * <pre>
 *     {@code
 *     Request request = new LookupRequest(LookupBuilder.IdTypes.ITUNES, firstId, secondId)
 *                              .entity("song").limit(10).newRequest()
 *     }
 * </pre>
 * <p>
 *
 * Please note, Apple provides very little documentation for generating lookup requests, so the information provided here
 * is what I've been able to gather by experimenting with writing requests.
 * <p>
 * See <a href="https://affiliate.itunes.apple.com/resources/documentation/itunes-store-web-service-search-api/">Apple
 * documentation </a> for more information.
 */
public final class LookupBuilder {

    public enum IdTypes{
        ITUNES,
        AMG_ARTIST,
        AMG_ALBUM,
        AMG_VIDEO,
        UPC,
        ISBN;

        private String key;

        static {
            ITUNES.key = KeyVals.LookupKeys.ITUNES_ID;
            AMG_ARTIST.key = KeyVals.LookupKeys.AMG_ARTIST_ID;
            AMG_ALBUM.key = KeyVals.LookupKeys.AMG_ALBUM_ID;
            AMG_VIDEO.key = KeyVals.LookupKeys.AMG_VIDEO_ID;
            UPC.key = KeyVals.LookupKeys.UPC;
            ISBN.key = KeyVals.LookupKeys.ISBN;
        }

        /**
         * Private method used by the constructor to convert an IdType to a String key to save in the paramMap.
         */
        private String getKey() {
            return key;
        }

    }

    private Map<String, String> paramMap = new HashMap<>();

    /**
     * @param idType {@link IdTypes} id.
     * @param id ids to assign to the id type
     */
    public LookupBuilder(IdTypes idType, long... id){
        paramMap.put(idType.getKey(), convertNumberArrayToString(id));
    }

    /**
     * Creates a new {@link Request} instance.
     */
    public RequestImpl newRequest(){
        return new RequestImpl(paramMap, Request.LOOKUP_URL_BASE);
    }

    /**
     * Sets the itunesId. Note, there is no separate id category for artist, albums, etc. This method should be used to
     * set any itunesId ('collectionId', 'artistId', 'trackId').
     */
    public LookupBuilder itunesId(long ... ids){
        paramMap.put(KeyVals.LookupKeys.ITUNES_ID, convertNumberArrayToString(ids));
        return this;
    }

    /**
     * Sets the AMG (All Music Group) artist id.
     */
    public LookupBuilder amgArtistId(long ... ids){
        paramMap.put(KeyVals.LookupKeys.AMG_ARTIST_ID, convertNumberArrayToString(ids));
        return this;
    }

    /**
     * Sets the AMG (All Music Group) album id.
     */
    public LookupBuilder amgAlbumId(long ... ids){
        paramMap.put(KeyVals.LookupKeys.AMG_ALBUM_ID, convertNumberArrayToString(ids));
        return this;
    }

    /**
     * Sets the AMG (All Music Group) video id.
     */
    public LookupBuilder amgVideoId(long ... ids){
        paramMap.put(KeyVals.LookupKeys.AMG_VIDEO_ID, convertNumberArrayToString(ids));
        return this;
    }

    /**
     * Sets the Universal Product Code id.
     */
    public LookupBuilder upc(long ... ids){
        paramMap.put(KeyVals.LookupKeys.UPC, convertNumberArrayToString(ids));
        return this;
    }

    /**
     * Sets the ISBN id.
     *
     * See <a href="https://en.wikipedia.org/wiki/International_Standard_Book_Number">Wikipedia entry for ISBN</a>
     */
    public LookupBuilder isbn(long ... ids){
        paramMap.put(KeyVals.LookupKeys.ISBN, convertNumberArrayToString(ids));
        return this;
    }

    /**
     * Sets the number of results to return. The maximum is 200.
     */
    public LookupBuilder limit(int limit){
        paramMap.put(KeyVals.LookupKeys.LIMIT, String.valueOf(limit));
        return this;
    }

    /**
     * Sets the entity associated with the media type.
     * <p>
     * See <a href="https://affiliate.itunes.apple.com/resources/documentation/itunes-store-web-service-search-api/">
     * Itunes Search API</a> for a list of valid values.
     */
    public LookupBuilder entity(String entity){
        this.paramMap.put(KeyVals.LookupKeys.ENTITY, entity);
        return this;
    }

    /**
     * Converts the given array to a String with a comma separating each value.
     */
    private String convertNumberArrayToString(long[] array){
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < array.length; i++){
            builder.append(String.valueOf(array[i]));
            // append a comma to all but last item
            if (i != array.length-1){
                builder.append(",");
            }
        }

        return builder.toString();
    }

}
