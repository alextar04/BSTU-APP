/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 *  android.graphics.Bitmap
 *  android.graphics.drawable.BitmapDrawable
 *  java.lang.Class
 *  java.lang.Object
 */
package c.c.a.m.w.c;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import c.c.a.m.u.s;
import c.c.a.m.u.w;
import f.b.k.h;

public final class q
implements w<BitmapDrawable>,
s {
    public final Resources e;
    public final w<Bitmap> f;

    public q(Resources resources, w<Bitmap> w2) {
        h.i.p(resources, "Argument must not be null");
        this.e = resources;
        h.i.p(w2, "Argument must not be null");
        this.f = w2;
    }

    public static w<BitmapDrawable> f(Resources resources, w<Bitmap> w2) {
        if (w2 == null) {
            return null;
        }
        return new q(resources, w2);
    }

    @Override
    public void a() {
        w<Bitmap> w2 = this.f;
        if (w2 instanceof s) {
            ((s)((Object)w2)).a();
        }
    }

    @Override
    public Object b() {
        return new BitmapDrawable(this.e, this.f.b());
    }

    @Override
    public int c() {
        return this.f.c();
    }

    @Override
    public Class<BitmapDrawable> d() {
        return BitmapDrawable.class;
    }

    @Override
    public void e() {
        this.f.e();
    }
}

