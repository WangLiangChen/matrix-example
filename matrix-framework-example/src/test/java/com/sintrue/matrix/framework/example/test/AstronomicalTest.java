package com.sintrue.matrix.framework.example.test;


import org.junit.jupiter.api.Test;
import wang.liangchen.matrix.framework.commons.astronomy.AstronomicalAlgorithmUtil;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;

public class AstronomicalTest {
    @Test
    public void testStep() {
        ZonedDateTime utc = ZonedDateTime.of(2000, 1, 1, 12, 0, 0, 0, ZoneOffset.UTC);
        double julianDay = AstronomicalAlgorithmUtil.INSTANCE.utc2JulianDay(utc);
        System.out.println("julianDay:" + julianDay);
        double julianCentury = AstronomicalAlgorithmUtil.INSTANCE.julianCentury(julianDay);
        System.out.println("julianCentury:" + julianCentury);
        double meanSolarLongitude = AstronomicalAlgorithmUtil.INSTANCE.meanSolarLongitude(julianCentury);
        System.out.println("meanSolarLongitude:" + meanSolarLongitude);
        double meanSolarAnomaly = AstronomicalAlgorithmUtil.INSTANCE.meanSolarAnomaly(julianCentury);
        System.out.println("meanSolarAnomaly:" + meanSolarAnomaly);
        double earthOrbitEccentricity = AstronomicalAlgorithmUtil.INSTANCE.earthOrbitEccentricity(julianCentury);
        System.out.println("earthOrbitEccentricity:" + earthOrbitEccentricity);
        double solarEquationOfCenter = AstronomicalAlgorithmUtil.INSTANCE.solarEquationOfCenter(meanSolarAnomaly, julianCentury);
        System.out.println("solarEquationOfCenter:" + solarEquationOfCenter);
        double trueSolarLongitude = AstronomicalAlgorithmUtil.INSTANCE.trueSolarLongitude(julianCentury);
        System.out.println("trueSolarLongitude:" + trueSolarLongitude);
        double truedSolarAnomaly = AstronomicalAlgorithmUtil.INSTANCE.trueSolarAnomaly(julianCentury);
        System.out.println("truedSolarAnomaly:" + truedSolarAnomaly);
        double eot1 = AstronomicalAlgorithmUtil.INSTANCE.equationOfTimeMinutes(utc);
        System.out.println("eot:" + eot1);

    }
    @Test
    public void solarTerm(){
        ZonedDateTime utc = AstronomicalAlgorithmUtil.INSTANCE.solarTerm(2000, 0);
        System.out.println(utc);
    }
}

