package jaxb;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlList;
import javax.xml.bind.annotation.XmlRootElement;

import com.sun.xml.internal.txw2.annotation.XmlElement;

@XmlRootElement
public class TestJAXB {

	private String id;
	private String name;
	private int age;
	private String location;

	private List<String> device;

	@XmlAttribute
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@XmlElement
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@XmlElement
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@XmlElement
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	// @XmlElementWrapper(name="devices")
	@XmlElement
	public List<String> getDevice() {
		return device;
	}

	public void setDevice(List<String> device) {
		this.device = device;
	}

	public String toString() {
		return "id=" + this.getId() + ", name=" + this.getName() + ", age="
				+ this.getAge() + ", location=" + this.getLocation()
				+ ", deviceList=" + this.getDevice();
	}

}
