package de.telekom.sea.seminar;

public class BaseObject extends Object {

	// explizite parent child Beziehung
	private Object parent;

	private int i;
	
	int j;
	
	public int getI() {
		return i;
	}

	protected void setI(int i) {
		this.i = i;
	}

	public Object getParent() {
		return parent;
	}

	public void setParent(Object parent) {
		this.parent = parent;
	}

	// vergabe neue unique ID je Instanz
	private long id;
	private static long idCounter = 1;

	public BaseObject() {
		this.id = idCounter++;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
		
	}
	
	
	@Override
	public String toString() {
		return ((Long) id).toString();
	}

	@Override
	public boolean equals(final Object obj) {
/*		if (obj == this) {                       // selbe Instanz
			return true;
		}
		if (obj == null) {                       // ist obj null
			return false;
		}
*/		
		if (!super.equals(obj)) {
			return false;
		}
		
		
		
		if (!(obj instanceof BaseObject)) {      // ist es nicht derselbe Typ
			return false;
		}
		BaseObject baseobject = (BaseObject) obj;// cast auf den Typ BaseObject
		return (baseobject.id == this.id);       // Inhaltsvergleich der id
	}

}











