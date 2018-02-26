package httpandwerapilection;

import com.mashape.unirest.http.exceptions.UnirestException;

public class Application {
    public static void main(String[] args) throws UnirestException {
        String response = YouTubeAPI.Search("cats", 5);
        System.out.println(response);
    }
}
