package testDom;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLDisplay {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = null;
		Document dom = null;
		try {
			db = dbf.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		File file = new File("src/objectToXMLDemo.xml");
		try {
			dom = db.parse(file);
			dom.normalize();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		NodeList ageList = dom.getElementsByTagName("age");
		for (int i = 0; i < ageList.getLength(); i++) {
			/*
			 * node object can not use getNodeValue() directly to get text,
			 * 1.getFirstChild().getNodeValue(); 2.getTextContent();
			 */
			System.out.println("age node[" + i + "]:"
					+ ageList.item(i).getNodeName() + ",value:"
					// + ageList.item(i).getFirstChild().getNodeValue());
					+ ageList.item(i).getTextContent());
		}
		
//		get root element
		NodeList childList = dom.getChildNodes();
		for (int i = 0; i < childList.getLength(); i++) {
			System.out.println("node name:" + i + "-"
					+ childList.item(i).getNodeName());
			childList.item(i).normalize();
			NodeList subList = childList.item(i).getChildNodes();
			for (int j = 0; j < subList.getLength(); j++) {
				System.out.println("sub node:" + subList.item(j).getNodeName()
						+ ",value:" + subList.item(j).getTextContent());

			}
		}
//		get root element
		Element eleRoot = dom.getDocumentElement();
		System.out.println("eleRoot name:" + eleRoot.getNodeName());
		NodeList nodeList = eleRoot.getChildNodes();
		for (int i = 0; i < nodeList.getLength(); i++) {
			String nodeName = nodeList.item(i).getNodeName();
			short type = nodeList.item(i).getNodeType();
			System.out.println("node name:" + nodeName);
			System.out.println("node type:" + type);
			if (nodeName != null && !nodeName.startsWith("#")) {
				System.out.println("non-# node name:" + nodeName);
				System.out.println("non-# node value:" + nodeList.item(i).getTextContent());
			}
		}
	}

}
