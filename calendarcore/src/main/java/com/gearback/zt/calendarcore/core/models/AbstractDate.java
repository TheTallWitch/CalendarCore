package com.gearback.zt.calendarcore.core.models;

public abstract class AbstractDate {

    public void setDate(int year, int month, int day) {
        setYear(year);
        setMonth(month);
        setDayOfMonth(day);
    }

    public abstract int getYear();

    public abstract void setYear(int year);

    public abstract int getMonth();

    public abstract void setMonth(int month);

    public abstract int getDayOfMonth();

    public abstract void setDayOfMonth(int day);

    public abstract int getDayOfWeek();

    public abstract int getDayOfYear();

    public abstract int getWeekOfYear();

    public abstract int getWeekOfMonth();

    public abstract AbstractDate rollDay(int amount, boolean up);

    public abstract AbstractDate rollMonth(int amount, boolean up);

    public abstract AbstractDate rollYear(int amount, boolean up);

    public abstract String getEvent();

    public abstract boolean isLeapYear();

    public abstract AbstractDate clone();
}
