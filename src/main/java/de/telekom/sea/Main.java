package de.telekom.sea;

import de.telekom.sea.seminar.SeminarApp;









public class Main {
			
	public static void main(String[] args) {
        
		SeminarApp app = new SeminarApp();
		var app2 = SeminarApp.getRootApp();
		System.out.println(app);
		System.out.println(app2);
		app.setParent(null);
		app.run(args);

	}

}