class Device {
    String deviceId;
    String status;

    Device(String deviceId, String status) {
        this.deviceId = deviceId;
        this.status = status;
    }

    void displayStatus() {
        System.out.println("Device ID: " + deviceId + ", Status: " + status);
    }
}

class Thermostat extends Device {
    int temperatureSetting;

    Thermostat(String deviceId, String status, int temperatureSetting) {
        super(deviceId, status);
        this.temperatureSetting = temperatureSetting;
    }

    void displayStatus() {
        System.out.println("Thermostat ID: " + deviceId + ", Status: " + status +
                           ", Temperature Setting: " + temperatureSetting + "°C");
    }
}

public class Main {
    public static void main(String[] args) {
        Thermostat t1 = new Thermostat("T1001", "On", 24);
        t1.displayStatus();
    }
}
