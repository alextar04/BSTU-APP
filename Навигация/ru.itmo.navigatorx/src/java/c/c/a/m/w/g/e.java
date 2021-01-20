/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.drawable.Drawable
 *  c.c.a.i
 *  c.c.a.m.w.e.b
 *  c.c.a.m.w.g.c
 *  c.c.a.q.h.e
 *  java.lang.Class
 *  java.util.List
 */
package c.c.a.m.w.g;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import c.c.a.i;
import c.c.a.l.a;
import c.c.a.m.u.c0.d;
import c.c.a.m.u.s;
import c.c.a.m.w.e.b;
import c.c.a.m.w.g.c;
import c.c.a.m.w.g.g;
import java.util.List;

public class e
extends b<c>
implements s {
    public e(c c2) {
        super((Drawable)c2);
    }

    @Override
    public void a() {
        ((c)this.e).b().prepareToDraw();
    }

    public int c() {
        g g2 = ((c)this.e).e.a;
        return g2.a.b() + g2.o;
    }

    public Class<c> d() {
        return c.class;
    }

    public void e() {
        g.a a2;
        g.a a3;
        ((c)this.e).stop();
        c c2 = (c)this.e;
        c2.h = true;
        g g2 = c2.e.a;
        g2.c.clear();
        Bitmap bitmap = g2.m;
        if (bitmap != null) {
            g2.e.c(bitmap);
            g2.m = null;
        }
        g2.f = false;
        g.a a4 = g2.j;
        if (a4 != null) {
            g2.d.l((c.c.a.q.h.e)a4);
            g2.j = null;
        }
        if ((a2 = g2.l) != null) {
            g2.d.l((c.c.a.q.h.e)a2);
            g2.l = null;
        }
        if ((a3 = g2.n) != null) {
            g2.d.l((c.c.a.q.h.e)a3);
            g2.n = null;
        }
        g2.a.clear();
        g2.k = true;
    }
}

