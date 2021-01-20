/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Typeface
 *  java.lang.Object
 */
package c.e.a.a.c0;

import android.graphics.Typeface;
import c.e.a.a.a0.b;
import c.e.a.a.a0.c;
import c.e.a.a.c0.d;

public final class a
extends d {
    public final Typeface a;
    public final a b;
    public boolean c;

    public a(a a2, Typeface typeface) {
        this.a = typeface;
        this.b = a2;
    }

    @Override
    public void a(int n2) {
        this.c(this.a);
    }

    @Override
    public void b(Typeface typeface, boolean bl) {
        this.c(typeface);
    }

    public final void c(Typeface typeface) {
        if (!this.c) {
            c c2 = ((b)this.b).a;
            a a2 = c2.v;
            boolean bl = true;
            if (a2 != null) {
                a2.c = bl;
            }
            if (c2.s != typeface) {
                c2.s = typeface;
            } else {
                bl = false;
            }
            if (bl) {
                c2.k();
            }
        }
    }

}

