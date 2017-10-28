package controller;

import model.Word;

import javax.xml.namespace.QName;
import javax.xml.stream.*;
import javax.xml.stream.events.XMLEvent;
import java.io.*;
import java.nio.file.Files;
import java.util.List;

public class GlossaryStAXParser {
    private File file;
    private File file2;
    private Word word = null;
    private boolean w = false;//tag word
    private boolean v = false;//tag value

    public GlossaryStAXParser() {
        file = new File("D:\\Ilya\\MyProg\\Remembering Words\\src\\main\\resources\\data.xml");
        file2 = new File("D:\\Ilya\\MyProg\\Remembering Words\\src\\main\\resources\\copyData.xml");

        try {
            if (file2.isFile())
                file2.createNewFile();

            Files.copy(file.toPath(), file2.toPath());    //копируем файл
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Word readRecord() {
        XMLInputFactory factory = XMLInputFactory.newInstance();

        //local variables
        int num;//number of values; attribute of tag values
        int count = 0;//counter for values which was read

        try {
            XMLStreamReader reader = factory.createXMLStreamReader(new FileInputStream(file));
            int event = reader.getEventType();
            boolean flag = true;
            while (reader.hasNext() & flag) {

                switch (event) {
                    case XMLStreamConstants.START_ELEMENT:
                        if (reader.getLocalName().equals("record")) {
                            word = new Word();
                        } else if (reader.getLocalName().equals("word")) {
                            w = true;
                        } else if (reader.getLocalName().equals("values")) {
                            num = Integer.parseInt(reader.getAttributeValue(0));
                        } else if (reader.getLocalName().equals("value")) {
                            if (!v)
                                v = true;
                            count++;
                        }
                        break;
                    case XMLStreamConstants.CHARACTERS:
                        if (w) {
                            word.setWord(reader.getText());
                            w = false;
                        } else if (v) {
                            word.addValue(reader.getText());
                            count--;
                            if (count == 0)
                                v = false;
                        }
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        if (reader.getLocalName().equals("record")) {
                            flag = false;
                        }

                }
                event = reader.next();
            }

        } catch (XMLStreamException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return word;
    }

    public Word findRecordById(int _id) {
        XMLInputFactory factory = XMLInputFactory.newInstance();

        //local variables
        int num;//number of values; attribute of tag values
        int count = 0;//counter for values which was read
        int id;

        try {
            XMLStreamReader reader = factory.createXMLStreamReader(new FileInputStream(file));

            int event = reader.getEventType();
            boolean flag = true;

            while (reader.hasNext() & flag) {

                switch (event) {
                    case XMLStreamConstants.START_ELEMENT:
                        if (reader.getLocalName().equals("record")) {
                            id = Integer.parseInt(reader.getAttributeValue(0));
                            if (id == _id)
                                word = new Word();
                            else break;
                        } else if (reader.getLocalName().equals("word")) {
                            w = true;
                        } else if (reader.getLocalName().equals("values")) {
                            num = Integer.parseInt(reader.getAttributeValue(0));
                        } else if (reader.getLocalName().equals("value")) {
                            if (!v)
                                v = true;
                            count++;
                        }
                        break;
                    case XMLStreamConstants.CHARACTERS:
                        if (w) {
                            word.setWord(reader.getText());
                            w = false;
                        } else if (v) {
                            word.addValue(reader.getText());
                            count--;
                            if (count == 0)
                                v = false;
                        }
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        if (reader.getLocalName().equals("record")) {
                            flag = false;
                        }

                }
                event = reader.next();
            }

        } catch (XMLStreamException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return word;
    }

    public Word findLastRecord() {
        XMLInputFactory factory = XMLInputFactory.newInstance();

        //local variables
        int num;//number of values; attribute of tag values
        int count = 0;//counter for values which was read
        String end;//if "t" - last item, if "f" - not last
        int id;

        try {
            XMLStreamReader reader = factory.createXMLStreamReader(new FileInputStream(file));
            int event = reader.getEventType();
            boolean flag = true;
            while (reader.hasNext() & flag) {

                switch (event) {
                    case XMLStreamConstants.START_ELEMENT:
                        if (reader.getLocalName().equals("record")) {
                            end = reader.getAttributeValue(1);
                            if (end.equals("t")) {
                                id = Integer.parseInt(reader.getAttributeValue(0));
                                word = new Word();
                            } else break;
                        } else if (reader.getLocalName().equals("word")) {
                            w = true;
                        } else if (reader.getLocalName().equals("values")) {
                            num = Integer.parseInt(reader.getAttributeValue(0));
                        } else if (reader.getLocalName().equals("value")) {
                            if (!v)
                                v = true;
                            count++;
                        }
                        break;
                    case XMLStreamConstants.CHARACTERS:
                        if (w) {
                            word.setWord(reader.getText());
                            w = false;
                        } else if (v) {
                            word.addValue(reader.getText());
                            count--;
                            if (count == 0)
                                v = false;
                        }
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        if (reader.getLocalName().equals("record")) {
                            flag = false;
                        }

                }
                event = reader.next();
            }

        } catch (XMLStreamException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return word;
    }

    public void addRecordVersion1(Word w) {

        boolean flag = true;
        boolean endRec = false;

        try {
            XMLInputFactory inFactory = XMLInputFactory.newInstance();
            XMLEventReader eventReader = inFactory.createXMLEventReader(new FileInputStream(file2));

            XMLOutputFactory outFactory = XMLOutputFactory.newInstance();
            XMLEventWriter eventWriter = outFactory.createXMLEventWriter(new FileWriter(file));

            XMLEventFactory eventFactory = XMLEventFactory.newInstance();

            XMLEvent event = eventReader.nextEvent();//шапка xml-файла
            eventWriter.add(event);

            while (eventReader.hasNext() | flag) {
                event = eventReader.nextEvent();

                if (event.getEventType() == XMLEvent.START_ELEMENT ) {
                    if(event.asStartElement().getName().getLocalPart().equalsIgnoreCase("record")){
                        if(event.asStartElement().getAttributeByName(new QName("endRec")).getValue().equals("t")){
                            endRec = true;

                            eventWriter.add(eventFactory.createStartElement("", null, "record"));
                            eventWriter.add(eventFactory.createAttribute("id",
                                    event.asStartElement().getAttributeByName(new QName("id")).getValue()));
                            eventWriter.add(eventFactory.createAttribute("endRec", "f"));

                            event = eventReader.nextEvent();
                        }
                    }


                }

                eventWriter.add(event);

                if (event.getEventType() == XMLEvent.END_ELEMENT ){
                    if(event.asEndElement().getName().getLocalPart().equalsIgnoreCase("record")){
                        if (endRec){
                            eventWriter.add(eventFactory.createStartElement("", null, "record"));
                            eventWriter.add(eventFactory.createAttribute("id", "1"));

                            eventWriter.add(eventFactory.createStartElement("", null, "word"));
                            eventWriter.add(eventFactory.createCharacters("I"));
                            eventWriter.add(eventFactory.createEndElement("", null, "word"));

                            eventWriter.add(eventFactory.createStartElement("", null, "values"));
                            eventWriter.add(eventFactory.createStartElement("", null, "value"));

                            eventWriter.add(eventFactory.createAttribute("id", "0"));
                            eventWriter.add(eventFactory.createCharacters("я"));

                            eventWriter.add(eventFactory.createEndElement("", null, "value"));
                            eventWriter.add(eventFactory.createEndElement("", null, "values"));

                            eventWriter.add(eventFactory.createEndElement("", null, "record"));

                            flag = false;
                        }
                    }
                }
            }
            eventWriter.close();
            file2.deleteOnExit();

        } catch (XMLStreamException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addRecordVersion2(Word w){
        boolean flag = true;

        try {
            XMLInputFactory inFactory = XMLInputFactory.newInstance();
            XMLEventReader eventReader = inFactory.createXMLEventReader(new FileInputStream(file.getAbsoluteFile()));

            XMLOutputFactory outFactory = XMLOutputFactory.newInstance();
            XMLStreamWriter writer = outFactory.createXMLStreamWriter(new FileOutputStream(file, true));

            while (eventReader.hasNext() | flag){
                XMLEvent event = eventReader.nextEvent();
                if (event.getEventType() == XMLEvent.START_ELEMENT ){
                    if (event.asStartElement().getName().toString().equals("glossary")){
                        //write word:
                        writer.writeStartElement("record");
                        writer.writeStartElement("word");
                        writer.writeCharacters(w.getWord());
                        writer.writeEndElement();

                        //write values for word:
                        writer.writeStartElement("values");
                        List<String> vs = w.getValues();
                        int numValues = vs.size();
                        writer.writeAttribute("num", Integer.toString(numValues));

                        for(String v : vs){
                            writer.writeStartElement("value");
                            writer.writeAttribute("id", Integer.toString(vs.indexOf(v)));
                            writer.writeCharacters(v);
                            writer.writeEndElement();
                        }

                        writer.writeEndElement();

                        flag = false;
                    }
                }

            }


        } catch (XMLStreamException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
