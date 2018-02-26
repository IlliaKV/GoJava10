package httpandwebapipractica;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class YouTubeAPI {
    public static final String API_KEY = "AIzaSyCrVQPr-LRlFYQkpipjrY0x1HGYAwoP7E8";

    public static String getActivities(String channelId, int maxResults, String publishedAfter) throws UnirestException {
        HttpResponse<String> response = Unirest.get("https://www.googleapis.com/youtube/v3/activities")
                .queryString("key", API_KEY)
                .queryString("maxResults", maxResults)
                .queryString("channelId", channelId)
                .queryString("part", "snippet,contentDetails")
                .queryString("publishedAfter", publishedAfter)
                .asString();
        return response.getBody();
    }
}
