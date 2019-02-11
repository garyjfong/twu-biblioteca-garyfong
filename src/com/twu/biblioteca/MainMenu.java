package com.twu.biblioteca;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainMenu extends Library {

    MainMenu() {
        System.out.println(returnWelcomeMessage());
    }

    //Shows main menu
    public void showMainMenu(UserAccounts userAccounts) {
        Scanner reader = new Scanner(System.in);
        try {
            System.out.println("Main Menu:\n" + "1) List of Books\n" + "2) List of Movies\n" +
                    "3) Login to Library Account\n\n" + "Enter a Number to Proceed\n" + "Enter 0 to Quit\n");
            System.out.println("----------------------------------------------------\n");
            int n = reader.nextInt();
            reader.nextLine();
            System.out.println("\n");
            switch (n) {
                case 1:
                    System.out.println("List of Books:\n");
                    printLists(returnListOfBooksAuthorsDates());
                    System.out.println("----------------------------------------------------\n");
                    showMainMenu(userAccounts);
                case 2:
                    System.out.println("List of Movies: \n ");
                    printLists(returnListOfMovies());
                    System.out.println("----------------------------------------------------\n");
                    showMainMenu(userAccounts);
                case 3:
                    userVerification(userAccounts);
                case 0:
                    System.exit(0);
            }
        } catch (InputMismatchException e) {
            System.out.println("Please select a valid option!\n");
        }
    }

    public void showSubMenu(UserAccounts userAccounts) {
        Scanner verify = new Scanner(System.in);
        try {
            System.out.println("Sub Menu:\n" + "1) View User Information\n" + "2) Checkout a Book\n" +
                    "3) Return a Book\n" + "4) Checkout a Movie\n" + "5) Return a Movie\n"
                    + "6) View List of Books\n" + "7) View List of Movies\n\n" +
                    "Enter a Number to Proceed\n" + "Enter 0 to Quit\n");
            System.out.println("----------------------------------------------------\n");
            int n = verify.nextInt();
            verify.nextLine();
            System.out.println("\n");
            switch (n) {
                case 1:
                    System.out.println(
                            "Name: \n" + userAccounts.returnName() + "\n\n" +
                            "Library Number: \n" + userAccounts.returnLibraryNumber() + "\n\n" +
                            "Password: \n" + userAccounts.returnPassword() + "\n\n" +
                            "Email: \n" + userAccounts.returnEmail() + "\n\n" +
                            "Phone Number: \n" + userAccounts.returnPhoneNumber() + "\n\n");
                    showSubMenu(userAccounts);
                case 2:
                    System.out.println("Enter a book title to checkout: \n");
                    String b = verify.nextLine();
                    checkoutBook(b);
                    showSubMenu(userAccounts);
                case 3:
                    System.out.println("Enter a book title to check in: \n");
                    String c = verify.nextLine();
                    checkinBook(c);
                    showSubMenu(userAccounts);
                case 4:
                    System.out.println("Enter a movie title to checkout: \n");
                    String d = verify.nextLine();
                    checkoutMovie(d);
                    showSubMenu(userAccounts);
                case 5:
                    System.out.println("Enter a movie title to check in: \n");
                    String e = verify.nextLine();
                    checkinMovie(e);
                    showSubMenu(userAccounts);
                case 6:
                    System.out.println("List of Books:\n");
                    printLists(returnListOfBooksAuthorsDates());
                    System.out.println("----------------------------------------------------\n");
                    showSubMenu(userAccounts);
                case 7:
                    System.out.println("List of Movies: \n ");
                    printLists(returnListOfMovies());
                    System.out.println("----------------------------------------------------\n");
                    showSubMenu(userAccounts);
                case 0:
                    System.exit(0);
            }
        } catch (InputMismatchException e) {
            System.out.println("Please select a valid option!\n");
        }
    }

    public void userVerification(UserAccounts userAccounts){
        Scanner user = new Scanner(System.in);
        System.out.println("Enter Your Library Number: \n");
        int libNum = user.nextInt();
        user.nextLine();

        System.out.println("\nEnter Password: \n");
        String pass = user.nextLine();

        if(libNum == userAccounts.returnLibraryNumber() && pass.equals(userAccounts.returnPassword())){
            System.out.println("\nYou have logged in!\n");
            showSubMenu(userAccounts);
        }else{
            System.out.println("Sorry, account was not found. Please try again.\n");
            showMainMenu(userAccounts);
        }
    }
}
