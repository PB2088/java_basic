package org.pb.xml;

import org.dom4j.*;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.*;
import java.util.Iterator;

/**
 * @author boge.peng
 * @create 2018-12-29 14:14
 */
public class TestXxml {
    public static void main(String[] args) {
        //parseXml();
        generateXml();
    }

    private static void parseXml() {
        SAXReader saxReader = new SAXReader();
        try {
            Document document = saxReader.read(Thread.currentThread().getContextClassLoader().getResourceAsStream("book.xml"));
            //System.out.println(document);
            Element rootElement = document.getRootElement();
            System.out.println(rootElement.getName()+"----");

            Iterator<Element> bookIterator = rootElement.elementIterator();

            while (bookIterator.hasNext()) {
                Element book = bookIterator.next();
                System.out.println(book.getName()+"----");

                Element name = book.element("name");
                System.out.println(name.getName()+"----"+name.getText());

                Element author = book.element("author");
                System.out.println(author.getName()+"----"+author.getText());

                Element price = book.element("price");
                System.out.println(price.getName()+"----"+price.getText());

                System.out.println("=============这是一条华丽的分割线============");
            }


        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    private static void generateXml() {
        Document document = DocumentHelper.createDocument();

        Element rootElement = document.addElement("persons");
        Element person = rootElement.addElement("person");
        person.addAttribute("id","p001");

        Element name = person.addElement("name");
        name.addText("波波");

        Element age = person.addElement("age");
        age.addText("22");

        Element gender = person.addElement("gender");
        gender.addText("男");

        Writer writer = null;
        //writer = new FileWriter("xml_demo" + File.separator + "person.xml");
        writer = new BufferedWriter(new OutputStreamWriter(System.out));

        OutputFormat prettyPrint = OutputFormat.createPrettyPrint();
        XMLWriter xmlWriter = new XMLWriter(writer,prettyPrint);

        try {
            xmlWriter.write(document);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
