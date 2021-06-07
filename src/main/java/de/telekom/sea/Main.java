package de.telekom.sea;

import javax.management.RuntimeErrorException;

import de.telekom.sea.seminar.SeminarApp;

public class Main {

	
/** @author Zeljko 
 *  @throws RuntimeException ist ein Test
 *  
 *  */
	
	

	public static void main(String[] args) {

		
		
		
//		SeminarApp app = new SeminarApp();
		SeminarApp app = SeminarApp.getRootApp();
//		System.out.println(app);
//		System.out.println(app2);
		app.setParent(null);
		app.run(args);
				
//	throw new RuntimeErrorException(null);
	var kurt = new RuntimeException("Test Exception");
	throw kurt;
	
	
	}

	
	
	
}
