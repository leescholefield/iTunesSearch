package parse;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import model.Item;

import java.lang.reflect.Type;
import java.util.List;


/**
 *
 */
public class Parser {

    /**
     * Parses the given JSON string into a ResultList of Item instances.
     *
     * @param jsonString json string to parse.
     * @return ResultList of type Item instance.
     */
    public ResultList<Item> parse(String jsonString){
        Type type = new TypeToken<List<Item>>(){}.getType();
        Gson gson = new GsonBuilder().registerTypeAdapter(type, new ItemDeserializer())
                .create();

        return new ResultList<>(gson.fromJson(jsonString, type));
    }

    /**
     * Utility method for automatically parsing a JSON string into Item subclasses.
     *
     * @param jsonString json string to parse.
     * @param type ItemType to search for.
     * @param model Item subclasses to cast to.
     * @param <T> model to cast Item instances to.
     * @return a new ResultList of type T.
     */
    public <T extends Item> ResultList<T> parseToModel(String jsonString, Item.ItemType type, Class<T> model){
        ResultList<Item> itemResults = parse(jsonString);
        return itemResults.getResultsOfType(type, model);
    }


}
