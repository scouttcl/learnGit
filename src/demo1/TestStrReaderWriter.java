package demo1;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Locale;

public class TestStrReaderWriter {

	public static void main(String[] args) {
		String demoStr = "demostring abc";
		StringReader sr = new StringReader(demoStr);
		StringWriter sw = new StringWriter();
		
		char[] chars = new char[1024];
		int length = 0;
		int resultChar = 0;
		String strRead = null;
		try {
			
//			while((length = sr.read(chars)) != -1){
//				strRead = new String(chars,0,length).toUpperCase(Locale.ENGLISH);
//				System.out.println(strRead);
//				sw.write(strRead);
//				sw.flush();
//			}
			
			while((resultChar = sr.read()) != -1){
				strRead = new String(String.valueOf((char)resultChar)).toUpperCase(Locale.ENGLISH);
				System.out.print(strRead);
				sw.write(strRead);
				sw.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			sr.close();
			try {
				sw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
