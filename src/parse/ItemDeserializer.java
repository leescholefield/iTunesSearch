package parse;

import com.google.gson.*;

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

            if ("track".equals(wrapperType)){
                Item track = gson.fromJson(element, Item.class);
                itemList.add(track);
            }
        }

        return itemList;
    }
}
