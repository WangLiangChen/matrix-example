package com.sintrue.matrix.framework.example.test;

import org.junit.jupiter.api.Test;
import wang.liangchen.matrix.framework.commons.datetime.DateTimeUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class JsoupTest {
    @Test
    public void crawerJieqi() throws IOException {
        Path path = Files.createFile(Path.of("D:\\Astronomical\\jieqi.txt"));
        List<String> lines = new ArrayList<>();
        lines.add("utc,beijing,solar_term");

        List<String> strings = Files.readAllLines(Path.of("D:\\Astronomical\\jieqi_temp.txt"));
        for (int i = 0; i < strings.size(); i++) {
            int index = i % 24;
            String beijing = strings.get(i);
            LocalDateTime beijingDateTime = DateTimeUtil.INSTANCE.dateTimeString2LocalDateTime(beijing);
            LocalDateTime utcDateTime = DateTimeUtil.INSTANCE.localDateTime2UTC(beijingDateTime, DateTimeUtil.CN_ZONE);
            lines.add(String.format("%s,%s,%d", DateTimeUtil.INSTANCE.format(utcDateTime), beijing, index));
        }
        Files.write(path, lines, StandardOpenOption.APPEND);
    }

}
