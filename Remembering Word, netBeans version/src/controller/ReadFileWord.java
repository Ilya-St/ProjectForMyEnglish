package controller;

import Security.ExceptionWordNotFound;
import model.Word;

import java.io.IOException;
import java.util.Date;
import java.util.HashSet;

/**
 * Created by Илья on 24.07.2017.
 */
public class ReadFileWord extends ReadFile {
    private Word wrd;
    private HashSet<Word> set;//множество без дубликатов

    public ReadFileWord() throws IOException {
        super("D:\\Ilya\\MyProg\\Remembering Word, netBeans version\\sources\\data\\Word.dat");
        set = new HashSet<>();
    }

    public Word readWord() throws IOException, ClassNotFoundException {
        wrd = (Word) is.readObject();
        return wrd;
    }

    //прочитать слово по id
    public Word readWord(int id) throws IOException, ClassNotFoundException, ExceptionWordNotFound {
        int count = 0;

        while ((wrd = (Word) is.readObject())!= null){
            if(wrd.getId() == id){
                count++;
                break;
            }
        }

        if(count==0)
            throw new ExceptionWordNotFound(id);

        return wrd;
    }

    //(прочитать слово по слову)проверить наличие слова в словаре
    public Word checkWord(String w) throws IOException, ClassNotFoundException, ExceptionWordNotFound {
        int count = 0;

        while ((wrd = (Word) is.readObject())!= null){
            if(wrd.getWord() == w){
                count++;
                break;
            }
        }

        if(count==0){
            //return false;
            wrd.setWord("wnf");//W - word, N - not, F - found
            //throw new ExceptionWordNotFound(wrd.getWord());
        }
            
        return wrd;//true;
    }

    //прочитать слово по дате
    public Word readWord(Date date) throws IOException, ClassNotFoundException, ExceptionWordNotFound {
        int count = 0;

        while ((wrd = (Word) is.readObject())!= null){
            if(wrd.getDateSeance() == date){
                count++;
                break;
            }
        }

        if(count==0)
            throw new ExceptionWordNotFound();

        return wrd;
    }

    //прочитать 10 слов в множество с начала
    public HashSet<Word> read10Word() throws IOException, ClassNotFoundException {
        return read10Word(0);
    }

    //ПЕРЕДЕЛАТЬ
    //прочитать 10 слов в множество с опрделенного индекса
    public HashSet<Word> read10Word(int indexStart) throws IOException, ClassNotFoundException {
        //переставить коретку на indexStart объект
        for(int i=0; i<indexStart;i++){
            readWord();
        }

        for (int i=0;i<10 || readWord()!=null;i++){
            set.add(wrd);
        }

        return set;
    }
}
