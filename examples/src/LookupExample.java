import model.Item;
import model.artist.Artist;
import model.track.Song;
import parse.Parser;
import parse.ResultList;
import request.KeyVals;
import request.LookupBuilder;
import request.Request;
import request.Response;

import java.io.IOException;

/**
 * A simple Lookup example
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
        Request request = new LookupBuilder(LookupBuilder.IdTypes.ITUNES, id).entity(KeyVals.Entity.Music.SONG)
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

    public static void main (String[] args){
        ResultList<Song> results = topSongs();
        for (Song song : results.getResultList()){
            System.out.println(song.toString());
        }
    }
}
