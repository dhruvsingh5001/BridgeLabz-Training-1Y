class Activity extends Thread {
    private String activityName;
    private int startDelay;

    public Activity(String name, int delay) {
        this.activityName = name;
        this.startDelay = delay;
    }

    @Override
    public void run() {
        try {
            System.out.println(activityName + " State: " + Thread.currentThread().getState());

            Thread.sleep(startDelay);

            System.out.println(activityName + " Started | State: " + Thread.currentThread().getState());

            for (int i = 1; i <= 3; i++) {
                System.out.println(activityName + " Running Cycle " + i + " | State: " + Thread.currentThread().getState());
                Thread.sleep(2000);
            }

            System.out.println(activityName + " Completed | State: " + Thread.currentThread().getState());

        } catch (InterruptedException e) {
            System.out.println(activityName + " Interrupted");
        }
    }
}

public class ExamHallManagement {
    public static void main(String[] args) throws InterruptedException {

        Activity entry = new Activity("Student Entry Monitoring", 0);
        Activity question = new Activity("Question Paper Distribution", 5000);
        Activity attendance = new Activity("Attendance Marking", 10000);
        Activity collection = new Activity("Answer Sheet Collection", 15000);

        entry.setPriority(5);
        question.setPriority(10);
        attendance.setPriority(8);
        collection.setPriority(7);

        System.out.println("Entry Thread State: " + entry.getState());
        System.out.println("Question Thread State: " + question.getState());
        System.out.println("Attendance Thread State: " + attendance.getState());
        System.out.println("Collection Thread State: " + collection.getState());

        entry.start();
        question.start();
        attendance.start();
        collection.start();

        System.out.println("Entry Thread State After Start: " + entry.getState());
        System.out.println("Question Thread State After Start: " + question.getState());
        System.out.println("Attendance Thread State After Start: " + attendance.getState());
        System.out.println("Collection Thread State After Start: " + collection.getState());

        entry.join();
        question.join();
        attendance.join();
        collection.join();

        System.out.println("All activities completed");
    }
}