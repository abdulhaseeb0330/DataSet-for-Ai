import dbconnectlab.*;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            DBManager mgr=new DBManager();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}