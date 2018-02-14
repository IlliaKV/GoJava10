package multithreadandstreamandweb;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;
import java.util.Scanner;

public class websitedownloader {

    public static ArrayList<String> readFile(String pathToFile){
        File file = new File(pathToFile);
        Scanner scanner = null;
        ArrayList<String> strings = new ArrayList<>();

        try {
            scanner = new Scanner(file);
            int i = 0;
            while (scanner.hasNext()){
                strings.add(scanner.nextLine());
                i++;
            }
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return strings;
    }
    public static void main(String[] args) throws IOException {
        ArrayList<String> links = new ArrayList<>();
        ArrayList<String> sites = new ArrayList<>();
        links = readFile("Files/multithreadandstreamandweb/links.txt");
        links.forEach(System.out::println);

        long timeStart;
        long timeEnd;

        for (int i = 0; i < links.size(); i++){
            timeStart = System.currentTimeMillis();
            URL website = new URL(links.get(i));
            ReadableByteChannel rbc = Channels.newChannel(website.openStream());
            FileOutputStream fos = new FileOutputStream("Files/cache/" + i);
            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);

            timeEnd = System.currentTimeMillis();
            System.out.println("\n Файл " + links.get(i) + " загружен [" + (timeEnd-timeStart) + "]\n");
        }


    }
}
