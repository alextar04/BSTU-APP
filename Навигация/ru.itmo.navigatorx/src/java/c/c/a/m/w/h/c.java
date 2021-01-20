/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.drawable.BitmapDrawable
 *  android.graphics.drawable.Drawable
 *  c.c.a.m.o
 *  java.lang.Object
 */
package c.c.a.m.w.h;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import c.c.a.m.o;
import c.c.a.m.u.c0.d;
import c.c.a.m.u.w;
import c.c.a.m.w.h.e;

public final class c
implements e<Drawable, byte[]> {
    public final d a;
    public final e<Bitmap, byte[]> b;
    public final e<c.c.a.m.w.g.c, byte[]> c;

    public c(d d2, e<Bitmap, byte[]> e2, e<c.c.a.m.w.g.c, byte[]> e3) {
        this.a = d2;
        this.b = e2;
        this.c = e3;
    }

    @Override
    public w<byte[]> a(w<Drawable> w2, o o2) {
        Drawable drawable = w2.b();
        if (drawable instanceof BitmapDrawable) {
            return this.b.a(c.c.a.m.w.c.e.f(((BitmapDrawable)drawable).getBitmap(), this.a), o2);
        }
        if (drawable instanceof c.c.a.m.w.g.c) {
            return this.c.a(w2, o2);
        }
        return null;
    }
}

