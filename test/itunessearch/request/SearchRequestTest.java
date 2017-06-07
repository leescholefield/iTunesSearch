package request;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 */
public class SearchRequestTest {

    private static final Map<String, String> testParam = new LinkedHashMap<>();
    static{
        testParam.put(RequestKeys.SearchKeys.TERM, "history");
        testParam.put(RequestKeys.SearchKeys.MEDIA, "podcast");
        testParam.put(RequestKeys.SearchKeys.LIMIT, "150");
        testParam.put(RequestKeys.SearchKeys.EXPLICIT, "No");
    }


}