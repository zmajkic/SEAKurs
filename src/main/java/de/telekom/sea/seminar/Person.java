package de.telekom.sea.seminar;

public class Person extends BaseObject { // superKlasse

	private String vorname;
	private String nachname;
	
	
	public void abc(){
		System.out.println(getI());
		setI(3);  // this.setI() und super.setI() sind möglich
	}
	
	
	
	public String getVorname() {
		return vorname;
	}
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	public String getNachname() {
		return nachname;
	}
	public void setNachname(String nachname) {
		this.nachname = nachname;
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

		// this.equals(obj);
		if (!super.equals(obj)){
				return false;	
		}
		
		if (!(obj instanceof Person)) {      // ist es nicht derselbe Typ
			return false;
		}
	//	Person person = (Person) obj;
		
		
		// prüfen Vorname Nachname 
		System.out.println("");
		return true;
		
	}




		
}
