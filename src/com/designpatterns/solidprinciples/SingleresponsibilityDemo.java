package com.designpatterns.solidprinciples;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SingleresponsibilityDemo {
	public static void main(String[] args) throws IOException {
		final Journal journal = new Journal();
		journal.addEntry("Started Design Patterns");
		journal.addEntry("Single responsibility principle was the first topic");
		System.out.println(journal.toString());

		journal.removeEntry(0);
		System.out.println("\n------After removing first entry------");
		System.out.println(journal.toString());

		System.out.println("\n------Adding entry------");
		journal.addEntry("Next is Open-Close principle");
		System.out.println(journal.toString());

		final Persistence<Journal> persistJournal = new Persistence<>();
		persistJournal.saveToFile(journal, "journal.txt");

		System.out.println("\n-----Read from file-----");
		System.out.println(persistJournal.readFromFile("journal.txt"));
	}
}

/**
 * The main responsibility of Journal class is to maintain entries should not do
 * anything other than that like saving journal to file,reading journal from
 * file etc.
 */
final class Journal {
	private final List<String> entries;
	private static int count;

	public Journal() {
		entries = new ArrayList<>();
	}

	public void addEntry(final String entry) {
		entries.add(++count + ". " + entry);
	}

	public boolean removeEntry(int index) {
		return entries.remove(index) != null;
	}

	@Override
	public String toString() {
		return String.join(System.lineSeparator(), entries);
	}
}

/**
 * Persistence should be used to read from or write to a file, and this class
 * should be limited to this work
 *
 * @param <T> Can save any object but returns string format of it.
 */
final class Persistence<T> {
	public void saveToFile(final T t, final String fileName) throws FileNotFoundException {
		try (PrintStream out = new PrintStream(fileName)) {
			out.println(t.toString());
		}
	}

	public String readFromFile(final String fileName) throws FileNotFoundException, IOException {
		final StringBuilder sb = new StringBuilder();
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			sb.append(br.lines().collect(Collectors.joining()));
		}
		return sb.toString();
	}
}