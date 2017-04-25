package main;

import java.util.Map;

/**
 *
 */
interface Response {

    /**
     * Returns a Request instance for the next page.
     */
    Request nextPageRequest();

    /**
     * Convenience method for getting the next page in a Paginated request.
     */
    Response nextPage();

    /**
     * Returns the http response body as a String.
     */
    String responseBody();

    /**
     * Returns the current page number.
     */
    int getCurrentPageNumber();

}
