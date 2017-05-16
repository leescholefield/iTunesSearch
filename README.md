Wrapper around the iTunes Search Api

This library utilizes Gson to parse the JSON response into classes representing each result type. The result type
is determined by the "wrapperType" and "kind". I have tried to follow the definitions set by iTunes when defining class
inheritance. Consequently, some relationships between classes may be unclear. For example, FeatureMovie extends Track.

## Example usage

This uses the built in SimpleHttpRequest to handle sending the request.

``` java

    Request request = new RequestBuilder("creedence").limit(10).country("GB").newAlbumRequest();

    Response response = request.sendRequest();

    ResultList<Album> albums = new Parser().parseToModel(response, Item.ItemType.ALBUM, Album.class);
```


