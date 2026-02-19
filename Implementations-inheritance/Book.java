class Book {
    String title;
    int publicationYear;

    Book(String title, int publicationYear) {
        this.title = title;
        this.publicationYear = publicationYear;
    }

    void displayInfo() {
        System.out.println("Title: " + title + ", Publication Year: " + publicationYear);
    }
}

class Author extends Book {
    String name;
    String bio;

    Author(String title, int publicationYear, String name, String bio) {
        super(title, publicationYear);
        this.name = name;
        this.bio = bio;
    }

    void displayInfo() {
        System.out.println("Title: " + title + ", Publication Year: " + publicationYear +
                           ", Author: " + name + ", Bio: " + bio);
    }
}

public class Main {
    public static void main(String[] args) {
        Author book1 = new Author("The Great Adventure", 2020, "John Doe", "An experienced fiction writer");
        book1.displayInfo();
    }
}
