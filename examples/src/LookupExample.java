import model.Item;
import model.artist.Artist;
import model.track.Song;
import parse.Parser;
import parse.ResultList;
import request.RequestKeys;
import request.LookupBuilder;
import request.Request;
import request.Response;

import java.io.IOException;

/**
 * Contains different lookup examples.
 */
public class LookupExample {

    /**
     * Lookups the id for Jack Johnson.
     */
    private static ResultList<Artist> singleId(){
        long id = 909253;
        Request request = new LookupBuilder(LookupBuilder.IdTypes.ITUNES, id).newRequest();

        try {
            Response response = request.sendRequest();
            return new Parser().parseToModel(response, Item.ItemType.ARTIST, Artist.class);
        } catch (IOException e) {
            System.exit(1);
            // unreachable
            return null;
        }
    }

    /**
     * Lookups an artists id and then returns their top 10 songs.
     * <p>
     * Note, along with the 10 song items in the JSON results array, it will also contain an item for the artist. When
     * {@link Parser#parseToModel} is called it will only grab the song items.
     */
    private static ResultList<Song> topSongs() {
        long id = 178834;
        Request request = new LookupBuilder(LookupBuilder.IdTypes.ITUNES, id).entity(RequestKeys.Entity.Music.SONG)
                .limit(10).newRequest();

        try {
            Response response = request.sendRequest();
            return new Parser().parseToModel(response, Item.ItemType.SONG, Song.class);
        } catch (IOException e){
            System.exit(1);
            // unreachable
            return null;
        }

    }

    /**
     * Lookups multiple artist ids and returns their 10 most recent songs(including songs they are featured on).
     * <p>
     * The actual result array will contain 33 items. 3 artist items for each id, and then 10 song items for each artist.
     */
    private static ResultList<Item> multipleArtistsSongs() {
        Request request = new LookupBuilder(LookupBuilder.IdTypes.ITUNES, 178834, 909253, 289550)
                .entity(RequestKeys.Entity.Music.SONG)
                .limit(10)
                .sort(RequestKeys.Sort.RECENT)
                .newRequest();

        try {
            Response response = request.sendRequest();
            return new Parser().parse(response);
        } catch (IOException e){
            System.exit(1);
            // unreachable
            return null;
        }
    }

    public static void main (String[] args){
        ResultList<Item> results = multipleArtistsSongs();
        ResultList<Artist> artists = results.getResultsOfType(Item.ItemType.ARTIST, Artist.class);
        ResultList<Song> songs = results.getResultsOfType(Item.ItemType.SONG, Song.class);

        System.out.println("Artists:");
        for (Artist artist : artists.getResultList()){
            System.out.println(artist.toString());
        }

        System.out.println("Songs");
        for (Song song : songs.getResultList()) {
            System.out.println(song.toString());
        }
    }
}
