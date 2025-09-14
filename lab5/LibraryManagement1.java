package sc2002.lab5;

import java.util.*;

public class LibraryManagement1 {
    private static Library<Book> library = new Library<>();
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        while (true) {
            System.out.printf("""
                    ----------------------------\n
                    1.Add Book to Library\n
                    2.Filter Books by Genre\n
                    3.Filter Books by Author\n
                    4.Search Books by Keyword\n
                    5.Sort Books by Title\n
                    6.Provide Recommendation \n
                    7.Borrower Operations \n
                    8.Exit \n
                    -----------------------------\n
                    Enter your choice: \n

                    """);

            int choice = scanner.nextInt();
                    scanner.nextLine(); // consume the newline character
        
                    switch (choice) {
                        case 1:
                            addBookToLibrary();
                            break;
                        case 2:
                            filterBooksByGenre();
                            break;
                        case 3:
                            filterBooksByAuthor();
                            break;
                        case 4:
                            searchBooksByKeyword();
                            break;
                        case 5:
                            sortBooksByTitle();
                            break;
                        case 6:
                            provideRecommendation();
                            break;
                        case 7:
                            borrowerOperations();
                            break;
                        case 8:
                            return;
                        default:
                            System.out.println("Invalid choice. Please try again.");
    }
}
    }

    private static void addBookToLibrary() {
        String title = "";
        String author;
        String genre;
        while(true){
        System.out.print("Enter book title(enter \"[]\" to stop adding): ");
        title = scanner.nextLine();
        if (title.equalsIgnoreCase("[]")){
            break;
        }
        System.out.print("Enter author: ");
        author = scanner.nextLine();
        System.out.print("Enter genre: ");
        genre = scanner.nextLine();
        System.out.print("Enter publication year: ");
        int year = scanner.nextInt();
        scanner.nextLine(); // consume the enter char

        library.addBook(new Book(title, author, genre, year));
        }
        System.out.println("Library contains " + library.getAllBooks().size() + " books.");
        }

    private static void filterBooksByGenre() {
        System.out.print("Enter genre to filter by: ");
        String genre = scanner.nextLine();
        List<Book> filteredBooks = library.filterByGenre(genre);
        System.out.println("List of books: " + filteredBooks);
    }

    private static void filterBooksByAuthor() {

        System.out.print("Enter author to filter by: ");
        String author = scanner.nextLine();
        List<Book> filteredBooks = library.filterByAuthor(author);
        System.out.println("List of books: " + filteredBooks);

    }

    private static void searchBooksByKeyword() {
        System.out.print("Enter keyword to search for: ");
        String keyword = scanner.nextLine();
        List<Book> searchResults = library.searchBook(keyword);
        System.out.println("List of books:" + searchResults);
    }

    private static void sortBooksByTitle() {
        List<Book> sortedBooks = new ArrayList<>(library.getAllBooks()); //get a copy of the lists
        sortedBooks.sort(Comparator.comparing(Book::getTitle));
        System.out.println("Sorted Books by Title:");
        sortedBooks.forEach(System.out::println);
    }

    private static void provideRecommendation() {
        System.out.print("Category: ");
        String category = scanner.nextLine();
        System.out.println("Recommendation: " + library.recommendBook(category));
    }

    private static void borrowerOperations() {
        System.out.print("Name: ");
        String borrowerName = scanner.nextLine();
        String temp = " ";
        Borrower borrower = new Borrower(borrowerName);
        while (!temp.equalsIgnoreCase("[]")){
        System.out.print("Enter borrowedBooks(enter \"[]\" to end/skip ): ");
        temp = scanner.nextLine();
        if (!temp.equalsIgnoreCase("[]")){
            borrower.borrowBooks(temp);}
        }
        System.out.println("Borrower: " + borrower);
        while (true) {
            System.out.println("""
                    ------------------------------ \n
                    1. Borrow a Book \n
                    2. Return a Book \n
                    3. Exit Borrower Operations \n
                    ------------------------------ \n
                    Enter your choice: \n
                    """);
            int choice = scanner.nextInt();

            scanner.nextLine(); // consume newline character
            //System.out.println("Borrower Details: " + borrower);
            switch (choice) {
                case 1:
                    System.out.println("Borrower: " + borrower);
                    System.out.print("Enter book title to borrow: ");
                    String borrowTitle = scanner.nextLine();
                    borrower.borrowBooks(borrowTitle);
                    System.out.println("Borrower details: " + borrower);
                    break;
                case 2:
                    System.out.println("Borrower: " + borrower);
                    System.out.print("Enter book title to return: ");
                    String returnTitle = scanner.nextLine();
                    borrower.returnBooks(returnTitle);
                    System.out.println("Borrower details: " + borrower);
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }



}