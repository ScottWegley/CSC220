package FinalProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBManager {

    static Connection con;
 
    public DBManager(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void triggerSessionUpdate(long sessionID, int p1Score, int p2Score) {
        try {
            PreparedStatement stmt = con.prepareStatement("INSERT INTO RPS_RECORDS VALUES(?,?,?)");
            stmt.setLong(1, sessionID);
            stmt.setInt(2, p1Score);
            stmt.setInt(3, p2Score);
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ResultSet retrieveRecord(long sessionID){
        try {
            Statement stmt = con.createStatement();
            return stmt.executeQuery("SELECT * FROM RPS_RECORDS WHERE SESSIONID=" + sessionID);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
