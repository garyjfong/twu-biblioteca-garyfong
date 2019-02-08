package com.twu.biblioteca;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Library {

    private String message = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!\n";
    private List<String> books = new LinkedList<String>(Arrays.asList("Pride and Prejudice", "A Tale of Two Cities", "Frankenstein"));
    private List<String> authorsDates = Arrays.asList("Jane Austen | 1813", "Charles Dickens | 1859",
            "Mary Wollstonecraft Shelley | 1818");
    private List<String> booksAuthorsDates = new ArrayList<String>();

    //Gets Welcome Message
    public String returnWelcomeMessage(){
        return message;
    }

    //Gets list of books
    public List<String> returnListOfBooks(){
        return books;
    }

    //Prints lists
    public void printLists(List<String> stringList){
        for(String s : stringList){
            System.out.println(s +"\n");
        }
    }

    //Returns books, authors, dates
    public List<String> returnListOfBooksAuthorsDates(){
        if(booksAuthorsDates.isEmpty()) {
            for (int i = 0; i < books.size(); i++) {
                booksAuthorsDates.add(books.get(i) + " | " + authorsDates.get(i));
            }
        }return booksAuthorsDates;
    }
}
