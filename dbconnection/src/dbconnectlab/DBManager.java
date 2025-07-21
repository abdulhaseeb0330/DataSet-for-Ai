package dbconnectlab;

import java.sql.*;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;

public class DBManager {
    Connection con=null;
    Statement stmt=null;
    public DBManager() throws SQLException{


        DriverManager.registerDriver(new SQLServerDriver());
        //initializtion of conncection class object
        String url="jdbc:sqlserver://127.0.0.1;instanceName=MSSQLSERVERNEW;databaseName=BIIT;" +
                "encrypt=true;trustServerCertificate=true";// databaseName=your database name
        con=DriverManager.getConnection(url,"sa","123");                         //
        stmt=con.createStatement();
        System.out.println("Connection established");

    }
    public void insertUpdateDelete(String query) throws SQLException{

        stmt.execute(query);

    }
    public ResultSet select(String query) throws SQLException{

        ResultSet rs= stmt.executeQuery(query);
        return rs;

    }
    
}
