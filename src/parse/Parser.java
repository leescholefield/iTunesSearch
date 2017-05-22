package parse;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import model.Item;
import request.Response;

import java.lang.reflect.Type;
import java.util.List;


/**
 * Uses Gson to parse a Response into a {@link ResultList}.
 *
 * If you are only interested in results of a specific kind ( {@code model.track.Song} for instance), or you know that the
 * JSON returned by the iTunes server will only contain results of a specific kind, you can use a {@link #parseToModel}
 * method, which will automatically cast the results to the {@code model} class.
 *
 * <pre>
 *     {@code
 *     ResultList<Song> resultList = new Parser().parseToModel(jsonString, Item.ItemType.SONG, Song.class;
 *     }
 * </pre>
 */
public class Parser {

    /**
     * Parses the given JSON string into a {@link ResultList<Item>}.
     *
     * @param jsonString json string to parse.
     * @return ResultList of type Item.
     */
    public ResultList<Item> parse(String jsonString){
        Type type = new TypeToken<List<Item>>(){}.getType();
        Gson gson = new GsonBuilder().registerTypeAdapter(type, new ItemDeserializer())
                .create();

        return new ResultList<>(gson.fromJson(jsonString, type));
    }

    /**
     * Parses the given {@link Response} instance into a {@link ResultList<Item>}.
     *
     * @param response Response instance.
     * @return ResultList of type Item.
     */
    public ResultList<Item> parse(Response response){
        Type type = new TypeToken<List<Item>>(){}.getType();
        Gson gson = new GsonBuilder().registerTypeAdapter(type, new ItemDeserializer()).create();

        return new ResultList<>(gson.fromJson(response.responseBody(), type));
    }

    /**
     * Parses the given JSON string into a {@link ResultList<T>} where T is the {@code model} value.
     *
     * @param jsonString json string to parse.
     * @param type {@link model.Item.ItemType} to search for.
     * @param model Item subclass to cast to.
     * @param <T> model to cast Item instances to.
     * @return a new {@link ResultList<T>}
     */
    public <T extends Item> ResultList<T> parseToModel(String jsonString, Item.ItemType type, Class<T> model){
        ResultList<Item> itemResults = parse(jsonString);
        return itemResults.getResultsOfType(type, model);
    }

    /**
     * Parses the given {@link Response} into a {@link ResultList<T>} where T is the {@code model} value.
     *
     * @param response Response instance.
     * @param type {@link model.Item.ItemType} to search for.
     * @param model Item subclass to cast to.
     * @param <T> model to cast Item instances to.
     * @return a new {@link ResultList<T>}
     */
    public <T extends Item> ResultList<T> parseToModel(Response response, Item.ItemType type, Class<T> model){
        ResultList<Item> itemResults = parse(response);
        return itemResults.getResultsOfType(type, model);
    }

}
