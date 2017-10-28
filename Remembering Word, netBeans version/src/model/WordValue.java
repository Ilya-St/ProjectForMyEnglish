package model;

import java.io.Serializable;

/**
 * Created by Илья on 25.06.2017.
 */
public class WordValue implements Serializable{
    private String value;//значения слова
    private long id;//порядковый номер слова для конкретного сеанса
    private int idInMass;//индекс в массиве значений слова, нало нумерации с 0


    public WordValue(String value, long id, int IdInMass) {
        this.value = value;
        //this.dateSeance = dateSeance;

        this.id = id;
        this.idInMass = IdInMass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WordValue wordValue = (WordValue) o;

        if (id != wordValue.id) return false;
        if (!value.equals(wordValue.value)) return false;

        return true;
    }
    @Override
    public int hashCode() {
        int result = value.hashCode();
        result = 31 * result;
        return result;
    }

    public long getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValue() {

        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getIdInMass() {
        return idInMass;
    }

    public void setIdInMass(int idInMass) {
        this.idInMass = idInMass;
    }
}
