package parse;

import com.google.gson.JsonElement;
import model.Item;
import model.track.Song;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static parse.TestUtil.getJsonElement;

import java.math.BigDecimal;
import java.util.List;

/**
 *
 */
public class SongDeserializer {

    private static Song model = null;

    @BeforeClass
    public static void getModel() throws Exception{
        ItemDeserializer deserializer = new ItemDeserializer();
        JsonElement elem = getJsonElement("song");
        List<Item> response = deserializer.deserialize(elem, Item.class, null);
        model = (Song)response.get(0);
    }

    /**
     *  Track fields.
     */

    @Test
    public void artistName() throws Exception{
        assertEquals(model.getArtistName(), "Jack Johnson");
    }

    @Test
    public void trackName() throws Exception {
        assertEquals(model.getTrackName(), "Better Together");
    }

    @Test
    public void trackCensoredName() throws Exception{
        assertEquals(model.getTrackCensoredName(), "Better Together");
    }

    @Test
    public void primaryGenreName() throws Exception {
        assertEquals(model.getPrimaryGenreName(), "Rock");
    }

    @Test
    public void trackViewUrl() throws Exception{
        assertEquals(model.getTrackViewUrl(), "https://itunes.apple.com/us/album/better-together/id879273552?i=879273565&uo=4");
    }

    @Test
    public void trackId() throws Exception{
        assertEquals(model.getTrackId(), 879273565);
    }

    @Test
    public void trackExplicitness() throws Exception{
        assertEquals(model.isTrackExplicit(), false);
    }

    @Test
    public void collectionExplcitness() throws Exception{
        assertEquals(model.isCollectionExplicit(), false);
    }

    @Test
    public void releaseDate() throws Exception{
        assertEquals(model.getReleaseDate(), "2005-03-01T08:00:00Z");
    }

    @Test
    public void currency() throws Exception{
        assertEquals(model.getCurrency(), "USD");
    }

    @Test
    public void trackPrice() throws Exception{
        assertEquals(model.getTrackPrice(), BigDecimal.valueOf(1.29));
    }

    @Test
    public void collectionPrice() throws Exception{
        assertEquals(model.getCollectionPrice(), BigDecimal.valueOf(8.99));
    }

    @Test
    public void country() throws Exception{
        assertEquals(model.getCountry(), "USA");
    }

    /**
     * Audio fields
     */

    @Test
    public void artistId() throws Exception {
        assertEquals(model.getArtistId(), 909253);
    }

    @Test
    public void collectionId() throws Exception{
        assertEquals(model.getCollectionId(),  879273552);
    }

    @Test
    public void collectionName() throws Exception{
        assertEquals(model.getCollectionName(), "In Between Dreams");
    }

    @Test
    public void artistViewUrl() throws Exception{
        assertEquals(model.getArtistViewUrl(), "https://itunes.apple.com/us/artist/jack-johnson/id909253?uo=4");
    }

    @Test
    public void collectionViewUrl() throws Exception{
        assertEquals(model.getCollectionViewUrl(), "https://itunes.apple.com/us/album/better-together/id879273552?i=879273565&uo=4");
    }

    @Test
    public void trackCount() throws Exception{
        assertEquals(model.getTrackCount(), 15);
    }

    /**
     * Record fields.
     */

    @Test
    public void previewUrl() throws Exception{
        assertEquals(model.getPreviewUrl(), "http://a25.phobos.apple.com/us/r30/Music6/v4/13/22/67/1322678b-e40d-fb4d-8d9b-3268fe03b000/mzaf_8818596367816221008.plus.aac.p.m4a");
    }

    @Test
    public void discCount() throws Exception{
        assertEquals(model.getDiscCount(), 1);
    }

    @Test
    public void discNumber() throws Exception{
        assertEquals(model.getDiscNumber(), 1);
    }

    @Test
    public void trackNumber() throws Exception{
        assertEquals(model.getTrackNumber(), 1);
    }

    @Test
    public void trackTimeMillis() throws Exception{
        assertEquals(model.getTrackTimeInMillis(), 207679);
    }

    /**
     * Song fields
     */

    @Test
    public void streamable() throws Exception{
        assertEquals(model.isStreamable(), true);
    }

    @Test
    public void collectionArtistName() throws Exception{
        assertEquals(model.getCollectionArtistName(), null);
    }

    @Test
    public void collectionArtistId() throws Exception{
        assertEquals(model.getCollectionArtistId(), 0);
    }

    @Test
    public void collectionArtistViewUrl() throws Exception{
        assertEquals(model.getCollectionArtistViewUrl(), null);
    }
}
