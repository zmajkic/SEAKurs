package de.telekom.sea.seminar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import de.telekom.sea.seminar.VerwaltungsGruppe7Test;

public class VerwaltungsGruppe7Test {

	private VerwaltungsGruppe7 cut; // class under test

	@BeforeEach // diese Methode for jedem test ausführen
	void setup() {
		cut = new VerwaltungsGruppe7();
	}

	@Test
	void add_exception_test() {
		// Arrange

		for (int i = 0; i <= 14; i++) {

			Person personX = new Person();
			personX.setVorname("Ilona" + i);
			personX.setNachname("Keiser");
//			System.out.println("Nr.: " + i + " " + personX.toString());
			cut.add(personX);
		}

		// Act
		// Assert

		assertThrows(RuntimeException.class, () -> {
			cut.add(new Person());
		});
	}

	@Test // liefert die Methode check standardmässig True zurück?
	void check_test() {
		// Arrange

		// Act
		boolean result = cut.check();
		// Assert
		assertTrue(result);

	}

	@Test
	void add_test() {
		// Arrange
		Person person = new Person();
		person.setVorname("Ilona");
		person.setNachname("Keiser");

		// Act
		cut.add(person);
		int result = cut.size(); //
		var result2 = (Person) cut.get(0); // Objekt Person
		var result3 = ((Person) cut.get(0)).getVorname();
		var result4 = ((Person) cut.get(0)).getNachname();

		// Assert
		assertEquals(1, result);
		assertEquals(person, result2);
		assertEquals("Ilona", result3);
		assertEquals("Keiser", result4);

	}

	@Test
	void clear_test() {
		// Arrange
		Person person = new Person();

		cut.add(person);

		int result = cut.size();
		assertEquals(1, result);

		// Act
		cut.clear();

		int result2 = cut.size();

		// Assert
		assertEquals(0, result2);
	}

	@Test
	void remove_Object_test() {
		// Arrange
		Person person = new Person();

		cut.add(person);

		int result = cut.size();
		assertEquals(1, result);

		// Act
		cut.remove(person);
		int result2 = cut.size();

		// Assert
		assertEquals(1, result2);
		boolean result3 = cut.remove(person);
		assertFalse(result3);

	}

	@Test
	void remove_int_test() {
		// Arrange
		Person person = new Person();
		cut.add(person);
		int result = cut.size();
		assertEquals(1, result);
		// Act
		cut.remove(0);
//		assertNull(result);
		int result2 = cut.size();
		// Assert
		assertEquals(0, result2);
	}

	@Test
	void fail_test() {
		fail();
		
	}
	
	
//	
//	@Test
//	void MyList_search_test() {
//
//
//		
//		// Arrange
//		Person person = new Person();
//		person.setVorname("Ilona");
//		person.setNachname("Keiser");
//
//		// Act
//		cut.add(person);
//		int result = cut.size(); //
//		var result2 = (Person) cut.get(0); // Objekt Person
//		var result3 = ((Person) cut.get(0)).getVorname();
//		var result4 = ((Person) cut.get(0)).getNachname();
//
//		// Assert
//		assertEquals(1, result);
//		assertEquals(person, result2);
//		assertEquals("Ilona", result3);
//		assertEquals("Keiser", result4);
//		
//		
//		
//	}

	//Hallo
	
	@AfterEach
	void teardown() {
		cut = null;

	}

}
