package httpandwebapihomework;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class YouTubeAPI {
    public static final String API_KEY = "AIzaSyCrVQPr-LRlFYQkpipjrY0x1HGYAwoP7E8";

    public static String Search(String channelId) throws UnirestException {
        HttpResponse<String> response = Unirest.get("https://www.googleapis.com/youtube/v3/videos")
                .queryString("key", API_KEY)
                .queryString("id", channelId)
                .queryString("part", "snippet,contentDetails,statistics")
                .asString();
        return response.getBody();
    }
}
