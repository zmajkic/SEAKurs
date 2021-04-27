package de.telekom.sea.seminar;

public class SeminarApp {

	private Object parent;
	
	private static SeminarApp thisInstance;
	
	public SeminarApp() {
		thisInstance = this; 
	}

	public Object getParent() {
		return parent;
	}

	public void setParent(Object parent) {
		this.parent = parent;
	}

	public void run(String[] args) {
		Person child = new Person();
		child.setParent(this); // create a child in this Method

		System.out.println("Hello World");
	}

	public static Object getRootApp() {
		return thisInstance;
	}

}
