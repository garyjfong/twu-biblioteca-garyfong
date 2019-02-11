package com.twu.biblioteca;


public class BibliotecaApp {

    public static void main(String[] args) {
        UserAccounts userAccounts = new UserAccounts(123456, 569651859,
                "password", "Gary Fong", "garyj.fong@gmail.com");
        MainMenu mainMenu = new MainMenu();
        mainMenu.showMainMenu(userAccounts);

    }
}
