package de.telekom.sea.seminar;

public class VerwaltungsGruppe extends BaseObject implements MyList, EventRegistration {

	public int listSize = 13; // gesamte ArrayLaenge
	public int count = 0; // Anzahl der angemeldeten Objekte
	private Object[] liste = new Object[listSize]; // Array liste erstellen arraylaenge4 -> String0,1,2,3

	private EventListener eventlistener;

	public void subscribe(EventListener eventlistener) {
		this.eventlistener = eventlistener;
	}

	public boolean add(Object einTeilnehmer) { // add Methode
		if (count < listSize) {
			liste[count] = einTeilnehmer; // belege den ersten freien Platz
			count++;

			Event event = new Event();
			event.setDescription("Teilnehmer hinzugefügt");
			if (eventlistener != null) {
				eventlistener.receive(event);
			}
			return true;
		} else {
			return false;
		}

	}

	public int size() { // size gibt aus wieviele angemeldet sind
		return count;
	}

	public Object get(int i) { // gibt einen Wert zurück wenn innerhalb der ArrayLänge

		if (i < listSize) {
			return liste[i];
		} else
			throw new RuntimeException("der Wert ist außerhalb der ArrayLaenge");

		// return null;
	}

	public boolean remove(Object obj) {
		if (count == 0) {
			return false;
		}
		for (int i = 0; i < count - 1; i++) {

			if (obj == liste[i]) {
				liste[i] = liste[count - 1];
				liste[count - 1] = null;
				count--;
				return true;
			}
		}

		if (obj == liste[count - 1]) {
			liste[count - 1] = null;
			count--;
			return true;
		}

		return false;
	}

	public MyList sublist(String searchtext) {
		MyList sublist = new VerwaltungsGruppe();
		for (int i = 0; i < listSize ; i++) {
			if ( this.get(i) != null ) {
				Person person = (Person) this.get(i);
				boolean answer = person.getVorname().startsWith(searchtext);
				if ( answer ) {
					sublist.add(person);
				} else {
					answer = person.getNachname().startsWith(searchtext);
					if ( answer ) {
						sublist.add(person);
					}
				}
			}
		}
		return sublist;
	}
	
	
	
	/*
	
	public MyList sublist(String searchtext) {
		MyList sublist = new VerwaltungsGruppe();
		for (int i = 0; i < listSize; i++) {
			
			if (this.get(i) != null) {
							
			Object test = this.get(i);
			Person testPerson = (Person) test;
			String vorname = testPerson.getVorname();
			boolean antwort = vorname.startsWith(searchtext);

			System.out.println("List Size: " + listSize);
			System.out.println("Test: " + test);
			System.out.println("TestPerson: " + testPerson);
			System.out.println("antwort: " + antwort);
			System.out.println("vorname: " + vorname);
			System.out.println("antwort: " + antwort);

			if (antwort) {
				sublist.add(testPerson);
			}
		}
		}
			
		return sublist;
	}
*/



	public void clear() {
		this.count = 0;
		liste = new Object[listSize];

		Event event = new Event();
		event.setDescription("Alle Teilnehmer gelöscht");
		eventlistener.receive(event);

	}

}