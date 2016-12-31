package Zadanie1;

import java.sql.*;

/**
 *
 * @author Kamil Zemczak
 */
public class Polaczenie {

    private static final String DB_URL = "jdbc:mysql://localhost/njpo";
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_USER = "admin";
    private static final String DB_PASS = "admin2";

    private static Polaczenie inst;
    private Connection con;

    public static synchronized Polaczenie getConnector() throws SQLException {
        if (inst == null) {
            inst = new Polaczenie();
        }
        return inst;
    }

    private Polaczenie() throws SQLException {
        try {
            Class.forName(JDBC_DRIVER);
            con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
        } catch (SQLException e) {
            throw e;
        } catch (Exception e) {
            System.out.println("Wystąpił nieoczekiwany błąd przy próbie połączenia się z bazą danych: " + e.getMessage());
        }
    }

    public Connection getConnection() {
        return con;
    }
    
    public synchronized ResultSet exeQuery(String query) throws SQLException {
        try(PreparedStatement qr = con.prepareStatement(query)){
            try(ResultSet result = qr.executeQuery(query)){
                return result;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw ex;
        }
    }
    
    public synchronized int exeUpdate(String query){
        int result;
        
        try(Statement sttmnt = con.createStatement();) {
            result = sttmnt.executeUpdate(query);
        }
        catch(SQLException ex){
            result = -1;
        }

        return result;
    }
}
