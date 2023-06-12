package ascending;

import java.io.*;
import java.util.*;

public class Ascending {
    public static void ascendingOrder(String directory) {
        File[] files = new File(directory).listFiles();
        Set<String> sortedFiles = new TreeSet<>();
        
        for (File file : files) {
            if (file.isFile()) {
                sortedFiles.add(file.getName());
            }
        }

        sortedFiles.forEach(System.out::println);
    }
}
