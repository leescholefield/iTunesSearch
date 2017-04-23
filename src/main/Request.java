package main;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents a main.Request to the iTunes Search Api.
 */
public class Request {

    public enum Keys {
        TERM,
        COUNTRY,
        MEDIA,
        ENTITY,
        ATTRIBUTE,
        LIMIT,
        LANG,
        VERSION,
        EXPLICIT;

        @Override
        public String toString() {
            return super.toString().toLowerCase();
        }
    }

    private final Map<Keys, String> paramMap;


    /**
     * Private constructor. Use one of the static constructor methods.
     */
    private Request(Map<Keys, String> requestParams){
        paramMap = requestParams;
    }

    public String createUrl(){
        final String urlBase = "https://itunes.apple.com/search?";

        StringBuilder builder = new StringBuilder();
        builder.append(urlBase);

        for (Map.Entry<Keys, String> entry : paramMap.entrySet()){
            builder.append("&" ).append(entry.getKey().toString()).append("=").append(entry.getValue());
        }

        return builder.toString();
    }


    public static class RequestFactory {

        private Map<Request.Keys, String> paramMap = new HashMap<>();

        public Request newRequest(){
            return new Request(paramMap);
        }

        public RequestFactory(String term){
            this.paramMap.put(Request.Keys.TERM, term);
        }

        public RequestFactory country(String country){
            this.paramMap.put(Request.Keys.COUNTRY, country);
            return this;
        }

        public RequestFactory media(String mediaType){
            this.paramMap.put(Request.Keys.MEDIA, mediaType);
            return this;
        }

        public RequestFactory entity(String entity){
            this.paramMap.put(Request.Keys.ENTITY, entity);
            return this;
        }

        public RequestFactory attribute(String attribute){
            this.paramMap.put(Request.Keys.ATTRIBUTE, attribute);
            return this;
        }

        public RequestFactory limit(int limit){
            if(limit >= 0 && limit <= 200){
                this.paramMap.put(Request.Keys.LIMIT, String.valueOf(limit));
                return this;
            }
            throw new IllegalArgumentException("limit must be between 0 and 200");
        }

        public RequestFactory language(String language){
            this.paramMap.put(Request.Keys.LANG, language);
            return this;
        }

        public RequestFactory version(int version){
            if(version == 1 || version == 2){
                this.paramMap.put(Request.Keys.VERSION, String.valueOf(version));
                return this;
            }
            throw new IllegalArgumentException("version must either be 1 or 2");
        }

        public RequestFactory explicit(boolean explicit){
            String val = "Yes";
            if(!explicit){
                val = "No";
            }
            this.paramMap.put(Request.Keys.EXPLICIT, val);
            return this;
        }
    } // end of factory class
}
