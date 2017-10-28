package controller;

import model.WordValue;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Илья on 26.07.2017.
 */
public class ReadFileWordValue extends ReadFile {

    private WordValue wv;
    private ArrayList<WordValue> wvList;

    public ReadFileWordValue() throws IOException {
        super("D:\\Ilya\\MyProg\\Remembering Word, netBeans version\\sources\\data\\Translates.dat");
        wvList = new ArrayList<>();
    }

    //по id
    public WordValue readValue(int i) throws IOException, ClassNotFoundException, ExceptionWordNotFound {
        int count = 0;

        while ((wv = (WordValue) is.readObject())!= null){
            if(wv.getId() == i){
                count++;
                break;
            }
        }

        if(count==0)
            throw new ExceptionWordNotFound(i);

        return wv;
    }
    //по значению
    public WordValue readValue(String s) throws IOException, ClassNotFoundException, ExceptionWordNotFound {
        int count = 0;

        while ((wv = (WordValue) is.readObject())!= null){
            if(wv.getValue() == s){
                count++;
                break;
            }
        }

        if(count==0)
            throw new ExceptionWordNotFound(s);

        return wv;
    }
    //прочитать все значения для данного id
    public ArrayList<WordValue> readAllValues(long id) throws IOException, ClassNotFoundException, ExceptionWordNotFound {
        int count = 0;

        while ((wv = (WordValue) is.readObject())!= null){
            if(wv.getId() == id){
                wvList.add(wv);
                count++;
                break;
            }
        }

        if(count==0)
            throw new ExceptionWordNotFound(id);

        return wvList;
    }
}
