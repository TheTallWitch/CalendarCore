package com.gearback.zt.calendarcore.core.models;

public class CalendarEvent {
    private PersianDate mPersianDate;
    private CivilDate mCivilDate;
    private IslamicDate mIslamicDate;
    private String mTitle;
    private String mDesc;
    private boolean mHoliday;
    private boolean mObit;
    private String mType;

    public CalendarEvent(PersianDate persianDate, CivilDate civilDate, IslamicDate islamicDate, String title, String desc, boolean holiday, boolean obit, String type) {
        this.mPersianDate = persianDate;
        this.mCivilDate = civilDate;
        this.mIslamicDate = islamicDate;
        this.mTitle = title;
        this.mDesc = desc;
        this.mHoliday = holiday;
        this.mObit = obit;
        this.mType = type;
    }

    public PersianDate getPersianDate() {
        return mPersianDate;
    }

    public void setPersianDate(PersianDate date) {
        this.mPersianDate = date;
    }

    public CivilDate getCivilDate() {
        return mCivilDate;
    }

    public void setCivilDate(CivilDate date) {
        this.mCivilDate = date;
    }

    public IslamicDate getIslamicDate() {
        return mIslamicDate;
    }

    public void setIslamicDate(IslamicDate date) {
        this.mIslamicDate = date;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getDesc() {
        return mDesc;
    }

    public String getType() {
        return mType;
    }

    public void setTitle(String title) {
        this.mTitle = title;
    }

    public void setDesc(String desc) {
        this.mDesc = desc;
    }

    public void setType(String type) {
        this.mType = type;
    }

    public boolean isHoliday() {
        return mHoliday;
    }

    public void setHoliday(boolean holiday) {
        this.mHoliday = holiday;
    }

    public boolean isObit() {
        return mObit;
    }

    public void setObit(boolean obit) {
        this.mObit = obit;
    }
}