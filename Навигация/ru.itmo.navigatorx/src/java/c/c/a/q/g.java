/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.graphics.drawable.Drawable
 *  android.util.Log
 *  c.c.a.m.o
 *  c.c.a.m.s
 *  c.c.a.m.u.l
 *  c.c.a.m.u.m
 *  java.lang.Class
 *  java.lang.Enum
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  java.util.concurrent.Executor
 */
package c.c.a.q;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.Log;
import c.c.a.m.m;
import c.c.a.m.o;
import c.c.a.m.s;
import c.c.a.m.u.k;
import c.c.a.m.u.l;
import c.c.a.m.u.r;
import c.c.a.m.u.w;
import c.c.a.q.b;
import c.c.a.q.c;
import c.c.a.q.d;
import c.c.a.q.f;
import c.c.a.q.h.e;
import c.c.a.q.i.a;
import c.c.a.s.j;
import c.c.a.s.k.d;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

public final class g<R>
implements b,
c.c.a.q.h.d,
f {
    public static final boolean D = Log.isLoggable((String)"Request", (int)2);
    public int A;
    public boolean B;
    public RuntimeException C;
    public final String a;
    public final c.c.a.s.k.d b;
    public final Object c;
    public final d<R> d;
    public final c e;
    public final Context f;
    public final c.c.a.d g;
    public final Object h;
    public final Class<R> i;
    public final c.c.a.q.a<?> j;
    public final int k;
    public final int l;
    public final c.c.a.e m;
    public final e<R> n;
    public final List<d<R>> o;
    public final c.c.a.q.i.c<? super R> p;
    public final Executor q;
    public w<R> r;
    public l.d s;
    public long t;
    public volatile l u;
    public a v;
    public Drawable w;
    public Drawable x;
    public Drawable y;
    public int z;

    public g(Context context, c.c.a.d d2, Object object, Object object2, Class<R> class_, c.c.a.q.a<?> a2, int n2, int n3, c.c.a.e e2, e<R> e3, d<R> d3, List<d<R>> list, c c2, l l2, c.c.a.q.i.c<? super R> c3, Executor executor) {
        String string = D ? String.valueOf((int)super.hashCode()) : null;
        this.a = string;
        this.b = new c.c.a.s.k.d(){
            public volatile boolean a;

            public void a() {
                if (!this.a) {
                    return;
                }
                throw new IllegalStateException("Already released");
            }
        };
        this.c = object;
        this.f = context;
        this.g = d2;
        this.h = object2;
        this.i = class_;
        this.j = a2;
        this.k = n2;
        this.l = n3;
        this.m = e2;
        this.n = e3;
        this.d = d3;
        this.o = list;
        this.e = c2;
        this.u = l2;
        this.p = c3;
        this.q = executor;
        this.v = a.e;
        if (this.C == null && d2.g) {
            this.C = new RuntimeException("Glide request origin trace");
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void a() {
        Object object;
        Object object2 = object = this.c;
        synchronized (object2) {
            if (this.isRunning()) {
                this.clear();
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void b() {
        Object object;
        a a2 = a.g;
        a a3 = a.f;
        Object object2 = object = this.c;
        synchronized (object2) {
            this.f();
            this.b.a();
            this.t = c.c.a.s.f.b();
            if (this.h == null) {
                if (j.k(this.k, this.l)) {
                    this.z = this.k;
                    this.A = this.l;
                }
                int n2 = this.h() == null ? 5 : 3;
                this.n(new r("Received null model"), n2);
                return;
            }
            if (this.v == a3) {
                throw new IllegalArgumentException("Cannot restart a running request");
            }
            if (this.v == a.h) {
                this.o(this.r, c.c.a.m.a.i);
                return;
            }
            this.v = a2;
            if (j.k(this.k, this.l)) {
                this.e(this.k, this.l);
            } else {
                this.n.h(this);
            }
            if (this.v == a3 || this.v == a2) {
                c c2 = this.e;
                boolean bl = c2 == null || c2.f(this);
                if (bl) {
                    this.n.b(this.i());
                }
            }
            if (D) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("finished run method in ");
                stringBuilder.append(c.c.a.s.f.a(this.t));
                this.m(stringBuilder.toString());
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public boolean c() {
        Object object;
        Object object2 = object = this.c;
        synchronized (object2) {
            if (this.v != a.h) return false;
            return true;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    @Override
    public void clear() {
        Object object;
        c c2;
        a a2 = a.j;
        Object object2 = object = this.c;
        // MONITORENTER : object2
        this.f();
        this.b.a();
        if (this.v == a2) {
            // MONITOREXIT : object2
            return;
        }
        this.g();
        w<R> w2 = this.r;
        w<R> w3 = null;
        if (w2 != null) {
            w<R> w4 = this.r;
            this.r = null;
            w3 = w4;
        }
        boolean bl = (c2 = this.e) == null || c2.g(this);
        if (bl) {
            this.n.g(this.i());
        }
        this.v = a2;
        // MONITOREXIT : object2
        if (w3 == null) return;
        this.u.f(w3);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public boolean d() {
        Object object;
        Object object2 = object = this.c;
        synchronized (object2) {
            if (this.v != a.j) return false;
            return true;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void e(int n2, int n3) {
        Object object;
        int n4 = n2;
        a a2 = a.f;
        this.b.a();
        Object object2 = object = this.c;
        synchronized (object2) {
            try {
                if (D) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Got onSizeReady in ");
                    stringBuilder.append(c.c.a.s.f.a(this.t));
                    this.m(stringBuilder.toString());
                }
                if (this.v != a.g) {
                    return;
                }
                this.v = a2;
                float f2 = this.j.f;
                if (n4 != Integer.MIN_VALUE) {
                    n4 = Math.round((float)(f2 * (float)n4));
                }
                this.z = n4;
                int n5 = n3 == Integer.MIN_VALUE ? n3 : Math.round((float)(f2 * (float)n3));
                this.A = n5;
                if (D) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("finished setup for calling load in ");
                    stringBuilder.append(c.c.a.s.f.a(this.t));
                    this.m(stringBuilder.toString());
                }
                l l2 = this.u;
                c.c.a.d d2 = this.g;
                Object object3 = this.h;
                m m2 = this.j.p;
                int n6 = this.z;
                int n7 = this.A;
                Class<?> class_ = this.j.w;
                Class<R> class_2 = this.i;
                c.c.a.e e2 = this.m;
                k k2 = this.j.g;
                Map<Class<?>, s<?>> map = this.j.v;
                boolean bl = this.j.q;
                boolean bl2 = this.j.C;
                o o2 = this.j.u;
                boolean bl3 = this.j.m;
                boolean bl4 = this.j.A;
                boolean bl5 = this.j.D;
                boolean bl6 = this.j.B;
                Executor executor = this.q;
            }
            finally {
                Object object4 = object;
            }
        }
    }

    public final void f() {
        if (!this.B) {
            return;
        }
        throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void g() {
        this.f();
        this.b.a();
        this.n.a(this);
        l.d d2 = this.s;
        if (d2 != null) {
            l l2;
            l l3 = l2 = d2.c;
            synchronized (l3) {
                d2.a.h(d2.b);
            }
            this.s = null;
            return;
        }
    }

    public final Drawable h() {
        if (this.y == null) {
            Drawable drawable;
            int n2;
            c.c.a.q.a<?> a2 = this.j;
            this.y = drawable = a2.s;
            if (drawable == null && (n2 = a2.t) > 0) {
                this.y = this.l(n2);
            }
        }
        return this.y;
    }

    public final Drawable i() {
        if (this.x == null) {
            Drawable drawable;
            int n2;
            c.c.a.q.a<?> a2 = this.j;
            this.x = drawable = a2.k;
            if (drawable == null && (n2 = a2.l) > 0) {
                this.x = this.l(n2);
            }
        }
        return this.x;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public boolean isRunning() {
        Object object;
        Object object2 = object = this.c;
        synchronized (object2) {
            if (this.v == a.f) return true;
            if (this.v != a.g) return false;
            return true;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean j(b b2) {
        Object object;
        int n2;
        int n3;
        c.c.a.q.a<?> a2;
        Object object2;
        c.c.a.e e2;
        Class<R> class_;
        int n4;
        Object object3;
        if (!(b2 instanceof g)) {
            return false;
        }
        Object object4 = object3 = this.c;
        synchronized (object4) {
            n3 = this.k;
            n4 = this.l;
            object2 = this.h;
            class_ = this.i;
            a2 = this.j;
            e2 = this.m;
            n2 = this.o != null ? this.o.size() : 0;
        }
        g g2 = (g)b2;
        Object object5 = object = g2.c;
        synchronized (object5) {
            int n5 = g2.k;
            int n6 = g2.l;
            Object object6 = g2.h;
            Class<R> class_2 = g2.i;
            c.c.a.q.a<?> a3 = g2.j;
            c.c.a.e e3 = g2.m;
            int n7 = g2.o != null ? g2.o.size() : 0;
            return n3 == n5 && n4 == n6 && j.a(object2, object6) && class_.equals(class_2) && a2.equals(a3) && e2 == e3 && n2 == n7;
        }
    }

    public final boolean k() {
        c c2 = this.e;
        return c2 == null || !c2.b().e();
        {
        }
    }

    public final Drawable l(int n2) {
        Resources.Theme theme = this.j.y;
        if (theme == null) {
            theme = this.f.getTheme();
        }
        c.c.a.d d2 = this.g;
        return c.c.a.m.w.e.a.a((Context)d2, (Context)d2, n2, theme);
    }

    public final void m(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append(" this: ");
        stringBuilder.append(this.a);
        Log.v((String)"Request", (String)stringBuilder.toString());
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void n(r r2, int n2) {
        Object object;
        this.b.a();
        Object object2 = object = this.c;
        synchronized (object2) {
            boolean bl;
            boolean bl2;
            block13 : {
                block12 : {
                    if (r2 == null) {
                        throw null;
                    }
                    int n3 = this.g.h;
                    if (n3 <= n2) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Load failed for ");
                        stringBuilder.append(this.h);
                        stringBuilder.append(" with size [");
                        stringBuilder.append(this.z);
                        stringBuilder.append("x");
                        stringBuilder.append(this.A);
                        stringBuilder.append("]");
                        Log.w((String)"Glide", (String)stringBuilder.toString(), (Throwable)r2);
                        if (n3 <= 4) {
                            r2.e("Glide");
                        }
                    }
                    this.s = null;
                    this.v = a.i;
                    this.B = bl = true;
                    try {
                        if (this.o == null) break block12;
                        Iterator iterator = this.o.iterator();
                        bl2 = false;
                        while (iterator.hasNext()) {
                            bl2 |= ((d)iterator.next()).b(r2, this.h, this.n, this.k());
                        }
                        break block13;
                    }
                    catch (Throwable throwable) {
                        this.B = false;
                        throw throwable;
                    }
                }
                bl2 = false;
            }
            if (this.d == null || !this.d.b(r2, this.h, this.n, this.k())) {
                bl = false;
            }
            if (!(bl2 | bl)) {
                this.q();
            }
            this.B = false;
            c c2 = this.e;
            if (c2 != null) {
                c2.c(this);
            }
            return;
        }
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public void o(w<?> w2, c.c.a.m.a a2) {
        Object object;
        this.b.a();
        w<?> w3 = null;
        Object object2 = object = this.c;
        // MONITORENTER : object2
        {
            catch (Throwable throwable) {
                if (w3 == null) throw throwable;
                this.u.f(w3);
                throw throwable;
            }
        }
        this.s = null;
        w3 = null;
        if (w2 == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Expected to receive a Resource<R> with an object of ");
            stringBuilder.append(this.i);
            stringBuilder.append(" inside, but instead got null.");
            this.n(new r(stringBuilder.toString()), 5);
            // MONITOREXIT : object2
            return;
        }
        Object obj = w2.b();
        w3 = null;
        if (obj != null && this.i.isAssignableFrom(obj.getClass())) {
            boolean bl;
            c c2 = this.e;
            w3 = null;
            boolean bl2 = c2 == null || (bl = c2.a(this));
            if (bl2) {
                this.p(w2, obj, a2);
                // MONITOREXIT : object2
                return;
            }
            this.r = null;
            this.v = a.h;
            // MONITOREXIT : object2
            this.u.f(w2);
            return;
        }
        try {
            this.r = null;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Expected to receive an object of ");
            stringBuilder.append(this.i);
            stringBuilder.append(" but instead got ");
            String string = obj != null ? obj.getClass() : "";
            stringBuilder.append((Object)string);
            stringBuilder.append("{");
            stringBuilder.append(obj);
            stringBuilder.append("} inside Resource{");
            stringBuilder.append(w2);
            stringBuilder.append("}.");
            String string2 = obj != null ? "" : " To indicate failure return a null Resource object, rather than a Resource object containing null data.";
            stringBuilder.append(string2);
            this.n(new r(stringBuilder.toString()), 5);
            // MONITOREXIT : object2
        }
        catch (Throwable throwable) {
            w3 = w2;
            Throwable throwable2 = throwable;
            // MONITOREXIT : object2
            throw throwable2;
        }
        this.u.f(w2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void p(w<R> w2, R r2, c.c.a.m.a a2) {
        boolean bl;
        boolean bl2;
        boolean bl3;
        block9 : {
            block8 : {
                bl2 = this.k();
                this.v = a.h;
                this.r = w2;
                if (this.g.h <= 3) {
                    StringBuilder stringBuilder = c.b.a.a.a.c("Finished loading ");
                    stringBuilder.append(r2.getClass().getSimpleName());
                    stringBuilder.append(" from ");
                    stringBuilder.append((Object)a2);
                    stringBuilder.append(" for ");
                    stringBuilder.append(this.h);
                    stringBuilder.append(" with size [");
                    stringBuilder.append(this.z);
                    stringBuilder.append("x");
                    stringBuilder.append(this.A);
                    stringBuilder.append("] in ");
                    stringBuilder.append(c.c.a.s.f.a(this.t));
                    stringBuilder.append(" ms");
                    Log.d((String)"Glide", (String)stringBuilder.toString());
                }
                this.B = bl = true;
                try {
                    if (this.o == null) break block8;
                    Iterator iterator = this.o.iterator();
                    bl3 = false;
                    while (iterator.hasNext()) {
                        bl3 |= ((d)iterator.next()).a(r2, this.h, this.n, a2, bl2);
                    }
                    break block9;
                }
                catch (Throwable throwable) {
                    this.B = false;
                    throw throwable;
                }
            }
            bl3 = false;
        }
        if (this.d == null || !this.d.a(r2, this.h, this.n, a2, bl2)) {
            bl = false;
        }
        if (!(bl | bl3)) {
            if ((a.a)this.p == null) {
                throw null;
            }
            c.c.a.q.i.a<?> a3 = c.c.a.q.i.a.a;
            this.n.c(r2, a3);
        }
        this.B = false;
        c c2 = this.e;
        if (c2 != null) {
            c2.d(this);
        }
    }

    public final void q() {
        c c2 = this.e;
        boolean bl = c2 == null || c2.f(this);
        if (!bl) {
            return;
        }
        Object object = this.h;
        Drawable drawable = null;
        if (object == null) {
            drawable = this.h();
        }
        if (drawable == null) {
            if (this.w == null) {
                Drawable drawable2;
                int n2;
                c.c.a.q.a<?> a2 = this.j;
                this.w = drawable2 = a2.i;
                if (drawable2 == null && (n2 = a2.j) > 0) {
                    this.w = this.l(n2);
                }
            }
            drawable = this.w;
        }
        if (drawable == null) {
            drawable = this.i();
        }
        this.n.d(drawable);
    }

}

