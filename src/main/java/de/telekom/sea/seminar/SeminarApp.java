package de.telekom.sea.seminar;

public class SeminarApp {

	private Object parent;

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

	public Object getRootApp() {
		return this;
	}

}
