package demo1;

import java.io.IOException;

import javax.xml.namespace.QName;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPBodyElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;

public class TestSOAP {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			//get soap message factory
			MessageFactory factory = MessageFactory.newInstance();
			//get soap message
			SOAPMessage message = factory.createMessage();
			//get soap part
			SOAPPart part = message.getSOAPPart();
			//get soap envelope
			SOAPEnvelope envelope = part.getEnvelope();
			//get soap body
			SOAPBody body = envelope.getBody();
			//create related nodes by a QName
			//<ns:add xmlns="http://www.abc.com/webservice" />
			QName qName = new QName("http://www.abc.com/webservice","add","ns");
			//set element, two ways
			/*
			 * 1.add body element and set related content with body element directly,
			 *  <> will be displayed as "&lt;" and "&gt;"
			 */
//			body.addBodyElement(qName).setValue("<a>11</a><b>33</b>");
			/*
			 * 2.add body element first, then add child element and set related values
			 */
			SOAPBodyElement bodyElement = body.addBodyElement(qName);
			bodyElement.addChildElement("a").setValue("11");
			bodyElement.addChildElement("b").setValue("33");
			//print message
			try {
				message.writeTo(System.out);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (SOAPException e) {
			e.printStackTrace();
		}

	}

}
