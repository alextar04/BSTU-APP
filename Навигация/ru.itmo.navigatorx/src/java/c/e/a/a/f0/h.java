/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.RectF
 *  java.lang.Float
 *  java.lang.Object
 *  java.util.Arrays
 */
package c.e.a.a.f0;

import android.graphics.RectF;
import c.e.a.a.f0.c;
import java.util.Arrays;

public final class h
implements c {
    public final float a;

    public h(float f2) {
        this.a = f2;
    }

    @Override
    public float a(RectF rectF) {
        return this.a * rectF.height();
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof h)) {
            return false;
        }
        h h2 = (h)object;
        return this.a == h2.a;
    }

    public int hashCode() {
        Object[] arrobject = new Object[]{Float.valueOf((float)this.a)};
        return Arrays.hashCode((Object[])arrobject);
    }
}

