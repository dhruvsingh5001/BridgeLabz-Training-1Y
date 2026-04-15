import java.util.*;

class LibraryCatalog {
    public static void main(String[] args) {
        Map<String, String> books = new TreeMap<>();

        books.put("978-1", "Java");
        books.put("978-2", "Python");
        books.put("978-3", "C++");

        String isbn = "978-2";
        System.out.println(books.getOrDefault(isbn, "Book not found"));

        books.remove("978-3");

        for (String key : books.keySet()) {
            System.out.println(key + " " + books.get(key));
        }

        String searchTitle = "Java";
        for (String key : books.keySet()) {
            if (books.get(key).equals(searchTitle)) {
                System.out.println("Found ISBN: " + key);
            }
        }
    }
}