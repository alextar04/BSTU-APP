/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.animation.TimeInterpolator
 *  android.view.animation.DecelerateInterpolator
 *  android.view.animation.LinearInterpolator
 *  f.m.a.a.a
 *  f.m.a.a.b
 *  f.m.a.a.c
 *  java.lang.Object
 */
package c.e.a.a.l;

import android.animation.TimeInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import f.m.a.a.b;
import f.m.a.a.c;

public class a {
    public static final TimeInterpolator a = new LinearInterpolator();
    public static final TimeInterpolator b = new b();
    public static final TimeInterpolator c = new f.m.a.a.a();
    public static final TimeInterpolator d = new c();
    public static final TimeInterpolator e = new DecelerateInterpolator();

    public static float a(float f2, float f3, float f4) {
        return f2 + f4 * (f3 - f2);
    }
}

