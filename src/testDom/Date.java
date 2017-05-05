package testDom;

import javax.xml.bind.annotation.XmlElement;

public class Date {

	private String day;
	private String month;
	private int year;

//	constructors
	public Date(){
		super();
	}
	public Date(String day,String month,int year){
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
//	getter and setter
	@XmlElement
	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	@XmlElement
	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	@XmlElement
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String toString() {
		return "day=" + this.getDay() + ", month="
				+ this.getMonth() + ", year=" + this.getYear();
	}

}
