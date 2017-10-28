/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import model.Record;

/**
 *
 * @author Илья
 */
public class ReadWriteFile {
    protected File parth;//путь к файлу со словами
    protected RandomAccessFile wFile;
    protected ArrayList<Record> words;

    public ReadWriteFile() throws FileNotFoundException, IOException {
        parth = new File("D:\\Ilya\\MyProg\\Remembering Word, netBeans version\\sources\\data\\","Word.dat");
        if(parth.isFile())
            parth.createNewFile();
        wFile = new RandomAccessFile(parth, "rw");
        words = new ArrayList<>();
        
    }
    
    /*концепция: 2 файла:
    1 файл - данные о слове
    2ой файл - данные о позиции слова
    оба бинарные
    */
    
    //функции чтения и записи
    public void readAll(){
        
    }
    
    public void writeRecord(){
        
    }
    
    
}
