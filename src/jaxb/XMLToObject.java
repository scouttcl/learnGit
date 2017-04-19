package jaxb;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;


public class XMLToObject {

	public static void main(String[] args) {
		File file = new File("src/objectToXMLDemo.xml");
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(TestJAXB.class);
//			Unmarshaller: used to transform xml content to java object
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			TestJAXB jaxb = (TestJAXB)unmarshaller.unmarshal(file);
			System.out.println(jaxb.toString());
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
	}
}
