package jaxb;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class ObjectToXML {

	public static void main(String[] args) {
		TestJAXB jaxb = new TestJAXB();
		jaxb.setAge(21);
		jaxb.setId("100");
		jaxb.setName("Bob");
		jaxb.setLocation("America");
		List<String> deviceList = new ArrayList<String>();
		deviceList.add("ipad");
		deviceList.add("iphone");
		jaxb.setDevice(deviceList);
		
//		File file = new File("C:\\Users\\EMQRRVA\\Desktop\\objectToXMLDemo.xml");
		File file = new File("src/objectToXMLDemo.xml");
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(TestJAXB.class);
//			Marshaller: used to transform java object to xml content
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(jaxb, file);
			marshaller.marshal(jaxb, System.out);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
}
