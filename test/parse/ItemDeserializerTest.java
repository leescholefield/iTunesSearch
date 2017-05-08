package parse;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import model.Item;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;
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

    private JsonElement getJsonElement(String type) throws IOException, IllegalArgumentException{
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

    /**
     * Tests whether ItemDeserializer correctly parses JSON into a Song object.
     */
    @Test
    public void isSong() throws Exception{
        JsonElement song = getJsonElement("song");

        List<Item> response = deserializer.deserialize(song, Item.class, null);

        assertEquals(response.get(0).getType(), Item.ItemType.SONG);

    }

    /**
     * Tests whether ItemDeserializer correctly parses JSON into an Artist object.
     */
    @Test
    public void isArtist() throws Exception{
        JsonElement artist = getJsonElement("artist");

        List<Item> response = deserializer.deserialize(artist, Item.class, null);

        assertEquals(response.get(0).getType(), Item.ItemType.ARTIST);

    }

    /**
     * Tests whether ItemDeserializer correctly parses JSON into an Audiobook object.
     */
    @Test
    public void isAudiobook() throws Exception{
        JsonElement audiobook = getJsonElement("audiobook");

        List<Item> response = deserializer.deserialize(audiobook, Item.class, null);

        assertEquals(response.get(0).getType(), Item.ItemType.AUDIOBOOK);
    }

}