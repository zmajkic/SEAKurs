package de.telekom.sea.io;

import java.io.Closeable;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import de.telekom.sea.seminar.MyList;
import de.telekom.sea.seminar.Person;
//import de.telekom.sea.seminar.VerwaltungsGruppe;

public class VerwaltungsGruppeWriter implements Closeable {

	private FileWriter fileWriter;
	private PersonWriter personWriter;

	public VerwaltungsGruppeWriter(String filepath) throws IOException {
		File file = new File(filepath);
		fileWriter = new FileWriter(file);
		// personWriter = new PersonWriter(filepath);
		personWriter = new PersonWriter(fileWriter);
	}

	public VerwaltungsGruppeWriter(FileWriter fileWriter) { //
		this.fileWriter = fileWriter;
		personWriter = new PersonWriter(fileWriter);
	}

	public void write(MyList myList) throws IOException {

		for (int i = 0; i < myList.size(); i++) {
			Object object = myList.get(i);
			Person person = (Person) object;

			personWriter.write(person);

		}

	}

	public void close() throws IOException {
		this.fileWriter.close();

	}

}
