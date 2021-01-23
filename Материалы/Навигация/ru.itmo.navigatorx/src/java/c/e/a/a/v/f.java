/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.content.Context
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.BaseAdapter
 *  android.widget.TextView
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Calendar
 *  java.util.Locale
 */
package c.e.a.a.v;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import c.e.a.a.h;
import c.e.a.a.i;
import c.e.a.a.v.a0;
import java.util.Calendar;
import java.util.Locale;

public class f
extends BaseAdapter {
    public static final int h;
    public final Calendar e;
    public final int f;
    public final int g;

    public static {
        int n2 = Build.VERSION.SDK_INT >= 26 ? 4 : 1;
        h = n2;
    }

    public f() {
        Calendar calendar;
        this.e = calendar = a0.g();
        this.f = calendar.getMaximum(7);
        this.g = this.e.getFirstDayOfWeek();
    }

    public int getCount() {
        return this.f;
    }

    public Object getItem(int n2) {
        int n3 = this.f;
        if (n2 >= n3) {
            return null;
        }
        int n4 = n2 + this.g;
        if (n4 > n3) {
            n4 -= n3;
        }
        return n4;
    }

    public long getItemId(int n2) {
        return 0L;
    }

    @SuppressLint(value={"WrongConstant"})
    public View getView(int n2, View view, ViewGroup viewGroup) {
        TextView textView = (TextView)view;
        if (view == null) {
            textView = (TextView)LayoutInflater.from((Context)viewGroup.getContext()).inflate(h.mtrl_calendar_day_of_week, viewGroup, false);
        }
        Calendar calendar = this.e;
        int n3 = n2 + this.g;
        int n4 = this.f;
        if (n3 > n4) {
            n3 -= n4;
        }
        calendar.set(7, n3);
        textView.setText((CharSequence)this.e.getDisplayName(7, h, Locale.getDefault()));
        String string = viewGroup.getContext().getString(i.mtrl_picker_day_of_week_column_header);
        Object[] arrobject = new Object[]{this.e.getDisplayName(7, 2, Locale.getDefault())};
        textView.setContentDescription((CharSequence)String.format((String)string, (Object[])arrobject));
        return textView;
    }
}

