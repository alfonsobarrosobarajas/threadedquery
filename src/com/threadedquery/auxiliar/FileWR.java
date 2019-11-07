package com.threadedquery.auxiliar;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWR {

    private File file;
    private FileWriter fw;
    private BufferedWriter bw;

    public FileWR(String fileName){
        file = new File(fileName);
    }

    public void write(String data) throws IOException {
        fw = new FileWriter(file, true);
        bw = new BufferedWriter(fw);

        bw.write(data);

        bw.close();
        fw.close();

    }
}
