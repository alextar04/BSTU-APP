/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Drawable
 *  java.lang.Math
 */
package f.d.a;

import android.graphics.drawable.Drawable;

public class f
extends Drawable {
    public static final double a = Math.cos((double)Math.toRadians((double)45.0));

    public static float a(float f2, float f3, boolean bl) {
        if (bl) {
            f2 = (float)((double)f2 + (1.0 - a) * (double)f3);
        }
        return f2;
    }

    public static float b(float f2, float f3, boolean bl) {
        float f4 = f2 * 1.5f;
        if (bl) {
            f4 = (float)((double)f4 + (1.0 - a) * (double)f3);
        }
        return f4;
    }
}

