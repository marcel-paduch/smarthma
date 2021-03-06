/*
 * Copyright (C) 2007 The Android Open Source Project
 * Copyright (C) 2013 Ivan Kovac  navratnanos@gmail.com
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package pl.wasat.smarthma.customviews;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import java.util.Calendar;

import pl.wasat.smarthma.R;
import pl.wasat.smarthma.customviews.TimePicker.OnTimeChangedListener;


/**
 * A dialog that prompts the user for the time of day using a {@link TimePicker}
 * .
 */
public class SmHmaTimePickerDialog extends Dialog implements
        OnClickListener, OnTimeChangedListener {

    /**
     * The callback interface used to indicate the user is done filling in the
     * time (they clicked on the 'Set' button).
     */
    public interface OnTimeSetListener {

        /**
         * @param view      The view associated with this listener.
         * @param hourOfDay The hour that was set.
         * @param minute    The minute that was set.
         */
        void onTimeSet(TimePicker view, int hourOfDay, int minute, int seconds);
    }

    private static final String HOUR = "hour";
    private static final String MINUTE = "minute";
    private static final String SECONDS = "seconds";
    private static final String IS_24_HOUR = "is24hour";

    private final TimePicker mTimePicker;
    private final OnTimeSetListener mCallback;
    private final Calendar mCalendar;
    private final java.text.DateFormat mDateFormat;


    /**
     * @param context      Parent.
     * @param callBack     How parent is notified.
     * @param hourOfDay    The initial hour.
     * @param minute       The initial minute.
     * @param is24HourView Whether this is a 24 hour view, or AM/PM.
     */
    public SmHmaTimePickerDialog(Context context, OnTimeSetListener callBack,
                                 int hourOfDay, int minute, int seconds, boolean is24HourView) {

        this(context, 0, callBack, hourOfDay, minute, seconds, is24HourView);
    }

    /**
     * @param context      Parent.
     * @param theme        the theme to apply to this dialog
     * @param callBack     How parent is notified.
     * @param hourOfDay    The initial hour.
     * @param minute       The initial minute.
     * @param is24HourView Whether this is a 24 hour view, or AM/PM.
     */
    @SuppressLint("InflateParams")
    @SuppressWarnings("deprecation")
    private SmHmaTimePickerDialog(Context context, int theme,
                                  OnTimeSetListener callBack, int hourOfDay, int minute, int seconds,
                                  boolean is24HourView) {
        //TODO INFOAPPS
        super(context /*, theme*/);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        mCallback = callBack;

        mDateFormat = DateFormat.getTimeFormat(context);
        mCalendar = Calendar.getInstance();
        updateTitle(hourOfDay, minute, seconds);

        //TODO INFOAPPS
        //  setButton(context.getText(R.string.time_set), this);
        // setButton2(context.getText(R.string.cancel), (OnClickListener) null);
        // setIcon(android.R.drawable.ic_dialog_time);

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.dialog_time_picker, null);
        //TODO INFOAPPS setview(view)
        setContentView(view);
        mTimePicker = (TimePicker) view.findViewById(R.id.timePicker);

        // initialize state
        mTimePicker.setCurrentHour(hourOfDay);
        mTimePicker.setCurrentMinute(minute);
        mTimePicker.setCurrentSecond(seconds);
        mTimePicker.setIs24HourView(is24HourView);
        mTimePicker.setOnTimeChangedListener(this);

        Button cancel = (Button) view.findViewById(R.id.dialog_time_picker_cancel);
        Button choose = (Button) view.findViewById(R.id.dialog_time_picker_choose);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        choose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCallback != null) {
                    mTimePicker.clearFocus();
                    mCallback.onTimeSet(mTimePicker, mTimePicker.getCurrentHour(),
                            mTimePicker.getCurrentMinute(),
                            mTimePicker.getCurrentSeconds());
                }
                dismiss();
            }
        });

    }

    public void onClick(DialogInterface dialog, int which) {
        if (mCallback != null) {
            mTimePicker.clearFocus();
            mCallback.onTimeSet(mTimePicker, mTimePicker.getCurrentHour(),
                    mTimePicker.getCurrentMinute(),
                    mTimePicker.getCurrentSeconds());
        }
    }

    public void onTimeChanged(TimePicker view, int hourOfDay, int minute,
                              int seconds) {
        updateTitle(hourOfDay, minute, seconds);
    }

    public void updateTime(int hourOfDay, int minutesOfHour, int seconds) {
        mTimePicker.setCurrentHour(hourOfDay);
        mTimePicker.setCurrentMinute(minutesOfHour);
        mTimePicker.setCurrentSecond(seconds);
    }

    private void updateTitle(int hour, int minute, int seconds) {
        mCalendar.set(Calendar.HOUR_OF_DAY, hour);
        mCalendar.set(Calendar.MINUTE, minute);
        mCalendar.set(Calendar.SECOND, seconds);
        setTitle(mDateFormat.format(mCalendar.getTime()) + ":"
                + String.format("%02d", seconds));
    }

    @Override
    public Bundle onSaveInstanceState() {
        Bundle state = super.onSaveInstanceState();
        state.putInt(HOUR, mTimePicker.getCurrentHour());
        state.putInt(MINUTE, mTimePicker.getCurrentMinute());
        state.putInt(SECONDS, mTimePicker.getCurrentSeconds());
        state.putBoolean(IS_24_HOUR, mTimePicker.is24HourView());
        return state;
    }

    @Override
    public void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        int hour = savedInstanceState.getInt(HOUR);
        int minute = savedInstanceState.getInt(MINUTE);
        int seconds = savedInstanceState.getInt(SECONDS);
        mTimePicker.setCurrentHour(hour);
        mTimePicker.setCurrentMinute(minute);
        mTimePicker.setCurrentSecond(seconds);
        mTimePicker.setIs24HourView(savedInstanceState.getBoolean(IS_24_HOUR));
        mTimePicker.setOnTimeChangedListener(this);
        updateTitle(hour, minute, seconds);
    }

}
