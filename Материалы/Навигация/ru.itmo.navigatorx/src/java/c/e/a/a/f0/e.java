/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Math
 */
package c.e.a.a.f0;

import c.e.a.a.f0.d;
import c.e.a.a.f0.m;

public class e
extends d {
    public float a = -1.0f;

    @Override
    public void a(m m2, float f2, float f3, float f4) {
        m2.e(0.0f, f4 * f3, 180.0f, 180.0f - f2);
        double d2 = Math.sin((double)Math.toRadians((double)f2));
        double d3 = f4;
        double d4 = d2 * d3;
        double d5 = f3;
        m2.d((float)(d4 * d5), (float)(d5 * (d3 * Math.sin((double)Math.toRadians((double)(90.0f - f2))))));
    }
}

