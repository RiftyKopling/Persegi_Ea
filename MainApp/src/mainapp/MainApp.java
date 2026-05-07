package mainapp;

import java.util.*;

public class MainApp {

    public static void main(String[] args) {

        List<BendaGeometri> shapes = new ArrayList<>(); // Polymorphism
        Random rand = new Random();

        // generate random object
        for (int i = 0; i < 50; i++) {
            if (i % 2 == 0) {
                shapes.add(new BujurSangkar(rand.nextInt(10) + 1));
            } else {
                shapes.add(new LimasPersegi(rand.nextInt(10) + 1, rand.nextInt(5) + 1));
            }
        }

        System.out.println("=== SINGLE THREAD ===");
        ThreadExecutorSingle.processShapes(shapes);

        System.out.println("\n=== MULTI THREAD ===");
        ThreadExecutor.processShapes(shapes);
    }
}