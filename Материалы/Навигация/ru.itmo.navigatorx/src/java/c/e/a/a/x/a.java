/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.util.DisplayMetrics
 *  f.b.k.h
 *  java.lang.Object
 */
package c.e.a.a.x;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import c.e.a.a.b;
import f.b.k.h;

public class a {
    public final boolean a;
    public final int b;
    public final int c;
    public final float d;

    public a(Context context) {
        this.a = h.i.s1(context, b.elevationOverlayEnabled, false);
        this.b = h.i.b0(context, b.elevationOverlayColor, 0);
        this.c = h.i.b0(context, b.colorSurface, 0);
        this.d = context.getResources().getDisplayMetrics().density;
    }
}

