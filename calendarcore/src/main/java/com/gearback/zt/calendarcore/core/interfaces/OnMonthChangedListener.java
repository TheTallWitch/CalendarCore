package com.gearback.zt.calendarcore.core.interfaces;

import com.gearback.zt.calendarcore.core.models.CivilDate;
import com.gearback.zt.calendarcore.core.models.IslamicDate;
import com.gearback.zt.calendarcore.core.models.PersianDate;

public interface OnMonthChangedListener {
    void onPersianChanged(PersianDate date);
    void onCivilChanged(CivilDate date);
    void onIslamicChanged(IslamicDate date);
}
