package data.xmlreader;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class XMLReader implements XMLGeneratorInterface, XMLParseInterface {

    private static Document myDocument;
    private static final int ZERO = 0;
    private static final String XML_EXTENSION = ".xml";

    private static final String CARD_TAG = "Card";
    private static final String SUIT_TAG = "Suit";
    private static final String VALUE_TAG = "Value";

    public XMLReader(File file) throws IOException, SAXException, ParserConfigurationException {
        myDocument = XMLGeneratorInterface.createDocument(file);
    }

    public XMLReader(String file) throws IOException, SAXException, ParserConfigurationException {
        myDocument = XMLGeneratorInterface.createDocument(new File(file));
    }

    // TODO - refactor, very similar to parsePlayers method
    private List<Pair> parseDeck(Document d) {
        List<Pair> list = new ArrayList<>();
        NodeList cardNodeList = d.getElementsByTagName(CARD_TAG);
        for (int index = 0; index < cardNodeList.getLength(); index ++) {
            Node cardNode = cardNodeList.item(index);
            Element cardElement = (Element) cardNode;
            String suit = getElement(cardElement, SUIT_TAG);
            String value = getElement(cardElement, VALUE_TAG);
            list.add(new Pair(suit, value));
        }
        return list;
    }

    private List<String> getXMLList(String metatag, String subtag) {
        List<String> list = new ArrayList<>();
        NodeList handNodeList = myDocument.getElementsByTagName(metatag);
        for (int index = 0; index < handNodeList.getLength(); index ++) {
            Node handNode = handNodeList.item(index);
            Element handElement = (Element) handNode;
            String name = getElement(handElement, subtag);
            list.add(name);
        }
        return list;
    }

    private String getElement(Element e, String tag) {
        return e.getElementsByTagName(tag).item(ZERO).getTextContent();
    }

}
