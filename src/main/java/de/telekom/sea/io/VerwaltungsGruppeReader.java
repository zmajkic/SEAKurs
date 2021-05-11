package de.telekom.sea.io;

import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

import de.telekom.sea.seminar.MyList;
import de.telekom.sea.seminar.Person;
import de.telekom.sea.seminar.VerwaltungsGruppe;

public class VerwaltungsGruppeReader implements Closeable {

	private FileReader fileReader;
	private BufferedReader bufferedReader;
	private PersonReader personReader;

	public VerwaltungsGruppeReader(String filepath) throws IOException {
		File file = new File(filepath);
		fileReader = new FileReader(file);
		bufferedReader = new BufferedReader(fileReader);
		// personWriter = new PersonWriter(filepath);
		personReader = new PersonReader(bufferedReader);

	}

	public MyList read() throws IOException {
		VerwaltungsGruppe verwaltungsgruppe = new VerwaltungsGruppe();
		Person person;
		do {
			person = personReader.read();

			if (person != null) {
				verwaltungsgruppe.add(person);
			}
		} while (person != null);
		return verwaltungsgruppe;
	}

	@Override
	public void close() throws IOException {
		fileReader.close();

	}
}
