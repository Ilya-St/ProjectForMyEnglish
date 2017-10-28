package model;

import java.util.ArrayList;
import java.util.List;

public class Word {
    private String word;
    private List<String> values;

    public Word(){
        //word = null;
        values = new ArrayList<String>();
    }

    public Word(String word, List<String> values) {
        this.word = word;
        this.values = values;
    }

    public Word(String word, String value) {
        this.word = word;
        values = new ArrayList<String>();
        values.add(value);
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public List<String> getValues() {
        return values;
    }

    public void setValues(List<String> values) {
        this.values = values;
    }

    @Override
    public String toString() {
        return "Word:" + word + "\n" +
                "Values: " + values +
                "\n";
    }

    public void addValue(String val){
        values.add(val);
    }
}
