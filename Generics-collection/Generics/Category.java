import java.util.*;

abstract class Category {
    String name;

    public Category(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
}

class BookCategory extends Category {
    public BookCategory(String name) {
        super(name);
    }
}

class ClothingCategory extends Category {
    public ClothingCategory(String name) {
        super(name);
    }
}

class GadgetCategory extends Category {
    public GadgetCategory(String name) {
        super(name);
    }
}

class Product<T extends Category> {
    String productName;
    double price;
    T category;

    public Product(String productName, double price, T category) {
        this.productName = productName;
        this.price = price;
        this.category = category;
    }

    public String toString() {
        return productName + " - " + price + " - " + category;
    }
}

class CatalogUtil {
    public static <T extends Category> void displayProducts(List<Product<T>> products) {
        for (Product<T> p : products) {
            System.out.println(p);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        List<Product<BookCategory>> books = Arrays.asList(
                new Product<>("Java Book", 500, new BookCategory("Education")),
                new Product<>("DSA Book", 600, new BookCategory("Programming"))
        );

        List<Product<ClothingCategory>> clothes = Arrays.asList(
                new Product<>("Shirt", 1200, new ClothingCategory("Men")),
                new Product<>("Dress", 2000, new ClothingCategory("Women"))
        );

        List<Product<GadgetCategory>> gadgets = Arrays.asList(
                new Product<>("Mobile", 20000, new GadgetCategory("Electronics")),
                new Product<>("Laptop", 60000, new GadgetCategory("Electronics"))
        );

        CatalogUtil.displayProducts(books);
        CatalogUtil.displayProducts(clothes);
        CatalogUtil.displayProducts(gadgets);
    }
}