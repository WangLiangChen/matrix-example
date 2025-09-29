package com.sintrue.matrix.framework.example.test;


import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.junit.jupiter.api.Test;
import wang.liangchen.matrix.framework.commons.astronomy.AstronomicalAlgorithmUtil;
import wang.liangchen.matrix.framework.commons.datetime.DateTimeUtil;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AstronomicalTest {

    @Test
    public void validateJulianDay() {
        List<String> list = new ArrayList<>(100);
        list.add("2000-01-01 12:00:00@2451545.00000");

        list.forEach(string -> {
            int i = string.indexOf("@");
            String datetimeString = string.substring(0, i);
            String julianString = string.substring(i + 1);
            ZonedDateTime utc = ZonedDateTime.of(LocalDateTime.parse(datetimeString, DateTimeUtil.DEFAULT_DATETIME_FORMATTER), ZoneOffset.UTC);
            double julian = Double.parseDouble(julianString);
            double result = AstronomicalAlgorithmUtil.INSTANCE.utc2JulianDay(utc);
            System.out.println(String.format("datetime:%s, julian:%f, result:%f = %f", datetimeString, julian, result, julian - result));
        });
    }

    @Test
    public void testEOT() throws IOException {
        Path path = Paths.get("D:\\Astronomical\\EquationOfTime.csv");
        Files.lines(path).skip(1000).limit(30).forEach(line -> {
            String[] split = line.split(",");
            String datetimeString = split[0];
            ZonedDateTime utc = ZonedDateTime.of(LocalDateTime.parse(datetimeString, DateTimeFormatter.ISO_DATE_TIME), ZoneOffset.UTC);
            double eot_total = Double.parseDouble(split[1]);
            double eot_eccentricity = Double.parseDouble(split[2]);
            double eot_obliquity = Double.parseDouble(split[3]);
            double[] doubles = AstronomicalAlgorithmUtil.INSTANCE.equationOfTimeWithComponents(AstronomicalAlgorithmUtil.INSTANCE.uct2JulianCentury(utc));
            System.out.println(doubles[0] * 4 - eot_total);
        });

    }

    @Test
    public void testEOTUTC() {
        double[] benches = {-3.28, -13.53, -12.3, -3.77, 2.95, 2.14, -3.89, -6.29, 0.1, 10.42, 16.45, 10.83, -9.21, -14.2, -8.83, 0.04, 3.66, -0.52, -5.98, -4.4, 4.88, 14.3, 15.37, 4.68, -13.22, -12.49, -4.66, 2.7, 2.58, -3.5, -6.44, -0.84, 9.77, 16.33, 11.56, -2.21};
        for (int i = 0; i < benches.length; i++) {
            int month = i % 12 + 1;
            int day = i / 12 * 15;
            day = 0 == day ? 1 : day;
            if (2 == month && day == 30) {
                day = 29;
            }


            ZonedDateTime utc = ZonedDateTime.of(2000, month, day, 0, 0, 0, 0, ZoneOffset.UTC);
            double minutes = AstronomicalAlgorithmUtil.INSTANCE.equationOfTimeMinutes(utc);
            System.out.println(new BigDecimal(minutes - benches[i]).setScale(2, RoundingMode.HALF_UP).doubleValue());
        }


    }

    @Test
    public void testPdf() throws IOException {
        Pattern yearPattern = Pattern.compile("公元(\\d{4})年");
        Pattern jieqiPattern = Pattern.compile("节  气.*", Pattern.DOTALL);

        try (PDDocument document = Loader.loadPDF(new File("D:\\Astronomical\\1900-2025.pdf"))) {
            PDFTextStripper stripper = new PDFTextStripper();

            // 设置提取选项
            stripper.setSortByPosition(true); // 按位置排序
            stripper.setStartPage(3);         // 起始页
            stripper.setEndPage(3);           // 结束页
            String text = stripper.getText(document);
            Matcher yearMatcher = yearPattern.matcher(text);
            if (yearMatcher.find()) {
                System.out.println(yearMatcher.group(1));
            }
            Matcher jieqiMatcher = jieqiPattern.matcher(text);
            if (jieqiMatcher.find()) {
                String[] lines = jieqiMatcher.group().split("\r\n");
                for (int i = 2; i < lines.length; i++) {
                    String[] split = lines[i].split(" ");
                    for (int j = 0; j < split.length; j++) {
                        if (j % 5 == 0) {
                            System.out.println(split[j]);
                        }
                    }
                }
            }

        }
    }
}

