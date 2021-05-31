package de.telekom.sea.seminar;

public class VerwaltungsGruppe7 extends BaseObject implements MyList {
	//-- Variabeln-----------------------------------------------------------------------------------------------------	
	int maxobjectliste=15;												// maximale Anzahl an Objekten, derzeit auf 15 begrenzt
	private Object[] objectliste = new Object[maxobjectliste];			// Array von Objekten
	private int anzahl;													// Zaehler der Objekte 0 bis 14
//	private MyListener myListener;
	//-- Methoden------------------------------------------------------------------------------------------------------
	public boolean add(Object obj) {									// *Hinzufuegen eines Objektes in das Array (die Refernzadresse wird kopiert und nicht das Objekt) 
																		// Typ Object ist eine vordefinierte minimale Klasse in Java 
		if (anzahl==maxobjectliste) {									// Pruefung auf maximal gefuelltes Array
			throw new RuntimeException ( "\n\nDie Liste ist voll."			// RunTimeException
					+ " Es können keinen weiteren Teilnehmer hinzu"
					+ "gefügt werden.\n"
					+ "Die Anwendung wird beendet.\n" );					
		}												
		else {
			objectliste[anzahl++]=obj;									// Das Arryay wird von 0 zu 14 gefuellt, leere Positionen sind nicht vorgesehen
//			if (myListener != null) {
//				//Empfänger empfängt Verwaltungsguppe sendet
//				myListener.receive("Teilnehmer hinzugefügt.");
//			}
			return true;												// Null ist ein gueltiger Wert
		}
	}
	public int size() {													// *Liefert die Anzahl an Objekten
		return anzahl;
		}
	public boolean check() {
		if (this.anzahl==this.maxobjectliste) {
			return false;
		}
		else return true;
	}
	public Object get(int i) {											// *Liefert die Referenzadresse fuer ein Objekt
		if (i<0 || anzahl<=i) {											// Pruefung auf eine Arrayposition die belegt ist.  I{0..14} < anzahl{1..15}
			throw new RuntimeException ( "\n\nUngültiger Wert,"			// RunTimeException
					+ " Wert kleiner Null oder größer der maximalen"
					+ " Anzahl der Teilnehmer.\n"
					+ "Die Anwendung wird beendet.\n" );					
		}																
		else return objectliste[i];			
	}
	/*
	Methode remove (ohne leere Positionen im Array)	
	 a)	Umsetzen 				Variante A
	 	Die Referenz auf das letzte Objekt wird an die zu löschende Position kopiert.
	 	Die Referenz auf das letzte Objekt wird auf null gesetzt.
	 	Der Zaehler anzahl wird um eins reduziert.
	 	Einfach und schnell, allerdings wird die Reihenfolge der Objekte verändert.
	 b) Aufruecken 				Variante B
	 	Die Referenz auf das Objekt, welches auf das zu löschende folgt, wird auf die Position des zu löschenden kopiert.
	 	Dies wird wiederholt bis die letzte befüllte Position im Array erreicht ist.
	 	Die Referenz auf das letzte Objekt wird auf null gesetzt.
	 	Der Zaehler anzahl wird um eins reduziert.
	 	Achtung: Sollte die letzte Position im vollständig gefüllten Array gelöscht werden kann dies zu einem Fehler führen. 
	*/
	/*
	// Variante A
	public boolean remove(int i) {										// *Entfernt die Referenzadresse fuer ein Objekt
		if (i<0 ||anzahl<=i) {											// Pruefung auf eine Arrayposition die belegt ist.  I{0..14} < anzahl{1..15}
			return false;
		}
		else {
			objectliste[i]=objectliste[(--anzahl)];						// Kopieren der Referenz des letzten Objekts an die Position i, (--anzahl) ist die Position des letzten Objekts
			objectliste[anzahl]=null;									// Zuweisen von null 
			return true;
		}
	}
	*/
	// Variante B
	public boolean remove (int i) {										// *Entfernt die Referenzadresse fuer ein Objekt
		if (i<0 || anzahl<=i) {											// Pruefung auf eine Arrayposition die belegt ist.  I{0..14} < anzahl{1..15}
			return false;
		}
		else {
			while (i<anzahl && i<(maxobjectliste-1)){
				objectliste[i]=objectliste[++i];
			}
			objectliste[--anzahl]=null;
			//Empfänger empfängt Verwaltungsguppe sendet
//			if (myListener!=null) {
//				myListener.receive("Teilnehmer entfernt.");
//			}
			return true;
		}
	}
	// Rückgabe ändern auf myList
	public Object search(String input) {
		MyList subList = new VerwaltungsGruppe();
		if (anzahl>0) {
			for (int i=0; i<anzahl; i++) {
				if (objectliste[i]==null) {
					System.out.println("Null-Wert");
				}
				else {
					/*System.out.println(System.lineSeparator().repeat(1));
					System.out.print("Suchanfrage:    "+ input);
					System.out.println(System.lineSeparator().repeat(1));
					System.out.print("Person Nr. "+i+"     ");
					System.out.print("Vorname: ");
					System.out.print(((Person)objectliste[i]).getvorname()+"     ");
					System.out.print("Nachname: "); 
					System.out.print(((Person)objectliste[i]).getnachname()+"     ");
					*/
					if ( ((Person)objectliste[i]).getVorname().startsWith (input) ) {
						subList.add	(objectliste[i]);	
					}
				}
			}
		}	
		else{
			System.out.println(System.lineSeparator().repeat(2));
			System.out.println("Keine Personen vorhanden.");
		}
		return subList;
	}
	public void clear () {											// Entfernt die Instanz von der Referenzvariablen objectliste und legt eine neue Instanz an
		objectliste=null;
		anzahl=0;
		objectliste=new Object[maxobjectliste];
//		if (myListener!=null) {
//			myListener.receive("Alle Teilnehmer gelöscht");
//		}
	}
//	@Override
//	public void subscribe(MyListener myListener) {	//Sender, subscribe als eventListener
//		this.myListener = myListener;
//	}	
	@Override
	public void subscribe(EventListener eventlistener) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean remove(Object object) {
		// TODO Auto-generated method stub
		return false;
	}
}