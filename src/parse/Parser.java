package parse;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import model.Item;
import request.Response;

import java.lang.reflect.Type;
import java.util.List;


/**
 * Uses Gson to parse a Response into a ResultList.
 */
public class Parser {

    /**
     * Parses the given JSON string into a ResultList of Item instances.
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
     * Parses the given Response instance into a ResultList of Item instances.
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
     * Utility method for automatically parsing a JSON string into Item subclasses.
     *
     * @param jsonString json string to parse.
     * @param type ItemType to search for.
     * @param model Item subclass to cast to.
     * @param <T> model to cast Item instances to.
     * @return a new ResultList of type T.
     */
    public <T extends Item> ResultList<T> parseToModel(String jsonString, Item.ItemType type, Class<T> model){
        ResultList<Item> itemResults = parse(jsonString);
        return itemResults.getResultsOfType(type, model);
    }

    /**
     * Utility method for automatically parsing a JSON string into Item subclasses.
     *
     * @param response Response instance.
     * @param type itemType to search for.
     * @param model Item subclass to cast to.
     * @param <T> model to cast Item instances to.
     * @return a new ResultList of type T.
     */
    public <T extends Item> ResultList<T> parseToModel(Response response, Item.ItemType type, Class<T> model){
        ResultList<Item> itemResults = parse(response);
        return itemResults.getResultsOfType(type, model);
    }

}
