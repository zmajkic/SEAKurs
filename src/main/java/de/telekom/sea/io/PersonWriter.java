package de.telekom.sea.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import de.telekom.sea.seminar.Person;

public class PersonWriter {

//	private static final String dateiname = null;
	FileWriter fileWriter;

	public PersonWriter(String filepath) throws IOException { // enthält Dateiname und Pfad
		File file = new File(filepath);
		fileWriter = new FileWriter(file);
	}

	public PersonWriter(FileWriter fileWriter) {    // 
		this.fileWriter = fileWriter;
	}

	public void write(Person person) throws IOException {
		fileWriter.write(person.getVorname());
		fileWriter.write(person.getNachname());

	}

}
