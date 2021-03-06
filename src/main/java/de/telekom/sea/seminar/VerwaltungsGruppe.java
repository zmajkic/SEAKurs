package de.telekom.sea.seminar;

public class VerwaltungsGruppe extends BaseObject implements MyList, EventRegistration {

	public int arraylaenge = 14; // gesamte ArrayLaenge
	public int count = 0; // Anzahl der angemeldeten Objekte
	private Object[] liste = new Object[arraylaenge]; // Array liste erstellen arraylaenge4 -> String0,1,2,3

	private EventListener eventlistener;

	public void subscribe(EventListener eventlistener) {
		this.eventlistener = eventlistener;
	}

	public boolean add(Object einTeilnehmer) { // add Methode
		if (count < arraylaenge) {
			liste[count] = einTeilnehmer; // belege den ersten freien Platz
			count++;
			sendEvent("Teilnehmer hinzugefügt");
			return true;
		} else {
			return false;
		}
	}

	public int size() { // size gibt aus wieviele angemeldet sind
		return count;
	}

	public Object get(int i) { // gibt einen Wert zurück wenn innerhalb der ArrayLänge

		if (i < arraylaenge) {
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
				sendEvent("Ein Teilnehmer gelöscht");
				return true;
			}
		}

		if (obj == liste[count - 1]) {
			liste[count - 1] = null;
			count--;
			sendEvent("Ein Teilnehmer gelöscht");
			return true;
		}
		return false;
	}

	public void clear() {
		this.count = 0;
		liste = new Object[arraylaenge];
		sendEvent("Alle Teilnehmer gelöscht");
	}

	private void sendEvent(String description) {
		if (eventlistener != null) {
			Event event = new Event();
			event.setDescription(description);
			eventlistener.receive(event);
		}
	}

}