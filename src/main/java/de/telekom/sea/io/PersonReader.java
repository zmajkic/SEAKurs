package de.telekom.sea.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import de.telekom.sea.seminar.Anrede;
import de.telekom.sea.seminar.Person;

public class PersonReader {

	private FileReader fileReader;
	private BufferedReader bufferedReader;

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
			
			String anredeString = field[1];
			Anrede anrede = Anrede.fromString(anredeString);
			
			String vorname = field[2]; // vorname ist feld 1
			String nachname = field[3]; // nachname ist feld 2

			Person person = new Person();
			person.setId(id);
			person.setAnrede(anrede);;	
			person.setVorname(vorname);
			person.setNachname(nachname);

			return person;
		}
		return null;
	}

}
