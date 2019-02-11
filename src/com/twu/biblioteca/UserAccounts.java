package com.twu.biblioteca;

import java.util.Scanner;

public class UserAccounts {
    //Lists of Books and Movies can be accessed without login
    //To checkout and return movies/books, you have to login
    //Library Number XXX-XXX and password
    //To view customer information, you have to login
    //(Name, Email, Phone Number) will be shown
    private int phoneNumber;
    private int libraryNumber;
    private String password;
    private String name;
    private String email;


    public UserAccounts(int libraryNumber, int phoneNumber, String password, String name, String email) {
        this.libraryNumber = libraryNumber;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.name = name;
        this.email = email;
    }

    public int returnLibraryNumber(){
        return libraryNumber;
    }

    public int returnPhoneNumber(){
        return phoneNumber;
    }

    public String returnPassword(){
        return password;
    }

    public String returnName(){
        return name;
    }

    public String returnEmail(){
        return email;
    }


}
