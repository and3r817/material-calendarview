package com.prolificinteractive.materialcalendarview;

import android.app.Activity;

import java.util.Collection;
import java.util.HashSet;

public class ViolationsDecorator implements DayViewDecorator {

    private int[] color;
    private HashSet<CalendarDay> dates;
    private Activity context;

    public ViolationsDecorator(Activity context, int[] color, Collection<CalendarDay> dates) {
        this.color = color;
        this.dates = new HashSet<>(dates);
        this.context = context;
    }

    @Override
    public boolean shouldDecorate(CalendarDay day) {
        return dates.contains(day);
    }

    @Override
    public void decorate(DayViewFacade view) {
        float dotSpanRadius = context.getResources().getDimension(R.dimen._2sdp);
        view.addSpan(new CustomMultipleDotSpan(context, dotSpanRadius, color));
    }
}
