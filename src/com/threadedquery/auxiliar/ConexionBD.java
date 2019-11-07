package com.threadedquery.auxiliar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    private Connection connection;
    private String sql;

    public ConexionBD() throws ClassNotFoundException, SQLException {


        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/classicmodels",
                "root",
                "Root.1234"
        );


    }

    public Connection obtenerConexion() {
        return connection;
    }


}
