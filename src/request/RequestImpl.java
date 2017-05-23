package request;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;

/**
 *  A simple implementation of the {@link Request} interface for making Http request to the iTunes Server.
 *  <p>
 *  The primary responsibility of this class is to generate the actual Url that will be sent to the iTunes Server. It also
 *  has convenience methods for sending a request ( {@link RequestImpl#sendRequest()} ) utilizing the
 *  {@link SimpleHttpRequest} class.
 *  <p>
 *  Because the {@link SearchBuilder} and {@link LookupBuilder} classes are responsible for verifying that the values set
 *  for each key are valid for either a lookup or search request, this class does not need to check the Map keys or values
 *  it is given. It will simply assume they are correct. This also eliminates the need for two seperate implementations
 *  for searches and requests.
 *  <p>
 *  A note on the offset: the offset is the number of results iTunes should ignore when making a request. To
 *  generate the offset, this class will add the LIMIT value from the paramMap, or 50 (iTunes default) if it
 *  is not set.
 */
class RequestImpl implements Request {

    private final Map<String, String> paramMap;
    private final String baseUrl;
    private int offset;

    /**
     * Package-private constructor. Use either {@link SearchBuilder} or {@link LookupBuilder} to create a Request instance.
     */
    RequestImpl(Map<String, String> paramMap, String baseUrl){
        this.paramMap = paramMap;
        this.baseUrl = baseUrl;
    }

    /**
     * Creates a String url by combining the keys and values used in the Builder with the base url for the request type
     * (either 'lookup' or 'search').
     */
    @Override
    public String createUrl() {
        StringBuilder builder = new StringBuilder();
        builder.append(baseUrl);

        for (Map.Entry<String, String> entry : paramMap.entrySet()){
            builder.append("&" ).append(entry.getKey()).append("=").append(entry.getValue());
        }

        builder.append(createOffsetParam(offset));

        return builder.toString();
    }

    /**
     * Returns a String url for the next page.
     * <p>
     * Note, calling this method has the side-effect of incrementing the {@link RequestImpl#offset}.
     */
    @Override
    public String nextPageUrl(){
        addLimitToOffset();
        return createUrl();
    }

    /**
     * Returns a {@link Request} for the next page.
     * <p>
     * Note, this returns the same Request instance.
     */
    @Override
    public Request nextPageRequest(){
        addLimitToOffset();
        return this;
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
     * Returns the paramMap as an UnmodifiableMap.
     */
    @Override
    public Map<String, String> getParamMap() {
        return Collections.unmodifiableMap(paramMap);
    }

    @Override
    public int getCurrentOffset() {
        return offset;
    }

    /**
     * Adds the value for limit (found in the paramMap) to the current offset. If limit is not set it will
     * use the iTunes defined default of 50.
     */
    private void addLimitToOffset(){
        int limit = Integer.parseInt(paramMap.getOrDefault(RequestKeys.SearchKeys.LIMIT, "50"));
        offset = offset + limit;
    }

    private static String createOffsetParam(int offset){
        return "&" + RequestKeys.SearchKeys.OFFSET + "=" + String.valueOf(offset);
    }
}
