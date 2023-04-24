package bookApp;

import java.util.Scanner;

public class MainBookApp {
	public static void main(String[] args) {
		// Create Type objects
		Type typeWeb = new Type();
		typeWeb.id = 1;
		typeWeb.name = "Web Design and Usability";

		Type typeFolklore = new Type();
		typeFolklore.id = 2;
		typeFolklore.name = "Folklore";

		Type[] types = { typeWeb, typeFolklore };

		// Create Customer objects
		Customer customerKath = new Customer();
		customerKath.id = 1;
		customerKath.name = "Katherine Nguyen";
		customerKath.email = "Khanhnh123";

		Customer customerGab = new Customer();
		customerGab.id = 2;
		customerGab.name = "Gabriel Wendt";
		customerGab.email = "GabrielWendt274";

		Customer[] customers = { customerKath, customerGab };

		// Create Location objects
		Location locationA = new Location();
		locationA.id = 1;
		locationA.name = "Block A";

		Location locationB = new Location();
		locationB.id = 2;
		locationB.name = "Block B";

		Location[] locations = { locationA, locationB };

		// Create Book objects
		Book book1 = new Book();
		book1.isbn = 111;
		book1.name = "Don't Make Me Think";
		book1.author = "Steve King";

		Book book2 = new Book();
		book2.isbn = 112;
		book2.name = "We Were On A Break";
		book2.author = "Lindsey Kelk";

		Book book3 = new Book();
		book3.isbn = 113;
		book3.name = "The Design of Everyday Things";
		book3.author = "Don Norman";

		Book[] books = { book1, book2, book3 };

		// Create TypeOfBook objects
		TypeOfBook book1TypeWeb = new TypeOfBook();
		book1TypeWeb.book = book1;
		book1TypeWeb.type = typeWeb;

		TypeOfBook book2TypeFolk = new TypeOfBook();
		book2TypeFolk.book = book2;
		book2TypeFolk.type = typeFolklore;

		TypeOfBook book3TypeWeb = new TypeOfBook();
		book3TypeWeb.book = book3;
		book3TypeWeb.type = typeWeb;

		TypeOfBook[] typeOfBooks = { book1TypeWeb, book2TypeFolk, book3TypeWeb };

		// Create BookInStock objects
		BookInStock book1LocationA = new BookInStock();
		book1LocationA.book = book1;
		book1LocationA.setLocation(locationA);
		book1LocationA.setQuantity(25);

		BookInStock book2LocationB = new BookInStock();
		book2LocationB.book = book2;
		book2LocationB.setLocation(locationB);
		book2LocationB.setQuantity(35);

		BookInStock book3LocationB = new BookInStock();
		book3LocationB.book = book3;
		book3LocationB.setLocation(locationB);
		book3LocationB.setQuantity(15);

		BookInStock[] bookInStock = { book1LocationA, book2LocationB, book3LocationB };
		// Create TrackingHistory objects
		TrackingHistory KathBorrowBook1 = new TrackingHistory();
		KathBorrowBook1.book = book1;
		KathBorrowBook1.borrowID = 1;
		KathBorrowBook1.customer = customerKath;
		KathBorrowBook1.setBorrowDate("18/03/2023");
		KathBorrowBook1.setReturnDate("22/04/2023");

		TrackingHistory KathBorrowBook2 = new TrackingHistory();
		KathBorrowBook2.book = book2;
		KathBorrowBook2.borrowID = 2;
		KathBorrowBook2.customer = customerKath;
		KathBorrowBook2.setBorrowDate("10/03/2023");

		TrackingHistory GabBorrowBook2 = new TrackingHistory();
		GabBorrowBook2.book = book2;
		GabBorrowBook2.borrowID = 3;
		GabBorrowBook2.customer = customerGab;
		GabBorrowBook2.setBorrowDate("30/03/2023");
		GabBorrowBook2.setReturnDate("20/04/2023");

		TrackingHistory GabBorrowBook3 = new TrackingHistory();
		GabBorrowBook3.book = book3;
		GabBorrowBook3.borrowID = 4;
		GabBorrowBook3.customer = customerGab;
		GabBorrowBook3.setBorrowDate("15/03/2023");

		TrackingHistory[] trackingHistories = { KathBorrowBook1, KathBorrowBook2, GabBorrowBook2, GabBorrowBook3 };

		// Show borrow list history
		getBorrowListHistory(trackingHistories);

		// Show borrow & return of a book
		getStatusOfBook(trackingHistories);
	}

	// Print borrow list history
	public static void getBorrowListHistory(TrackingHistory[] trackingHistories) {
		System.out.println("THE BORROW LIST HISTORY IS SHOWN BELLOW");
		for (TrackingHistory trackingHistory : trackingHistories) {
			System.out.println();
			System.out.println("-- Book name is : " + trackingHistory.book.name);
			System.out.println("Book's ISBN is : " + trackingHistory.book.isbn);
			System.out.println("Book's author is : " + trackingHistory.book.author);
			System.out.println("Borrow ID is : " + trackingHistory.borrowID);
			System.out.println("Borrower is : " + trackingHistory.customer.name);
			System.out.println("Borrow date is : " + trackingHistory.getBorrowDate());
			if (trackingHistory.getReturnDate() == null) {
				System.out.println("xxxxxx This book hasn't returned yet by " + trackingHistory.customer.name);
			} else
				System.out.println("Return date is : " + trackingHistory.getReturnDate());
		}
		System.out.println("---------------------------------------------------");
	}

	// Print borrow & return status of a book
	public static void getStatusOfBook(TrackingHistory[] trackingHistories) {
		System.out.println("HERE IS THE BORROW & RETURN STATUS OF THE BOOK YOU ARE LOOKING FOR");

		Scanner sc = new Scanner(System.in);
		String bookTitle;
		System.out.println("Please input the book title : ");
		bookTitle = sc.nextLine();

		for (TrackingHistory trackingHistory : trackingHistories) {
			if (trackingHistory.book.name.equals(bookTitle)) {
				System.out.println();
				System.out.println("-- Book name is : " + trackingHistory.book.name);
				System.out.println("Book's ISBN is : " + trackingHistory.book.isbn);
				System.out.println("Book's author is : " + trackingHistory.book.author);
				System.out.println("Borrow date is : " + trackingHistory.getBorrowDate());
				if (trackingHistory.getReturnDate() == null) {
					System.out.println("xxxxxx This book hasn't returned yet by " + trackingHistory.customer.name);
				} else
					System.out.println("Return date is : " + trackingHistory.getReturnDate());

			}
		}
	}

}
