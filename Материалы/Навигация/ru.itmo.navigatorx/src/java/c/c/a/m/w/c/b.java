/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.drawable.BitmapDrawable
 *  c.c.a.m.o
 *  c.c.a.m.r
 *  c.c.a.m.w.c.e
 *  java.io.File
 *  java.lang.Object
 */
package c.c.a.m.w.c;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import c.c.a.m.c;
import c.c.a.m.o;
import c.c.a.m.r;
import c.c.a.m.u.c0.d;
import c.c.a.m.u.w;
import c.c.a.m.w.c.e;
import java.io.File;

public class b
implements r<BitmapDrawable> {
    public final d a;
    public final r<Bitmap> b;

    public b(d d2, r<Bitmap> r2) {
        this.a = d2;
        this.b = r2;
    }

    public boolean a(Object object, File file, o o2) {
        w w2 = (w)object;
        return this.b.a((Bitmap)new e(((BitmapDrawable)w2.b()).getBitmap(), this.a), file, o2);
    }

    public c b(o o2) {
        return this.b.b(o2);
    }
}

