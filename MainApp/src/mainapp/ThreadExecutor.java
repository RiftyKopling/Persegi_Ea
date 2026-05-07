package mainapp;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadExecutor {

    public static void processShapes(List<BendaGeometri> shapes) {

        ExecutorService executor = Executors.newFixedThreadPool(4);
        AtomicInteger counter = new AtomicInteger(1);

        for (BendaGeometri shape : shapes) {
            executor.submit(() -> processShape(shape, counter.getAndIncrement()));
        }

        executor.shutdown();
    }

    private static void processShape(BendaGeometri shape, int index) {
        String threadName = Thread.currentThread().getName();

        try {
            Thread.sleep((int)(Math.random()*100)); // bikin acak

            BangunDatar bd = (BangunDatar) shape;

            System.out.printf("%s | #%d | [%s] -> Luas: %.2f%n",
                    threadName,
                    index,
                    shape.getClass().getSimpleName(),
                    bd.hitungLuas());

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
