/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.TypedArray
 *  android.graphics.Paint
 *  c.e.a.a.v.g
 *  f.b.k.h
 *  java.lang.Object
 *  java.lang.String
 */
package c.e.a.a.v;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import c.e.a.a.k;
import c.e.a.a.v.b;
import c.e.a.a.v.g;
import f.b.k.h;

public final class c {
    public final b a;
    public final b b;
    public final b c;
    public final b d;
    public final b e;
    public final b f;
    public final b g;
    public final Paint h;

    public c(Context context) {
        Paint paint;
        TypedArray typedArray = context.obtainStyledAttributes(h.i.t1(context, c.e.a.a.b.materialCalendarStyle, g.class.getCanonicalName()), k.MaterialCalendar);
        this.a = b.a(context, typedArray.getResourceId(k.MaterialCalendar_dayStyle, 0));
        this.g = b.a(context, typedArray.getResourceId(k.MaterialCalendar_dayInvalidStyle, 0));
        this.b = b.a(context, typedArray.getResourceId(k.MaterialCalendar_daySelectedStyle, 0));
        this.c = b.a(context, typedArray.getResourceId(k.MaterialCalendar_dayTodayStyle, 0));
        ColorStateList colorStateList = h.i.d0(context, typedArray, k.MaterialCalendar_rangeFillColor);
        this.d = b.a(context, typedArray.getResourceId(k.MaterialCalendar_yearStyle, 0));
        this.e = b.a(context, typedArray.getResourceId(k.MaterialCalendar_yearSelectedStyle, 0));
        this.f = b.a(context, typedArray.getResourceId(k.MaterialCalendar_yearTodayStyle, 0));
        this.h = paint = new Paint();
        paint.setColor(colorStateList.getDefaultColor());
        typedArray.recycle();
    }
}

