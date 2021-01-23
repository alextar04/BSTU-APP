/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.PorterDuffColorFilter
 *  android.graphics.drawable.Drawable
 *  f.b.p.j$a
 *  java.lang.Class
 *  java.lang.Object
 */
package f.b.p;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import f.b.p.j;
import f.b.p.m0;
import f.b.p.u0;

public final class j {
    public static final PorterDuff.Mode b = PorterDuff.Mode.SRC_IN;
    public static j c;
    public m0 a;

    public static j a() {
        Class<j> class_ = j.class;
        synchronized (j.class) {
            if (c == null) {
                j.e();
            }
            j j2 = c;
            // ** MonitorExit[var2] (shouldn't be in output)
            return j2;
        }
    }

    public static PorterDuffColorFilter c(int n2, PorterDuff.Mode mode) {
        Class<j> class_ = j.class;
        synchronized (j.class) {
            PorterDuffColorFilter porterDuffColorFilter = m0.h(n2, mode);
            // ** MonitorExit[var4_2] (shouldn't be in output)
            return porterDuffColorFilter;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void e() {
        Class<j> class_ = j.class;
        synchronized (j.class) {
            if (c == null) {
                j j2;
                c = j2 = new j();
                j2.a = m0.d();
                m0 m02 = j.c.a;
                a a2 = new a();
                m0 m03 = m02;
                synchronized (m03) {
                    m02.g = a2;
                }
            }
            // ** MonitorExit[var5] (shouldn't be in output)
            return;
        }
    }

    public static void f(Drawable drawable, u0 u02, int[] arrn) {
        m0.l(drawable, u02, arrn);
    }

    public Drawable b(Context context, int n2) {
        j j2 = this;
        synchronized (j2) {
            Drawable drawable = this.a.f(context, n2);
            return drawable;
        }
    }

    public ColorStateList d(Context context, int n2) {
        j j2 = this;
        synchronized (j2) {
            ColorStateList colorStateList = this.a.i(context, n2);
            return colorStateList;
        }
    }
}

