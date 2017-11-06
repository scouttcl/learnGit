package demo1;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class TestReflect implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -6495750534126479913L;
	private String name;
	private String city;
	private String carNo;

	// constructors
	public TestReflect() {
		super();
	}

	public TestReflect(String name, String city, String carNo) {
		this.name = name;
		this.city = city;
		this.carNo = carNo;
	}

	// getter and setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCarNo() {
		return carNo;
	}

	public void setCarNo(String carNo) {
		this.carNo = carNo;
	}
	
	@Override
	public String toString(){
		StringBuilder sbdr = new StringBuilder();
		sbdr.append("TestReflect object: ");
		sbdr.append("name-" + this.getName() + ", ");
		sbdr.append("city-" + this.getCity() + ", ");
		sbdr.append("carNo-" + this.getCarNo() + ", ");
		return sbdr.toString();
	}

	public static void main(String[] args) {
		// rule 1:create Class object with java bean object
		TestReflect reflectObj = new TestReflect();
		Class<?> clazz1 = reflectObj.getClass();
		System.out.println("class name: " + clazz1.getName());

		// rule 2:create Class object with java bean class
		Class<?> clazz2 = TestReflect.class;
		Class<?> superClazz = clazz2.getSuperclass();
		System.out.println("super class name: " + superClazz.getName());

		Class<?>[] interfaceClazzArr = clazz2.getInterfaces();
		for (int i = 0; i < interfaceClazzArr.length; i++) {
			System.out.println("TestReflect's interface: "
					+ interfaceClazzArr[i].getName());
		}

		// rule 3:create Class object with java bean class full name
		Class<?> clazz3 = null;
		try {
			clazz3 = Class.forName(clazz1.getName());

			// get constructor Class object
			Constructor<?>[] cons = clazz3.getConstructors();
			for (int i = 0; i < cons.length; i++) {
				System.out.print("cons[" + i + "](");
				
//				get constructor parameter type Class object
//				this solution can not ensure the order of them, so user cons[i].getConstructor() is better.
				/**
				 * demo:
				 * Constructor cons0 = demo.getConstructor();
		            Constructor cons1 = demo.getConstructor(String.class);
		            Constructor cons2 = demo.getConstructor(int.class);
		            Constructor cons3 = demo.getConstructor(String.class,int.class);
		             
		            Person per1 = (Person) cons0.newInstance();
		            Person per2 = (Person) cons1.newInstance("Rollen");
		            Person per3 = (Person) cons2.newInstance(20);
		            Person per4 = (Person) cons3.newInstance("Rollen", 20);
				 */
				Class<?>[] parameterTypes = cons[i].getParameterTypes();
				for (int j = 0; j < parameterTypes.length; j++) {
					if (j != parameterTypes.length - 1) {
						System.out.print(parameterTypes[j].getName() + ",");
					} else {
						System.out.print(parameterTypes[j].getName());
					}
				}
				System.out.println(")");
			}
//			TestReflect tr1 = (TestReflect) cons[0].newInstance();
			TestReflect tr2 = (TestReflect) cons[1].newInstance("007",
					"London", "SD2341");
			System.out.println(tr2.toString());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
//		compare 3 Class objects below
		System.out.println("clazz1 == clazz2?"+(clazz1 == clazz2));
		System.out.println("clazz2 == clazz3?"+(clazz2 == clazz3));
	}
}
