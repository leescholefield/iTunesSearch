package request;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 *
 */
public class RequestImplTest {

    private static final Map<Request.Keys, String> testParam = new LinkedHashMap<>();
    static{
        testParam.put(Request.Keys.TERM, "history");
        testParam.put(Request.Keys.MEDIA, "podcast");
        testParam.put(Request.Keys.LIMIT, "150");
        testParam.put(Request.Keys.EXPLICIT, "No");
    }


    /**
     * Tests the private implementation of createUrl(), rather than the public parameter-less version, because RequestImpl
     * uses a HashMap to store the Keys and their values which does not preserve insertion order. This makes it difficult
     * to test String equality.
     */
    @Test
    public void createUrl() throws Exception {
        String expected = "https://itunes.apple.com/search?&term=history&media=podcast&limit=150&explicit=No&offset=0";
        String actual = RequestImpl.createUrl(testParam, 0);

        assertEquals(expected, actual);

    }

}