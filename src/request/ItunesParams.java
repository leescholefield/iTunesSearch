package request;

/**
 * Utility class containing static Strings for the MEDIA and ENTITY parameters, and valid Keys.
 * <p>
 * The use of inner classes is to make the calling code easier to read. For example, to set the Entity to albums
 * you would use {@code String entity = ItunesParams.Entity.Music.ALBUM;}.
 */
public abstract class ItunesParams {

    /**
     * List of valid parameter keys.
     * <p>
     * Note, "callback" and "version", although valid, are not here since this
     * library only supports version 2 and does not support callback at all.
     */
    public static class Keys {
        public static final String TERM = "term";
        public static final String COUNTRY = "country";
        public static final String MEDIA = "media";
        public static final String ENTITY = "entity";
        public static final String ATTRIBUTE = "attribute";
        public static final String LIMIT = "limit";
        public static final String LANG = "lang";
        public static final String EXPLICIT = "explicit";
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
     * List of valid Entity values for each MEDIA type.
     */
    public static class Entity {

        public static class Music {
            // Music Track includes both songs and music videos
            public static final String MUSIC_TRACK = "musicTrack";
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

    }
}
