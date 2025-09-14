package sc2002.lab5;

import java.util.*;
import java.util.stream.Collectors;


public class Library<T extends Book> implements Searchable {
    private List<T> books = new ArrayList<>();
    private Set<String> genres = new HashSet<>();
    private Map<String,List<T>> authors = new HashMap<>();

    public void addBook(T book){
        books.add(book);
        genres.add(book.getGenre());
        if (!authors.containsKey(book.getAuthor())) { //doesnt contain the man
            authors.put(book.getAuthor(), new ArrayList<>()); //add dude
        }
        (authors.get(book.getAuthor())).add(book); //add book to the list
    }

    public void removeBook(String title) {
        books.removeIf(book -> book.getTitle().equalsIgnoreCase(title));
    }

    public List<T> getAllBooks() {
        return books;
    }

    public List<T> filterByGenre(String genre){
        return books.stream().filter(book -> book.getGenre().equalsIgnoreCase(genre)).collect(Collectors.toList());
    }

    public List<T> filterByAuthor(String author) {
        return books.stream().filter(book -> book.getAuthor().equalsIgnoreCase(author)).collect(Collectors.toList());
    }
    @Override
    public List<Book> searchBook(String keyword) {
        return books.stream().filter(book -> book.getTitle().toLowerCase().contains(keyword.toLowerCase())).collect(Collectors.toList());
    }

    public String recommendBook(String category) {
        return switch (category.toLowerCase()) {
            case "fiction" -> "Try '1984' by George Orwell.";
            case "science" -> "Try 'A Brief History of Time' by Stephen Hawking.";
            case "biography" -> "Try 'A Beautiful Mind' by Sylvia Nasar.";
            default -> "No recommendations available.";
        };
    }
}
