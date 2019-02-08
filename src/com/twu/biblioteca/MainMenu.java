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
            int n;
            do {
                System.out.println("Main Menu:\n" + "1) List of Books\n" + "2) Checkout Book\n\n" +
                    "Enter a Number to Proceed\n" + "Enter 0 to Quit\n");
                n = reader.nextInt();
                reader.nextLine();
                System.out.println("\n");
                switch (n) {
                    case 1:
                        printLists(returnListOfBooksAuthorsDates());
                        System.out.println("----------------------------------------------------\n");
                }
            } while (n < 2);

        }catch(InputMismatchException e){
            System.out.println("Please select a valid option!\n");
        }
    }
}
