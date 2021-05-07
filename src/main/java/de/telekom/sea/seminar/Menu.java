package de.telekom.sea.seminar;

public class Menu implements MyMenu, EventListener {

	MyList verwaltungsgruppe;
	MyList suchliste;

	java.util.Scanner scanner = new java.util.Scanner(System.in);

	public void setMyList(MyList myList) // public - gib die Verwaltungs-"DB" dem Menu bekannt
	{
		verwaltungsgruppe = myList;
	}

	public void receive(Event event) {
		listAllPersons(verwaltungsgruppe);
		System.out.println(event.getDescription());
		System.out.println(">>>Event<<<");
	}

	public void keepAsking() // public - hällt die Schleife bis zum Abbruch am Leben
	{

		String result = "0";
		this.showMenu();
		// readMenu();
		do {
			result = this.inputMenu();
			this.checkMenu(result);
//			System.out.println("KeepAsking");
		} while (!result.equals("0"));
//		System.out.println("while ende");
	}

	// Diese Methoden sind privat und haben im Interface nichts verloren
	// Hier nur zur einheitlichen Umsetzung

	public void showMenu() // privat - Zeigt die Auswahl an und exit oder continue
	{
		// System.out.println(System.lineSeparator().repeat(50));
		System.out.println("__________________________");
		System.out.println(" ::::  Menu  ::::");
		System.out.println("--------------------------");
		System.out.println("1. Person Anlegen.");
		System.out.println("2. Person ausgeben.");
		System.out.println("3. Alle Personen löschen.");
		System.out.println("4. Suchen.");
		System.out.println("0. Exit");
		System.out.println("__________________________");
	}

	@Override
	public void close() {
		scanner.close();
	}

	public String inputMenu() // privat - nimmt die Usereingabe entgegen --> scanner
	{
		var eingabe = scanner.nextLine();
		return eingabe;
	}

	public void checkMenu(String eingabe) // privat - case Evaluierung und Ausführungsaufruf
	{
		switch (eingabe) {
		case "1":
			System.out.println(" ***  Person anlegen *** ");
			inputPerson();
			break;
		case "2":
			System.out.println(" *** Personen ausgeben *** ");
			listAllPersons(verwaltungsgruppe);
			break;
		case "3":
			System.out.println(" *** Alles löschen *** ");
			removeAll();
			break;
		case "4":
			System.out.println(" *** Suchen *** ");
			search();
			break;
		case "0":
			System.out.println("Du hast 0 gewählt!");
			System.out.println("Tschüss");
			break;
		}
	}

	public void inputPerson() // privat - eine Neue Person über StdIn erfassen
	{
		Person person = new Person();
		System.out.println("Vorname eingeben:");
		person.setVorname(this.inputMenu());
//		System.out.println(person.getVorname());

		System.out.println("Nachname eingeben:");
		person.setNachname(this.inputMenu());
//		System.out.println(person.getNachname());
		verwaltungsgruppe.add(person);
		// System.out.println(verwaltungsgruppe);
		showMenu();
	}

	public void listAllPersons(MyList liste) //
	{

		// System.out.println("bin hier2");
		if (liste.size() == 0) {
			System.out.println(" *** Liste ist leer! *** " );
		}else {
		
		for (int i = 0; i < liste.size(); i++) {

//			if ((Person) this.verwaltungsgruppe.get(i) == null) {
			// System.out.println("Nullelement auf der Stelle: " + i);
			// }

			// System.out.println(verwaltungsgruppe.get(0));
			System.out.print("Person: " + i + " heißt: ");
			System.out.print(((Person) liste.get(i)).getVorname() + " ");
			System.out.println(((Person) liste.get(i)).getNachname());

		}
		System.out.println();
		showMenu();
	}
	}
	public void search() {
		System.out.print("Suchparameter eingeben: ");
		String searchtext = inputMenu();
		this.suchliste = verwaltungsgruppe.sublist(searchtext);
		this.listAllPersons(suchliste);
		
		
		/*
		 * for (int i = 0; i < sublist.size(); i++) { System.out.print(((Person)
		 * sublist.get(i)).getVorname() + " "); System.out.println(((Person)
		 * sublist.get(i)).getNachname() + " "); }
		 */

		//showMenu();

	}

	public void removeAll() // Die Teilnehmerliste resetten
	{
		verwaltungsgruppe.clear();
		System.out.println("Alles gelöscht!");
		showMenu();
	}

}
