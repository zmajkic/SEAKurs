package de.telekom.sea.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import de.telekom.sea.seminar.Person;

public class PersonReader {

	FileReader fileReader;
	BufferedReader bufferedReader;

	public PersonReader(String filepath) throws IOException { // enthält Dateiname und Pfad
		File file = new File(filepath); // java.io.File
		fileReader = new FileReader(file); // Datei einlesen
		bufferedReader = new BufferedReader(fileReader); //

	}

	public PersonReader(BufferedReader bufferedReader) { //
		this.bufferedReader = bufferedReader;
	}

	public Person read() throws IOException {
		String result = bufferedReader.readLine(); // Zeile einlesen in result

		if (result != null) {
			String[] field = result.split(";"); // result splitten -> in field schreiben
			String idstring = field[0]; // id ist feld 0
			long id = Long.parseLong(idstring); // idstring zur long verwandeln
												// long id = Long.parseLong(fields[0]);
			String vorname = field[1]; // vorname ist feld 1
			String nachname = field[2]; // nachname ist feld 2

			Person person = new Person();
			person.setId(id);
			person.setVorname(vorname);
			person.setNachname(nachname);

			return person;
		}
		return null;
	}

}
