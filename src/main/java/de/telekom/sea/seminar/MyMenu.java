package de.telekom.sea.seminar;
public interface MyMenu {
	
	public void setMyList(MyList myList);	// public - gib die Verwaltungs-"DB" dem Menu bekannt
	public void keepAsking(); 				// public - hällt die Schleife bis zum Abbruch am Leben
	
	
	// Diese Methoden sind privat und haben im Interface nichts verloren
	// Hier nur zur einheitlichen Umsetzung
	
	public void showMenu(); 				// privat - Zeigt die Auswahl an und exit oder continue
	public String inputMenu(); 				// privat - nimmt die Usereingabe entgegen --> scanner
	public void checkMenu(String eingabe); 	// privat - case Evaluierung
	public void inputPerson();				// privat - eine Neue Person über StdIn erfassen
	public void listAllPersons();			//
	public void removeAll();				// Die Teilnehmerliste resetten	
}