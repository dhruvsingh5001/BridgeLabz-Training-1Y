class HotelBooking {
    String guestName;
    String roomType;
    int nights;

    // Default Constructor
    public HotelBooking() {
        guestName = "Guest";
        roomType = "Standard";
        nights = 1;
    }

    // Parameterized Constructor
    public HotelBooking(String guestName, String roomType, int nights) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.nights = nights;
    }

    // Copy Constructor
    public HotelBooking(HotelBooking hb) {
        this.guestName = hb.guestName;
        this.roomType = hb.roomType;
        this.nights = hb.nights;
    }

    // Method to display booking details
    public void displayBookingDetails() {
        System.out.println("Guest Name: " + guestName);
        System.out.println("Room Type: " + roomType);
        System.out.println("Number of Nights: " + nights);
    }
}

public class HotelBookingTest {
    public static void main(String[] args) {
        // Using Default Constructor
        HotelBooking booking1 = new HotelBooking();
        System.out.println("Booking 1 (Default Constructor):");
        booking1.displayBookingDetails();

        // Using Parameterized Constructor
        HotelBooking booking2 = new HotelBooking("Aryan", "Deluxe", 3);
        System.out.println("\nBooking 2 (Parameterized Constructor):");
        booking2.displayBookingDetails();

        // Using Copy Constructor
        HotelBooking booking3 = new HotelBooking(booking2);
        System.out.println("\nBooking 3 (Copy Constructor - Cloned from Booking 2):");
        booking3.displayBookingDetails();
    }
}
