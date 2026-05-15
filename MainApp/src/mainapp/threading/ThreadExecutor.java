package mainapp.threading;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

import mainapp.projek_pbo.BangunRuang;
import mainapp.projek_pbo.BendaGeometri;

public class ThreadExecutor {

    public static List<String> processShapes(List<BendaGeometri> shapes) {

        List<String> output
                = Collections.synchronizedList(new ArrayList<>());

        // jumlah thread mengikuti jumlah core CPU
        int totalThread
                = Runtime.getRuntime().availableProcessors();

        ExecutorService executor
                = Executors.newFixedThreadPool(totalThread);

        AtomicInteger counter = new AtomicInteger(1);

        for (BendaGeometri shape : shapes) {

            executor.execute(() -> {

                String result
                        = processShape(
                                shape,
                                counter.getAndIncrement()
                        );

                output.add(result);
            });
        }

        executor.shutdown();

        try {

            executor.awaitTermination(
                    10,
                    TimeUnit.MINUTES
            );

        } catch (InterruptedException e) {

            e.printStackTrace();
            Thread.currentThread().interrupt();
        }

        return output;
    }

    private static String processShape(
            BendaGeometri shape,
            int index
    ) {

        String threadName
                = Thread.currentThread().getName();

        try {

            // =========================
            // SIMULASI PEKERJAAN BERAT
            // =========================
            double result = 0;

            for (long i = 0; i < 5_000_000L; i++) {
                result += Math.sqrt(i);
            }

            BangunRuang bd
                    = (BangunRuang) shape;

            return String.format(
                    "%s | #%d | [%s] -> %s\n",
                    threadName,
                    index,
                    shape.getClass().getSimpleName(),
                    bd.infoSingleLine()
            );

        } catch (Exception e) {

            return "Error : " + e.getMessage();
        }
    }
}
