package controller;

import model.Word;
import model.WordValue;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Илья on 22.06.2017.
 */
public class Addition {

    private File putWord;
    private FileOutputStream fileStream;
    private ObjectOutputStream os;

    public Addition(String fname) throws IOException {
        putWord = new File(fname);
        fileStream = new FileOutputStream(putWord);
        os = new ObjectOutputStream(fileStream);
    }

    public void addWordInFile(Word wrd) throws IOException {
        os.writeObject(wrd);
    }

    public void addValueInFile(WordValue wrdValue) throws IOException {
        os.writeObject(wrdValue);
    }

    public void addValuesInFile(ArrayList<WordValue> wvs) {
        try {
            for (WordValue wv : wvs) {
                addValueInFile(wv);
            }
        } catch (IOException ex) {
            Logger.getLogger(Addition.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setFileName(String fn) throws IOException {
        putWord = new File(fn);
        fileStream = new FileOutputStream(putWord);
        os = new ObjectOutputStream(fileStream);
    }

    public void close_file() throws IOException {
        os.close();
    }
}
