package com.threadedquery.auxiliar;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QueryDB extends Thread {

    private FileWR fwr;
    private String sql;

    public QueryDB(String sql) {

        this.sql = sql;
        fwr = new FileWR("test_file.dat");
    }

    public void process() throws SQLException, ClassNotFoundException, IOException {


        ResultSet rs = new ConexionBD().obtenerConexion().createStatement().executeQuery(sql);

        int columns = rs.getMetaData().getColumnCount();

        while (rs.next()) {

            String data = "";
            for (int i = 1; i < columns; i++) {

                data += rs.getString(i) + " | ";

            }

            String threadName = Thread.currentThread().getName();
            System.out.println(threadName);


            fwr.write(data + ": " + threadName + "\n");

        }

    }


    @Override
    public void run() {

        try {
            process();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
