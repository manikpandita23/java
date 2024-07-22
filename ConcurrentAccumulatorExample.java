import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.LongAccumulator;
public class ConcurrentAccumulatorExample {
    public static void main(String[] args) throws InterruptedException {
        LongAccumulator balance = new LongAccumulator(Long::sum, 10000L);
        Runnable task = () -> balance.accumulate(1000L);
        ExecutorService executor = Executors.newFixedThreadPool(50);
        for (int i = 0; i < 50; i++) {
            executor.submit(task);
        }
        executor.shutdown();
        if (executor.awaitTermination(1000L, TimeUnit.MILLISECONDS)) {
            System.out.println("Balance: " + balance.get());
            assert balance.get() == 60000L : "Final balance is not as expected!";
        } else {
            System.out.println("Executor did not terminate in the expected time.");
        }
    }
}