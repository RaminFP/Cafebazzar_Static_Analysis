package com.farsitel.bazaar.d;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.text.format.DateFormat;
import android.widget.TimePicker;
import com.farsitel.bazaar.BazaarApplication;
import com.farsitel.bazaar.util.an;
import java.util.Calendar;

public final class av extends DialogFragment implements OnTimeSetListener {
    public final Dialog onCreateDialog(Bundle bundle) {
        Calendar instance = Calendar.getInstance();
        int i = instance.get(11);
        int i2 = instance.get(12);
        SharedPreferences sharedPreferences = BazaarApplication.c().getSharedPreferences("BazaarPreferences", 0);
        int i3 = sharedPreferences.getInt("schedule_update_stop_hour", 7);
        int i4 = sharedPreferences.getInt("schedule_update_stop_minute", 0);
        Dialog timePickerDialog = new TimePickerDialog(getActivity(), this, i, i2, DateFormat.is24HourFormat(getActivity()));
        timePickerDialog.updateTime(i3, i4);
        return timePickerDialog;
    }

    public final void onTimeSet(TimePicker timePicker, int i, int i2) {
        if (timePicker.isShown()) {
            int intValue = timePicker.getCurrentHour().intValue();
            int intValue2 = timePicker.getCurrentMinute().intValue();
            Editor edit = BazaarApplication.c().getSharedPreferences("BazaarPreferences", 0).edit();
            edit.putInt("schedule_update_stop_hour", intValue);
            edit.putInt("schedule_update_stop_minute", intValue2);
            edit.commit();
            an.a();
        }
    }
}
