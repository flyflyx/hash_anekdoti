package ru.mirea.hash;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Test {


    private static long run(int k) {
        long t0 = System.currentTimeMillis();
        MyHashTable t = new MyHashTable(k);
        int n = 10000;
        for (int i = 0; i < n; i++) {
            t.add("table" + i, "стол" + i);
        }
        for (int j = 0; j < 100; j++) {
            for (int i = 0; i < n; i++) {
                t.get("table" + i);
            }
        }
        long t1 = System.currentTimeMillis();
        return t1 - t0;
    }

    public static void main(String[] args) throws IOException {
        XYSeries series = new XYSeries("1");
        int[] ks = {100, 200, 500, 1000, 2000};
        for (int k : ks) {
            long time = run(k);
            series.add(k, time);
        }

        XYSeriesCollection sc = new XYSeriesCollection(series);
        JFreeChart chart = ChartFactory.createXYLineChart("Hash", "k", "Time", sc);
        BufferedImage image = chart.createBufferedImage(600, 400);
        File file = new File("C:\\temp\\chart.png");
        ImageIO.write(image, "png", file);
        Desktop.getDesktop().open(file);
    }
}
