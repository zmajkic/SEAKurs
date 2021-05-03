package de.telekom.sea.seminar;

public class SeminarApp extends BaseObject {

	private static SeminarApp theInstance;

	// Constructor enthält Refernzvariable
	private SeminarApp() {
	}

	// run Methode
	public void run(String[] args) {

		MyList verwaltungsgruppe = new VerwaltungsGruppe();
		//VerwaltungsGruppe verwaltungsgruppe = new VerwaltungsGruppe();

		MyMenu menu = new Menu();
		menu.setMyList(verwaltungsgruppe);
		verwaltungsgruppe.subscribe(menu);
		menu.keepAsking();

	}

	public static SeminarApp getRootApp() {
		if (theInstance == null) {
			theInstance = new SeminarApp();
		}
		return theInstance;
	}
	/*
	 * public void altmain() { // TODO Auto-generated method stub
	 * 
	 * MyList sea = new VerwaltungsGruppe(); // VerwaltungsGruppe1 sea = new
	 * VerwaltungsGruppe1(); // VerwaltungsGruppe2 sea = new VerwaltungsGruppe2();
	 * 
	 * Person thomas = new Person(); thomas.setVorname("Thomas");
	 * thomas.setNachname("Horchem");
	 * 
	 * Person agata = new Person(); agata.setVorname("Agata");
	 * agata.setNachname("Rubin-Jung");
	 * 
	 * Person zeljko = new Person(); zeljko.setVorname("Zeljko");
	 * zeljko.setNachname("Majkic");
	 * 
	 * Person thorsten = new Person(); thorsten.setVorname("Thorsten");
	 * thorsten.setNachname("Lorenz");
	 * 
	 * Object o = new Object(); o = null;
	 * 
	 * sea.add(o); sea.add(thomas); sea.add(agata); sea.add(zeljko);
	 * sea.add(thorsten);
	 * 
	 * System.out.println(sea.size()); System.out.println("Ausgabe nach anmelden");
	 * for (int i = 0; i < 4; i++) { if (sea.get(i) == null) { System.out.println(i
	 * + " is null "); } else { // System.out.println(sea.getTeilnehmer(i));
	 * System.out.println(((Person) sea.get(i)).getVorname()); } }
	 * 
	 * System.out.println("Anzahl: " + sea.size());
	 * 
	 * sea.size(); // var teilnehmer = sea.getTeilnehmer(3); //
	 * System.out.println(teilnehmer.getVorname() + " " + teilnehmer.getNachname());
	 * 
	 * // sea.remove(thomas); // sea.remove(agata);
	 * 
	 * // sea.remove(null); // sea.remove(thorsten);
	 * 
	 * System.out.println("Ausgabe nach abmelden" + " Anzahl: " + sea.size());
	 * 
	 * for (int i = 0; i < 4; i++) { if (sea.get(i) == null) { System.out.println(i
	 * + " is null"); } else { // System.out.println(sea.getTeilnehmer(i));
	 * System.out.println(((Person) sea.get(i)).getVorname()); } }
	 * 
	 * }
	 */
}
