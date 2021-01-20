/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.animation.TypeEvaluator
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 */
package f.s.a.a;

import android.animation.TypeEvaluator;
import f.b.k.h;

public class c
implements TypeEvaluator<f.h.f.c[]> {
    public f.h.f.c[] a;

    public Object evaluate(float f2, Object object, Object object2) {
        f.h.f.c[] arrc = (f.h.f.c[])object;
        f.h.f.c[] arrc2 = (f.h.f.c[])object2;
        if (h.i.i(arrc, arrc2)) {
            if (!h.i.i(this.a, arrc)) {
                this.a = h.i.U(arrc);
            }
            for (int i2 = 0; i2 < arrc.length; ++i2) {
                f.h.f.c c2 = this.a[i2];
                f.h.f.c c3 = arrc[i2];
                f.h.f.c c4 = arrc2[i2];
                if (c2 != null) {
                    float[] arrf;
                    c2.a = c3.a;
                    for (int i3 = 0; i3 < (arrf = c3.b).length; ++i3) {
                        c2.b[i3] = arrf[i3] * (1.0f - f2) + f2 * c4.b[i3];
                    }
                    continue;
                }
                throw null;
            }
            return this.a;
        }
        throw new IllegalArgumentException("Can't interpolate between two incompatible pathData");
    }
}

