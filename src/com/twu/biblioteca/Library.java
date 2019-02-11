package com.twu.biblioteca;
import java.util.*;
import static java.util.Collections.sort;

public class Library {

    private String message = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!\n";


    private Map<Integer, List<String>> books = new HashMap<Integer, List<String>>();
    private List<String> book1 = new LinkedList<String>(Arrays.asList("Pride and Prejudice",
            "Jane Austen", "1813"));
    private List<String> book2 = new LinkedList<String>(Arrays.asList("A Tale of Two Cities",
            "Charles Dickens", "1859"));
    private List<String> book3 = new LinkedList<String>(Arrays.asList("Frankenstein",
            "Mary Wollstonecraft Shelley", "1818"));

    private Map<Integer, List<String>> movies = new HashMap<Integer, List<String>>();
    private List<String> movie1 = new LinkedList<String>(Arrays.asList("Invictus", "2009", "Clint Eastwood", "7"));
    private List<String> movie2 = new LinkedList<String>(Arrays.asList("The Dark Knight", "2008",
            "Christopher Nolan", "9"));
    private List<String> movie3 = new LinkedList<String>(Arrays.asList("Bumblebee", "2018", "Travis Knight", "7"));

    private List<String> bookTitles = new LinkedList<String>();
    private List<String> booksAuthorsDates = new LinkedList<String>();
    private List<String> moviesInfo = new LinkedList<String>();

    private List<Integer> checkedOutBooks = new LinkedList<Integer>();
    private List<Integer> availableBooks = new LinkedList<Integer>();

    private List<Integer> checkedOutMovies = new LinkedList<Integer>();
    private List<Integer> availableMovies = new LinkedList<Integer>();




    public Library(){
        setup();
    }

    private void setup(){
        books.put(1, book1);
        books.put(2, book2);
        books.put(3, book3);

        movies.put(1, movie1);
        movies.put(2, movie2);
        movies.put(3, movie3);

        availableBooks.addAll(books.keySet());
        availableMovies.addAll(movies.keySet());
        updateBooks();
        updateMovies();
    }

    //Gets Welcome Message
    public String returnWelcomeMessage(){
        return message;
    }

    public List<Integer> returnAvailableBooks(){
        return availableBooks;
    }

    public List<Integer> returnCheckedoutBooks(){
        return checkedOutBooks;
    }

    public List<Integer> returnAvailableMovies(){
        return availableMovies;
    }

    public List<Integer> returnCheckedoutMovies(){
        return checkedOutMovies;
    }

    //Gets list of books
    public List<String> returnListOfBooks(){
        bookTitles.clear();
        for(int i = 0; i < availableBooks.size(); i++) {
            bookTitles.add(books.get(availableBooks.get(i)).get(0));
        }
        return bookTitles;
    }

    //Returns books, authors, dates
    public List<String> returnListOfBooksAuthorsDates() {
        return booksAuthorsDates;
    }

    //Returns movie list
    public List<String> returnListOfMovies(){
        return moviesInfo;
    }

    //Prints lists
    public void printLists(List<String> stringList){
        System.out.println("----------------------------------------------------\n");
        for(String s : stringList){
            System.out.println(s +"\n");
        }
    }

    //Update available books
    public void updateBooks(){
        booksAuthorsDates.clear();
        for(int i = 0; i < availableBooks.size(); i++){
            booksAuthorsDates.add(books.get(availableBooks.get(i)).get(0) + " | " +
                    books.get(availableBooks.get(i)).get(1) +
                    " | " + books.get(availableBooks.get(i)).get(2));
        }
    }

    //Updates available movies
    public void updateMovies(){
        moviesInfo.clear();
        for(int i = 0; i < availableMovies.size(); i++){
            moviesInfo.add(movies.get(availableMovies.get(i)).get(0) + " | " +
                    movies.get(availableMovies.get(i)).get(1) + " | " + movies.get(availableMovies.get(i)).get(2)
                    + " | " + movies.get(availableMovies.get(i)).get(3));
        }
    }

    //Checkout books, update list of available books
    public List<String> checkoutBook(String bookName){
        int n = 0;
        for(int k = 1; k < books.size() + 1; k++){
            if(!checkedOutBooks.contains(k) && availableBooks.contains(k)
                    && books.get(k).get(0).equals(bookName)){
                checkedOutBooks.add(k);
                sort(checkedOutBooks);
                availableBooks.remove(Integer.valueOf(k));
                System.out.println("Thank You! Enjoy the book.\n");
                n = k;
                break;
            }
        }
        //Update Available Books
       updateBooks();

        if(n == 0){
            System.out.println("Sorry, that book is not available.\n");
        }
        return booksAuthorsDates;
    }

    //Checkin books, update list of available books
    public List<String> checkinBook(String bookName){
        int m = 0;
        for(int k = 1; k < books.size() + 1; k++){
            if(checkedOutBooks.contains(k) && !availableBooks.contains(k)
                    && books.get(k).get(0).equals(bookName)){
                checkedOutBooks.remove(Integer.valueOf(k));
                availableBooks.add(k);
                sort(availableBooks);
                System.out.println("Thank You for returning the book.\n");
                m = k;
                break;
            }
        }
        //Update Available Books
        updateBooks();

        if(m == 0){
            System.out.println("That is not a valid book to return.\n");
        }
        return booksAuthorsDates;
    }

    //Checkout a movie
    public List<String> checkoutMovie(String movieName){
        int p = 0;
        for(int k = 1; k < movies.size() + 1; k++){
            if(!checkedOutMovies.contains(k) && availableMovies.contains(k)
                    && movies.get(k).get(0).equals(movieName)){
                checkedOutMovies.add(k);
                sort(checkedOutMovies);
                availableMovies.remove(Integer.valueOf(k));
                System.out.println("Thank You! Enjoy the movie.\n");
                p = k;
                break;
            }
        }
        //Update Available Movies
        updateMovies();

        if(p == 0){
            System.out.println("Sorry, that movie is not available.\n");
        }
        return moviesInfo;
    }

    //Checkin books, update list of available books
    public List<String> checkinMovie(String movieName){
        int m = 0;
        for(int k = 1; k < movies.size() + 1; k++){
            if(checkedOutMovies.contains(k) && !availableMovies.contains(k)
                    && movies.get(k).get(0).equals(movieName)){
                checkedOutMovies.remove(Integer.valueOf(k));
                availableMovies.add(k);
                sort(availableMovies);
                System.out.println("Thank You for returning the movie.\n");
                m = k;
                break;
            }
        }
        //Update Available Movies
        updateMovies();

        if(m == 0){
            System.out.println("That is not a valid movie to return.\n");
        }
        return moviesInfo;
    }

}
