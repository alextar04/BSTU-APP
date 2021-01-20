/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ComponentCallbacks2
 *  android.content.Context
 *  android.content.res.Configuration
 *  android.graphics.Bitmap
 *  android.graphics.drawable.Drawable
 *  android.os.Handler
 *  android.os.Looper
 *  android.util.Log
 *  java.lang.Class
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Set
 *  java.util.concurrent.CopyOnWriteArrayList
 */
package c.c.a;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import c.c.a.b;
import c.c.a.c;
import c.c.a.i;
import c.c.a.m.u.k;
import c.c.a.n.c;
import c.c.a.n.f;
import c.c.a.n.h;
import c.c.a.n.m;
import c.c.a.n.n;
import c.c.a.n.p;
import c.c.a.q.d;
import c.c.a.q.e;
import c.c.a.s.j;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public class i
implements ComponentCallbacks2,
c.c.a.n.i,
Object<c.c.a.h<Drawable>> {
    public static final e p;
    public final c.c.a.b e;
    public final Context f;
    public final h g;
    public final n h;
    public final m i;
    public final p j;
    public final Runnable k;
    public final Handler l;
    public final c.c.a.n.c m;
    public final CopyOnWriteArrayList<d<Object>> n;
    public e o;

    public static {
        e e2 = (e)new e().c(Bitmap.class);
        e2.x = true;
        p = e2;
        ((e)new e().c(c.c.a.m.w.g.c.class)).x = true;
        k k2 = k.b;
        (e)((e)((e)new e().d(k2)).g(c.c.a.e.h)).k(true);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public i(c.c.a.b b2, h h2, m m2, Context context) {
        e e2;
        c.c.a.d d2;
        List<i> list;
        n n2 = new n();
        c.c.a.n.d d3 = b2.k;
        this.j = new p();
        this.k = new Runnable(this){
            public final /* synthetic */ i e;
            {
                this.e = i2;
            }

            public void run() {
                i i2 = this.e;
                i2.g.a(i2);
            }
        };
        this.l = new Handler(Looper.getMainLooper());
        this.e = b2;
        this.g = h2;
        this.i = m2;
        this.h = n2;
        this.f = context;
        Context context2 = context.getApplicationContext();
        b b3 = new b(n2);
        if ((f)d3 == null) {
            throw null;
        }
        boolean bl = f.h.e.a.a(context2, "android.permission.ACCESS_NETWORK_STATE") == 0;
        if (Log.isLoggable((String)"ConnectivityMonitor", (int)3)) {
            String string = bl ? "ACCESS_NETWORK_STATE permission granted, registering connectivity monitor" : "ACCESS_NETWORK_STATE permission missing, cannot register connectivity monitor";
            Log.d((String)"ConnectivityMonitor", (String)string);
        }
        c.c.a.n.c c2 = bl ? new c.c.a.n.e(context2, b3) : new c.c.a.n.j();
        this.m = c2;
        if (j.i()) {
            this.l.post(this.k);
        } else {
            h2.a(this);
        }
        h2.a(this.m);
        this.n = new CopyOnWriteArrayList(b2.g.d);
        c.c.a.d d4 = d2 = b2.g;
        synchronized (d4) {
            if (d2.i == null) {
                if (d2.c == null) {
                    throw null;
                }
                e e3 = new e();
                e3.x = true;
                d2.i = e3;
            }
            e2 = d2.i;
        }
        i i2 = this;
        synchronized (i2) {
            e e4 = (e)e2.b();
            if (e4.x && !e4.z) {
                throw new IllegalStateException("You cannot auto lock an already locked options object, try clone() first");
            }
            e4.z = true;
            e4.x = true;
            this.o = e4;
        }
        List<i> list2 = list = b2.l;
        synchronized (list2) {
            if (!b2.l.contains((Object)this)) {
                b2.l.add((Object)this);
                return;
            }
            throw new IllegalStateException("Cannot register already registered manager");
        }
    }

    @Override
    public void e() {
        i i2 = this;
        synchronized (i2) {
            this.m();
            this.j.e();
            return;
        }
    }

    @Override
    public void i() {
        i i2 = this;
        synchronized (i2) {
            this.n();
            this.j.i();
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void k() {
        i i2 = this;
        synchronized (i2) {
            List<i> list;
            this.j.k();
            Iterator iterator = j.f(this.j.e).iterator();
            while (iterator.hasNext()) {
                this.l((c.c.a.q.h.e)iterator.next());
            }
            this.j.e.clear();
            n n2 = this.h;
            Iterator iterator2 = ((ArrayList)j.f(n2.a)).iterator();
            while (iterator2.hasNext()) {
                n2.a((c.c.a.q.b)iterator2.next());
            }
            n2.b.clear();
            this.g.b(this);
            this.g.b(this.m);
            this.l.removeCallbacks(this.k);
            c.c.a.b b2 = this.e;
            List<i> list2 = list = b2.l;
            synchronized (list2) {
                if (b2.l.contains((Object)this)) {
                    b2.l.remove((Object)this);
                    return;
                }
                throw new IllegalStateException("Cannot unregister not yet registered manager");
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void l(c.c.a.q.h.e<?> e2) {
        List<i> list;
        if (e2 == null) {
            return;
        }
        boolean bl = this.o(e2);
        c.c.a.q.b b2 = e2.f();
        if (bl) return;
        c.c.a.b b3 = this.e;
        List<i> list2 = list = b3.l;
        synchronized (list2) {
            Iterator iterator = b3.l.iterator();
            while (iterator.hasNext()) {
                if (!((i)iterator.next()).o(e2)) continue;
                return;
            }
        }
        boolean bl2 = false;
        if (bl2) return;
        if (b2 == null) return;
        e2.j(null);
        b2.clear();
    }

    public void m() {
        i i2 = this;
        synchronized (i2) {
            n n2 = this.h;
            n2.c = true;
            for (c.c.a.q.b b2 : (ArrayList)j.f(n2.a)) {
                if (!b2.isRunning()) continue;
                b2.a();
                n2.b.add((Object)b2);
            }
            return;
        }
    }

    public void n() {
        i i2 = this;
        synchronized (i2) {
            n n2 = this.h;
            n2.c = false;
            for (c.c.a.q.b b2 : (ArrayList)j.f(n2.a)) {
                if (b2.c() || b2.isRunning()) continue;
                b2.b();
            }
            n2.b.clear();
            return;
        }
    }

    public boolean o(c.c.a.q.h.e<?> e2) {
        i i2 = this;
        synchronized (i2) {
            c.c.a.q.b b2;
            block6 : {
                b2 = e2.f();
                if (b2 != null) break block6;
                return true;
            }
            if (this.h.a(b2)) {
                this.j.e.remove(e2);
                e2.j(null);
                return true;
            }
            return false;
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    public void onLowMemory() {
    }

    public void onTrimMemory(int n2) {
    }

    public String toString() {
        i i2 = this;
        synchronized (i2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(super.toString());
            stringBuilder.append("{tracker=");
            stringBuilder.append((Object)this.h);
            stringBuilder.append(", treeNode=");
            stringBuilder.append((Object)this.i);
            stringBuilder.append("}");
            String string = stringBuilder.toString();
            return string;
        }
    }

    public class b
    implements c.a {
        public final n a;

        public b(n n2) {
            this.a = n2;
        }
    }

}

