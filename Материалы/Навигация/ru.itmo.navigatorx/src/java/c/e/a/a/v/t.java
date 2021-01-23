/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.BaseAdapter
 *  android.widget.TextView
 *  java.lang.CharSequence
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Calendar
 *  java.util.Collection
 *  java.util.Date
 *  java.util.Iterator
 *  java.util.Locale
 */
package c.e.a.a.v;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import c.e.a.a.h;
import c.e.a.a.v.a;
import c.e.a.a.v.a0;
import c.e.a.a.v.b;
import c.e.a.a.v.c;
import c.e.a.a.v.d;
import c.e.a.a.v.s;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;

public class t
extends BaseAdapter {
    public static final int i = a0.g().getMaximum(4);
    public final s e;
    public final d<?> f;
    public c g;
    public final a h;

    public t(s s2, d<?> d2, a a2) {
        this.e = s2;
        this.f = d2;
        this.h = a2;
    }

    public int a() {
        return this.e.g();
    }

    public Long b(int n2) {
        if (n2 >= this.e.g() && n2 <= this.c()) {
            s s2 = this.e;
            int n3 = 1 + (n2 - s2.g());
            Calendar calendar = a0.c(s2.e);
            calendar.set(5, n3);
            return calendar.getTimeInMillis();
        }
        return null;
    }

    public int c() {
        return -1 + (this.e.g() + this.e.j);
    }

    public int getCount() {
        return this.e.j + this.a();
    }

    public long getItemId(int n2) {
        return n2 / this.e.i;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public View getView(int var1_1, View var2_2, ViewGroup var3_3) {
        block10 : {
            var4_4 = var3_3.getContext();
            if (this.g == null) {
                this.g = new c(var4_4);
            }
            var5_5 = (TextView)var2_2;
            if (var2_2 == null) {
                var5_5 = (TextView)LayoutInflater.from((Context)var3_3.getContext()).inflate(h.mtrl_calendar_day, var3_3, false);
            }
            if ((var6_6 = var1_1 - this.a()) < 0) ** GOTO lbl-1000
            var12_7 = this.e;
            if (var6_6 < var12_7.j) {
                var13_8 = var6_6 + 1;
                var5_5.setTag((Object)var12_7);
                var5_5.setText((CharSequence)String.valueOf((int)var13_8));
                var14_9 = a0.c(this.e.e);
                var14_9.set(5, var13_8);
                var15_10 = var14_9.getTimeInMillis();
                if (this.e.h == s.e().h) {
                    var19_11 = Locale.getDefault();
                    var18_12 = Build.VERSION.SDK_INT >= 24 ? a0.b(var19_11).format(new Date(var15_10)) : a0.d(var19_11).format(new Date(var15_10));
                } else {
                    var17_13 = Locale.getDefault();
                    var18_12 = Build.VERSION.SDK_INT >= 24 ? a0.i(var17_13).format(new Date(var15_10)) : a0.d(var17_13).format(new Date(var15_10));
                }
                var5_5.setContentDescription((CharSequence)var18_12);
                var5_5.setVisibility(0);
                var5_5.setEnabled(true);
            } else lbl-1000: // 2 sources:
            {
                var5_5.setVisibility(8);
                var5_5.setEnabled(false);
            }
            var7_14 = this.b(var1_1);
            if (var7_14 == null) {
                return var5_5;
            }
            if (this.h.h.m(var7_14)) {
                var5_5.setEnabled(true);
                var9_15 = this.f.v().iterator();
                while (var9_15.hasNext()) {
                    var10_16 = (Long)var9_15.next();
                    if (a0.a(var7_14) != a0.a(var10_16)) continue;
                    var8_17 = this.g.b;
                    break block10;
                }
                var8_17 = a0.f().getTimeInMillis() == var7_14.longValue() ? this.g.c : this.g.a;
            } else {
                var5_5.setEnabled(false);
                var8_17 = this.g.g;
            }
        }
        var8_17.b(var5_5);
        return var5_5;
    }

    public boolean hasStableIds() {
        return true;
    }
}

