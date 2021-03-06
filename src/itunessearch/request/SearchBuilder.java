package itunessearch.request;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * Utility class for constructing a new {@link Request} instance.
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
public final class SearchBuilder {

    private Map<String, String> paramMap = new HashMap<>();

    /* Creates a {@link Request} instance. */
    public Request newRequest() {
        return new RequestImpl(paramMap, Request.SEARCH_URL_BASE);
    }

    /**
     * Creates a new {@link Request} instance for a Podcast itunessearch.request. If the caller has already set the MEDIA and
     * ENTITY this will override the previously set values.
     */
    public Request newPodcastRequest() {
        this.paramMap.put(RequestKeys.SearchKeys.MEDIA, RequestKeys.Entity.Podcast.PODCAST);
        this.paramMap.put(RequestKeys.SearchKeys.ENTITY, "podcast");
        return new RequestImpl(paramMap, Request.SEARCH_URL_BASE);
    }

    /**
     * Creates a new {@link Request} instance for a Song itunessearch.request. If the caller has already set the MEDIA and
     * ENTITY this will override the previously set values.
     */
    public Request newSongRequest() {
        this.paramMap.put(RequestKeys.SearchKeys.MEDIA, "music");
        this.paramMap.put(RequestKeys.SearchKeys.ENTITY, "song");
        return new RequestImpl(paramMap, Request.SEARCH_URL_BASE);
    }

    /**
     * Creates a new {@link Request} instance for an Album itunessearch.request. If the caller has already set the MEDIA and
     * ENTITY this will override the previously set values.
     */
    public Request newAlbumRequest() {
        this.paramMap.put(RequestKeys.SearchKeys.MEDIA, "music");
        this.paramMap.put(RequestKeys.SearchKeys.ENTITY, "album");
        return new RequestImpl(paramMap,Request.SEARCH_URL_BASE);
    }

    /**
     * Creates a new {@link Request} instance for a Movie itunessearch.request. If the caller has already set the MEDIA and
     * ENTITY this will override the previously set values.
     */
    public Request newMovieRequest() {
        this.paramMap.put(RequestKeys.SearchKeys.MEDIA, "movie");
        this.paramMap.put(RequestKeys.SearchKeys.ENTITY, "movie");
        return new RequestImpl(paramMap, Request.SEARCH_URL_BASE);
    }

    /**
     * Creates a new {@link Request} instance for a Music Artist itunessearch.request. If the caller has already set the MEDIA
     * and ENTITY this will override the previously set values.
     */
    public Request newMusicArtistRequest() {
        this.paramMap.put(RequestKeys.SearchKeys.MEDIA, "music");
        this.paramMap.put(RequestKeys.SearchKeys.ENTITY, "musicArtist");
        return new RequestImpl(paramMap, Request.SEARCH_URL_BASE);
    }


    /**
     * The term is the only required param for constructing a {@link Request}.
     *
     * @param term term to search for.
     * @throws IllegalArgumentException if the term could not be sanitized.
     */
    public SearchBuilder(String term) throws IllegalArgumentException {
        String sanInput = null;
        try {
            sanInput = URLEncoder.encode(term, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new IllegalArgumentException(term + " could not be sanitized", e);
        }
        this.paramMap.put(RequestKeys.SearchKeys.TERM, sanInput);
    }


    /**
     * Sets the ISO country code for the country Store you want to search in.
     * <p>
     * See <a href="https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2">ISO codes</a> for a list of valid codes.
     */
    public SearchBuilder country(String country) {
        this.paramMap.put(RequestKeys.SearchKeys.COUNTRY, country);
        return this;
    }

    /**
     * Sets the media type you want to search for.
     * <p>
     * Valid media types: movie, podcast, music, musicVideo, audiobook, shortFilm, tvShow,
     * software, ebook, all
     */
    public SearchBuilder media(String mediaType) {
        this.paramMap.put(RequestKeys.SearchKeys.MEDIA, mediaType);
        return this;
    }

    /**
     * Sets the entity associated with the media type.
     * <p>
     * See <a href="https://affiliate.itunes.apple.com/resources/documentation/itunes-store-web-service-search-api/">
     * Itunes Search API</a> for a list of valid values.
     */
    public SearchBuilder entity(String entity) {
        this.paramMap.put(RequestKeys.SearchKeys.ENTITY, entity);
        return this;
    }

    /**
     * Specifies the attribute you want to search for in the stores, relative to the specified media type.
     */
    public SearchBuilder attribute(String attribute) {
        this.paramMap.put(RequestKeys.SearchKeys.ATTRIBUTE, attribute);
        return this;
    }

    /**
     * Number of results for the itunes itunessearch.request to return.
     *
     * @param limit must be between 0 and 200.
     */
    public SearchBuilder limit(int limit) {
        if (limit >= 0 && limit <= 200) {
            this.paramMap.put(RequestKeys.SearchKeys.LIMIT, String.valueOf(limit));
            return this;
        }
        throw new IllegalArgumentException("limit must be between 0 and 200");
    }

    /**
     * The language you want to use when returning search results from the iTunes Store.
     * <p>
     * Note, the only valid values are "en_us" and "ja_jp".
     */
    public SearchBuilder language(String language) {
        this.paramMap.put(RequestKeys.SearchKeys.LANG, language);
        return this;
    }

    /**
     * Whether explicit content should be included in the returned results.
     */
    public SearchBuilder explicit(boolean explicit) {
        String val = "Yes";
        if (!explicit) {
            val = "No";
        }
        this.paramMap.put(RequestKeys.SearchKeys.EXPLICIT, val);
        return this;
    }

    /**
     * The offset is the number of items (from the beginning) iTunes should skip when returning results.
     */
    public SearchBuilder offset(int offset) {
        this.paramMap.put(RequestKeys.SearchKeys.OFFSET, String.valueOf(offset));
        return this;
    }

    /**
     * Sets the sort order. Either {@code RequestKeys.Sort.POPULAR} or {@code RequestKeys.Sort.RECENT}.
     *
     * The default is popular.
     */
    public SearchBuilder sort(RequestKeys.Sort order){
        this.paramMap.put(RequestKeys.SearchKeys.SORT, order.getKeyName());
        return this;
    }

} // end of SearchBuilder class
