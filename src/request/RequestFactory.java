package request;

import java.util.HashMap;
import java.util.Map;

/**
 */
public class RequestFactory {

    private Map<RequestImpl.Keys, String> paramMap = new HashMap<>();

    /* Creates a {@link Request} instance. */
    public Request newRequest(){
        return new RequestImpl(paramMap);
    }

    /* term is the only required value for a RequestImpl */
    public RequestFactory(String term){
        this.paramMap.put(RequestImpl.Keys.TERM, term);
    }

    /**
     * Constructor methods.
     */

    public RequestFactory country(String country){
        this.paramMap.put(RequestImpl.Keys.COUNTRY, country);
        return this;
    }

    public RequestFactory media(String mediaType){
        this.paramMap.put(RequestImpl.Keys.MEDIA, mediaType);
        return this;
    }

    public RequestFactory entity(String entity){
        this.paramMap.put(RequestImpl.Keys.ENTITY, entity);
        return this;
    }

    public RequestFactory attribute(String attribute){
        this.paramMap.put(RequestImpl.Keys.ATTRIBUTE, attribute);
        return this;
    }

    /**
     * Number of results for the itunes request to return.
     * @param limit must be between 0 and 200.
     */
    public RequestFactory limit(int limit){
        if(limit >= 0 && limit <= 200){
            this.paramMap.put(RequestImpl.Keys.LIMIT, String.valueOf(limit));
            return this;
        }
        throw new IllegalArgumentException("limit must be between 0 and 200");
    }

    public RequestFactory language(String language){
        this.paramMap.put(RequestImpl.Keys.LANG, language);
        return this;
    }

    /**
     * The results version to be returned by the itunes request.
     * @param version either 1 or 2
     */
    public RequestFactory version(int version){
        if(version == 1 || version == 2){
            this.paramMap.put(RequestImpl.Keys.VERSION, String.valueOf(version));
            return this;
        }
        throw new IllegalArgumentException("version must either be 1 or 2");
    }

    /**
     * Whether explicit content should be included in the returned results.
     */
    public RequestFactory explicit(boolean explicit){
        String val = "Yes";
        if(!explicit){
            val = "No";
        }
        this.paramMap.put(RequestImpl.Keys.EXPLICIT, val);
        return this;
    }

    /**
     * Used for Pagination. The default is 0.
     */
    public RequestFactory offset(int offset){
        this.paramMap.put(Request.Keys.OFFSET, String.valueOf(offset));
        return this;
    }
} // end of factory class

