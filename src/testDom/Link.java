package testDom;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Link {

	private String id;
	private String text;
	private String url;
	private String author;
	private Date date;
	private String description;
	
//	constructors
	public Link(){
		super();
	}
	
	public Link(String id,String text,String url,String author,Date date,String description){
		this.id = id;
		this.text = text;
		this.url = url;
		this.author = author;
		this.date = date;
		this.description = description;
	}
	
//	getter and setter
	@XmlAttribute
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	@XmlElement
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	@XmlElement
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	@XmlElement
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	@XmlElement
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	@XmlElement
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String toString() {
		return "id=" + this.getId() + ", text=" + this.getText() + ", url="
				+ this.getUrl() + ", author=" + this.getAuthor() + ", date={"
				+ this.getDate() + "}, description=" + this.getDescription();
	}
	
	public static void main(String[] args) {
		File file = new File("src/Link.xml");
		Date date = new Date("5","May",2017);
		Link link = new Link("001","","github.com","scouttcl",date,"display link object");
		try {
			JAXBContext context = JAXBContext.newInstance(Link.class);
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(link, file);
			marshaller.marshal(link, System.out);
			System.out.println(link.toString());
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
}
