package ru.itpark;

import java.text.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import static java.util.Calendar.*;

public class DepositCalculatorService {

    public int depositCalculate(int sumDeposit, String dateStart, int period, double percentDeposit) {

        double deposit = 0;

        double percent = Math.round(percentDeposit * 100);
        int millsOfDay = 1000 * 60 * 60 * 24;

        String[] partsDateStart = dateStart.split("\\.");
        int dayDateStart = Integer.parseInt(partsDateStart[0]);
        int monthDateStart = Integer.parseInt(partsDateStart[1]);
        int yearDateStart = Integer.parseInt(partsDateStart[2]);


        Calendar dateFirst = new GregorianCalendar(yearDateStart, monthDateStart - 1, dayDateStart);

        Calendar dateSecond = new GregorianCalendar(yearDateStart, monthDateStart - 1, dayDateStart);
        dateSecond.add(MONTH, period);

        String dateFinish = new SimpleDateFormat("dd.MM.yyyy").format(dateSecond.getTime());

        String[] partsDateFinish = dateFinish.split("\\.");

        int yearDateFinish = Integer.parseInt(partsDateFinish[2]);

        for (int i = yearDateStart; i <= yearDateFinish; i ++) {
            Calendar dateYear = new GregorianCalendar();
            Calendar lastDayYear = new GregorianCalendar();

            if (i > yearDateStart) {
                dateYear.set(YEAR, i);
                dateYear.set(MONTH, 0);
                dateYear.set(DAY_OF_MONTH, 1);

                if (i != yearDateFinish) {
                    lastDayYear.set(YEAR, i + 1);
                    lastDayYear.set(MONTH, 0);
                    lastDayYear.set(DAY_OF_MONTH, 1);

                } else {

                    lastDayYear.set(YEAR, i);
                    lastDayYear.set(MONTH, dateSecond.get(MONTH));
                    lastDayYear.set(DAY_OF_MONTH, dateSecond.get(DAY_OF_MONTH));
                }
            } else {
                    lastDayYear.set(YEAR, i + 1);
                    lastDayYear.set(MONTH, 0);
                    lastDayYear.set(DAY_OF_MONTH, 1);

                    dateYear.set(YEAR, i);
                    dateYear.set(MONTH, dateFirst.get(MONTH));
                    dateYear.set(DAY_OF_MONTH, dateFirst.get(DAY_OF_MONTH));

            }
            if (new GregorianCalendar().isLeapYear(i)) {
                long days =  (lastDayYear.getTimeInMillis() - dateYear.getTimeInMillis()) / millsOfDay;
                deposit += sumDeposit * percent * days / (366 * 10000);
            } else {
                long days = (lastDayYear.getTimeInMillis() - dateYear.getTimeInMillis()) / millsOfDay;
                deposit += sumDeposit * percent * days / (365 * 10000);
            }
        }
        return sumDeposit + (int)Math.round(deposit);
    }
}
