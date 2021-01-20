/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  java.lang.Class
 *  java.lang.Object
 */
package c.c.a.m.w.c;

import android.graphics.Bitmap;
import c.c.a.m.u.c0.d;
import c.c.a.m.u.s;
import c.c.a.m.u.w;
import c.c.a.s.j;
import f.b.k.h;

public class e
implements w<Bitmap>,
s {
    public final Bitmap e;
    public final d f;

    public e(Bitmap bitmap, d d2) {
        h.i.p(bitmap, "Bitmap must not be null");
        this.e = bitmap;
        h.i.p(d2, "BitmapPool must not be null");
        this.f = d2;
    }

    public static e f(Bitmap bitmap, d d2) {
        if (bitmap == null) {
            return null;
        }
        return new e(bitmap, d2);
    }

    @Override
    public void a() {
        this.e.prepareToDraw();
    }

    @Override
    public Object b() {
        return this.e;
    }

    @Override
    public int c() {
        return j.e(this.e);
    }

    @Override
    public Class<Bitmap> d() {
        return Bitmap.class;
    }

    @Override
    public void e() {
        this.f.c(this.e);
    }
}

