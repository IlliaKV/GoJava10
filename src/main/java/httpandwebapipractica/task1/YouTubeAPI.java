package httpandwebapipractica.task1;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class YouTubeAPI {
    public static final String API_KEY = "AIzaSyCrVQPr-LRlFYQkpipjrY0x1HGYAwoP7E8";

    public static String Search(String videoId, int maxResults) throws UnirestException {
        HttpResponse<String> response = Unirest.get("https://www.googleapis.com/youtube/v3/commentThreads")
                .queryString("key", API_KEY)
                .queryString("part", "snippet,replies")
                .queryString("maxResults", maxResults)
                .queryString("videoId", videoId)
                .asString();
        return response.getBody();
    }
}
