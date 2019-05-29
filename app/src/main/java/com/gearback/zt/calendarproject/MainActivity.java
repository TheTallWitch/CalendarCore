package com.gearback.zt.calendarproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.gearback.zt.calendarcore.core.interfaces.OnDayClickedListener;
import com.gearback.zt.calendarcore.core.interfaces.OnMonthChangedListener;
import com.gearback.zt.calendarcore.core.models.CalendarEvent;
import com.gearback.zt.calendarcore.core.models.CivilDate;
import com.gearback.zt.calendarcore.core.models.IslamicDate;
import com.gearback.zt.calendarcore.core.models.PersianDate;
import com.gearback.zt.persiancalendar.PersianCalendarView;
import com.gearback.zt.persiancalendar.core.PersianCalendarHandler;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //region Persian Calendar
        final PersianCalendarView persianCalendarView  = findViewById(R.id.persian_calendar);
        final PersianCalendarHandler persianCalendarHandler = persianCalendarView.getCalendar();
        final PersianDate persianDateToday = persianCalendarHandler.getToday();
        persianCalendarHandler.addLocalEvent(new CalendarEvent(
                persianDateToday.clone().rollDay(2,true), null, null, "Custom event", "", false, false, ""
        ));
        persianCalendarHandler.setOnMonthChangedListener(new OnMonthChangedListener() {
            @Override
            public void onPersianChanged(PersianDate date) {
                Toast.makeText(MainActivity.this, persianCalendarHandler.getMonthName(date),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCivilChanged(CivilDate date) {

            }

            @Override
            public void onIslamicChanged(IslamicDate date) {

            }
        });
        persianCalendarView.setOnDayClickedListener(new OnDayClickedListener() {
            @Override
            public void onPersianClick(PersianDate date) {
                List<CalendarEvent> calendarEvents = persianCalendarHandler.getAllEventsForDay(date);
                for(CalendarEvent e : calendarEvents) {
                    Log.e("event", e.getTitle());
                }
            }

            @Override
            public void onCivilClick(CivilDate date) {

            }

            @Override
            public void onIslamicClick(IslamicDate date) {

            }
        });

        persianCalendarHandler.setColorBackground(getResources().getColor(android.R.color.holo_blue_dark));
        persianCalendarView.update();
        //endregion

        findViewById(R.id.todayBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                persianCalendarView.goToToday();
            }
        });

        findViewById(R.id.goToBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                persianCalendarView.goToDate(new PersianDate(1398, 5, 18));
            }
        });

//        //region Lunar Calendar
//        final LunarCalendarView lunarCalendarView  = findViewById(R.id.lunar_calendar);
//        final LunarCalendarHandler lunarCalendarHandler = lunarCalendarView.getCalendar();
//        final IslamicDate islamicDateToday = lunarCalendarHandler.getToday();
//        //calendar.addLocalEvent(new CalendarEvent(today, "Custom event", true));
//        lunarCalendarHandler.addLocalEvent(new CalendarEvent(
//                DateConverter.islamicToPersian(islamicDateToday.clone().rollDay(2,true)), "Custom event", "", false
//        ));
//        lunarCalendarHandler.setOnMonthChangedListener(new OnMonthChangedListener() {
//            @Override
//            public void onPersianChanged(PersianDate date) {
//
//            }
//
//            @Override
//            public void onCivilChanged(CivilDate date) {
//
//            }
//
//            @Override
//            public void onIslamicChanged(IslamicDate date) {
//                Toast.makeText(MainActivity.this, lunarCalendarHandler.getMonthName(date),Toast.LENGTH_SHORT).show();
//            }
//        });
//        lunarCalendarView.setOnDayClickedListener(new OnDayClickedListener() {
//            @Override
//            public void onPersianClick(PersianDate date) {
//
//            }
//
//            @Override
//            public void onCivilClick(CivilDate date) {
//
//            }
//
//            @Override
//            public void onIslamicClick(IslamicDate date) {
//                for(CalendarEvent e : lunarCalendarHandler.getAllEventsForDay(date))
//                    Toast.makeText(MainActivity.this, e.getTitle(), Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        lunarCalendarHandler.setColorBackground(getResources().getColor(android.R.color.holo_green_dark));
//
//        lunarCalendarView.update();
//        //endregion

//        //region Gregorian Calendar
//        final GregorianCalendarView gregorianCalendarView  = findViewById(R.id.gregorian_calendar);
//        final GregorianCalendarHandler gregorianCalendarHandler = gregorianCalendarView.getCalendar();
//        final CivilDate civilDateToday = gregorianCalendarHandler.getToday();
//        //calendar.addLocalEvent(new CalendarEvent(today, "Custom event", true));
//        gregorianCalendarHandler.addLocalEvent(new CalendarEvent(
//                DateConverter.civilToPersian(civilDateToday.clone().rollDay(2,true)), "Custom event", "", false
//        ));
//        gregorianCalendarHandler.setOnMonthChangedListener(new OnMonthChangedListener() {
//            @Override
//            public void onPersianChanged(PersianDate date) {
//
//            }
//
//            @Override
//            public void onCivilChanged(CivilDate date) {
//                Toast.makeText(MainActivity.this, gregorianCalendarHandler.getMonthName(date),Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onIslamicChanged(IslamicDate date) {
//
//            }
//        });
//        gregorianCalendarView.setOnDayClickedListener(new OnDayClickedListener() {
//            @Override
//            public void onPersianClick(PersianDate date) {
//
//            }
//
//            @Override
//            public void onCivilClick(CivilDate date) {
//                for(CalendarEvent e : gregorianCalendarHandler.getAllEventsForDay(date))
//                    Toast.makeText(MainActivity.this, e.getTitle(), Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onIslamicClick(IslamicDate date) {
//
//            }
//        });
//
//        gregorianCalendarHandler.setColorBackground(getResources().getColor(android.R.color.holo_green_dark));
//
//        gregorianCalendarView.update();
//        //endregion
    }
}
