package main;

import java.util.Map;

/**
 *
 */
public class Response {

    private final Map<Request.Keys, String> paramMap;
    private final String responseBody;

    protected Response(Map<Request.Keys, String> paramMap, String responseBody){
        this.paramMap = paramMap;
        this.responseBody = responseBody;
    }


    public Request nextPageRequest(){
        int currentPage = getCurrentPageNumber();

        replaceOffset(currentPage++);

        return new Request(paramMap);
    }

    public String getResponseBody(){
        return responseBody;
    }

    private int getCurrentPageNumber(){
        String s_offset = paramMap.get(Request.Keys.OFFSET);
        int i_offset = 0;

        if (s_offset != null){
            i_offset = Integer.valueOf(s_offset);
        }

        return i_offset;
    }

    private void replaceOffset(int newOffset){
        paramMap.put(Request.Keys.OFFSET, String.valueOf(newOffset));
    }



}
