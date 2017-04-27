package parse;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 *
 */
public class Parser {

    public List<Item> parse(String jsonString){
        Type type = new TypeToken<List<Item>>(){}.getType();
        Gson gson = new GsonBuilder().registerTypeAdapter(type, new ItemDeserializer())
                .create();

        List<Item> resultArray = gson.fromJson(jsonString, type);
        return resultArray;
    }


}
