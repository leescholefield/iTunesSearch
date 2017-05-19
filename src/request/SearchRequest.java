package request;


import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * A simple implementation of the {@link Request} interface for making Search requests. The primary
 * responsibility of this class is to generate the Url that will be used to send the Http request.
 * <p>
 * It also has convenience methods for sending an Http request, utilizing the {@link SimpleHttpRequest} class.
 * <p>
 * A note on the offset: the offset is the number of results iTunes should ignore when making a request. To
 * generate the offset, this class will add the LIMIT value from the paramMap, or 50 (iTunes default) if it
 * is not set.
 */
class SearchRequest implements Request {

    private final Map<String, String> paramMap;
    private int currentOffset = 0;

    /**
     * Package private constructor used by the Response class. For normal instantiation use one of the static factory
     * methods.
     *
     * Note, this makes a copy the requestParams map.
     */
    SearchRequest(Map<String, String> requestParams){
        paramMap = new HashMap<>(requestParams);
    }

    /**
     * Creates a String url from the values in the paramMap.
     */
    @Override
    public String createUrl(){
        return createUrl(paramMap, currentOffset);
    }

    /**
     * Appends the key, values and offset in the given map to the base url and returns it.
     * <p>
     * Package-private so can be tested.
     */
    static String createUrl(Map<String, String> paramMap, int offset){
        final String urlBase = "https://itunes.apple.com/search?";

        StringBuilder builder = new StringBuilder();
        builder.append(urlBase);

        for (Map.Entry<String, String> entry : paramMap.entrySet()){
            builder.append("&" ).append(entry.getKey()).append("=").append(entry.getValue());
        }

        builder.append(createOffsetParam(offset));

        return builder.toString();
    }

    /**
     * Utility method for sending an http request.
     *
     * @return a {@link Response} object
     * @throws IOException if their was a network problem.
     */
    @Override
    public Response sendRequest() throws IOException {
        SimpleHttpRequest req = new SimpleHttpRequest();
        return req.sendRequest(this);
    }

    /**
     * Returns a String url for the next page.
     * <p>
     * See the class documentation for details on how the offset is calculated.
     */
    @Override
    public String nextPageUrl(){
        addLimitToOffset();
        return createUrl();
    }

    /**
     * Returns a {@link Request} for the next page. Note, this just adds the limit to current offset and returns the
     * same instance.
     */
    @Override
    public Request nextPageRequest(){
        addLimitToOffset();
        return this;
    }
    /**
     * Returns an UnmodifiableMap.
     */
    public Map<String, String> getParamMap(){
        return Collections.unmodifiableMap(paramMap);
    }

    /**
     * Adds the value for limit (found in the paramMap) to the current offset. If limit is not set it will
     * use the iTunes defined default of 50.
     */
    private void addLimitToOffset(){
        int limit = Integer.parseInt(paramMap.getOrDefault(KeyVals.SearchKeys.LIMIT, "50"));
        currentOffset = currentOffset + limit;
    }

    @Override
    public String getPageUrlAtOffset(int offset){
        return createUrl(paramMap, offset);
    }

    private static String createOffsetParam(int offset){
        return "&" + KeyVals.SearchKeys.OFFSET + "=" + String.valueOf(offset);
    }

    /**
     * The offset is the number of items iTunes will skip when returning the results.
     *
     * @return the current offset.
     */
    @Override
    public int getCurrentOffset() {
        return currentOffset;
    }
}
