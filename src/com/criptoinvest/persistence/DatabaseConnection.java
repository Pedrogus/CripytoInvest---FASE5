package com.criptoinvest.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {


    //private  static final String URL = "jdbc:mysql://localhost:3306/cripto_db";
    private  static final String URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl";
    private  static final String USER = System.getenv("DB_USER");
    private  static final String PASS = System.getenv("DB_PASS");


    public static Connection getConnection() throws SQLException {
        Connection conn = DriverManager.getConnection(URL, USER, PASS);;
        System.out.println("Conexão com o banco de dados estabelecida com sucesso!");
        System.out.println(conn.getCatalog());
        return conn;
    }



}
