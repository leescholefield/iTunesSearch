package request;


import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * A simple implementation of the {@link Request} interface. The primary responsibility of this class is to
 * generate the Url that will be used to send the Http request.
 * <p>
 * It also has convenience methods for sending an Http request, utilizing the {@link SimpleHttpRequest} class.
 * <p>
 * A note on the offset: the offset is the number of results iTunes should ignore when making a request. To
 * generate the offset, this class will add the LIMIT value from the paramMap, or 50 (iTunes default) if it
 * is not set.
 */
class RequestImpl implements Request {

    private final Map<String, String> paramMap;
    private int currentOffset = 0;

    /**
     * Package private constructor used by the Response class. For normal instantiation use one of the static factory
     * methods.
     *
     * Note, this makes a copy the requestParams map.
     */
    RequestImpl(Map<String, String> requestParams){
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

    @Override
    public Response sendRequest() throws IOException {
        SimpleHttpRequest req = new SimpleHttpRequest();
        return req.sendRequest(this);
    }

    /**
     * Returns an UnmodifiableMap.
     */
    public Map<String, String> getParamMap(){
        return Collections.unmodifiableMap(paramMap);
    }

    @Override
    public String nextPageUrl(){
        addLimitToOffset();
        return createUrl();
    }

    public Request nextPageRequest(){
        addLimitToOffset();
        return this;
    }

    /**
     * Adds the value for limit (found in the paramMap) to the current offset. If limit is not set it will
     * use the iTunes defined default of 50.
     */
    private void addLimitToOffset(){
        int limit = Integer.parseInt(paramMap.getOrDefault(KeyVals.Keys.LIMIT, "50"));
        currentOffset = currentOffset + limit;
    }

    @Override
    public String getPageUrlAtOffset(int offset){
        return createUrl(paramMap, offset);
    }

    private static String createOffsetParam(int offset){
        return "&" + KeyVals.Keys.OFFSET + "=" + String.valueOf(offset);
    }

    @Override
    public int getCurrentOffset() {
        return currentOffset;
    }
}
