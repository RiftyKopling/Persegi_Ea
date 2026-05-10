package mainapp.threading;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import mainapp.projek_pbo.BangunDatar;
import mainapp.projek_pbo.BendaGeometri;

public class ThreadExecutor {

    public static List processShapes(List<BendaGeometri> shapes) {
        List<String> output = Collections.synchronizedList(new ArrayList<>());

        ExecutorService executor = Executors.newFixedThreadPool(4);
        AtomicInteger counter = new AtomicInteger(1);

        for (BendaGeometri shape : shapes) {
            executor.execute(() -> {
                String result = processShape(shape, counter.getAndIncrement());
                output.add(result);
            });
        }

        executor.shutdown();
        try {
            executor.awaitTermination(10, TimeUnit.MINUTES);
        } 
        catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
        
        return output;
    }

    private static String processShape(BendaGeometri shape, int index) {
        String threadName = Thread.currentThread().getName();

        try {
            Thread.sleep((int)(Math.random()*100)); // bikin acak

            BangunDatar bd = (BangunDatar) shape;

            return String.format("%s | #%d | [%s] -> Luas: %.2f%n",
                    threadName,
                    index,
                    shape.getClass().getSimpleName(),
                    bd.hitungLuas());

        } catch (Exception e) {
            return String.format("Error: " + e.getMessage());
        }
    }
}
