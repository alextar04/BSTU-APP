/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Drawable
 *  c.c.a.q.h.e
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package c.c.a.q.h;

import android.graphics.drawable.Drawable;
import c.c.a.q.b;
import c.c.a.q.h.d;
import c.c.a.q.h.e;
import c.c.a.s.j;

public abstract class a<T>
implements e<T> {
    public final int e;
    public final int f;
    public b g;

    public a() {
        if (j.k(Integer.MIN_VALUE, Integer.MIN_VALUE)) {
            this.e = Integer.MIN_VALUE;
            this.f = Integer.MIN_VALUE;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: ");
        stringBuilder.append(Integer.MIN_VALUE);
        stringBuilder.append(" and height: ");
        stringBuilder.append(Integer.MIN_VALUE);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public final void a(d d2) {
    }

    public void b(Drawable drawable) {
    }

    public void d(Drawable drawable) {
    }

    public void e() {
    }

    public final b f() {
        return this.g;
    }

    public final void h(d d2) {
        d2.e(this.e, this.f);
    }

    public void i() {
    }

    public final void j(b b2) {
        this.g = b2;
    }

    public void k() {
    }
}

