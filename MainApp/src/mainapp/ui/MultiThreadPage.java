package mainapp.ui;

/**
 * @author morxidia
 * this page show single thread vs multi thread output
 */

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

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

        // ===== TOP PANEL =====
        JPanel topPanel = new JPanel();
        topPanel.add(button);

        add(topPanel, BorderLayout.NORTH);

        // ===== TEXT AREA =====
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

        // ===== BOTTOM PANEL =====
        JPanel bottomPanel = new JPanel(new GridLayout(1, 2));

        bottomPanel.add(singleRuntime);
        bottomPanel.add(multiRuntime);

        add(bottomPanel, BorderLayout.SOUTH);

        // ===== BUTTON ACTION =====
        button.addActionListener(e -> handleMultiThread());
    }

    public void handleMultiThread() {

        singleArea.setText("");
        multiArea.setText("");

        List<BendaGeometri> shapes = new ArrayList<>();
        Random rand = new Random();

        // generate random object
        for (int i = 0; i < 50; i++) {

            if (i % 2 == 0) {
                shapes.add(
                    new BujurSangkar(
                        rand.nextInt(10) + 1,
                        rand.nextInt(10) + 1
                    )
                );
            } else {
                shapes.add(
                    new LimasPersegi(
                        rand.nextInt(10) + 1,
                        rand.nextInt(5) + 1
                    )
                );
            }
        }

        new Thread(() -> {

            // =========================
            // SINGLE THREAD
            // =========================
            long startSingle = System.currentTimeMillis();

            List<String> singleOutput =
                    ThreadExecutorSingle.processShapes(shapes);

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

            // =========================
            // MULTI THREAD
            // =========================
            long startMulti = System.currentTimeMillis();

            List<String> multiOutput =
                    ThreadExecutor.processShapes(shapes);

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