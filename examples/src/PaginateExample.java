import model.Item;
import model.track.Podcast;
import parse.Parser;
import parse.ResultList;
import request.Request;
import request.RequestBuilder;
import request.Response;

import java.io.IOException;

/**
 * Quick and dirty example showing how to get paginated results form the iTunes store.
 */
public class PaginateExample {

    private Response response;

    public PaginateExample(String term){
    }

    /**
     * Handles both sending the Request and parsing the Response into the Podcast model.
     */
    private ResultList<Podcast> sendRequest(Request request) throws IOException{
        response = request.sendRequest();

        ResultList<Podcast> podcastList = new Parser().parseToModel(response,
                Item.ItemType.PODCAST, Podcast.class);

        return podcastList;
    }

    public static void main(String[] args){

        PaginateExample Obj = new PaginateExample("history");

        // getting first page
        Request request = new RequestBuilder("History").newPodcastRequest();
        ResultList<Podcast> results = null;

        try {
            results = Obj.sendRequest(request);
        } catch (IOException e){
            System.exit(1);
        }

        // printing first page
        System.out.println("First page: ");
        for (Podcast pod : results.getResultList()){
            System.out.println(pod);
        }

        // getting next page
        Request nextPage = Obj.response.nextPageRequest();
        ResultList<Podcast> nextPageResults = null;

        try {
            nextPageResults = Obj.sendRequest(nextPage);
        } catch (IOException e){
            System.exit(1);
        }

        // printing next page
        System.out.println("\nSecond page: ");
        for (Podcast pod : nextPageResults.getResultList()) {
            System.out.println(pod);
        }
    }
}
