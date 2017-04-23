package test;

import main.Request;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests the {@link Request} class.
 */
public class RequestTest {

    @Test
    public void testCreateUrl(){
        Request.RequestFactory factory = new Request.RequestFactory("history");
        factory.media("podcast").explicit(true).limit(30);

        String actual = factory.newRequest().createUrl();
        String expected = "https://itunes.apple.com/search?&limit=30&term=history&media=podcast&explicit=Yes";

        assertEquals(actual, expected);
    }

}
