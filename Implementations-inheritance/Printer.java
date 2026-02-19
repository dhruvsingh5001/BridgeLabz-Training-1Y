class Printer {
    void printDocument(String content) {
        System.out.println("Printing: " + content);
    }
}

class ColorPrinter extends Printer {
    void printColorDocument(String content, String color) {
        System.out.println("Printing in " + color + ": " + content);
    }
}

public class Main {
    public static void main(String[] args) {
        Printer basicPrinter = new Printer();
        ColorPrinter colorPrinter = new ColorPrinter();

        basicPrinter.printDocument("Hello World");
        colorPrinter.printDocument("Hello World");
        colorPrinter.printColorDocument("Hello World", "Red");
    }
}
