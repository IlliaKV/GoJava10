package httpandwebapipractica;

import com.mashape.unirest.http.exceptions.UnirestException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Main {
    static SimpleDateFormat fmt1 = new SimpleDateFormat("YYYY-MM-dd");
    static SimpleDateFormat fmt2 = new SimpleDateFormat("hh:mm:ss.sZ");//"2018-02-14T16:40:15.000Z"
    public static void main(String[] args) throws UnirestException {
        ArrayList<String> channelIds = new ArrayList<>();
        channelIds.add("UCvhDdAR0kvVWdGdhkMtXSSA");
        channelIds.add("UCuXYmUOJSbEH1x88WUV1aMg");
        final int N = 10;
        GregorianCalendar date = new GregorianCalendar();
        date.add(GregorianCalendar.DAY_OF_YEAR, -N);
        String dateFormatted = fmt1.format(date.getTime()) + "T" + fmt2.format(date.getTime());
        System.out.println(dateFormatted);

        String response = YouTubeAPI.getActivities(channelIds.get(0), 50, dateFormatted);
        System.out.println(response);
//        for (int i = 0; i < videoIds.size(); i++){
//            System.out.println("---------------------");
//            String response = YouTubeAPI.Search(videoIds.get(i), 50);
//            CommentThreadList commentThreadList = JSON.parseObject(response, CommentThreadList.class);
//            System.out.println(commentThreadList);
//            System.out.println("---------------------");
//        }
    }
}
