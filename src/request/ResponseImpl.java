package request;

import java.io.IOException;

/**
 * A simple implementation of the {@link Response} interface. This is the default implementation that the library
 * will use.
 */
class ResponseImpl implements Response {


    private Request request; // not final since nextPage uses it to avoid creating a new Response instance.
    private final String responseBody;


    ResponseImpl(Request request, String responseBody){
        this.request = request;
        this.responseBody = responseBody;
    }

    /**
     * Returns the {@link Request} instance passed via the constructor with the offset value incremented by
     * the 'limit' value.
     */
    @Override
    public Request nextPageRequest(){
        request = request.nextPageRequest();
        return request;
    }

    /**
     * Utility method for getting the next page of results.
     *
     * @return a new {@link Response} instance representing the next page of results.
     */
    @Override
    public Response nextPage() throws IOException{
         request = request.nextPageRequest();
         return request.sendRequest();
    }

    /**
     * @return the Json text as a String.
     */
    @Override
    public String responseBody(){
        return responseBody;
    }

    /**
     * @return the {@link Request} instances current offset value.
     */
    @Override
    public int getCurrentPageNumber(){
        return request.getCurrentOffset();
    }


}
