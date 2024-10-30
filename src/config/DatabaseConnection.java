package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection{
    private static final String URL = "jdbc:SQLite:banco_de_dados_da_galera.db";

    public static Connection getConnection(){
        try{
            return DriverManager.getConnection(URL);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}













