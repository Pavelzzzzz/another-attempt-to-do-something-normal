package com.pavelzzzzz.another_attempt_to_do_something_normal;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class SAXDemo {

  public static void main(String[] args) throws FileNotFoundException, XMLStreamException {
    XMLInputFactory factory = XMLInputFactory.newInstance();
    XMLStreamReader parser = factory.createXMLStreamReader(
        new FileInputStream("contact.html"));

    while (parser.hasNext()){
      if (parser.next() == XMLStreamConstants.START_ELEMENT){
        System.out.println(parser.getLocalName());
      }
    }
  }

}
