package org.excutar.util; // ALTERAÇÃO OBRIGATÓRIA: Mude o pacote para o novo nome

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static final String DRIVER = "org.postgresql.Driver";
    private static final String URL = "jdbc:postgresql://localhost:5432/hotifruti";
    private static final String USER = "postgres";
    private static final String PASS = "12345678";

    // Recomendação: Usar apenas SQLException no throws para simplificar o seu DAO
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException e) {
            throw new SQLException("Driver PostgreSQL não encontrado!", e);
        }
    }
}