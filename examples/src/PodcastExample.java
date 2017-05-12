import model.Item;
import model.track.Podcast;
import parse.Parser;
import parse.ResultList;
import request.Request;
import request.RequestBuilder;
import request.Response;

/**
 * Performs an Itunes search for podcasts with the keyword "history"
 */
public class PodcastExample {

    private String term;

    public PodcastExample(String term){
        this.term = term;
    }

    public ResultList<Podcast> search(){
        Request request = new RequestBuilder(term).newPodcastRequest();
        Response response = request.sendRequest();

        ResultList<Item> resultList = new Parser().parse(response.responseBody());
        ResultList<Podcast> podcastList = resultList.getResultsOfType(Item.ItemType.PODCAST, Podcast.class);

        return podcastList;
    }
    public static void main(String[] args){
        PodcastExample podObj = new PodcastExample("history");
        ResultList<Podcast> results = podObj.search();

        for (Podcast pod : results.getResultList()){
            System.out.println(pod);
        }
    }
}
