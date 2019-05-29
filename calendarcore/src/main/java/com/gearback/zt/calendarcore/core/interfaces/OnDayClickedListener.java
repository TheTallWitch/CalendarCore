package com.gearback.zt.calendarcore.core.interfaces;

import com.gearback.zt.calendarcore.core.models.CivilDate;
import com.gearback.zt.calendarcore.core.models.IslamicDate;
import com.gearback.zt.calendarcore.core.models.PersianDate;

public interface OnDayClickedListener {
    void onPersianClick(PersianDate date);
    void onCivilClick(CivilDate date);
    void onIslamicClick(IslamicDate date);
}
