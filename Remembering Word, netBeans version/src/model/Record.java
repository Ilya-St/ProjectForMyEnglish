/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;


/**
 *
 * @author Илья
 */
public class Record {
    private String name;//слово
    private ArrayList<String> values;//перевод
    private Date dateSeance;//дата сеанса
    private int numValues;//количество значений для слова
    private int localId;//номер перевода в группе
    
    public Record(String n, String[] v, Date d, int nv, int li){
        name = n;
        values = new ArrayList<>();
        values.addAll(Arrays.asList(v));
        dateSeance = d;
        numValues = nv;
        localId = li;
    }

    public Record(String name, ArrayList<String> values, Date dateSeance, int numValues, int localId) {
        this.name = name;
        this.values = values;
        this.dateSeance = dateSeance;
        this.numValues = numValues;
        this.localId = localId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getValues() {
        return values;
    }

    public void setValues(ArrayList<String> values) {
        this.values = values;
    }

    public Date getDateSeance() {
        return dateSeance;
    }

    public void setDateSeance(Date dateSeance) {
        this.dateSeance = dateSeance;
    }

    public int getNumValues() {
        return numValues;
    }

    public void setNumValues(int numValues) {
        this.numValues = numValues;
    }

    public int getLocalId() {
        return localId;
    }

    public void setLocalId(int localId) {
        this.localId = localId;
    }

    @Override
    public String toString() {
        return name + ";" + values + ";" + dateSeance + ";" + numValues + ";" + localId + ".";
    }
    
    
}
