import java.util.concurrent.Executors;
public class VirtualThreadJava21 {
    public static void main (String[]args){
        Runnable runnable = () -> System.out.println("Inside Runnable:"+Thread.currentThread().getName());
        Thread.startVirtualThread(runnable);
        Thread virtualThread = Thread.ofVirtual().start(runnable);
        var executor = Executors.newVirtualThreadPerTaskExecutor();
        executor.submit(runnable);
        executor.shutdown();
    }
}
