package main;

import java.util.Map;

/**
 *
 */
public class ResponseImpl implements Response {


    private final Map<RequestImpl.Keys, String> paramMap;
    private final String responseBody;

    protected ResponseImpl(Map<RequestImpl.Keys, String> paramMap, String responseBody){
        this.paramMap = paramMap;
        this.responseBody = responseBody;
    }

    @Override
    public RequestImpl nextPageRequest(){
        int currentPage = getCurrentPageNumber();

        replaceOffset(currentPage++);

        return new RequestImpl(paramMap);
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
        String s_offset = paramMap.get(RequestImpl.Keys.OFFSET);
        int i_offset = 0;

        if (s_offset != null){
            i_offset = Integer.valueOf(s_offset);
        }

        return i_offset;
    }

    private void replaceOffset(int newOffset){
        paramMap.put(RequestImpl.Keys.OFFSET, String.valueOf(newOffset));
    }


}
