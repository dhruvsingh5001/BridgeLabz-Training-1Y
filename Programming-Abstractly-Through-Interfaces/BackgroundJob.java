public class BackgroundJob {
    public static void main(String[] args) {

        Runnable task = () -> {
            System.out.println("Background job started...");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            System.out.println("Background job finished.");
        };

        Thread thread = new Thread(task);
        thread.start();

        System.out.println("Main thread continues running...");
    }
}
