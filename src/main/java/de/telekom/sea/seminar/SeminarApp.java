package de.telekom.sea.seminar;

public class SeminarApp extends Child{



	private static SeminarApp thisInstance;

	// Constructor enthält Refernzvariable
	public SeminarApp() {
		thisInstance = this;
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
