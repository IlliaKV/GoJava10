package jsonpracticalwork;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class LoadFile {
    public static String readUsingScanner(String pathToFile) throws IOException {
        File file = new File(pathToFile);
        Scanner scanner = new Scanner(file);
        String data = scanner.useDelimiter("\\Z").next();
        scanner.close();
        return data;
    }
}
