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
            System.out.println("Main Menu:\n" + "1) List of Books\n" + "2) Checkout a Book\n" + "3) Return a Book\n\n"+
                "Enter a Number to Proceed\n" + "Enter 0 to Quit\n");
            System.out.println("----------------------------------------------------\n");
            int n = reader.nextInt();
            reader.nextLine();
            System.out.println("\n");
            switch (n) {
                case 1:
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
                case 0:
                    System.exit(0);
            }
        }catch(InputMismatchException e){
            System.out.println("Please select a valid option!\n");
        }
    }
}
