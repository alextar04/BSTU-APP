/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.icu.text.DateFormat
 *  android.icu.util.TimeZone
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.text.DateFormat
 *  java.util.Calendar
 *  java.util.Locale
 *  java.util.TimeZone
 *  java.util.concurrent.atomic.AtomicReference
 */
package c.e.a.a.v;

import android.annotation.TargetApi;
import android.icu.text.DateFormat;
import android.icu.util.TimeZone;
import c.e.a.a.v.z;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicReference;

public class a0 {
    public static AtomicReference<z> a = new AtomicReference();

    public static long a(long l2) {
        Calendar calendar = a0.g();
        calendar.setTimeInMillis(l2);
        return a0.c(calendar).getTimeInMillis();
    }

    @TargetApi(value=24)
    public static DateFormat b(Locale locale) {
        DateFormat dateFormat = DateFormat.getInstanceForSkeleton((String)"MMMEd", (Locale)locale);
        dateFormat.setTimeZone(TimeZone.getTimeZone((String)"UTC"));
        return dateFormat;
    }

    public static Calendar c(Calendar calendar) {
        Calendar calendar2 = a0.h(calendar);
        Calendar calendar3 = a0.g();
        calendar3.set(calendar2.get(1), calendar2.get(2), calendar2.get(5));
        return calendar3;
    }

    public static java.text.DateFormat d(Locale locale) {
        java.text.DateFormat dateFormat = java.text.DateFormat.getDateInstance((int)0, (Locale)locale);
        dateFormat.setTimeZone(a0.e());
        return dateFormat;
    }

    public static java.util.TimeZone e() {
        return java.util.TimeZone.getTimeZone((String)"UTC");
    }

    public static Calendar f() {
        java.util.TimeZone timeZone;
        z z2 = (z)a.get();
        if (z2 == null) {
            z2 = z.c;
        }
        Calendar calendar = (timeZone = z2.b) == null ? Calendar.getInstance() : Calendar.getInstance((java.util.TimeZone)timeZone);
        Long l2 = z2.a;
        if (l2 != null) {
            calendar.setTimeInMillis(l2.longValue());
        }
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        calendar.setTimeZone(a0.e());
        return calendar;
    }

    public static Calendar g() {
        return a0.h(null);
    }

    public static Calendar h(Calendar calendar) {
        Calendar calendar2 = Calendar.getInstance((java.util.TimeZone)a0.e());
        if (calendar == null) {
            calendar2.clear();
            return calendar2;
        }
        calendar2.setTimeInMillis(calendar.getTimeInMillis());
        return calendar2;
    }

    @TargetApi(value=24)
    public static DateFormat i(Locale locale) {
        DateFormat dateFormat = DateFormat.getInstanceForSkeleton((String)"yMMMEd", (Locale)locale);
        dateFormat.setTimeZone(TimeZone.getTimeZone((String)"UTC"));
        return dateFormat;
    }
}

