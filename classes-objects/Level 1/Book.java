class Book {
    String title;
    String author;
    double price;

    // Default Constructor
    public Book() {
        title = "Unknown";
        author = "Unknown";
        price = 0.0;
    }

    // Parameterized Constructor
    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    // Method to display book details
    public void displayDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: " + price);
    }
}

public class BookTest {
    public static void main(String[] args) {
        // Using Default Constructor
        Book book1 = new Book();
        System.out.println("Book 1 Details (Default Constructor):");
        book1.displayDetails();

        // Using Parameterized Constructor
        Book book2 = new Book("Java Programming", "James Gosling", 499.99);
        System.out.println("\nBook 2 Details (Parameterized Constructor):");
        book2.displayDetails();
    }
}
