import java.util.concurrent.Executors;
public class VirtualThreadJava21 {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            try {
                Thread.sleep(500);
                System.out.println("Inside Runnable: " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };
        Thread.startVirtualThread(runnable);
        Thread virtualThread = Thread.ofVirtual().start(runnable);
        var executor = Executors.newVirtualThreadPerTaskExecutor();
        executor.submit(runnable);
        executor.shutdown();
        executor.awaitTermination(1, java.util.concurrent.TimeUnit.MINUTES);
        virtualThread.join();
    }
}