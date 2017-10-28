package controller;

import model.Word;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MyHandler extends DefaultHandler {
    private List<Word> dictionary = null;
    private Word wrd = null;

    private boolean word = false;
    private boolean value = false;

    Date date;//date
    int id;
    int numValues;//number of values for word

    public List<Word> getDictionary() {
        return dictionary;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        if (qName.equalsIgnoreCase("record")){
            //date = new Date(attributes.getValue("date"));
            id = Integer.parseInt(attributes.getValue("id"));
            wrd = new Word();
        }
        else if (qName.equalsIgnoreCase("word")){
            word = true;
        }
        /*else if (qName.equalsIgnoreCase("values")){
            numValues = Integer.parseInt(attributes.getValue("num"));
        }*/
        else if (qName.equalsIgnoreCase("value"))
        {
            value = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (dictionary == null)
            dictionary = new ArrayList<Word>(1);
        if (qName.equalsIgnoreCase("record") | wrd != null)
            dictionary.add(wrd);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (word){
            wrd.setWord(new String(ch, start, length));
            word = false;
        }
        else if(value)
        {
            wrd.addValue(new String(ch, start, length));
            value = false;
        }

    }
}
