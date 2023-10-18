package com.pluralsight;


import java.util.Scanner;

public class Screen {

    private static final Book[] Books = new Book[20];
    private static int BookInventory = 20;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);


        addInventory();

        System.out.println("Welcome to Muhamrif Library!");
        input.nextLine();

        boolean loopFlag = true;

        while (loopFlag) {
            mainScreenOptions();
            String UserChoice = mainScreenUserSelection();
            if (UserChoice.equalsIgnoreCase("E")) {
                printAllBooks();
                System.out.println("What Would you like to do next?");
            } else if (UserChoice.equalsIgnoreCase("A")) {
                printAllAvailableBooks();
            } else if (UserChoice.equalsIgnoreCase("N")) {
                printAllNonAvailableBooks();
            } else if (UserChoice.equalsIgnoreCase("C")) {
                checkInBook();
            } else if (UserChoice.equalsIgnoreCase("X")) {
                System.out.println("THANK YOU FOR VISITING MUHAMRIF LIBRARY! SEE YOU SOON : )");
                loopFlag = !loopFlag;
            }
        }


    }


    public static void mainScreenOptions() {
        System.out.println("Please Select From The Following Options:");
        System.out.println("Enter (E) to see our entire Books collection!");
        System.out.println("Enter (A) to see Books that are Available for checkout!");
        System.out.println("Enter (N) to see Books that are NOT Available for checkout!");
        System.out.println("Enter (C) to CheckIn a Borrowed Book!");
        System.out.println("Enter (X) to leave the Muhamrif Library!");

    }

    public static String mainScreenUserSelection() {

        Scanner input = new Scanner(System.in);
        String UserChoice = input.nextLine();
        if (UserChoice.equalsIgnoreCase("E") || UserChoice.equalsIgnoreCase("A") || UserChoice.equalsIgnoreCase("N") ||
                UserChoice.equalsIgnoreCase("C") || UserChoice.equalsIgnoreCase("X")) {
            return UserChoice;
        } else {
            System.out.println("select good value");
            mainScreenOptions();
        }
        return mainScreenUserSelection();
    }

    ;

    public static void printAllBooks() {

        System.out.println("These are all the books in Muhamrif Library:");
        for (int i = 0; i < Books.length; i++) {
            Book book = Books[i];
            int id = book.getId();
            String isbn = book.getIsbn();
            String title = book.getTitle();
            int availDays = book.getAvailableIn();
            String available = book.getAvailableIn() == 0 ? "You can checkout this book for 14 days!" : "available for checkout in " + availDays + " days!";
            System.out.println("id. " + id + " | " + "isbn" + "." + isbn + " | Title: " + title + " | " + available);

        }
        Scanner input = new Scanner(System.in);
        input.nextLine();

    }


    public static void printAllAvailableBooks() {

        System.out.println("These are all the available books that you can checkout:");
        for (int i = 0; i < Books.length; i++) {
            Book book = Books[i];
            if (!book.isCheckedOut()) {
                int id = book.getId();
                String isbn = book.getIsbn();
                String title = book.getTitle();
                String available = book.getAvailableIn() == 0 ? "You can checkout this book for 14 days!" : "not available for checkout yet! Will be Available in " + book.getAvailableIn() + "days!";
                System.out.println("id. " + id + " | " + "isbn" + "." + isbn + " | Title: " + title + " | " + available);

            }
        }
        Scanner input = new Scanner(System.in);
        input.nextLine();

        System.out.println("Would you like to checkout a book?");
        System.out.println("Enter (Y) for YES or (N) for No:");
        String userChoice = input.nextLine();


        if (userChoice.equalsIgnoreCase("Y")) {
            checkOutBook();
        } else if (userChoice.equalsIgnoreCase("N")) {
            System.out.println("Got it, Returning to MAIN MENU!");
        }


    }


    public static void printAllNonAvailableBooks() {

        System.out.println("These are all the available books that you can checkout:");
        for (int i = 0; i < Books.length; i++) {
            if (Books[i].isCheckedOut()) {
                int id = Books[i].getId();
                String isbn = Books[i].getIsbn();
                String title = Books[i].getTitle();
                String available = Books[i].getAvailableIn() == 0 ? "You can checkout this book for 14 days!" : "not available for checkout yet, it will be available in " + Books[i].getAvailableIn() + " days!";
                System.out.println("id. " + id + " | " + "isbn" + "." + isbn + " | Title: " + title + " | " + available);

            }
        }
        Scanner input = new Scanner(System.in);
        input.nextLine();

    }



    public static void checkOutBook() {

        Scanner input = new Scanner(System.in);

        System.out.println("Great! To get the checkout process started, Please enter your name:");
        String userName = input.next();
        input.nextLine();
        System.out.println("Awesome! Good to meet you " + userName + "!");
        System.out.println("Please Enter the Id of the book you would like to checkout:");
        int checkoutBook = input.nextInt();
        String bookName = "";
        for (int i = 0; i < Books.length; i++) {
            if (Books[i].getId() == checkoutBook) {
                Books[i].checkOut(userName);
                bookName = Books[i].getTitle();
            }
        }
        System.out.println("Success! Great you have securely checked out the book, " + bookName + " for 14 days!");
        input.nextLine();
        System.out.println("Going Back to MAIN MENU----->");

    }

    public static void checkInBook() {
        Scanner input = new Scanner(System.in);
        System.out.println("Great! To get the check-In process started, Please enter your name:");
        String userName = input.next();
        input.nextLine();
        System.out.println("Awesome! Good to meet you " + userName + "!");
        System.out.println("Please Enter the Id of the book you would like to check-In:");
        int checkoutBook = input.nextInt();
        String bookName = "";
        for (int i = 0; i < Books.length; i++) {
            if (Books[i].getId() == checkoutBook) {
                Books[i].checkIn();
                bookName = Books[i].getTitle();
            }
        }
        System.out.println("Success! Great you have securely checked In the book, " + bookName + "!");
        input.nextLine();
        System.out.println("Going Back to MAIN MENU----->");

    }


    private static void addInventory() {
        Books[0] = new Book(1001, "aaaa", "A Tale of Two Cities", false, "", 0);
        Books[1] = new Book(1002, "aaab", "The Little Prince", true, "", 9);
        Books[2] = new Book(1003, "aaac", "And Then There Were None", false, "", 0);
        Books[3] = new Book(1004, "aaad", "The Hobbit", true, "", 6);
        Books[4] = new Book(1005, "aaae", "She", false, "", 0);
        Books[5] = new Book(1006, "aaaf", "Da Vinci Code", true, "", 12);
        Books[6] = new Book(1007, "aaag", "The Alchemist", false, "", 0);
        Books[7] = new Book(1008, "aaah", "The Cather In The Rye", true, "", 10);
        Books[8] = new Book(1009, "aaai", "Lolita", false, "", 0);
        Books[9] = new Book(1010, "aaaj", "Heidi", true, "", 11);
        Books[10] = new Book(1011, "aaak", "Black Beauty", false, "", 0);
        Books[11] = new Book(1012, "aaal", "The Ginger Man", false, "", 0);
        Books[12] = new Book(1013, "aaam", "Cosmos", false, "", 0);
        Books[13] = new Book(1014, "aaan", "Kane and Abel", true, "", 7);
        Books[14] = new Book(1015, "aaao", "War And Peace", false, "", 0);
        Books[15] = new Book(1016, "aaap", "Kite Runner", false, "", 0);
        Books[16] = new Book(1017, "aaaq", "Great Gatsby", true, "", 3);
        Books[17] = new Book(1018, "aaar", "Hunger Games", false, "", 0);
        Books[18] = new Book(1019, "aaas", "Harry Potter", true, "", 13);
        Books[19] = new Book(1020, "aaat", "Dune", true, "", 2);
    }

}
