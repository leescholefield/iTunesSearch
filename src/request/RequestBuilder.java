package request;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * Utility class for constructing a new Request instance.
 * <p>
 * The only value required to construct a new Request is the "term" (string value to search the store for). If
 * the other values are not set the iTunes Search server will use their default values. These are:
 *      <ul>
 *          <li><b>Media</b> : "all".</li>
 *          <li><b>Entity</b> : the track entity associated with the specified Media type. E.g. if Media is
 *          "music" the Entity will be "musicTrack".</li>
 *          <li><b>Country</b> : "US".</li>
 *          <li><b>Limit</b> : 50.</li>
 *          <li><b>Explicit</b> : "Yes"</li>
 *      </ul>
 * <p>
 * Note these values are defined by iTunes and they could change.
 */
public class RequestBuilder {

    private Map<String, String> paramMap = new HashMap<>();

    /* Creates a {@link Request} instance. */
    public Request newRequest(){
        return new RequestImpl(paramMap);
    }

    /**
     * Creates a new {@link Request} instance for a Podcast request. If the caller has already set the MEDIA and
     * ENTITY this will override the previously set values.
     */
    public Request newPodcastRequest() {
        this.paramMap.put(KeyVals.Keys.MEDIA, KeyVals.Entity.Podcast.PODCAST);
        this.paramMap.put(KeyVals.Keys.ENTITY, "podcast");
        return new RequestImpl(paramMap);
    }

    /**
     * Creates a new {@link Request} instance for a Song request. If the caller has already set the MEDIA and
     * ENTITY this will override the previously set values.
     */
    public Request newSongRequest() {
        this.paramMap.put(KeyVals.Keys.MEDIA, "music");
        this.paramMap.put(KeyVals.Keys.ENTITY, "song");
        return new RequestImpl(paramMap);
    }

    /**
     * Creates a new {@link Request} instance for an Album request. If the caller has already set the MEDIA and
     * ENTITY this will override the previously set values.
     */
    public Request newAlbumRequest() {
        this.paramMap.put(KeyVals.Keys.MEDIA, "music");
        this.paramMap.put(KeyVals.Keys.ENTITY, "album");
        return new RequestImpl(paramMap);
    }

    /**
     * Creates a new {@link Request} instance for a Movie request. If the caller has already set the MEDIA and
     * ENTITY this will override the previously set values.
     */
    public Request newMovieRequest() {
        this.paramMap.put(KeyVals.Keys.MEDIA, "movie");
        this.paramMap.put(KeyVals.Keys.ENTITY, "movie");
        return new RequestImpl(paramMap);
    }

    /**
     * Creates a new {@link Request} instance for a Music Artist request. If the caller has already set the MEDIA
     * and ENTITY this will override the previously set values.
     */
    public Request newMusicArtistRequest() {
        this.paramMap.put(KeyVals.Keys.MEDIA, "music");
        this.paramMap.put(KeyVals.Keys.ENTITY, "musicArtist");
        return new RequestImpl(paramMap);
    }

    /* term is the only required value for a RequestImpl */
    public RequestBuilder(String term){
        String sanInput = null;
        try {
            sanInput = URLEncoder.encode(term, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        this.paramMap.put(KeyVals.Keys.TERM, sanInput);
    }


    /**
     * Sets the ISO country code for the country Store you want to search in.
     *
     * See <a href="https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2">ISO codes</a> for a list of valid codes.
     */
    public RequestBuilder country(String country){
        this.paramMap.put(KeyVals.Keys.COUNTRY, country);
        return this;
    }

    /**
     * Sets the media type you want to search for.
     *
     * Valid media types: movie, podcast, music, musicVideo, audiobook, shortFilm, tvShow,
     *  software, ebook, all
     */
    public RequestBuilder media(String mediaType){
        this.paramMap.put(KeyVals.Keys.MEDIA, mediaType);
        return this;
    }

    /**
     * Sets the entity associated with the media type.
     *
     * See <a href="https://affiliate.itunes.apple.com/resources/documentation/itunes-store-web-service-search-api/">
     *     Itunes Search API</a> for a list of valid values.
     */
    public RequestBuilder entity(String entity){
        this.paramMap.put(KeyVals.Keys.ENTITY, entity);
        return this;
    }

    /**
     * Specifies the attribute you want to search for in the stores, relative to the specified media type.
     */
    public RequestBuilder attribute(String attribute){
        this.paramMap.put(KeyVals.Keys.ATTRIBUTE, attribute);
        return this;
    }

    /**
     * Number of results for the itunes request to return.
     * @param limit must be between 0 and 200.
     */
    public RequestBuilder limit(int limit){
        if(limit >= 0 && limit <= 200){
            this.paramMap.put(KeyVals.Keys.LIMIT, String.valueOf(limit));
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
        this.paramMap.put(KeyVals.Keys.LANG, language);
        return this;
    }

    /**
     * Whether explicit content should be included in the returned results.
     */
    public RequestBuilder explicit(boolean explicit){
        String val = "Yes";
        if(!explicit){
            val = "No";
        }
        this.paramMap.put(KeyVals.Keys.EXPLICIT, val);
        return this;
    }

    /**
     * Used for Pagination. The default is 0.
     */
    public RequestBuilder offset(int offset){
        this.paramMap.put(KeyVals.Keys.OFFSET, String.valueOf(offset));
        return this;
    }
}

