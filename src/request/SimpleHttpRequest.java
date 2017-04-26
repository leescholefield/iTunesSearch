package request;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

/**
 *  Used by the RequestImpl class as the default way to send a request to the iTunes Search Api.
 */
class SimpleHttpRequest {

    Response sendRequest(Request request) throws IOException{
        URL url = new URL(request.createUrl());
        InputStream is = url.openStream();

        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder result = new StringBuilder();
        String line;

        while((line = reader.readLine()) != null){
            result.append(line);
        }

        return new ResponseImpl(request, result.toString());
    }
}
