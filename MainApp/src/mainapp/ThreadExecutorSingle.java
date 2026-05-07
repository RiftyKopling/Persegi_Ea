package mainapp;

import java.util.List;

public class ThreadExecutorSingle {

    public static void processShapes(List<BendaGeometri> shapes) {
        int index = 1;

        for (BendaGeometri shape : shapes) {
            processShape(shape, index++);
        }
    }

    private static void processShape(BendaGeometri shape, int index) {
        String threadName = Thread.currentThread().getName();

        BangunDatar bd = (BangunDatar) shape;

        System.out.printf("%s | #%d | [%s] -> Luas: %.2f%n",
                threadName,
                index,
                shape.getClass().getSimpleName(),
                bd.hitungLuas());
    }
}