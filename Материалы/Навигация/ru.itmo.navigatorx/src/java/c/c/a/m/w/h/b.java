/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 *  android.graphics.Bitmap
 *  android.graphics.drawable.BitmapDrawable
 *  c.c.a.m.o
 *  java.lang.Object
 */
package c.c.a.m.w.h;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import c.c.a.m.o;
import c.c.a.m.u.w;
import c.c.a.m.w.c.q;
import c.c.a.m.w.h.e;
import f.b.k.h;

public class b
implements e<Bitmap, BitmapDrawable> {
    public final Resources a;

    public b(Resources resources) {
        h.i.p(resources, "Argument must not be null");
        this.a = resources;
    }

    @Override
    public w<BitmapDrawable> a(w<Bitmap> w2, o o2) {
        return q.f(this.a, w2);
    }
}

