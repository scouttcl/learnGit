package testDom;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Links {

	private List<Link> link;
	
//	constructor
	public Links(){
		super();
	}
	public Links(List<Link> list){
		this.link = list;
	}

	@XmlElement
	public List<Link> getLink() {
		return link;
	}

	public void setLink(List<Link> linkList) {
		this.link = linkList;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		create a Links object
		Link link1 = new Link("002", "baidu", "www.baidu.com", "Li Yanhong",
				new Date("1", "January", 2001), "search engine");
		Link link2 = new Link("003", "taobao", "www.taobao.com", "Ma Yun",
				new Date("2", "January", 2002), "electricity supplier");
		List<Link> list = new ArrayList<Link>();
		list.add(link1);
		list.add(link2);
		Links links = new Links(list);
		
//		write this Links object to a XML file named Links.xml
		File file = new File("src/links.xml");
		try {
			JAXBContext context = JAXBContext.newInstance(Links.class);
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.setProperty(Marshaller.JAXB_ENCODING, "Cp1252");
			marshaller.marshal(links, file);
			marshaller.marshal(links, System.out);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
