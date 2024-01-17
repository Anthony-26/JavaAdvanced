package com.example.util;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Map;
import java.util.TreeMap;

import com.example.model.PricesTimeSerie;

public class Actions {

    public static String getDataFromTreeMap(TreeMap<LocalDate, PricesTimeSerie> dailySeries) {

        LocalDate mostRecentDate = dailySeries.lastKey();

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

                    Current value :

                    30 Days High/Low  : $%,.2f | $%,.2f
                    52 Weeks High/Low : $%,.2f | $%,.2f

                    Global Performance :
                        1 Week  : %,.2f%%
                        1 Month : %,.2f%%
                        1 Year  : %,.2f%%

                /--------------------------------------------------------------------/
                """.formatted(
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

}
