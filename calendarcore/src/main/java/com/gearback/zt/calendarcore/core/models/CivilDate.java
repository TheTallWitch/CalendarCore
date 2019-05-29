package com.gearback.zt.calendarcore.core.models;

import java.util.Calendar;

import com.gearback.zt.calendarcore.core.Constants;
import com.gearback.zt.calendarcore.core.exceptions.DayOutOfRangeException;
import com.gearback.zt.calendarcore.core.exceptions.MonthOutOfRangeException;
import com.gearback.zt.calendarcore.core.exceptions.YearOutOfRangeException;

public class CivilDate extends AbstractDate {
    private static final int[] daysInMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private int mYear;
    private int mMonth;
    private int mDay;

    public CivilDate() {
        this(Calendar.getInstance());
    }

    public CivilDate(long jdn) {
        int[] result = fromJdn(jdn);
        this.mYear = result[0];
        this.mMonth = result[1];
        this.mDay = result[2];
    }

    public CivilDate(Calendar calendar) {
        this.mYear = calendar.get(Calendar.YEAR);
        this.mMonth = calendar.get(Calendar.MONTH) + 1;
        this.mDay = calendar.get(Calendar.DAY_OF_MONTH);
    }

    public CivilDate(int year, int month, int day) {
        this();
        setYear(year);
        // Initialize mDay, so that we get no exceptions when setting mMonth
        this.mDay = 1;
        setMonth(month);
        setDayOfMonth(day);
    }

    public int getDayOfMonth() {
        return mDay;
    }

    public void setDayOfMonth(int day) {
        if (day < 1)
            throw new DayOutOfRangeException(
                    Constants.DAY + " " + day + " "  + Constants.IS_OUT_OF_RANGE);

        if (mMonth != 2 && day > daysInMonth[mMonth])
            throw new DayOutOfRangeException(
                    Constants.DAY + " "  + day + " "  + Constants.IS_OUT_OF_RANGE);

        if (mMonth == 2 && isLeapYear() && day > 29)
            throw new DayOutOfRangeException(
                    Constants.DAY + " "  + day + " "  + Constants.IS_OUT_OF_RANGE);

        if (mMonth == 2 && (!isLeapYear()) && day > 28)
            throw new DayOutOfRangeException(
                    Constants.DAY + " "  + day + " "  + Constants.IS_OUT_OF_RANGE);

        // TODO check for the case of leap mYear for February
        this.mDay = day;
    }

    public int getDayOfWeek() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, mYear);
        cal.set(Calendar.MONTH, mMonth - 1);
        cal.set(Calendar.DAY_OF_MONTH, mDay);
        return cal.get(Calendar.DAY_OF_WEEK);
    }

    public int getDayOfYear() {
        throw new RuntimeException(Constants.NOT_IMPLEMENTED_YET);
    }

    public String getEvent() {
        throw new RuntimeException(Constants.NOT_IMPLEMENTED_YET);
    }

    public int getMonth() {
        return mMonth;
    }

    public void setMonth(int month) {
        if (month < 1 || month > 12)
            throw new MonthOutOfRangeException(
                    Constants.MONTH  + " " + month + " "  + Constants.IS_OUT_OF_RANGE);

        // Set the mDay again, so that exceptions are thrown if the
        // mDay is out of range
        setDayOfMonth(getDayOfMonth());

        this.mMonth = month;
    }

    public int getWeekOfMonth() {
        throw new RuntimeException(Constants.NOT_IMPLEMENTED_YET);
    }

    public int getWeekOfYear() {
        throw new RuntimeException(Constants.NOT_IMPLEMENTED_YET);
    }

    public int getYear() {
        return mYear;
    }

    public void setYear(int year) {
        if (year == 0)
            throw new YearOutOfRangeException(Constants.YEAR_0_IS_INVALID);

        this.mYear = year;
    }

    public boolean isLeapYear() {
        if (mYear % 400 == 0)
            return true;

        else if (mYear % 100 == 0)
            return false;

        return (mYear % 4 == 0);
    }

    public CivilDate rollDay(int amount, boolean up) {
        mDay += amount * (up ? 1 : -1);
        return this;
    }

    public CivilDate rollMonth(int amount, boolean up) {
        mMonth += amount * (up ? 1 : -1);
        return this;
    }

    public CivilDate rollYear(int amount, boolean up) {
        mYear += amount * (up ? 1 : -1);
        return this;
    }

    private int[] fromJdn(long jdn) {
        if (jdn > 2299160) {
            long l = jdn + 68569;
            long n = ((4 * l) / 146097);
            l = l - ((146097 * n + 3) / 4);
            long i = ((4000 * (l + 1)) / 1461001);
            l = l - ((1461 * i) / 4) + 31;
            long j = ((80 * l) / 2447);
            int day = (int) (l - ((2447 * j) / 80));
            l = (j / 11);
            int month = (int) (j + 2 - 12 * l);
            int year = (int) (100 * (n - 49) + i + l);
            return new int[]{year, month, day};
        } else
            return julianFromJdn(jdn);
    }

    private static int[] julianFromJdn(long jdn) {
        long j = jdn + 1402;
        long k = ((j - 1) / 1461);
        long l = j - 1461 * k;
        long n = ((l - 1) / 365) - (l / 1461);
        long i = l - 365 * n + 30;
        j = ((80 * i) / 2447);
        int day = (int) (i - ((2447 * j) / 80));
        i = (j / 11);
        int month = (int) (j + 2 - 12 * i);
        int year = (int) (4 * k + n + i - 4716);

        return new int[]{year, month, day};
    }

    @Override
    public CivilDate clone() {
        return new CivilDate(getYear(), getMonth(), getDayOfMonth());
    }

    public boolean equals(CivilDate civilDate) {
        return this.getDayOfMonth() == civilDate.getDayOfMonth()
                && this.getMonth() == civilDate.getMonth()
                && (this.getYear() == civilDate.getYear() || this.getYear() == -1);
    }
}
