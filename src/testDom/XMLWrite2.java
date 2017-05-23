package testDom;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

public class XMLWrite2 {

	public static void main(String[] args) {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = null;
		Document doc = null;
		File file = new File("src/links.xml");
		try {
			builder = dbf.newDocumentBuilder();
			doc = builder.parse(file);
			doc.normalize();
			
//			create new link element
			Element linkEle = doc.createElement("link");
//			text content object
			Text textNode = null;
//			create attribute:id
			Attr id = doc.createAttribute("id");
			id.setValue("004");
			linkEle.setAttributeNode(id);
//			create text element
			Element textEle = doc.createElement("text");
			textNode = doc.createTextNode("qq");
			textEle.appendChild(textNode);
			linkEle.appendChild(textEle);
//			create url element
			Element urlEle = doc.createElement("url");
			textNode = doc.createTextNode("www.qq.com");
			urlEle.appendChild(textNode);
			linkEle.appendChild(urlEle);
//			create author element
			Element authorEle = doc.createElement("author");
			textNode = doc.createTextNode("Ma Huateng");
			authorEle.appendChild(textNode);
			linkEle.appendChild(authorEle);
//			create date element and its sub elements
			Element dateEle = doc.createElement("date");
			Element date_dayEle = doc.createElement("day");
			Element date_monthEle = doc.createElement("month");
			Element date_yearEle = doc.createElement("year");
			textNode = doc.createTextNode("8");
			date_dayEle.appendChild(textNode);
			textNode = doc.createTextNode("September");
			date_monthEle.appendChild(textNode);
			textNode = doc.createTextNode("1998");
			date_yearEle.appendChild(textNode);
			dateEle.appendChild(date_dayEle);
			dateEle.appendChild(date_monthEle);
			dateEle.appendChild(date_yearEle);
			linkEle.appendChild(dateEle);
//			create description element
			Element descriptionEle = doc.createElement("description");
			textNode = doc.createTextNode("weChat is populate");
			descriptionEle.appendChild(textNode);
			linkEle.appendChild(descriptionEle);
//			set new link element to document
			doc.getDocumentElement().appendChild(linkEle);
//			transform new link element to xml file
			TransformerFactory transFactory = TransformerFactory.newInstance();
			Transformer transformer = transFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(file);
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.transform(source, result);
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
		
	}
}
