import java.util.*;

class Cart<T> {
    private List<T> items = new ArrayList<>();

    public void addItem(T item) {
        items.add(item);
    }

    public void removeItem(T item) {
        items.remove(item);
    }

    public void displayItems() {
        for (T item : items) {
            System.out.println(item);
        }
    }
}

class Electronics {
    String name;

    public Electronics(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
}

class Clothing {
    String name;

    public Clothing(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
}

public class Main {
    public static void main(String[] args) {
        Cart<Electronics> electronicsCart = new Cart<>();
        electronicsCart.addItem(new Electronics("Laptop"));
        electronicsCart.addItem(new Electronics("Mobile"));
        electronicsCart.displayItems();

        Cart<Clothing> clothingCart = new Cart<>();
        clothingCart.addItem(new Clothing("Shirt"));
        clothingCart.addItem(new Clothing("Jeans"));
        clothingCart.displayItems();
    }
}