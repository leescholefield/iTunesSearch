package request;

/**
 *
 */
class ResponseImpl implements Response {


    private final Request request;
    private final String responseBody;


    ResponseImpl(Request request, String responseBody){
        this.request = request;
        this.responseBody = responseBody;
    }

    @Override
    public Request nextPageRequest(){
        return request.nextPageRequest();
    }

    @Override
    public Response nextPage(){
        return null;
    }

    @Override
    public String responseBody(){
        return responseBody;
    }

    @Override
    public int getCurrentPageNumber(){
        return request.getCurrentOffset();
    }


}
