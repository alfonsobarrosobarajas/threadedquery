package com.threadedquery;

import com.threadedquery.auxiliar.QueryDB;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        String nombre;
        Scanner input = new Scanner(System.in);

        Thread customerThread = new QueryDB("select * from customers");
        Thread paymentsThread = new QueryDB("select * from payments");

        customerThread.start();
        paymentsThread.start();

        System.out.println("Nombre: ");
        nombre = input.next();

        System.out.println("Hola " + nombre + "!");


        String g = "alfonsobarrosobarajas@gmail.com";
        String str = g.replaceAll("@", "[at]");

        System.out.println(str);
    }
}
