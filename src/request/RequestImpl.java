package request;


import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Represents an http RequestImpl to the iTunes Search Api.
 */
class RequestImpl implements Request {

    private final Map<Keys, String> paramMap;
    private int currentOffset = 0;

    /**
     * Package private constructor used by the Response class. For normal instantiation use one of the static factory
     * methods.
     *
     * Note, this makes a copy the requestParams map.
     */
    RequestImpl(Map<Keys, String> requestParams){
        paramMap = new HashMap<>(requestParams);
    }

    /**
     * Creates a String url from the values in the paramMap.
     */
    @Override
    public String createUrl(){
        return createUrl(paramMap, currentOffset);
    }

    private static String createUrl(Map<Keys, String> paramMap, int offset){
        final String urlBase = "https://itunes.apple.com/search?";

        StringBuilder builder = new StringBuilder();
        builder.append(urlBase);

        for (Map.Entry<Keys, String> entry : paramMap.entrySet()){
            builder.append("&" ).append(entry.getKey().toString()).append("=").append(entry.getValue());
        }

        builder.append(createOffsetParam(offset));

        return builder.toString();
    }

    @Override
    public Response sendRequest(){
        SimpleHttpRequest req = new SimpleHttpRequest();
        try{
            return req.sendRequest(this);
        } catch(IOException e){

        }
        return null;

    }

    /**
     * Returns an UnmodifiableMap.
     */
    public Map<Keys, String> getParamMap(){
        return Collections.unmodifiableMap(paramMap);
    }

    @Override
    public String nextPageUrl(){
        currentOffset++;
        return createUrl();
    }

    public Request nextPageRequest(){
        currentOffset++;
        return this;
    }

    @Override
    public String getPageUrlAtOffset(int offset){
        return createUrl(paramMap, offset);
    }

    private static String createOffsetParam(int offset){
        return "&" + Keys.OFFSET.toString() + "=" + String.valueOf(offset);
    }

    @Override
    public int getCurrentOffset() {
        return currentOffset;
    }
}
