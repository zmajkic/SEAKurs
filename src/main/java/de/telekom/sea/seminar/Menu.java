package de.telekom.sea.seminar;

public class Menu implements MyMenu {

	public void setMyList(MyList myList) // public - gib die Verwaltungs-"DB" dem Menu bekannt
	{
		
	}

	public void keepAsking() // public - hällt die Schleife bis zum Abbruch am Leben
	{
	}

	// Diese Methoden sind privat und haben im Interface nichts verloren
	// Hier nur zur einheitlichen Umsetzung

	public void showMenu() // privat - Zeigt die Auswahl an und exit oder continue
	{
		// System.out.println(System.lineSeparator().repeat(50));
		System.out.println("Menu");
		System.err.println("1. Person Anlegen.");
		System.out.println("2. Person ausgeben.");
		System.out.println("3. Alle Personen löschen.");
		System.out.println("0. Exit");
	}

	public String inputMenu() // privat - nimmt die Usereingabe entgegen --> scanner
	{
		return " ";

	}

	public void checkMenu(String eingabe) // privat - case Evaluierung und Ausführungsaufruf
	{

	}

	public void inputPerson() // privat - eine Neue Person über StdIn erfassen
	{
	}

	public void listAllPersons() //
	{
	}

	public void removeAll() // Die Teilnehmerliste resetten
	{
	}

}
