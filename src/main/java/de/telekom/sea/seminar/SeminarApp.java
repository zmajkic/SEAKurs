package de.telekom.sea.seminar;

public class SeminarApp {

	public Object parent;

	public void run(String[] args) {
		Person child = new Person();
		child.setParent(this);  // create a child in this Method

		System.out.println("Hello World");
	}

}
