package org.pb.webserver;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author boge.peng
 * @create 2018-12-14 23:32
 */
public class XmlTest {
    public static void main(String[] args) {
        try {
            //1.获取解析工厂
            SAXParserFactory factory = SAXParserFactory.newInstance();
            //2.从解析工厂获取解析器
            SAXParser parser = factory.newSAXParser();
            //3.加载文档Document注册处理器
            PersonHandler handler = new PersonHandler();
            parser.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream
                    ("persons.xml"), handler);
            List<Person> persons = handler.getPersons();
            for (Person person : persons) {
                System.out.println(person);
            }

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}

class PersonHandler extends DefaultHandler {
    private static final String PERSONS = "persons";
    private static final String PERSONS_PERSON = "person";
    private static final String PERSONS_PERSON_NAME = "name";
    private static final String PERSONS_PERSON_AGE = "age";
    private static final String PERSONS_PERSON_GENDER = "gender";

    private List<Person> persons;
    private Person person;
    private String tag;

    @Override
    public void startDocument() throws SAXException {
        persons = new ArrayList<>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println(qName + "---->解析开始");
        if (!Objects.equals(null, qName)) {
            tag = qName;
        }

        if (Objects.equals(qName, PERSONS_PERSON)) {
            person = new Person();
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String contents = String.valueOf(ch, start, length).trim();

        if (Objects.equals(tag, PERSONS_PERSON_NAME)) {
            person.setName(contents);
        }
        if (Objects.equals(tag, PERSONS_PERSON_AGE)) {
            person.setAge(Integer.valueOf(contents));
        }
        if (Objects.equals(tag, PERSONS_PERSON_GENDER)) {
            person.setGender(contents);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println(qName + "---->解析结束");

        if (Objects.equals(qName, PERSONS_PERSON)) {
            persons.add(person);
        }

        tag = null;
    }


    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
    }

    public List<Person> getPersons() {
        return persons;
    }
}
