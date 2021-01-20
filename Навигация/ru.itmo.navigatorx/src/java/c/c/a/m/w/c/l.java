/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Bitmap
 *  android.graphics.drawable.Drawable
 *  c.c.a.m.s
 *  c.c.a.m.w.c.q
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.security.MessageDigest
 */
package c.c.a.m.w.c;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import c.c.a.b;
import c.c.a.m.s;
import c.c.a.m.u.c0.d;
import c.c.a.m.u.w;
import c.c.a.m.w.c.k;
import c.c.a.m.w.c.q;
import java.security.MessageDigest;

public class l
implements s<Drawable> {
    public final s<Bitmap> b;
    public final boolean c;

    public l(s<Bitmap> s2, boolean bl) {
        this.b = s2;
        this.c = bl;
    }

    public void a(MessageDigest messageDigest) {
        this.b.a(messageDigest);
    }

    public w<Drawable> b(Context context, w<Drawable> w2, int n2, int n3) {
        d d2 = b.b((Context)context).e;
        Drawable drawable = w2.b();
        w<Bitmap> w3 = k.a(d2, drawable, n2, n3);
        if (w3 == null) {
            if (!this.c) {
                return w2;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unable to convert ");
            stringBuilder.append((Object)drawable);
            stringBuilder.append(" to a Bitmap");
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        w w4 = this.b.b(context, w3, n2, n3);
        if (w4.equals(w3)) {
            w4.e();
            return w2;
        }
        return q.f((Resources)context.getResources(), (w)w4);
    }

    public boolean equals(Object object) {
        if (object instanceof l) {
            l l2 = (l)object;
            return this.b.equals(l2.b);
        }
        return false;
    }

    public int hashCode() {
        return this.b.hashCode();
    }
}

