package com.RememberingWords.Main;

import controller.GlossaryStAXParser;
import model.Word;

public class Main {
    public static void main(String args[]){
        /*SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser();
            MyHandler myHandler = new MyHandler();
            parser.parse(new File("D:\\Ilya\\MyProg\\Remembering Words\\src\\main\\resources\\data"), myHandler);
            List<Word> l_Words = myHandler.getDictionary();
            for (Word w :l_Words) {
                System.out.println(w.toString() + "\n");
            }

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        GlossaryStAXParser parser = new GlossaryStAXParser();
        //System.out.println(parser.readRecord().toString());

        Word word = new Word("parser", "синтаксический анализатор");

        parser.addRecordVersion1(word);

        //parser.writeXmlBooks();

    }
}
