package parse;

import com.google.gson.*;
import model.Item;
import model.artist.Artist;
import model.audiobook.Audiobook;
import model.collection.Album;
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
class ItemDeserializer implements JsonDeserializer<List<Item>> {


    @Override
    public List<Item> deserialize(JsonElement jsonElement,
                                  Type type,
                                  JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {

        JsonArray resultsArray = jsonElement.getAsJsonObject().getAsJsonArray("results");
        List<Item> itemList = new ArrayList<>();
        Gson gson = new Gson();

        for (JsonElement element : resultsArray){
            JsonObject elementObject = element.getAsJsonObject();
            String wrapperType = elementObject.get("wrapperType").getAsString();
            Class<? extends Item> modelClass = null;

            switch(wrapperType) {

                case "track":
                    String kind = elementObject.get("kind").getAsString();
                    switch(kind) {
                        case "song":
                            modelClass = Song.class;
                            break;

                        case "music-video":
                            modelClass = MusicVideo.class;
                            break;

                        case "feature-movie":
                            modelClass = FeatureMovie.class;
                            break;

                        case "podcast":
                            modelClass = Podcast.class;
                            break;
                    }
                    break; // end of track case

                case "artist":
                    modelClass = Artist.class;
                    break;

                case "audiobook":
                    modelClass = Audiobook.class;
                    break;

                case "collection":
                    modelClass = Album.class;
                    break;

            } // end of switch


            if (modelClass != null){
                Item item = gson.fromJson(element, modelClass);
                itemList.add(item);
            } else{
                throw new IllegalArgumentException("Not a recognized wrapperType");
            }
        }

        return itemList;
    }
}
