package com.twu.biblioteca;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainMenu extends Library{

     MainMenu(){
         System.out.println(returnWelcomeMessage());
    }

    //Shows main menu
    public void showMainMenu(){
        Scanner reader = new Scanner(System.in);
        try {
            System.out.println("Main Menu:\n" + "1) List of Books\n" + "2) Checkout a Book\n" + "3) Return a Book\n"+
                "4) List of Movies\n" + "5) Checkout a Movie\n" + "6) Return a Movie\n\n" +
                    "Enter a Number to Proceed\n" + "Enter 0 to Quit\n");
            System.out.println("----------------------------------------------------\n");
            int n = reader.nextInt();
            reader.nextLine();
            System.out.println("\n");
            switch (n) {
                case 1:
                    System.out.println("List of Books:\n");
                    printLists(returnListOfBooksAuthorsDates());
                    System.out.println("----------------------------------------------------\n");
                    showMainMenu();
                case 2:
                    System.out.println("Enter a book title to checkout: \n");
                    String b = reader.nextLine();
                    checkoutBook(b);
                    showMainMenu();
                case 3:
                    System.out.println("Enter a book title to check in: \n");
                    String c = reader.nextLine();
                    checkinBook(c);
                    showMainMenu();
                case 4:
                    System.out.println("List of Movies: \n ");
                    printLists(returnListOfMovies());
                    System.out.println("----------------------------------------------------\n");
                    showMainMenu();
                case 5:
                    System.out.println("Enter a movie title to checkout: \n");
                    String d = reader.nextLine();
                    checkoutMovie(d);
                    showMainMenu();
                case 6:
                    System.out.println("Enter a movie title to check in: \n");
                    String e = reader.nextLine();
                    checkinMovie(e);
                    showMainMenu();
                case 0:
                    System.exit(0);
            }
        }catch(InputMismatchException e){
            System.out.println("Please select a valid option!\n");
        }
    }
}
