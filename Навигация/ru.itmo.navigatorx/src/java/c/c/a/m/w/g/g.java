/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.os.Handler
 *  android.os.Handler$Callback
 *  android.os.Looper
 *  android.os.Message
 *  android.os.SystemClock
 *  c.c.a.h
 *  c.c.a.i
 *  c.c.a.m.s
 *  c.c.a.m.w.g.g$a
 *  c.c.a.q.e
 *  c.c.a.q.h.e
 *  c.c.a.r.d
 *  f.b.k.h
 *  java.lang.Class
 *  java.lang.Math
 *  java.lang.Object
 *  java.util.ArrayList
 *  java.util.List
 */
package c.c.a.m.w.g;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import c.c.a.d;
import c.c.a.h;
import c.c.a.i;
import c.c.a.m.m;
import c.c.a.m.s;
import c.c.a.m.u.k;
import c.c.a.m.w.g.g;
import c.c.a.q.h.e;
import c.c.a.s.j;
import f.b.k.h;
import java.util.ArrayList;
import java.util.List;

/*
 * Exception performing whole class analysis.
 */
public class g {
    public final c.c.a.l.a a;
    public final Handler b;
    public final List<b> c;
    public final i d;
    public final c.c.a.m.u.c0.d e;
    public boolean f;
    public boolean g;
    public boolean h;
    public h<Bitmap> i;
    public a j;
    public boolean k;
    public a l;
    public Bitmap m;
    public a n;
    public int o;
    public int p;
    public int q;

    public g(c.c.a.b b2, c.c.a.l.a a2, int n2, int n3, s<Bitmap> s2, Bitmap bitmap) {
        c.c.a.m.u.c0.d d2 = b2.e;
        i i2 = c.c.a.b.d(b2.g.getBaseContext());
        i i3 = c.c.a.b.d(b2.g.getBaseContext());
        if (i3 != null) {
            h h2 = new h(i3.e, i3, Bitmap.class, i3.f).o((c.c.a.q.a)i.p);
            k k2 = k.a;
            h h3 = h2.o(((c.c.a.q.e)((c.c.a.q.e)((c.c.a.q.e)new c.c.a.q.e().d(k2)).n(true)).k(true)).f(n2, n3));
            this.c = new ArrayList();
            this.d = i2;
            Handler handler = new Handler(Looper.getMainLooper(), (Handler.Callback)new c());
            this.e = d2;
            this.b = handler;
            this.i = h3;
            this.a = a2;
            this.c(s2, bitmap);
            return;
        }
        throw null;
    }

    public final void a() {
        if (this.f) {
            a a2;
            if (this.g) {
                return;
            }
            if (this.h) {
                boolean bl = this.n == null;
                h.i.l(bl, "Pending target must be null when starting from the first frame");
                this.a.h();
                this.h = false;
            }
            if ((a2 = this.n) != null) {
                this.n = null;
                this.b(a2);
                return;
            }
            this.g = true;
            int n2 = this.a.f();
            long l2 = SystemClock.uptimeMillis() + (long)n2;
            this.a.d();
            this.l = new /* Unavailable Anonymous Inner Class!! */;
            h<Bitmap> h2 = this.i;
            c.c.a.r.d d2 = new c.c.a.r.d((Object)Math.random());
            h h3 = h2.o((c.c.a.q.a)((c.c.a.q.e)new c.c.a.q.e().j((m)d2)));
            h3.J = this.a;
            h3.M = true;
            h3.q((e)this.l);
        }
    }

    public void b(a a2) {
        this.g = false;
        if (this.k) {
            this.b.obtainMessage(2, (Object)a2).sendToTarget();
            return;
        }
        if (!this.f) {
            this.n = a2;
            return;
        }
        if (a2.k != null) {
            Bitmap bitmap = this.m;
            if (bitmap != null) {
                this.e.c(bitmap);
                this.m = null;
            }
            a a3 = this.j;
            this.j = a2;
            int n2 = this.c.size();
            while (--n2 >= 0) {
                ((b)this.c.get(n2)).a();
            }
            if (a3 != null) {
                this.b.obtainMessage(2, (Object)a3).sendToTarget();
            }
        }
        this.a();
    }

    public void c(s<Bitmap> s2, Bitmap bitmap) {
        h.i.p(s2, "Argument must not be null");
        h.i.p(bitmap, "Argument must not be null");
        this.m = bitmap;
        this.i = this.i.o(new c.c.a.q.e().l(s2, true));
        this.o = j.e(bitmap);
        this.p = bitmap.getWidth();
        this.q = bitmap.getHeight();
    }

    public static interface b {
        public void a();
    }

    public class c
    implements Handler.Callback {
        public boolean handleMessage(Message message) {
            int n2 = message.what;
            if (n2 == 1) {
                a a2 = message.obj;
                g.this.b(a2);
                return true;
            }
            if (n2 == 2) {
                a a3 = message.obj;
                g.this.d.l((e)a3);
            }
            return false;
        }
    }

}

