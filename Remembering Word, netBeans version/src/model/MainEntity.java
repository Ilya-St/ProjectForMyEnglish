package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

/**
 * Created by Илья on 25.06.2017.
 */
public class MainEntity implements Serializable {
    private String name;//слово
    private String[] value;//значения слова
    private ArrayList<String> translates;
    private Date dateSeance;//дата сеанса
    private long id;//порядковый номер слова для конкретного сеанса
    private int numValue;//количество значений для слова

    public MainEntity(String n, String[] v) {
        name = n;
        value = v;
        dateSeance = new Date();//должна ставиться дата начала сеанса
        coddingId();//id=
        numValue = value.length;
    }
    
    public MainEntity(String w, ArrayList<String> trs){
        name = w;
        translates = trs;
        dateSeance = new Date();
        coddingId();
        numValue = trs.size();
    }
    
    public MainEntity(Word w, ArrayList<WordValue> trs){
        name = w.getWord();
        for(WordValue v : trs){
            translates.add(v.getValue());
        }
        id = w.getId();
        dateSeance = w.getDateSeance();
        numValue = trs.size();
    }

    public MainEntity(WordValue val, Word w){
        this.name = w.getWord();
        this.id = w.getId();
        this.numValue = w.getNumValues();
        this.dateSeance = w.getDateSeance();

        value = new String[numValue];
        this.value[val.getIdInMass()] = val.getValue();
    }
    //добавить значение
    public void addValue(WordValue v){
        value[v.getIdInMass()] = v.getValue();
        this.dateSeance = new Date();//должно ставить текущее время
    }
    //геттер для слова
    public Word getWord(){
        return (new Word(id, name, numValue, dateSeance));
    }
    //геттер для значения
    public WordValue getWordValue(int index){
        return (new WordValue(value[index], id, index));
    }

    //получение id
    private void coddingId(){
        int temp;
        String t = /*name.substring(0, 2);*/"";
        char[] str = /*t.toCharArray();*/ name.toCharArray();

        for(int i=0; i<name.length(); i++){
            temp = str[i];
            t += Integer.toString(temp);
        }
        /*t += dateSeance.toString();
        for(int i=0;i<t.length();i++){
        
        if((temp = t.indexOf(":", i))!=-1 || (temp = t.indexOf(" ", i))!=-1){
        i=temp;
        t.re
        }
        }*/
                
        id = Long.parseLong(t);
    }

    public int getNumValue() {
        return numValue;
    }

    public long getId() {

        return id;
    }

    public Date getDateSeance() {

        return dateSeance;
    }

    public String[] getValue() {
        if(!translates.isEmpty())
            return translates.toArray(new String[translates.size()]);
        return value;
    }

    public String getName() {

        return name;
    }

    public String getValue(int indexVal) {
        if(!translates.isEmpty())
            return translates.get(indexVal);
        return value[indexVal];
    }
    
    public ArrayList<WordValue> getListValues(){
        ArrayList<WordValue> wvs = new ArrayList<>();
        
        if(translates.isEmpty()){
            for(int i =0; i<value.length;i++){
                wvs.add(this.getWordValue(i));
            }
        }
        else{
            for(String tr : translates){
                wvs.add(new WordValue(tr, id, translates.indexOf(tr)));
            }
        }
            
        return wvs;
    }
    
    public String getValuesInOne(){
        String allInOne = null;
        if(translates.isEmpty()){
            for(String s : value)
                allInOne += s + "; "; 
        }else{
            for(String s : translates)
                allInOne += s + "; ";
        }
        
        return allInOne;
    }
    
    public Vector<String> toVector(){
        Vector<String> v = new Vector<>();
        v.add(name);
        v.add(getValuesInOne());
        return v;
    }
}
