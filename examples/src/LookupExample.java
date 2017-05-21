import model.Item;
import model.artist.Artist;
import parse.Parser;
import parse.ResultList;
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

    public static void main (String[] args){
        ResultList<Artist> singleId = singleId();
        for (Artist artist : singleId.getResultList()){
            System.out.println(artist.toString());
        }
    }
}
