package com.twu.biblioteca;

import java.util.*;

public class Library {

    private String message = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!\n";


    private Map<Integer, List<String>> serialNumberBook = new HashMap<Integer, List<String>>();
    private List<String> book1 = new LinkedList<String>(Arrays.asList("Pride and Prejudice", "Jane Austen", "1813"));
    private List<String> book2 = new LinkedList<String>(Arrays.asList("A Tale of Two Cities", "Charles Dickens", "1859"));
    private List<String> book3 = new LinkedList<String>(Arrays.asList("Frankenstein", "Mary Wollstonecraft Shelley", "1818"));

    private List<String> bookTitles = new LinkedList<String>();
    private List<String> booksAuthorsDates = new LinkedList<String>();
    private List<Integer> checkedOutBooks = new LinkedList<Integer>();
    private List<Integer> availableBooks = new LinkedList<Integer>();



    public Library(){

        setup();
    }

    private void setup(){
        serialNumberBook.put(1, book1);
        serialNumberBook.put(2, book2);
        serialNumberBook.put(3, book3);

        availableBooks.clear();
        availableBooks.addAll(serialNumberBook.keySet());
        updateBooks();
    }

    //Gets Welcome Message
    public String returnWelcomeMessage(){
        return message;
    }

    //Gets list of books
    public List<String> returnListOfBooks(){
        return bookTitles;
    }

    //Returns books, authors, dates
    public List<String> returnListOfBooksAuthorsDates() {
        return booksAuthorsDates;
    }

    //Prints lists
    public void printLists(List<String> stringList){
        System.out.println("List of Books: \n");
        System.out.println("----------------------------------------------------\n");
        for(String s : stringList){
            System.out.println(s +"\n");
        }
    }

    public void updateBooks(){
        booksAuthorsDates.clear();
        for(int i = 0; i < availableBooks.size(); i++){
            booksAuthorsDates.add(serialNumberBook.get(availableBooks.get(i)).get(0) + " | " +
                    serialNumberBook.get(availableBooks.get(i)).get(1) +
                    " | " + serialNumberBook.get(availableBooks.get(i)).get(2));
        }
    }

    //Serial numbers are initially in availableBooks, but move between checkedoutBooks and availableBooks
    //That way, I will always know if a book is checked out or not.
    //Serial numbers are also "keys" to the book information
    //Have to connect serial numbers to the available/checkedoutBooks right now they are isolated
    //Have to always check if the book is available first and if it is checked out

    public List<String> checkoutBook(String bookName){
        int n = 0;
        for(int k = 1; k < serialNumberBook.size() + 1; k++){
            if(!checkedOutBooks.contains(k) && availableBooks.contains(k)
                    && serialNumberBook.get(k).get(0).equals(bookName)){
                checkedOutBooks.add(k);
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

    public List<String> checkinBook(String bookName){
        int m = 0;
        for(int k = 1; k < serialNumberBook.size() + 1; k++){
            if(checkedOutBooks.contains(k) && !availableBooks.contains(k)
                    && serialNumberBook.get(k).get(0).equals(bookName)){
                checkedOutBooks.remove(Integer.valueOf(k));
                availableBooks.add(k);
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
}
