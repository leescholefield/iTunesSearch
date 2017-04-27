package parse;

/**
 * Base class for a deserialized result.
 */
public class Item {

    private String wrapperType;
    private String trackName;
    private String artistName;

    public String toString(){
        return trackName + " " + artistName;
    }
}
