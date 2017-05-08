package parse;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import model.Item;
import org.junit.Test;

import java.io.File;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Tests whether the ItemDeserializer correctly parses each of the Item implementations.
 */
public class ItemDeserializerTest {

    private ItemDeserializer deserializer = new ItemDeserializer();

    private String readFile(String path){
        try {
            java.net.URL url = ItemDeserializerTest.class.getResource(path);
            return new java.util.Scanner(new File(url.toURI()), "UTF8").useDelimiter("\\Z").next();
        } catch (Exception e){
            return null;
        }
    }

    /**
     * Tests whether ItemDeserializer correctly parses JSON into a Song object.
     */
    @Test
    public void isSong(){
        String textContent = readFile("data/type_examples");
        JsonElement obj = new JsonParser().parse(textContent);
        JsonElement song = obj.getAsJsonObject().get("song");

        List<Item> response = deserializer.deserialize(song, Item.class, null);

        assertEquals(response.get(0).getType(), Item.ItemType.SONG);

    }

    /**
     * Tests whether ItemDeserializer correctly parses JSON into an Artist object.
     */
    @Test
    public void isArtist(){
        String textContent = readFile("data/type_examples");
        JsonElement obj = new JsonParser().parse(textContent);
        JsonElement artist = obj.getAsJsonObject().get("artist");

        List<Item> response = deserializer.deserialize(artist, Item.class, null);

        assertEquals(response.get(0).getType(), Item.ItemType.ARTIST);

    }

    /**
     * Tests whether ItemDeserializer correctly parses JSON into an Audiobook object.
     */
    @Test
    public void isAudiobook(){
        String textContent = readFile("data/type_examples");
        JsonElement obj = new JsonParser().parse(textContent);
        JsonElement audiobook = obj.getAsJsonObject().get("audiobook");

        List<Item> response = deserializer.deserialize(audiobook, Item.class, null);

        assertEquals(response.get(0).getType(), Item.ItemType.AUDIOBOOK);
    }

}