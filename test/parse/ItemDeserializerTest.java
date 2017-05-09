package parse;

import com.google.gson.JsonElement;
import model.Item;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static parse.TestUtil.getJsonElement;

/**
 * Tests whether the ItemDeserializer correctly parses each of the Item implementations.
 */
public class ItemDeserializerTest {

    private ItemDeserializer deserializer = new ItemDeserializer();

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