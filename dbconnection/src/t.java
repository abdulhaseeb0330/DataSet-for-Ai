import java.io.*;

class SymptomChecker {

    public String findMedicine(String userSymptomString) throws Exception{
        String fileData = "";

        FileInputStream fis = new FileInputStream("I:\\oop file handling\\Symptoms.txt.txt");
        int ch;

        while ((ch = fis.read()) != -1) {
            fileData += (char) ch;
        }
        fis.close();

        String[] data1 = fileData.split("|");

        for (int i = 0; i < data1.length; i++) {
            String[] data2 = data1[i].split("#");
            if (data2.length == 2) {
                String fileSymptoms = data2[0];
                String medicine = data2[1];

                if (fileSymptoms.equals(userSymptomString)) {
                    return medicine;
                }
            }
        }

        return "symptom not fuond";
    }

    public void addNewEntry(String symptomLine, String medicine) throws Exception {
        String newEntry = "|" + symptomLine + "#" + medicine;

        FileOutputStream fos = new FileOutputStream("I:\\oop file handling\\Symptoms.txt.txt", true);
        fos.write(newEntry.getBytes());
        fos.close();
        System.out.println("Newdata add successfully");

    }
}
