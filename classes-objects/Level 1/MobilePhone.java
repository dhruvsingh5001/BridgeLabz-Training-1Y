class MobilePhone {
    String brand;
    String model;
    double price;

    public MobilePhone(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    public void displayDetails() {
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Price: " + price);
    }
}

public class MobilePhoneTest {
    public static void main(String[] args) {
        MobilePhone phone1 = new MobilePhone("Samsung", "Galaxy S23", 75000);
        MobilePhone phone2 = new MobilePhone("Apple", "iPhone 14", 80000);

        System.out.println("Mobile Phone 1 Details:");
        phone1.displayDetails();

        System.out.println("\nMobile Phone 2 Details:");
        phone2.displayDetails();
    }
}
