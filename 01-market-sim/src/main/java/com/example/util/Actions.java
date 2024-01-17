package com.example.util;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import com.example.model.Fractal;
import com.example.model.PricesTimeSerie;

public class Actions {

    public static String getDataFromTreeMap(TreeMap<LocalDate, PricesTimeSerie> dailySeries, String ticker) {

        LocalDate mostRecentDate = dailySeries.lastKey();
        BigDecimal mostRecentValue = dailySeries.get(mostRecentDate).getClose();

        LocalDate dateOneWeekBefore = synchronizeDates(dailySeries, mostRecentDate.minusWeeks(1));
        LocalDate dateOneMonthBefore = synchronizeDates(dailySeries, mostRecentDate.minusMonths(1));
        LocalDate dateOneYearBefore = synchronizeDates(dailySeries, mostRecentDate.minusYears(1));

        BigDecimal[] last30dExtrems = getExtremLevelsByTime(dailySeries, dateOneMonthBefore, mostRecentDate);
        BigDecimal[] last52wExtrems = getExtremLevelsByTime(dailySeries, dateOneYearBefore, mostRecentDate);

        BigDecimal weeklyPerformance = getPerformanceByTime(dailySeries, dateOneWeekBefore, mostRecentDate);

        BigDecimal monthlyPerformance = getPerformanceByTime(dailySeries, dateOneMonthBefore, mostRecentDate);
        BigDecimal yearlyPerformance = getPerformanceByTime(dailySeries, dateOneYearBefore, mostRecentDate);

        return """

                /--------------------------------------------------------------------/

                    Last known value (%s) for %s : $%,.2f 

                    30 Days High/Low  : $%,.2f | $%,.2f
                    52 Weeks High/Low : $%,.2f | $%,.2f

                    Global Performance :
                        1 Week  : %,.2f%%
                        1 Month : %,.2f%%
                        1 Year  : %,.2f%%

                /--------------------------------------------------------------------/
                """.formatted(
                mostRecentDate.toString(),
                ticker,
                mostRecentValue.doubleValue(),
                last30dExtrems[0].doubleValue(),
                last30dExtrems[1].doubleValue(),
                last52wExtrems[0].doubleValue(),
                last52wExtrems[1].doubleValue(),
                weeklyPerformance.doubleValue(),
                monthlyPerformance.doubleValue(),
                yearlyPerformance.doubleValue());

    }

    public static BigDecimal[] getExtremLevelsByTime(
            TreeMap<LocalDate, PricesTimeSerie> Series,
            LocalDate startingDate,
            LocalDate endingDate) {

        BigDecimal[] extrems = new BigDecimal[2];
        extrems[0] = Series.get(endingDate).getHigh();
        extrems[1] = Series.get(endingDate).getLow();

        for (Map.Entry<LocalDate, PricesTimeSerie> entry : Series
                .subMap(startingDate, true, endingDate, true)
                .entrySet()) {
            BigDecimal localHigh = entry.getValue().getHigh();
            BigDecimal localLow = entry.getValue().getLow();

            /* Debugging output */
            // System.out.println("Date : " + entry.getKey() + " currentValue : " +
            // extrems[0] + " compared to newValue : " + localHigh);
            // System.out.println("Date : " + entry.getKey() + " currentLow : " +
            // extrems[1] + " compared to newLow : " + localLow);

            if (localHigh.compareTo(extrems[0]) > 0) {
                extrems[0] = localHigh;
            }
            if (extrems[1].compareTo(localLow) > 0) {
                extrems[1] = localLow;
            }
        }

        return extrems;
    }

    public static BigDecimal getPerformanceByTime(
            TreeMap<LocalDate, PricesTimeSerie> Series,
            LocalDate startingDate,
            LocalDate endingDate) {
        BigDecimal performance = Series.get(endingDate)
                .getClose()
                .divide(Series.get(startingDate).getOpen(), 4,
                        java.math.RoundingMode.HALF_UP)
                .subtract(new BigDecimal("1"))
                .multiply(new BigDecimal("100"));

        return performance;
    }

    private static LocalDate synchronizeDates(TreeMap<LocalDate, PricesTimeSerie> series, LocalDate dateToSynchronize) {
        if (series.containsKey(dateToSynchronize))
            return dateToSynchronize;
        else {
            while (!series.containsKey(dateToSynchronize)) {
                dateToSynchronize = dateToSynchronize.plusDays(1);
            }
        }
        return dateToSynchronize;
    }

    public static Fractal getFractals(TreeMap<LocalDate, PricesTimeSerie> series){
        TreeMap<LocalDate, BigDecimal> bearishFractal = new TreeMap<>();
        TreeMap<LocalDate, BigDecimal> bullishFractal = new TreeMap<>();

        ArrayList<LocalDate> dates = new ArrayList<>(series.keySet());

        if(dates.size() < 2){
            return null;
        }

        LocalDate currentDate;
        PricesTimeSerie currentSeries;

        PricesTimeSerie prevSeries1;
        PricesTimeSerie prevSeries2;
        PricesTimeSerie nextSeries1;
        PricesTimeSerie nextSeries2;

        for (int i = 2; i < dates.size() - 2; i++) {

            currentDate = dates.get(i);
            currentSeries = series.get(currentDate);

            prevSeries1 = series.get(dates.get(i - 1));
            prevSeries2 = series.get(dates.get(i - 2));
            nextSeries1 = series.get(dates.get(i + 1));
            nextSeries2 = series.get(dates.get(i + 2));

            if (currentSeries.getHigh().compareTo(prevSeries1.getHigh()) > 0 &&
                    currentSeries.getHigh().compareTo(prevSeries2.getHigh()) > 0 &&
                    currentSeries.getHigh().compareTo(nextSeries1.getHigh()) > 0 &&
                    currentSeries.getHigh().compareTo(nextSeries2.getHigh()) > 0) {
                bearishFractal.put(currentDate, currentSeries.getHigh());
            }

            if (currentSeries.getLow().compareTo(prevSeries1.getLow()) < 0 &&
                    currentSeries.getLow().compareTo(prevSeries2.getLow()) < 0 &&
                    currentSeries.getLow().compareTo(nextSeries1.getLow()) < 0 &&
                    currentSeries.getLow().compareTo(nextSeries2.getLow()) < 0) {
                bullishFractal.put(currentDate, currentSeries.getLow());
            }

        }
        Fractal fractals = new Fractal(bearishFractal, bullishFractal);

        return fractals;
    }

}
