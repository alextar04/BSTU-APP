/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.drawable.Drawable
 *  android.net.Uri
 *  c.c.a.m.o
 *  java.lang.Object
 *  java.lang.String
 */
package c.c.a.m.w.c;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import c.c.a.m.o;
import c.c.a.m.q;
import c.c.a.m.u.w;
import c.c.a.m.w.c.k;
import c.c.a.m.w.e.d;

public class t
implements q<Uri, Bitmap> {
    public final d a;
    public final c.c.a.m.u.c0.d b;

    public t(d d2, c.c.a.m.u.c0.d d3) {
        this.a = d2;
        this.b = d3;
    }

    @Override
    public w a(Object object, int n2, int n3, o o2) {
        Uri uri = (Uri)object;
        w w2 = this.a.c(uri);
        if (w2 == null) {
            return null;
        }
        Drawable drawable = (Drawable)w2.b();
        return k.a(this.b, drawable, n2, n3);
    }

    @Override
    public boolean b(Object object, o o2) {
        return "android.resource".equals((Object)((Uri)object).getScheme());
    }
}

