package mainapp.threading;

import java.util.List;
import java.util.ArrayList;
import mainapp.projek_pbo.BangunRuang;
import mainapp.projek_pbo.BendaGeometri;

public class ThreadExecutorSingle {

    public static List processShapes(List<BendaGeometri> shapes) {
        int index = 1;
        ArrayList<String> output = new ArrayList<>();
        for (BendaGeometri shape : shapes) {
            output.add(processShape(shape, index++));
        }
        return output;
    }

    private static String processShape(BendaGeometri shape, int index) {
        try{
            String threadName = Thread.currentThread().getName();
            BangunRuang bd = (BangunRuang) shape;

            return String.format("%s | #%d | [%s] -> %s\n",
                    threadName,
                    index,
                    shape.getClass().getSimpleName(),
                    bd.infoSingleLine());
        }
        catch(Exception e){
            return "Error: " + e.getMessage();
        }
    }
}