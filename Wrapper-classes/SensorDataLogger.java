import java.util.*;

public class SensorDataLogger {

    public static void logTemperature(Double temp, ArrayList<Double> list) {
        list.add(temp);
    }

    public static void main(String[] args) {
        ArrayList<Double> temperatures = new ArrayList<>();

        double t1 = 25.5;
        Double t2 = 30.2;

        logTemperature(t1, temperatures);
        logTemperature(t2, temperatures);

        for (Double temp : temperatures) {
            double value = temp;
            System.out.println("Temperature: " + value);
        }
    }
}