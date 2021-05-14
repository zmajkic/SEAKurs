package de.telekom.sea.seminar;

public enum Anrede {
	FRAU, HERR, DIVERS;

	public static Anrede fromString(String string) {
		switch (string.toUpperCase()) {
		case "FRAU":
		case "F":
			return FRAU;

		case "HERR":
			return HERR;

		case "DIVERS":
		case "D":

			return DIVERS;

		default:

			throw new IllegalArgumentException("Unexpected value: " + string);
		}

	}

	@Override
	public String toString() {
		switch (this) {
		case FRAU:
			return "Frau";
		case HERR:
			return "Herr";
		case DIVERS:
			return "Divers";

		default:
			throw new IllegalArgumentException("Unexpected value: ");

		}

	}

}
