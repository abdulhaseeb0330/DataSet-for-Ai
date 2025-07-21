import java.sql.*;
import dbconnectlab.*;
public class SymptomDatabaseHandler {
    String url = "jdbc:sqlserver://127.0.0.1;instanceName=MSSQLSERVERNEW;databaseName=HealthDB;encrypt=true;trustServerCertificate=true";
    String user = "sa";
    String password = "123";
    Connection con;
    public SymptomDatabaseHandler() throws SQLException {
        con = DriverManager.getConnection(url, user, password);
    }
    public void insertToDatabase(String name, String symptom, String medicine) throws SQLException {
        String query = "Insert into  SymptomMedicine (name, symptom, medicine) values (?,?,?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, name);
        ps.setString(2, symptom);
        ps.setString(3, medicine);
        ps.executeUpdate();
    }
    public void displayFromDatabase() throws SQLException {
        String query = "select * from SymptomMedicine";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        System.out.println("name symptom mediine");

        while (rs.next()) {
            System.out.println(rs.getString("name")  +
                    rs.getString("symptom") +
                    rs.getString("medicine"));
        }
    }
    public void searchBySymptom(String symptom) throws SQLException {
        String query = "select name, medicine from SymptomMedicine where symptom = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, symptom);
        ResultSet rs = ps.executeQuery();
        boolean found = false;
        while (rs.next()) {
            System.out.println("Name" + rs.getString("name") + "Medicine: " + rs.getString("medicine"));
            found = true;
        }
        if (!found) {
            System.out.println("Symptom not found");
        }
    }
    public void searchByMedicine(String medicine) throws SQLException {
        String query = "select name, symptom from SymptomMedicine where medicine = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, medicine);
        ResultSet rs = ps.executeQuery();
        boolean found = false;

        while (rs.next()) {
            System.out.println("Name" + rs.getString("name") + "\tSymptom" + rs.getString("symptom"));
            found = true;
        }

        if (!found) {
            System.out.println("Medicine not found");
        }
    }
}