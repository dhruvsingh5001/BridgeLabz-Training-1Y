import java.util.*;

class Ticket extends Thread {
    private int ticketId;
    private String type;
    private int queuePosition;
    private static Random rand = new Random();
    private static long totalTime = 0;
    private static int totalTickets = 0;
    private static Map<Integer, List<Long>> stats = new HashMap<>();

    public Ticket(int id, String type, int priority, int position) {
        this.ticketId = id;
        this.type = type;
        this.queuePosition = position;
        this.setPriority(priority);
        stats.putIfAbsent(priority, new ArrayList<>());
    }

    @Override
    public void run() {
        long start = System.currentTimeMillis();
        int sleepTime = (rand.nextInt(5) + 1) * 1000;

        System.out.println("Start -> Ticket: " + ticketId + " | Type: " + type +
                " | Agent: " + Thread.currentThread().getName() +
                " | Priority: " + getPriority() +
                " | Queue Pos: " + queuePosition);

        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {}

        long end = System.currentTimeMillis();
        long duration = (end - start) / 1000;

        synchronized (Ticket.class) {
            totalTime += duration;
            totalTickets++;
            stats.get(getPriority()).add(duration);
        }

        System.out.println("Completed -> Ticket: " + ticketId +
                " | Time: " + duration + " sec");
    }

    public static void printStats() {
        System.out.println("\nTotal Processing Time: " + totalTime + " sec");
        System.out.println("Average Time Per Ticket: " + (totalTime / totalTickets) + " sec");

        for (Map.Entry<Integer, List<Long>> entry : stats.entrySet()) {
            int priority = entry.getKey();
            List<Long> times = entry.getValue();
            long sum = 0;
            for (long t : times) sum += t;

            System.out.println("Priority " + priority +
                    " Avg Time: " + (times.size() == 0 ? 0 : sum / times.size()) + " sec");
        }
    }
}

public class TicketSystem {
    public static void main(String[] args) throws InterruptedException {

        List<Ticket> tickets = new ArrayList<>();

        tickets.add(new Ticket(1, "Critical Bug", 10, 1));
        tickets.add(new Ticket(2, "Feature Request", 4, 5));
        tickets.add(new Ticket(3, "General Query", 2, 7));
        tickets.add(new Ticket(4, "Feedback", 1, 10));
        tickets.add(new Ticket(5, "Critical Bug", 10, 2));
        tickets.add(new Ticket(6, "Feature Request", 4, 6));
        tickets.add(new Ticket(7, "General Query", 2, 8));
        tickets.add(new Ticket(8, "Feedback", 1, 9));
        tickets.add(new Ticket(9, "Critical Bug", 10, 3));
        tickets.add(new Ticket(10, "Feature Request", 4, 4));

        for (int i = 0; i < tickets.size(); i++) {
            tickets.get(i).setName("Agent-" + (i + 1));
        }

        tickets.sort((a, b) -> b.getPriority() - a.getPriority());

        for (Ticket t : tickets) t.start();

        for (Ticket t : tickets) t.join();

        Ticket.printStats();
    }
}