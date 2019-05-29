package com.gearback.zt.calendarcore.core.interfaces;

import com.gearback.zt.calendarcore.core.models.CivilDate;
import com.gearback.zt.calendarcore.core.models.IslamicDate;
import com.gearback.zt.calendarcore.core.models.PersianDate;

public interface OnDayLongClickedListener {
    void onPersianLongClick(PersianDate date);
    void onCivilLongClick(CivilDate date);
    void onIslamicLongClick(IslamicDate date);
}
