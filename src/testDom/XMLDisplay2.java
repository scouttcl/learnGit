package testDom;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

public class XMLDisplay2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = null;
		File file = null;
		Document doc = null;
		try {
			builder = dbf.newDocumentBuilder();
			file = new File("src/Link.xml");
			doc = builder.parse(file);
			doc.normalize();
			// get root element
			Element root = doc.getDocumentElement();
			// get root element attribute:id
			String id = root.getAttribute("id");
			System.out.println("id=" + id);
			// get child elements
			Element author = (Element) root.getElementsByTagName("author")
					.item(0);
			Element date = (Element) root.getElementsByTagName("date").item(0);
			Element date_day = (Element) date.getElementsByTagName("day").item(
					0);
			Element date_month = (Element) date.getElementsByTagName("month")
					.item(0);
			Element date_year = (Element) date.getElementsByTagName("year")
					.item(0);
			Element description = (Element) root.getElementsByTagName(
					"description").item(0);
			Element text = (Element) root.getElementsByTagName("text").item(0);
			Element url = (Element) root.getElementsByTagName("url").item(0);
			// get child element values
			System.out.println("author={" + author.getTextContent() + "}");
			System.out.println("date={" + date_year.getTextContent() + "-"
					+ date_month.getTextContent() + "-"
					+ date_day.getTextContent() + "}");
			System.out.println("description={" + description.getTextContent() + "}");
			System.out.println("text={" + text.getTextContent() + "}");
			System.out.println("url={" + url.getTextContent() + "}");
		} catch (ParserConfigurationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
