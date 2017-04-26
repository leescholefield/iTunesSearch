package main.request;


import java.io.IOException;
import java.util.Map;

/**
 * Represents an http RequestImpl to the iTunes Search Api.
 */
class RequestImpl implements Request {

    private final Map<Keys, String> paramMap;


    /**
     * Package private constructor used by the Response class. For normal instantiation use one of the static factory
     * methods.
     */
    RequestImpl(Map<Keys, String> requestParams){
        paramMap = requestParams;
    }

    /**
     * Creates a String url from the values in the paramMap.
     */
    @Override
    public String createUrl(){
        final String urlBase = "https://itunes.apple.com/search?";

        StringBuilder builder = new StringBuilder();
        builder.append(urlBase);

        for (Map.Entry<Keys, String> entry : paramMap.entrySet()){
            builder.append("&" ).append(entry.getKey().toString()).append("=").append(entry.getValue());
        }

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

    public Map<Keys, String> getParamMap(){
        return paramMap;
    }
}
