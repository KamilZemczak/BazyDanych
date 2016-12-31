package Zadanie3;

import java.sql.*;

/**
 *
 * @author Kamil Zemczak
 */
public class BDPolaczenie {

    private static final String DB_URL = "jdbc:mysql://localhost/njpo";
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_USER = "uzytkownik1";
    private static final String DB_PASS = "haslo1";

    private static BDPolaczenie inst;
    private Connection con;

    public static synchronized BDPolaczenie getConnector() throws SQLException {
        if (inst == null) {
            inst = new BDPolaczenie();
        }

        return inst;
    }

    private BDPolaczenie() throws SQLException {
        try {
            Class.forName(JDBC_DRIVER);
            con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
        } catch (SQLException e) {
            throw e;
        } catch (Exception e) {
            System.out.println("Wystąpił nieoczekiwany błąd przy próbie połączenia się z bazą danych: " + e.getMessage());
        }
    }

    public Connection getPolaczenie() {
        return con;
    }
    
    public synchronized ResultSet wykonajZapytanie(String query) throws SQLException {
        try(PreparedStatement qr = con.prepareStatement(query)){
            try(ResultSet result = qr.executeQuery(query)){
                return result;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw ex;
        }
    }
    
    public synchronized int wykonajAktualizacje(String query){
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
