class Product implements Cloneable {
    String name;
    double price;

    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    void display() {
        System.out.println("Name: " + name + ", Price: " + price);
    }
}

public class CloneDemo {
    public static void main(String[] args) {
        try {
            Product p1 = new Product("Laptop", 55000);
            Product p2 = (Product) p1.clone();

            p1.display();
            p2.display();

            p2.name = "Phone";
            p2.price = 20000;

            p1.display();
            p2.display();

        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }
    }
}
