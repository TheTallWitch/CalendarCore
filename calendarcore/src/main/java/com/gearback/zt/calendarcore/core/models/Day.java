package com.gearback.zt.calendarcore.core.models;

public class Day {
    private String mNum;
    private boolean mHoliday;
    private boolean mToday;
    private int mDayOfWeek;
    private PersianDate mPersianDate;
    private CivilDate mCivilDate;
    private IslamicDate mIslamicDate;
    private boolean mEvent;
    private boolean mLocalEvent;

    public boolean isEvent() {
        return mEvent;
    }

    public void setEvent(boolean event) {
        this.mEvent = event;
    }

    public boolean isLocalEvent() {
        return mLocalEvent;
    }

    public void setLocalEvent(boolean localEvent) {
        mLocalEvent = localEvent;
    }

    public String getNum() {
        return mNum;
    }

    public void setNum(String num) {
        this.mNum = num;
    }

    public boolean isHoliday() {
        return mHoliday;
    }

    public void setHoliday(boolean holiday) {
        this.mHoliday = holiday;
    }

    public boolean isToday() {
        return mToday;
    }

    public void setToday(boolean today) {
        this.mToday = today;
    }

    public int getDayOfWeek() {
        return mDayOfWeek;
    }

    public void setDayOfWeek(int dayOfWeek) {
        this.mDayOfWeek = dayOfWeek;
    }

    public PersianDate getPersianDate() {
        return mPersianDate;
    }

    public void setPersianDate(PersianDate persianDate) {
        this.mPersianDate = persianDate;
    }

    public CivilDate getCivilDate() {
        return mCivilDate;
    }

    public void setCivilDate(CivilDate civilDate) {
        this.mCivilDate = civilDate;
    }

    public IslamicDate getIslamicDate() {
        return mIslamicDate;
    }

    public void setIslamicDate(IslamicDate islamicDate) {
        this.mIslamicDate = islamicDate;
    }
}
