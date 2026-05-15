package mainapp.ui;

import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import mainapp.Handling.InvalidDimensionException;
import mainapp.threading.*;
import mainapp.projek_pbo.*;

public class MultiThreadPage extends JPanel {

    private JTextArea singleArea = new JTextArea();
    private JTextArea multiArea = new JTextArea();

    private JLabel singleRuntime = new JLabel("Runtime Single Thread : -");
    private JLabel multiRuntime = new JLabel("Runtime Multi Thread : -");

    private JButton button = new JButton("Show Multi Thread Executor");

    public MultiThreadPage() {

        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        topPanel.add(button);

        add(topPanel, BorderLayout.NORTH);

        singleArea.setEditable(false);
        multiArea.setEditable(false);

        JScrollPane singleScroll = new JScrollPane(singleArea);
        JScrollPane multiScroll = new JScrollPane(multiArea);

        JPanel centerPanel = new JPanel(new GridLayout(1, 2, 10, 10));

        // LEFT PANEL
        JPanel leftPanel = new JPanel(new BorderLayout());
        leftPanel.add(new JLabel("Single Thread", SwingConstants.CENTER),
                BorderLayout.NORTH);
        leftPanel.add(singleScroll, BorderLayout.CENTER);

        // RIGHT PANEL
        JPanel rightPanel = new JPanel(new BorderLayout());
        rightPanel.add(new JLabel("Multi Thread", SwingConstants.CENTER),
                BorderLayout.NORTH);
        rightPanel.add(multiScroll, BorderLayout.CENTER);

        centerPanel.add(leftPanel);
        centerPanel.add(rightPanel);

        add(centerPanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new GridLayout(1, 2));

        bottomPanel.add(singleRuntime);
        bottomPanel.add(multiRuntime);

        add(bottomPanel, BorderLayout.SOUTH);

        button.addActionListener(e -> handleMultiThread());
    }

    public void handleMultiThread() {

        singleArea.setText("");
        multiArea.setText("");

        List<BendaGeometri> shapes = new ArrayList<>();
        Random rand = new Random();

        for (int i = 0; i < 1000000; i++) {

            if (i % 2 == 0) {
                try {
                    shapes.add(new BujurSangkar(
                            rand.nextInt(10) + 1,
                            rand.nextInt(10) + 1
                    ));
                } catch (InvalidDimensionException ex) {
                    // fallback aman (harusnya tidak kejadian karena random >=1)
                    shapes.add(new BujurSangkar());
                }
            } else {
                try {
                    shapes.add(new LimasPersegi(
                            rand.nextInt(10) + 1,
                            rand.nextInt(5) + 1
                    ));
                } catch (InvalidDimensionException ex) {
                    shapes.add(new LimasPersegi());
                }
            }
        }

        new Thread(() -> {
            long startSingle = System.currentTimeMillis();

            List<String> singleOutput
                    = ThreadExecutorSingle.processShapes(shapes);

            long endSingle = System.currentTimeMillis();

            SwingUtilities.invokeLater(() -> {

                for (String s : singleOutput) {
                    singleArea.append(s);
                }

                singleRuntime.setText(
                        "Runtime Single Thread : "
                        + (endSingle - startSingle)
                        + " ms"
                );
            });

            long startMulti = System.currentTimeMillis();

            List<String> multiOutput
                    = ThreadExecutor.processShapes(shapes);

            long endMulti = System.currentTimeMillis();

            SwingUtilities.invokeLater(() -> {

                for (String s : multiOutput) {
                    multiArea.append(s);
                }

                multiRuntime.setText(
                        "Runtime Multi Thread : "
                        + (endMulti - startMulti)
                        + " ms"
                );
            });

        }).start();
    }
}
