/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.sql.Time
 *  java.text.DateFormat
 *  java.text.ParseException
 *  java.text.SimpleDateFormat
 *  java.util.Date
 */
package c.e.b.c0.z;

import c.e.b.a0;
import c.e.b.e0.b;
import c.e.b.e0.c;
import c.e.b.j;
import c.e.b.w;
import c.e.b.z;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class l
extends z<Time> {
    public static final a0 b = new a0(){

        @Override
        public <T> z<T> a(j j2, c.e.b.d0.a<T> a2) {
            if (a2.a == Time.class) {
                return new l();
            }
            return null;
        }
    };
    public final DateFormat a = new SimpleDateFormat("hh:mm:ss a");

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public Object a(c.e.b.e0.a a2) {
        l l2 = this;
        synchronized (l2) {
            if (a2.T() == b.m) {
                a2.P();
                return null;
            }
            try {
                return new Time(this.a.parse(a2.R()).getTime());
            }
            catch (ParseException parseException) {
                throw new w(parseException);
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void b(c c2, Object object) {
        Time time = (Time)object;
        l l2 = this;
        synchronized (l2) {
            String string = time == null ? null : this.a.format((Date)time);
            c2.N(string);
            return;
        }
    }

}

