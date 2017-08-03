package testIO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

public class LogInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String uid;
	private Date logDate = new Date();
//	private transient String pwd;
	private String pwd;

	public LogInfo(String uid, String passward) {
		this.uid = uid;
		this.pwd = passward;
	}

	public String toString() {
		String passward = null;
		if (this.pwd == null) {
			passward = "not set";
		} else {
			passward = this.pwd;
		}
		return "uid:" + this.uid + "\n" + "date:" + this.logDate + "\n"
				+ "passward:" + passward;
	}

	public static void main(String[] args) {
		LogInfo info = new LogInfo("Mike", "qwerty");
		System.out.println("LogInfo object:\n" + info.toString());
		try {
			ObjectOutputStream out = new ObjectOutputStream(
					new FileOutputStream("src/testLog.txt"));
			out.writeObject(info);
			if (out != null) {
				out.flush();
				out.close();
			}
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(
					"src/testLog.txt"));
			try {
				LogInfo info2 = (LogInfo) in.readObject();
				System.out.println("from testLog.txt file:\n"
						+ info2.toString());
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
