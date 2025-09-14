package sc2002.lab5;

import java.util.*;
class Borrower{
    private String name;
    private List<String> borrowedBooks = new ArrayList<>();

    public Borrower(String name){
        this.name = name;
    }

    public void borrowBooks(String title){
        borrowedBooks.add(title);
    }
    public void returnBooks(String title){
        borrowedBooks.remove(title);
    }
    @Override
    public String toString() {
        return String.format("{\"name\": \"%s\", \"borrowedBooks\":%s}", name, borrowedBooks);
    }
}
