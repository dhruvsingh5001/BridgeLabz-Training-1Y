import java.time.LocalTime;

class Device implements Runnable {
    private String name;
    private int interval;

    public Device(String name, int interval) {
        this.name = name;
        this.interval = interval;
    }

    @Override
    public void run() {
        int priority = Thread.currentThread().getPriority();

        for (int i = 1; i <= 5; i++) {
            System.out.println(
                LocalTime.now() + " | " + name + " running | Cycle: " + i + " | Priority: " + priority
            );

            try {
                Thread.sleep(interval);
            } catch (InterruptedException e) {
                System.out.println(name + " interrupted");
            }
        }
    }
}

public class SmartHomeSystem {
    public static void main(String[] args) {
        Thread temp = new Thread(new Device("Temperature Sensor", 5000));
        Thread security = new Thread(new Device("Security Camera", 3000));
        Thread light = new Thread(new Device("Light Controller", 4000));
        Thread door = new Thread(new Device("Door Lock Monitor", 6000));

        temp.setPriority(7);
        security.setPriority(10);
        light.setPriority(5);
        door.setPriority(5);

        temp.start();
        security.start();
        light.start();
        door.start();
    }
}