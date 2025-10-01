package com.sintrue.matrix.framework.example.test;


import org.junit.jupiter.api.Test;
import wang.liangchen.matrix.framework.commons.astronomy.AstronomicalAlgorithmUtil;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

public class AstronomicalTest {

    @Test
    public void validateEOT() {
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
    public void validation(){
        ZonedDateTime utc = ZonedDateTime.of(2000,3,20, 7,35,0,0,ZoneOffset.UTC);
        double v = AstronomicalAlgorithmUtil.INSTANCE.trueSolarLongitude(AstronomicalAlgorithmUtil.INSTANCE.utc2JulianCentury(utc));
        System.out.println(v);
    }
}

