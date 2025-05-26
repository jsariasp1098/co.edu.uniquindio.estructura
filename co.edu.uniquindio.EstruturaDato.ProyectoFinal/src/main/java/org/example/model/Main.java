package org.example.model;

import org.example.model.enums.Status;
import org.example.model.enums.UserType;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DigitalLibrary digitalLibrary = new DigitalLibrary();

        digitalLibrary.addBook(new Book("L001", "Cien años de soledad", "Rafael", "Realismo Mágico", "1995",
                Status.AVIABLE, null ));
        digitalLibrary.addBook(new Book("L002", "Don Quijote", "Miguel de Cervantes", "Clásico", "1605",
                Status.AVIABLE, null ));
        digitalLibrary.addBook(new Book("L003", "La Sombra del Viento", "Carlos Ruiz Zafón", "Misterio", "2001",
                Status.AVIABLE, null ));
        digitalLibrary.addBook(new Book("L004", "Alicia en el país de las maravillas", "Lewis Carroll", "Ficcion", "2003",
                Status.AVIABLE, null ));


        digitalLibrary.printCatalog();
        digitalLibrary.deleteBook(new Book("L004", "Alicia en el país de las maravillas",
                                    "Lewis Carroll", "Ficcion", "2003",
                                            Status.AVIABLE, null ));
        System.out.println("-----------------------------------------------------------------------");
        digitalLibrary.printCatalog();

       /* Scanner sc = new Scanner(System.in);
        System.out.println("id del libro: ");
        String id = sc.nextLine();
        System.out.println("Titulo del libro: ");
        String title = sc.nextLine();
        System.out.println("Autor del libro: ");
        String author = sc.nextLine();
        System.out.println("Genero del libro: ");
        String genre = sc.nextLine();
        System.out.println("Año de publicacion del libro: ");
        String year = sc.nextLine();

        digitalLibrary.addBook(new Book(id, title, author, genre, year, Status.AVIABLE, null ));
        digitalLibrary.printCatalog();*/

        System.out.println("-----------------------------------------------------------------------");
        digitalLibrary.addUser(new User("001", "Juan", "Arias", "jjj@jjj","3213213", "Calle 8 N 7-22",
                                        "jsap1098", "12346", UserType.READER));
        digitalLibrary.addUser(new User("002", "Lina", "Espinosa", "jjj@jjj","3213213", "Calle 8 N 7-22",
                "lina2460", "12346", UserType.READER));
        digitalLibrary.printUsers();
        System.out.println("-----------------------------------------------------------------------");
        digitalLibrary.updateUser(new User("001", "Juan Sebastian", "Arias", "jjj@jjj","3213213", "Calle 8 N 7-22",
                "jsap1098", "12346", UserType.READER));
        digitalLibrary.printUsers();
        System.out.println("-----------------------------------------------------------------------");
        digitalLibrary.deleteUser(new User("001", "Juan", "Arias", "jjj@jjj","3213213", "Calle 8 N 7-22",
                "jsap1099", "12346", UserType.READER));
        digitalLibrary.printUsers();

    }
}
