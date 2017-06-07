package itunessearch.request;

/**
 * Utility class containing keys and values for constructing {@link Request} instances. It uses a mixture of static classes
 * with String fields, and Enums. Generally speaking, Enums have been used when there is a small list of valid parameters.
 *
 * <p>
 * The use of inner classes is to make the calling code easier to read. For example, to set the Entity to albums
 * you would use {@code String entity = RequestKeys.Entity.Music.ALBUM;}.
 */
public abstract class RequestKeys {

    /**
     * List of valid Search keys. This is package-private and is used internally by the {@code SearchBuilder} class.
     * <p>
     * Note, "callback" and "version", although valid, are not here since this
     * library only supports version 2 and does not support callback at all.
     */
    static class SearchKeys {
        static final String TERM = "term";
        static final String COUNTRY = "country";
        static final String MEDIA = "media";
        static final String ENTITY = "entity";
        static final String ATTRIBUTE = "attribute";
        static final String LIMIT = "limit";
        static final String LANG = "lang";
        static final String EXPLICIT = "explicit";
        static final String OFFSET = "offset";
        static final String SORT = "sort";
    }

    /**
     * List of valid Lookup keys. This is public since it is used by the {@code LookupBuilder} constructor.
     */
    public static class LookupKeys {
        public static final String ITUNES_ID = "id";
        public static final String AMG_ARTIST_ID = "amgArtistId";
        public static final String UPC = "upc";
        public static final String AMG_ALBUM_ID = "amgAlbumId";
        public static final String AMG_VIDEO_ID = "amgVideoId";
        public static final String ISBN = "isbn";

        // package-private
        static final String LIMIT = "limit";
        static final String ENTITY = "entity";
        static final String SORT = "sort";
    }

    /**
     * List of values for the MEDIA key.
     */
    public static class Media {
        public static final String MOVIE = "movie";
        public static final String MUSIC = "music";
        public static final String PODCAST = "podcast";
        public static final String MUSIC_VIDEO = "musicVideo";
        public static final String AUDIOBOOK = "audiobook";
        public static final String SHORT_FILM = "shortFilm";
        public static final String TV_SHOW = "tvShow";
        public static final String SOFTWARE = "software";
        public static final String EBOOK = "ebook";
        public static final String ALL = "all";
    }

    /**
     * List of Entity values for each MEDIA type.
     */
    public static class Entity {

        public static class Music {
            public static final String MUSIC_TRACK = "musicTrack"; // includes both songs and music videos
            public static final String ARTIST = "musicArtist";
            public static final String ALBUM = "album";
            public static final String MUSIC_VIDEO = "musicVideo";
            public static final String MIX = "mix";
            public static final String SONG = "song";
        }

        public static class Podcast {
            public static final String AUTHOR = "podcastAuthor";
            public static final String PODCAST = "podcast";
        }

        public static class MOVIE {
            public static final String ARTIST = "movieArtist";
            public static final String MOVIE = "movie";
        }

        public static class MusicVideo {
            public static final String ARTIST = "musicArtist";
            public static final String MUSIC_VIDEO = "musicVideo";
        }

        public static class Audiobook {
            public static final String AUTHOR = "audiobookAuthor";
            public static final String AUDIOBOOK = "audiobook";
        }

        public static class ShortFilm {
            public static final String ARTIST = "shortFilmArtist";
            public static final String SHORT_FILM = "shortFilm";
        }

        public static class TvShow {
            public static final String EPISODE = "tvEpisode";
            public static final String SEASON = "tvSeason";
        }

        public static class Software {
            public static final String SOFTWARE = "software";
            public static final String IPAD = "iPadSoftware";
            public static final String MAC = "macSoftware";
        }

        public static class Ebook {
            public static final String EBOOK = "ebook";
        }

        public static class All {
            public static final String MOVIE = "movie";
            public static final String ALBUM = "album";
            public static final String ALL_ARTIST = "allArtist";
            public static final String PODCAST = "podcast";
            public static final String MUSIC_VIDEO = "musicVideo";
            public static final String MIX = "mix";
            public static final String AUDIOBOOK = "audiobook";
            public static final String TV_SHOW = "tvShow";
            public static final String ALL_TRACK = "allTrack";
        }

    } // end of Entity class

    /**
     * List of values for the {@code sort} option.
     */
    public enum Sort {
        POPULAR, RECENT;

        private String key;

        static {
            POPULAR.key = "popular";
            RECENT.key = "recent";
        }

        /**
         * Package-private method used to convert to a String key to be stored in the {@code []Builder.paramMap}.
         */
        String getKeyName(){
            return key;
        }
    }
}
