package org.mypackage;

/*
 * Click `Run` to execute the snippet below!
 */

import java.util.*;
import java.util.stream.Collectors;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class BooksAndReaders {

	public static void main(String[] args) {
		Book b0 = new Book("Les Métamorphoses");
		Book b1 = new Book("Les Enfants de minuit");
		Book b2 = new Book("Hamlet");
		Book b3 = new Book("Les Voyages de Gulliver");
		Book b4 = new Book("La Mort d'Ivan Ilitch");
		Book b5 = new Book("Mrs Dalloway");
		Book b6 = new Book("Mémoires d'Hadrien");
		Book b7 = new Book("Le Jardin des fruits");
		Book b8 = new Book("Le Carnet d'or");
		Book b9 = new Book("Madame Bovary");

		List<Person> persons = List.of(
				new Person("Gilles", 35, List.of(b1, b2, b3, b4, b9)),
				new Person("Adrien", 27, List.of(b0, b6, b3, b9)),
				new Person("Emilie", 29, List.of(b7, b2, b4)),
				new Person("Carlos", 29, List.of(b8, b1, b6)),
				new Person("Rafik", 27, List.of(b1, b2, b3, b4, b9)),
				new Person("Sabine", 35, List.of(b5, b6, b7, b8, b9)),
				new Person("Hanss", 18, List.of(b5, b6, b7, b8, b9)),
				new Person("Fatima", 15, List.of(b9)),
				new Person("Arnaud", 17, Collections.emptyList()),
				new Person("Virginie", 9, Collections.emptyList())
				);


		// 1 - La liste des noms des personnes majeures.
		System.out.println("\nLa liste des noms des personnes majeures");

		List<String> adults = persons.stream()		// Stream<Person>
				.filter(person -> person.years>=18)	// Stream<Person>
				.map(person -> person.name)			// Stream<String>
				.collect(Collectors.toList());		// List<String>                  

		System.out.println("adults " + adults);

		// 2 - L'ensemble des livres lus.
		System.out.println("\nL'ensemble des livres lus");

		Set<Book> booksRead = persons.stream()	// Stream<Person>
				.map(person -> person.books)	// Stream<List<Book>>
				.flatMap(x -> x.stream())		// Stream<Book>
				.collect(Collectors.toSet());	// Set<Book>

		System.out.println("books read: " + booksRead);

		// 3 - Les ensembles des personnes indexées par leur âge.
		System.out.println("\nLes ensembles des personnes indexées par leur âge");

		Map<Integer, Set<Person>> personByYears = persons.stream()					// Stream<Person>
				.collect(Collectors.groupingBy(p -> p.years, Collectors.toSet()));	//Map<Integer, Set<Person>>

		System.out.println(toString(personByYears));

		// 4 - Pour chaque livre, le nombre de personnes l'ayant lu
		System.out.println("\nPour chaque livre, le nombre de personnes l'ayant lu");
		
		Map<Book, Long> ownerCountByBook = persons.stream()						// Stream<Person>
				.map(person -> person.books)									// Stream<List<Book>>
				.flatMap(x -> x.stream())										// Stream<Book>
				.collect(Collectors.groupingBy(b -> b, Collectors.counting()));	//Map<Book, Long>
		
		System.out.println(toString(ownerCountByBook));
	}

	static class Person {
		final String name;
		final int years;
		final List<Book> books;

		Person(String name, int years, List<Book> books) {
			this.name = name;
			this.years = years;
			this.books = books;
		}

		@Override
		public String toString() {
			return "{name='" + name + "', years=" + years + ", books=" + books + "}\n";
		}
	}

	static class Book {
		final String title;

		public Book(String title) {
			this.title = title;
		}

		@Override
		public String toString() {
			return "{title='" + title + "'}";
		}
	}

	static <K,V> String toString(Map<K,V> map) {
		return map.entrySet()
				.stream()
				.map(entry -> entry.getKey() + " => " + entry.getValue())
				.collect(Collectors.joining("\n"));
	}
}
