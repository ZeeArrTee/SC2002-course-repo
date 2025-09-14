package sc2002.lab5;

public class Book {
private String title;
private String author;
private String genre;
private int publicationYear;

public Book(String title, String author, String genre, int publicationYear){  //constructor
    this.title = title;
    this.author = author;
    this.genre = genre;
    this.publicationYear = publicationYear;
}
    
public String getTitle(){
    return this.title;
}
public String getAuthor(){
    return this.author;
}
public String getGenre(){
    return this.genre;
}
public int getPublicationYear(){
    return this.publicationYear;
}

@Override
//change the output when your print the object by overriding the toString method
public String toString(){
    return String.format("{\"title\": %s, \"author\" : %s, \"genre\": %s, \"publicationYear\" : %d}",
    title,author,genre,publicationYear);
}

}
