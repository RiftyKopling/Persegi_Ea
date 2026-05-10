package mainapp.threading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import mainapp.projek_pbo.BangunDatar;
import mainapp.projek_pbo.BendaGeometri;

public class ThreadExecutor {

    public static List processShapes(List<BendaGeometri> shapes) {
        ArrayList<String> output = new ArrayList<>();

        ExecutorService executor = Executors.newFixedThreadPool(4);
        AtomicInteger counter = new AtomicInteger(1);

        for (BendaGeometri shape : shapes) {
            executor.submit(() -> {
                output.add(processShape(shape, counter.getAndIncrement()));
            });
        }

        executor.shutdown();
        
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
