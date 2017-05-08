package parse;

import com.google.gson.*;
import model.Item;
import model.artist.Artist;
import model.audiobook.Audiobook;
import model.track.FeatureMovie;
import model.track.MusicVideo;
import model.track.Podcast;
import model.track.Song;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 *  Custom {@link JsonDeserializer} that parses each element in the iTunes 'results' array.
 */
public class ItemDeserializer implements JsonDeserializer<List<Item>> {


    @Override
    public List<Item> deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonArray resultsArray = jsonElement.getAsJsonObject().getAsJsonArray("results");
        List<Item> itemList = new ArrayList<>();
        Gson gson = new Gson();

        for (JsonElement element : resultsArray){
            String wrapperType = element.getAsJsonObject().get("wrapperType").getAsString();
            Class<? extends Item> c = null;

            switch(wrapperType){

                case "track":
                    String kind = element.getAsJsonObject().get("kind").getAsString();
                    switch(kind){
                        case "song":
                            c = Song.class;
                            break;
                        case "music-video":
                            c = MusicVideo.class;
                            break;
                        case "feature-movie":
                            c = FeatureMovie.class;
                            break;
                        case "podcast":
                            c = Podcast.class;
                    }
                    break;
                case "artist":
                    c = Artist.class;
                    break;
                case "audiobook":
                    c = Audiobook.class;
                    break;
            } // end of switch


            if (c != null){
                Item item = gson.fromJson(element, c);
                itemList.add(item);
            } else{
                throw new IllegalArgumentException("Not a recognized wrapperType");
            }
        }

        return itemList;
    }
}
