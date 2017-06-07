package itunessearch.request;

import java.io.IOException;

/**
 *
 */
public interface Response {

    /**
     * Returns a Request instance for the next page.
     */
    Request nextPageRequest();

    /**
     * Convenience method for getting the next page in a Paginated itunessearch.request.
     */
    Response nextPage() throws IOException;

    /**
     * Returns the http response body as a String.
     */
    String responseBody();

    /**
     * Returns the current page number.
     */
    int getCurrentPageNumber();

}
