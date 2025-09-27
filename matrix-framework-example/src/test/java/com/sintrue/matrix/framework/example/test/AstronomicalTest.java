package com.sintrue.matrix.framework.example.test;


import org.junit.jupiter.api.Test;
import wang.liangchen.matrix.framework.commons.astronomy.AstronomicalAlgorithmUtil;
import wang.liangchen.matrix.framework.commons.datetime.DateTimeUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

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
        Path path = Paths.get("D:\\EquationOfTime.csv");
        Files.lines(path).skip(100).limit(30).forEach(line -> {
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
}

