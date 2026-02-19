class Product {
    // Instance Variables
    String productName;
    double price;

    // Class Variable (shared among all objects)
    static int totalProducts = 0;

    // Constructor
    public Product(String productName, double price) {
        this.productName = productName;
        this.price = price;
        totalProducts++; // Increment count whenever a product is created
    }

    // Instance Method to display product details
    public void displayProductDetails() {
        System.out.println("Product Name: " + productName);
        System.out.println("Price: " + price);
    }

    // Class Method to display total number of products
    public static void displayTotalProducts() {
        System.out.println("Total Products Created: " + totalProducts);
    }
}

public class ProductInventory {
    public static void main(String[] args) {
        Product p1 = new Product("Laptop", 60000);
        Product p2 = new Product("Mobile", 20000);
        Product p3 = new Product("Headphones", 3000);

        System.out.println("Product 1 Details:");
        p1.displayProductDetails();

        System.out.println("\nProduct 2 Details:");
        p2.displayProductDetails();

        System.out.println("\nProduct 3 Details:");
        p3.displayProductDetails();

        System.out.println();
        Product.displayTotalProducts(); // Calling class method
    }
}
