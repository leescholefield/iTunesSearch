import model.Item;
import model.collection.Album;
import parse.Parser;
import parse.ResultList;
import request.Request;
import request.Response;
import request.SearchBuilder;

import java.io.IOException;

/**
 * Searches for an artists top 10 albums
 */
public class AlbumExample {

    public static void main(String[] args){
        Request request = new SearchBuilder("creedence clearwater")
                .limit(10).country("GB")
                .attribute("artistTerm").newAlbumRequest();

        Response response = null;
        try {
            response = request.sendRequest();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ResultList<Album> albums = new Parser().parseToModel(response, Item.ItemType.ALBUM, Album.class);

        for (Album album : albums.getResultList()){
            System.out.println(album);
        }
    }
}
