package httpandwebapipractica.task1;

import com.alibaba.fastjson.JSON;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.util.ArrayList;

public class Application {

    public static void main(String[] args) throws UnirestException {
        ArrayList<String> videoIds = new ArrayList<>();
        videoIds.add("VhzAfSPQQiU");
        videoIds.add("j_TNPDkZilE");
        videoIds.add("eaDaH1phC-8");

        for (int i = 0; i < 1; i++){
            System.out.println("---------------------");
            String response = YouTubeAPI.Search(videoIds.get(i), 100);
            CommentThreadList commentThreadList = JSON.parseObject(response, CommentThreadList.class);
            System.out.println(commentThreadList);
            System.out.println("---------------------");
        }


    }
}
