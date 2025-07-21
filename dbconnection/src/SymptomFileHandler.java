import java.io.*;
import java.util.*;

public class SymptomFileHandler {
    private final File file = new File("I:\\oop file handling\\id.txt");

    public void insertToFile(String name, String symptom, String medicine) throws IOException {
        FileWriter fw = new FileWriter(file, true);
        fw.write(name + "#" + symptom + "#" + medicine + "\n");
        fw.close();
    }

    public void displayFromFile() throws FileNotFoundException {
        if (!file.exists()) {
            System.out.println("No file data found.");
            return;
        }

        Scanner reader = new Scanner(file);
        System.out.println("name symptoms medicine");

        while (reader.hasNextLine()) {
            String line = reader.nextLine();
            String[] parts = line.split("#");
            if (parts.length == 3) {
                System.out.println(parts[0] +  parts[1] + parts[2]);
            }
        }
        reader.close();
    }
}
