package com.threadedquery;

import com.threadedquery.auxiliar.QueryDB;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Thread customerThread = new QueryDB("select * from customers");
        Thread paymentsThread = new QueryDB("select * from payments");

        customerThread.start();
        paymentsThread.start();

    }
}
