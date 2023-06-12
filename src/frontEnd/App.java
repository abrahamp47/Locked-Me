package frontEnd;

import java.nio.file.*;
import java.util.*;

public class App {
    static Scanner sn = new Scanner(System.in);
    static String directory = "/Users/abphilip/Downloads/LOCKEDME-MAIN";

    public static void info() {
        String appHeader = "****************************************************\n" +
                "************* Welcome to LockedMe.com *************\n" +
                "****************************************************\n";
        String developerName = "Dev - Abraham Philip\n";
        String developerEmail = "DevEmail - abrahamphilip47@gmail.com\n";
        String appDetails = "You can use this application to:\n" +
                "--> Retrieve all file names in a given folder\n" +
                "--> Add, delete or search files\n";

        System.out.println(appHeader);
        System.out.println(developerName);
        System.out.println(developerEmail);
        System.out.println(appDetails);
    }

    public static void mainMenu() {
        System.out.println("");
        System.out.println("Main Menu");
        System.out.println("Press 1 to show files in ascending order");
        System.out.println("Press 2 to perform file operations");
        System.out.println("Press 3 to exit the application");

        int choice = sn.nextInt();
        handle(choice);
    }

    public static void handle(int num) {
        switch (num) {
            case 1:
                Ascending.ascendingOrder(directory);
                break;
            case 2:
                Operations.fileOperations(directory);
                break;
            case 3:
                System.out.println("Terminated :(");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid input");
        }
        mainMenu();
    }

    public static void main(String[] args) {
        info();
        mainMenu();
    }
}
