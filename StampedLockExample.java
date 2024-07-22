import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.StampedLock;
class Balance {
    private int amount;
    public Balance (int amount){
        this.amount = amount;
    }
    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
        }
}
public class StampedLockExample {
    public static void main(String[] args) {
        StampedLock lock = new StampedLock();
        Balance balance = new Balance(10000);
        Runnable writeTask = () -> {
            long stamp = lock.writeLock();
            try {
                balance.setAmount(balance.getAmount()+1000);
            }
            finally {
                lock.unlockWrite(stamp);
            }
        };
        Runnable readTask = () -> {
            long stamp = lock.tryOptimisticRead();
            int currentBalance = balance.getAmount();
            if (! lock.validate(stamp)) {
                stamp = lock.readLock();
                try {
                    currentBalance = balance.getAmount();
                }
                finally {
                    lock.unlockRead(stamp);
                }
            }
            System.out.println("Current Balance: " + currentBalance);
        };
        ExecutorService executor = Executors.newFixedThreadPool(10);
        for (int i = 0; i<50; i++){
            executor.execute(writeTask);
            executor.execute(readTask);
        }
        executor.shutdown();
    }
}