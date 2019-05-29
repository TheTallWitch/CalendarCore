package com.gearback.zt.calendarcore.core.models;

import com.gearback.zt.calendarcore.core.Constants;
import com.gearback.zt.calendarcore.core.exceptions.MonthOutOfRangeException;
import com.gearback.zt.calendarcore.core.exceptions.YearOutOfRangeException;

public class IslamicDate extends AbstractDate {
    private int mDay;
    private int mMonth;
    private int mYear;

    public IslamicDate(int year, int month, int day) {
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
        this.mDay = day;
    }

    public int getDayOfWeek() {
        throw new RuntimeException(Constants.NOT_IMPLEMENTED_YET);
    }

    public int getMonth() {
        return mMonth;
    }

    public void setMonth(int month) {
        if (month < 1 || month > 12)
            throw new MonthOutOfRangeException(
                    Constants.MONTH + " " + month + " " + Constants.IS_OUT_OF_RANGE);

        // Set the mDay again, so that exceptions are thrown if the
        // mDay is out of range
        setDayOfMonth(mDay);

        this.mMonth = month;
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

    public IslamicDate rollDay(int amount, boolean up) {
        mDay += amount * (up ? 1 : -1);
        return this;
    }

    public IslamicDate rollMonth(int amount, boolean up) {
        mMonth += amount * (up ? 1 : -1);
        return this;
    }

    public IslamicDate rollYear(int amount, boolean up) {
        mYear += amount * (up ? 1 : -1);
        return this;
    }

    public String getEvent() {
        throw new RuntimeException(Constants.NOT_IMPLEMENTED_YET);
    }

    @Override
    public boolean isLeapYear() {
        int d30 = mYear % 30;
        if (d30 == 2 || d30 == 5 || d30 == 7 || d30 == 10 || d30 == 13 || d30 == 16 || d30 == 18 || d30 == 21 || d30 == 24 || d30 == 26 || d30 == 29) {
            return true;
        }
        else return false;
    }

    public int getDayOfYear() {
        throw new RuntimeException(Constants.NOT_IMPLEMENTED_YET);
    }

    public int getWeekOfMonth() {
        throw new RuntimeException(Constants.NOT_IMPLEMENTED_YET);
    }

    @Override
    public IslamicDate clone() {
        return new IslamicDate(getYear(), getMonth(), getDayOfMonth());
    }

    public boolean equals(IslamicDate islamicDate) {
        return this.getDayOfMonth() == islamicDate.getDayOfMonth()
                && this.getMonth() == islamicDate.getMonth()
                && (this.getYear() == islamicDate.getYear() || this.getYear() == -1);
    }
}
