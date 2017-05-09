package parse;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.File;
import java.io.IOException;

/**
 * Utility methods for reading a file and converting it into a JsonElement.
 */
class TestUtil {


    static String readFile(String path){
        try {
            java.net.URL url = ItemDeserializerTest.class.getResource(path);
            return new java.util.Scanner(new File(url.toURI()), "UTF8").useDelimiter("\\Z").next();
        } catch (Exception e){
            return null;
        }
    }

    static JsonElement getJsonElement(String type) throws IOException, IllegalArgumentException{
        String content = readFile("data/type_examples");
        if (content == null){
            throw new IOException("Could not open file");
        }

        JsonElement obj = new JsonParser().parse(content);
        JsonElement elem = obj.getAsJsonObject().get(type);
        if (elem == null){
            throw new IllegalArgumentException(type + " is not a recognized type");
        }

        return elem;
    }
}
