import java.sql.*;
import java.util.*;

public class SymptomMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            SymptomFileHandler fileHandler = new SymptomFileHandler();
            SymptomDatabaseHandler dbHandler = new SymptomDatabaseHandler();

            while (true) {
                System.out.println("Symptom Medicine system");
                System.out.println("1 Add new");
                System.out.println("2 Display");
                System.out.println("3 Search by Symptom");
                System.out.println("4Search by Medicine");
                System.out.println("5 Exit");
                int choice = sc.nextInt();
                sc.nextLine();

                if (choice == 1) {
                    System.out.print("Enter Your Name");
                    String name = sc.nextLine();
                    System.out.print("Enter Symptom");
                    String symptom = sc.nextLine();
                    System.out.print("Enter Medicine");
                    String medicine = sc.nextLine();

                    fileHandler.insertToFile(name, symptom, medicine);
                    dbHandler.insertToDatabase(name, symptom, medicine);
                    System.out.println("Saved to file and database");

                } else if (choice == 2) {
                    System.out.print("1 fro DB 2 for File");
                    int opt = sc.nextInt();
                    if (opt == 1) dbHandler.displayFromDatabase();
                    else if (opt == 2) fileHandler.displayFromFile();
                    else System.out.println("Invalid option");

                } else if (choice == 3) {
                    System.out.print("Enter Symptom to Search");
                    String symptom = sc.nextLine();
                    dbHandler.searchBySymptom(symptom);

                } else if (choice == 4) {
                    System.out.print("Enter Medicine to Search");
                    String medicine = sc.nextLine();
                    dbHandler.searchByMedicine(medicine);

                } else if (choice == 5) {
                    System.out.println("Closed");
                    break;

                } else {
                    System.out.println("Invalid choice");
                }
            }

        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }

        sc.close();
    }
}
