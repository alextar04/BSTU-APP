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
package c.c.a.m.w.c;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import c.c.a.m.o;
import c.c.a.m.u.w;
import c.c.a.m.w.c.q;
import f.b.k.h;

public class a<DataType>
implements c.c.a.m.q<DataType, BitmapDrawable> {
    public final c.c.a.m.q<DataType, Bitmap> a;
    public final Resources b;

    public a(Resources resources, c.c.a.m.q<DataType, Bitmap> q2) {
        h.i.p(resources, "Argument must not be null");
        this.b = resources;
        h.i.p(q2, "Argument must not be null");
        this.a = q2;
    }

    @Override
    public w<BitmapDrawable> a(DataType DataType, int n2, int n3, o o2) {
        w<Bitmap> w2 = this.a.a(DataType, n2, n3, o2);
        return q.f(this.b, w2);
    }

    @Override
    public boolean b(DataType DataType, o o2) {
        return this.a.b(DataType, o2);
    }
}

