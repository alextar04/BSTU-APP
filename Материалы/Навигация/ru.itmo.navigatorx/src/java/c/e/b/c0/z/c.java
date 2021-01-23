/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.text.DateFormat
 *  java.text.ParseException
 *  java.text.ParsePosition
 *  java.text.SimpleDateFormat
 *  java.util.ArrayList
 *  java.util.Date
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Locale
 */
package c.e.b.c0.z;

import c.e.b.a0;
import c.e.b.c0.p;
import c.e.b.e0.b;
import c.e.b.j;
import c.e.b.w;
import c.e.b.z;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public final class c
extends z<Date> {
    public static final a0 b = new a0(){

        @Override
        public <T> z<T> a(j j2, c.e.b.d0.a<T> a2) {
            if (a2.a == Date.class) {
                return new c();
            }
            return null;
        }
    };
    public final List<DateFormat> a;

    public c() {
        boolean bl;
        ArrayList arrayList;
        this.a = arrayList = new ArrayList();
        arrayList.add((Object)DateFormat.getDateTimeInstance((int)2, (int)2, (Locale)Locale.US));
        if (!Locale.getDefault().equals((Object)Locale.US)) {
            this.a.add((Object)DateFormat.getDateTimeInstance((int)2, (int)2));
        }
        if (bl = p.a >= 9) {
            List<DateFormat> list = this.a;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("MMM d, yyyy");
            stringBuilder.append(" ");
            stringBuilder.append("h:mm:ss a");
            list.add((Object)new SimpleDateFormat(stringBuilder.toString(), Locale.US));
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public Object a(c.e.b.e0.a a2) {
        if (a2.T() == b.m) {
            a2.P();
            return null;
        }
        String string = a2.R();
        c c2 = this;
        synchronized (c2) {
            Iterator iterator = this.a.iterator();
            if (iterator.hasNext()) {
                DateFormat dateFormat = (DateFormat)iterator.next();
                return dateFormat.parse(string);
            }
            try {
                return c.e.b.c0.z.t.a.b(string, new ParsePosition(0));
            }
            catch (ParseException parseException) {
                throw new w(string, parseException);
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void b(c.e.b.e0.c c2, Object object) {
        Date date = (Date)object;
        c c3 = this;
        synchronized (c3) {
            if (date == null) {
                c2.u();
            } else {
                c2.N(((DateFormat)this.a.get(0)).format(date));
            }
            return;
        }
    }

}

