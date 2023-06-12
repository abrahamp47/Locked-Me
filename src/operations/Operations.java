package operations;

import java.io.*;
import java.nio.file.*;
import java.util.*;

import frontEnd.App;

public class Operations {
    static Scanner sn = new Scanner(System.in);

    public static void fileOperations(String directory) {
        System.out.println("");
        System.out.println("Press 1 to add a file");
        System.out.println("Press 2 to delete a file");
        System.out.println("Press 3 to search for a file");
        System.out.println("Press 4 to go back to the main menu");

        int choice = sn.nextInt();
        sn.nextLine(); // Consume newline character

        handle(choice, directory);
    }

    public static void handle(int num, String directory) {
        switch (num) {
            case 1:
                System.out.println("You selected Add Operation");
                addFile(directory);
                break;
            case 2:
                System.out.println("You selected Delete Operation");
                deleteFile(directory);
                break;
            case 3:
                System.out.println("You selected Search Operation");
                searchFile(directory);
                break;
            case 4:
                System.out.println("Going back to the Main Menu");
                App.main(null);
                break;
            default:
                System.out.println("Invalid input");
        }
        fileOperations(directory);
    }

    public static void addFile(String directory) {
        System.out.println("Enter the file path (e.g., /path/to/file.txt)");
        String input = sn.nextLine();
        Path path = Paths.get(input);

        if (!Files.exists(path)) {
            System.out.println("No such file exists");
            return;
        }

        String newPath = directory + "/" + path.getFileName();
        int i = 0;
        while (Files.exists(Paths.get(newPath))) {
            i++;
            newPath = directory + "/" + i + "_" + path.getFileName();
        }

        try {
            Files.copy(path, Paths.get(newPath));
            System.out.println("File has been stored");
        } catch (IOException e) {
            System.out.println("Unable to store the file");
            System.out.println(e);
        }
    }

    public static void deleteFile(String directory) {
        System.out.println("Enter the file name to delete (e.g., file.txt)");
        String input = sn.nextLine();
        String path = directory + "/" + input;
        File file = new File(path);

        if (!file.exists()) {
            System.out.println("No such file exists, cannot be deleted");
            return;
        }

        if (file.delete()) {
            System.out.println("File is deleted");
        } else {
            System.out.println("Unable to delete the file");
        }
    }

    public static void searchFile(String directory) {
        System.out.println("Enter the file name to search (e.g., file.txt)");
        String input = sn.nextLine();
        String path = directory + "/" + input;
        File file = new File(path);

        if (!file.exists()) {
            System.out.println("No such file exists");
        } else {
            System.out.println("File is present");
        }
    }
}
