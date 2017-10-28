package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.RandomAccessFile;

/**
 * Created by Илья on 23.07.2017.
 */
public class ReadFile {
    protected File fileName;//путь к файлу
    //protected RandomAccessFile inputStream;
    protected FileInputStream inputStream;
    protected ObjectInputStream is;

    public ReadFile(String fn) throws IOException {
        fileName = new File(fn);
        //inputStream = new RandomAccessFile(fileName, "r");
        inputStream = new FileInputStream(fileName);
        is = new ObjectInputStream(inputStream);
    }
}
