package com.gearback.zt.calendarproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        //region Persian Calendar
//        final PersianCalendarView persianCalendarView  = findViewById(R.id.persian_calendar);
//        final PersianCalendarHandler persianCalendarHandler = persianCalendarView.getCalendar();
//        final PersianDate persianDateToday = persianCalendarHandler.getToday();
//        persianCalendarHandler.addLocalEvent(new CalendarEvent(
//                persianDateToday.clone().rollDay(2,true), null, null, "Custom event", "", false, false, ""
//        ));
//        persianCalendarHandler.setOnMonthChangedListener(new OnMonthChangedListener() {
//            @Override
//            public void onPersianChanged(PersianDate date) {
//                Toast.makeText(MainActivity.this, persianCalendarHandler.getMonthName(date),Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onCivilChanged(CivilDate date) {
//
//            }
//
//            @Override
//            public void onIslamicChanged(IslamicDate date) {
//
//            }
//        });
//        persianCalendarView.setOnDayClickedListener(new OnDayClickedListener() {
//            @Override
//            public void onPersianClick(PersianDate date) {
//                List<CalendarEvent> calendarEvents = persianCalendarHandler.getAllEventsForDay(date);
//                for(CalendarEvent e : calendarEvents) {
//                    Log.e("event", e.getTitle());
//                }
//            }
//
//            @Override
//            public void onCivilClick(CivilDate date) {
//
//            }
//
//            @Override
//            public void onIslamicClick(IslamicDate date) {
//
//            }
//        });
//
//        persianCalendarHandler.setColorBackground(getResources().getColor(android.R.color.holo_blue_dark));
//        persianCalendarView.update();
//        //endregion
//
//        findViewById(R.id.todayBtn).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                persianCalendarView.goToToday();
//            }
//        });
//
//        findViewById(R.id.goToBtn).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                persianCalendarView.goToDate(new PersianDate(1398, 5, 18));
//            }
//        });
    }
}
