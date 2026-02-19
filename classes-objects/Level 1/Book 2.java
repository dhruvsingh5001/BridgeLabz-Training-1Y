class Book {
    String title;
    String author;
    double price;
    boolean availability;

    // Constructor
    public Book(String title, String author, double price, boolean availability) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.availability = availability;
    }

    // Method to borrow a book
    public void borrowBook() {
        if (availability) {
            availability = false;
            System.out.println("Book \"" + title + "\" has been borrowed successfully.");
        } else {
            System.out.println("Book \"" + title + "\" is currently not available.");
        }
    }

    // Method to display book details
    public void displayDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: " + price);
        System.out.println("Availability: " + (availability ? "Available" : "Not Available"));
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        Book book1 = new Book("Java Programming", "James Gosling", 499.0, true);

        System.out.println("Book Details:");
        book1.displayDetails();

        System.out.println("\nBorrowing the book...");
        book1.borrowBook();

        System.out.println("\nUpdated Book Details:");
        book1.displayDetails();
    }
}
