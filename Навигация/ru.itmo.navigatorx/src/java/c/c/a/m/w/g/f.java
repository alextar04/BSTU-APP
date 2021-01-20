/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  c.c.a.m.s
 *  c.c.a.m.w.c.e
 *  c.c.a.m.w.g.c
 *  f.b.k.h
 *  java.lang.Object
 *  java.security.MessageDigest
 */
package c.c.a.m.w.g;

import android.content.Context;
import android.graphics.Bitmap;
import c.c.a.b;
import c.c.a.m.s;
import c.c.a.m.u.c0.d;
import c.c.a.m.u.w;
import c.c.a.m.w.c.e;
import c.c.a.m.w.g.c;
import c.c.a.m.w.g.g;
import f.b.k.h;
import java.security.MessageDigest;

public class f
implements s<c> {
    public final s<Bitmap> b;

    public f(s<Bitmap> s2) {
        h.i.p(s2, "Argument must not be null");
        this.b = s2;
    }

    public void a(MessageDigest messageDigest) {
        this.b.a(messageDigest);
    }

    public w<c> b(Context context, w<c> w2, int n2, int n3) {
        w w3;
        c c2 = w2.b();
        d d2 = b.b((Context)context).e;
        e e2 = new e(c2.b(), d2);
        if (!e2.equals((Object)(w3 = this.b.b(context, (w)e2, n2, n3)))) {
            e2.e();
        }
        Bitmap bitmap = (Bitmap)w3.b();
        s<Bitmap> s2 = this.b;
        c2.e.a.c(s2, bitmap);
        return w2;
    }

    public boolean equals(Object object) {
        if (object instanceof f) {
            f f2 = (f)object;
            return this.b.equals(f2.b);
        }
        return false;
    }

    public int hashCode() {
        return this.b.hashCode();
    }
}

