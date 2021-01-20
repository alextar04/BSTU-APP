/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Drawable
 *  c.c.a.m.o
 *  java.lang.Object
 */
package c.c.a.m.w.e;

import android.graphics.drawable.Drawable;
import c.c.a.m.o;
import c.c.a.m.q;
import c.c.a.m.u.w;
import c.c.a.m.w.e.c;

public class e
implements q<Drawable, Drawable> {
    @Override
    public w a(Object object, int n2, int n3, o o2) {
        Drawable drawable = (Drawable)object;
        if (drawable != null) {
            return new c(drawable);
        }
        return null;
    }

    @Override
    public boolean b(Object object, o o2) {
        (Drawable)object;
        return true;
    }
}

