import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 
 */

/**
 * @author Akhil
 *
 */
public class Worker implements Runnable{
	private static BlockingQueue<Order> queue = new ArrayBlockingQueue<Order>(5);

    public void run() {
        Thread t1 = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    producer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    consumer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        t2.start();
        System.out.println("Producer and Consumer has been started...");
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void producer() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Order orderObj = new Order("NEW", i);
            Thread.sleep(1000);
            queue.put(orderObj);
            System.out.println("Produced: " + orderObj.getState()
                    + " Order No: " + orderObj.getOrderNumber());
        }
        Thread.sleep(1000);
        Order orderObj = new Order("FULFILLED");
        System.out.println("Produced State Changed : " + orderObj.getState());
    }

    public static void consumer() throws InterruptedException {
        Order order;
        while ((order = queue.take()).getState() != "FULFILLED") {
            Thread.sleep(1000);
            System.out.println("Consumed: " + order.getState() + " Order No: "
                    + order.getOrderNumber());
        }
    }	
	
	
}
