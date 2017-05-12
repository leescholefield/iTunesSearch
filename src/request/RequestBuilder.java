package request;

import java.util.HashMap;
import java.util.Map;

/**
 * Utility class for constructing a new Request instance.
 */
public class RequestBuilder {

    private Map<RequestImpl.Keys, String> paramMap = new HashMap<>();

    /* Creates a {@link Request} instance. */
    public Request newRequest(){
        return new RequestImpl(paramMap);
    }

    /**
     * Creates a new {@link Request} instance for a Podcast request. If the caller has already set the MEDIA and
     * ENTITY this will override the previously set values.
     */
    public Request newPodcastRequest(){
        this.paramMap.put(Request.Keys.MEDIA, "podcast");
        this.paramMap.put(Request.Keys.ENTITY, "podcast");
        return new RequestImpl(paramMap);
    }

    /**
     * Creates a new {@link Request} instance for a Song request. If the caller has already set the MEDIA and
     * ENTITY this will override the previously set values.
     */
    public Request newSongRequest(){
        this.paramMap.put(Request.Keys.MEDIA, "music");
        this.paramMap.put(Request.Keys.ENTITY, "song");
        return new RequestImpl(paramMap);
    }

    /* term is the only required value for a RequestImpl */
    public RequestBuilder(String term){
        this.paramMap.put(RequestImpl.Keys.TERM, term);
    }


    /**
     * Sets the ISO country code for the country Store you want to search in.
     *
     * See <a href="https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2">ISO codes</a> for a list of valid codes.
     */
    public RequestBuilder country(String country){
        this.paramMap.put(RequestImpl.Keys.COUNTRY, country);
        return this;
    }

    /**
     * Sets the media type you want to search for.
     *
     * Valid media types: movie, podcast, music, musicVideo, audiobook, shortFilm, tvShow,
     *  software, ebook, all
     */
    public RequestBuilder media(String mediaType){
        this.paramMap.put(RequestImpl.Keys.MEDIA, mediaType);
        return this;
    }

    /**
     * Sets the entity associated with the media type.
     *
     * See <a href="https://affiliate.itunes.apple.com/resources/documentation/itunes-store-web-service-search-api/">
     *     Itunes Search API</a> for a list of valid values.
     */
    public RequestBuilder entity(String entity){
        this.paramMap.put(RequestImpl.Keys.ENTITY, entity);
        return this;
    }

    /**
     * Specifies the attribute you want to search for in the stores, relative to the specified media type.
     */
    public RequestBuilder attribute(String attribute){
        this.paramMap.put(RequestImpl.Keys.ATTRIBUTE, attribute);
        return this;
    }

    /**
     * Number of results for the itunes request to return.
     * @param limit must be between 0 and 200.
     */
    public RequestBuilder limit(int limit){
        if(limit >= 0 && limit <= 200){
            this.paramMap.put(RequestImpl.Keys.LIMIT, String.valueOf(limit));
            return this;
        }
        throw new IllegalArgumentException("limit must be between 0 and 200");
    }

    /**
     * The language you want to use when returning search results from the iTunes Store.
     *
     * Note, the only valid values are "en_us" and "ja_jp".
     */
    public RequestBuilder language(String language){
        this.paramMap.put(RequestImpl.Keys.LANG, language);
        return this;
    }

    /**
     * The results version to be returned by the itunes request.
     *
     * @param version either 1 or 2
     */
    public RequestBuilder version(int version){
        if(version == 1 || version == 2){
            this.paramMap.put(RequestImpl.Keys.VERSION, String.valueOf(version));
            return this;
        }
        throw new IllegalArgumentException("version must either be 1 or 2");
    }

    /**
     * Whether explicit content should be included in the returned results.
     */
    public RequestBuilder explicit(boolean explicit){
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
    public RequestBuilder offset(int offset){
        this.paramMap.put(Request.Keys.OFFSET, String.valueOf(offset));
        return this;
    }
}

