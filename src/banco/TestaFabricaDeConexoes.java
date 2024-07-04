package banco;

import java.sql.Connection;
import java.sql.SQLException;

public class TestaFabricaDeConexoes {
    public static void main(String[] args) {
        Connection con = null;
        try {
            con = ConncetionFactory.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

