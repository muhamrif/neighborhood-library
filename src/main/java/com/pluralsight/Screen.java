package com.pluralsight;


import java.util.Scanner;

public class Screen {

    private static Book[] Books = new Book[20];
    private static int BookInventory = 20;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        addInventory();

        System.out.println("Welcome to Muhamrif Library!");
        input.nextLine();

        System.out.println("please select opt");


        printAllBooks();



    }



    public static void printAllBooks(){

        System.out.println("These are all the books in Muhamrif Library:");
        for (int i=0;i<Books.length;i++){
                int id = Books[i].getId();
                String isbn = Books[i].getIsbn();
                String title = Books[i].getTitle();
                int availDays = Books[i].getAvailableIn();
                String available= Books[i].getAvailableIn() == 0? "You can checkout this book for 14 days!":"available for checkout in "+availDays+" days!";
                System.out.println("id. " + id +" | "+"isbn"+"."+isbn+" | Title: "+ title +" | "+ available);


        }


    }

    public static void printAllAvailableBooks(){

        System.out.println("These are all the available books that you can checkout:");
        for (int i=0;i<Books.length;i++){
            if (Books[i].isCheckedOut() == false){
                int id = Books[i].getId();
                String isbn = Books[i].getIsbn();
                String title = Books[i].getTitle();
                String available= Books[i].getAvailableIn() == 0? "You can checkout this book for 14 days!":"not available for checkout yet!";
                System.out.println("id. " + id +" | "+"isbn"+"."+isbn+" | Title: "+ title +" | "+ available);

            }
        }
    }

    public static void printOneBook(){

    }

    public static void checkOutBook(){

    }

    public static void checkInBook(){

    }

    public static void choiceValidation(){

    }



    private static void addInventory() {
        Books[0]  = new Book(1001,"aaaa","A Tale of Two Cities",false,"",0);
        Books[1]  = new Book(1002,"aaab","The Little Prince",true,"",9);
        Books[2]  = new Book(1003,"aaac","And Then There Were None",false,"",0);
        Books[3]  = new Book(1004,"aaad","The Hobbit",true,"",6);
        Books[4]  = new Book(1005,"aaae","She",false,"",0);
        Books[5]  = new Book(1006,"aaaf","Da Vinci Code",true,"",12);
        Books[6]  = new Book(1007,"aaag","The Alchemist",false,"",0);
        Books[7]  = new Book(1008,"aaah","The Cather In The Rye",true,"",10);
        Books[8]  = new Book(1009,"aaai","Lolita",false,"",0);
        Books[9]  = new Book(1010,"aaaj","Heidi",true,"",11);
        Books[10] = new Book(1011,"aaak","Black Beauty",false,"",0);
        Books[11] = new Book(1012,"aaal","The Ginger Man",false,"",0);
        Books[12] = new Book(1013,"aaam","Cosmos",false,"",0);
        Books[13] = new Book(1014,"aaan","Kane and Abel",true,"",7);
        Books[14] = new Book(1015,"aaao","War And Peace",false,"",0);
        Books[15] = new Book(1016,"aaap","Kite Runner",false,"",0);
        Books[16] = new Book(1017,"aaaq","Great Gatsby",true,"",3);
        Books[17] = new Book(1018,"aaar","Hunger Games",false,"",0);
        Books[18] = new Book(1019,"aaas","Harry Potter",true,"",13);
        Books[19] = new Book(1020,"aaat","Dune",true,"",2);
    }

}
