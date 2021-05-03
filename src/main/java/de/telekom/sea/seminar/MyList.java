package de.telekom.sea.seminar;
public interface MyList extends EventRegistration{
	
	public boolean add(Object object);
	
	public int size();
	
	public Object get(int i);
	
	public boolean remove(Object object);
	
	public void clear();
	
}
