package request;

import java.util.HashMap;
import java.util.Map;

/**
 * Utility class for constructing a new {@link Request} class.
 * <p>
 * A valid Request only requires a single id number and its associated id type. However, you can supply multiple ids
 * for each valid IdType. See ({@link LookupBuilder.IdTypes} for a list of valid types.
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
     * Private constructor to avoid instantiation.
     *
     * @param idType {@link IdTypes} id.
     * @param id id VarArg
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

    public LookupBuilder itunesId(long ... ids){
        paramMap.put(KeyVals.LookupKeys.ITUNES_ID, convertNumberArrayToString(ids));
        return this;
    }

    public LookupBuilder amgArtistId(long ... ids){
        paramMap.put(KeyVals.LookupKeys.AMG_ARTIST_ID, convertNumberArrayToString(ids));
        return this;
    }

    public LookupBuilder amgAlbumId(long ... ids){
        paramMap.put(KeyVals.LookupKeys.AMG_ALBUM_ID, convertNumberArrayToString(ids));
        return this;
    }

    public LookupBuilder amgVideoId(long ... ids){
        paramMap.put(KeyVals.LookupKeys.AMG_VIDEO_ID, convertNumberArrayToString(ids));
        return this;
    }

    public LookupBuilder upc(long ... ids){
        paramMap.put(KeyVals.LookupKeys.UPC, convertNumberArrayToString(ids));
        return this;
    }

    public LookupBuilder isbn(long ... ids){
        paramMap.put(KeyVals.LookupKeys.ISBN, convertNumberArrayToString(ids));
        return this;
    }

    public LookupBuilder limit(int limit){
        paramMap.put(KeyVals.LookupKeys.LIMIT, String.valueOf(limit));
        return this;
    }

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
