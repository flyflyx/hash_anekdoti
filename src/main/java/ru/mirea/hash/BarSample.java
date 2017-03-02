package ru.mirea.hash;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BarSample {

    public static void main(String[] args) throws IOException {
        DefaultCategoryDataset data = new DefaultCategoryDataset();
        String category = "Население";
        data.addValue(12_000_000, category, "Москва");
        data.addValue(5_000_000, category, "Санкт-Петербург");
        data.addValue(200_000, category, "Бобруйск");
        JFreeChart chart = ChartFactory.createBarChart("Население городов", "Город", "Население, чел", data);
        BufferedImage image = chart.createBufferedImage(600, 400);
        File file = new File("C:\\temp\\chart.png");
        ImageIO.write(image, "png", file);
        Desktop.getDesktop().open(file);
    }
}
