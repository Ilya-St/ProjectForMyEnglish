package model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Илья on 18.07.2017.
 */
public class Word implements Serializable {
    private long id;
    private String word;
    private int numValues;
    private Date dateSeance;//дата последнего обновления

    public Word(long id, String word, int numValues, Date d) {
        this.word = word;
        this.id = id;
        this.numValues = numValues;
        this.dateSeance = d;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getNumValues() {
        return numValues;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Word word1 = (Word) o;

        if (id != word1.id) return false;
        if (numValues != word1.numValues) return false;
        if (!word.equals(word1.word)) return false;
        return dateSeance != null ? dateSeance.equals(word1.dateSeance) : word1.dateSeance == null;
    }

    @Override
    public int hashCode() {
        int result = word.length();
        result = 31 * result + word.hashCode();
        result = 31 * result + numValues;
        result = 31 * result + (dateSeance != null ? dateSeance.hashCode() : 0);
        return result;
    }

    public void setNumValues(int numValues) {
        this.numValues = numValues;
    }

    public Date getDateSeance() {

        return dateSeance;
    }

    public void setDateSeance(Date dateSeance) {
        this.dateSeance = dateSeance;
    }
}
