package com.pluralsight;

import java.util.Scanner;

public class NeighborhoodLibrary {
    public static void main(String[] args) {

        // The array to hold the inventory of books
        Book[] books = new Book[5];
        books[0] = new Book(1, "395-8-48-483632-5", "The Montessori Method");
        books[1] = new Book(2, "595-8-43-069816-3", "Napkin Finance");
        books[2] = new Book(3, "693-2-19-438408-7", "Data Warehouse");
        books[3] = new Book(4, "693-2-19-438408-7", "Rich Dad Poor Dad");
        books[4] = new Book(5, "695-6-71-079375-8", "Don't Swear The Small Stuff");

        Scanner scanner = new Scanner(System.in);

        // The home screen is displaying a list of options that a user can choose from
        while (true) {
            System.out.println("Welcome to the the Neighborhood Library. Please choose an option to continue");
            System.out.println("1 to Show Available Books");
            System.out.println("2 to Show Checked Out Books");
            System.out.println("3 to Exit");
            int response = scanner.nextInt();
            scanner.nextLine();

            // The switch statement handles the user's choice. It calls different methods based on the user's input:
            switch (response) {
                case 1:
                    showAvailableBooks(books, scanner);
                    break;
                case 2:
                    showCheckedOutBooks(books, scanner);
                    break;
                case 3:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 3.");
                    break;
            }
        }
    }

    // Method to show available books
    public static void showAvailableBooks(Book[] books, Scanner scanner) {
        System.out.println("Available Books:");
        for (Book book : books) {
            if (!book.isCheckedOut()) {
                System.out.println("ID: " + book.getId() + ", ISBN: " + book.getIsbn() + ", Title: " + book.getTitle());
            }
        }
        System.out.println("Select a book to check out (enter ID) or type 'Exit' to go back to home screen:");
        String input = scanner.nextLine();
        if (input.equalsIgnoreCase("Exit")) {
            return;
        }
        int selectedId = Integer.parseInt(input);
        for (Book book : books) {
            if (book.getId() == selectedId) {
                System.out.println("Enter your name:");
                String name = scanner.nextLine();
                book.checkOut(name);
                break;
            }
        }
    }

    // Method to show checked out books
    public static void showCheckedOutBooks(Book[] books, Scanner scanner) {
        System.out.println("Checked Out Books:");
        for (Book book : books) {
            if (book.isCheckedOut()) {
                System.out.println("ID: " + book.getId() + ", ISBN: " + book.getIsbn() + ", Title: " + book.getTitle()
                        + ", Checked Out To: " + book.getCheckedOutTo());
            }
        }
        System.out.println("C - Check In a book");
        System.out.println("X - Go back to home screen");
        String input = scanner.nextLine();
        switch (input.toUpperCase()) {
            case "C":
                checkInBook(books, scanner);
                break;
            case "X":
                return;
            default:
                System.out.println("Invalid choice");
        }
    }

    // Method to check in a book
    public static void checkInBook(Book[] books, Scanner scanner) {
        System.out.println("Enter the ID of the book you want to check in:");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        for (Book book : books) {
            if (book.getId() == id) {
                book.checkIn();
                return;
            }
        }
        System.out.println("Book with ID " + id + " not found.");
    }
}






