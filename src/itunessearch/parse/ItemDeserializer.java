package itunessearch.parse;

import com.google.gson.*;
import itunessearch.model.Item;
import itunessearch.model.artist.Artist;
import itunessearch.model.audiobook.Audiobook;
import itunessearch.model.collection.Album;
import itunessearch.model.track.FeatureMovie;
import itunessearch.model.track.MusicVideo;
import itunessearch.model.track.Podcast;
import itunessearch.model.track.Song;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 *  Custom {@link JsonDeserializer} that parses each element in the iTunes 'results' array into a {@link List<Item>}.
 *
 *  This class does not implement any custom parsing of the JSON feed. It simply looks up the "wrapperType" and determines
 *  which {@code Item} subclass should be instantiated.
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
