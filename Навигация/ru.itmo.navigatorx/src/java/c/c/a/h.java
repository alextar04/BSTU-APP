/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.content.Context
 *  android.util.Log
 *  java.lang.Class
 *  java.lang.Cloneable
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 *  java.util.concurrent.CopyOnWriteArrayList
 *  java.util.concurrent.Executor
 */
package c.c.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import c.c.a.i;
import c.c.a.j;
import c.c.a.m.u.k;
import c.c.a.m.u.l;
import c.c.a.n.n;
import c.c.a.n.p;
import c.c.a.q.a;
import c.c.a.q.b;
import c.c.a.q.c;
import c.c.a.q.d;
import c.c.a.q.g;
import c.c.a.q.h.e;
import f.b.k.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;

public class h<TranscodeType>
extends a<h<TranscodeType>>
implements Cloneable,
Object<h<TranscodeType>> {
    public final Context E;
    public final i F;
    public final Class<TranscodeType> G;
    public final c.c.a.d H;
    public j<?, ? super TranscodeType> I;
    public Object J;
    public List<d<TranscodeType>> K;
    public boolean L = true;
    public boolean M;

    public static {
        (c.c.a.q.e)((c.c.a.q.e)((c.c.a.q.e)new c.c.a.q.e().d(k.b)).g(c.c.a.e.h)).k(true);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @SuppressLint(value={"CheckResult"})
    public h(c.c.a.b b2, i i2, Class<TranscodeType> class_, Context context) {
        this.F = i2;
        this.G = class_;
        this.E = context;
        c.c.a.d d2 = i2.e.g;
        j j2 = (j)d2.e.get(class_);
        if (j2 == null) {
            for (Map.Entry entry : d2.e.entrySet()) {
                if (!((Class)entry.getKey()).isAssignableFrom(class_)) continue;
                j2 = (j)entry.getValue();
            }
        }
        if (j2 == null) {
            j2 = c.c.a.d.j;
        }
        this.I = j2;
        this.H = b2.g;
        Iterator iterator = i2.n.iterator();
        do {
            if (!iterator.hasNext()) {
                c.c.a.q.e e2;
                i i3 = i2;
                synchronized (i3) {
                    e2 = i2.o;
                }
                this.o(e2);
                return;
            }
            d d3 = (d)iterator.next();
            if (d3 == null) continue;
            if (this.K == null) {
                this.K = new ArrayList();
            }
            this.K.add((Object)d3);
        } while (true);
    }

    @Override
    public a b() {
        h h2 = (h)super.b();
        h2.I = h2.I.a();
        return h2;
    }

    @Override
    public Object clone() {
        h h2 = (h)super.b();
        h2.I = h2.I.a();
        return h2;
    }

    public h<TranscodeType> o(a<?> a2) {
        h.i.p(a2, "Argument must not be null");
        return (h)super.a(a2);
    }

    public final b p(Object object, e<TranscodeType> e2, d<TranscodeType> d2, c c2, j<?, ? super TranscodeType> j2, c.c.a.e e3, int n2, int n3, a<?> a2, Executor executor) {
        return this.r(object, e2, d2, a2, null, j2, e3, n2, n3, executor);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public <Y extends e<TranscodeType>> Y q(Y y2) {
        i i2;
        b b2;
        boolean bl;
        Executor executor = c.c.a.s.e.a;
        h.i.p(y2, "Argument must not be null");
        if (!this.M) throw new IllegalArgumentException("You must call #load() before calling #into()");
        b b3 = this.p(new Object(), y2, (d<TranscodeType>)null, (c)null, this.I, this.h, this.o, this.n, this, executor);
        g g2 = (g)b3;
        if (g2.j(b2 = y2.f()) && !(bl = !this.m && b2.c())) {
            h.i.p(b2, "Argument must not be null");
            if (b2.isRunning()) return y2;
            b2.b();
            return y2;
        }
        this.F.l(y2);
        y2.j(b3);
        i i3 = i2 = this.F;
        synchronized (i3) {
            i2.j.e.add(y2);
            n n2 = i2.h;
            n2.a.add((Object)b3);
            if (!n2.c) {
                g2.b();
            } else {
                g2.clear();
                if (Log.isLoggable((String)"RequestTracker", (int)2)) {
                    Log.v((String)"RequestTracker", (String)"Paused, delaying request");
                }
                n2.b.add((Object)b3);
            }
            return y2;
        }
    }

    public final b r(Object object, e<TranscodeType> e2, d<TranscodeType> d2, a<?> a2, c c2, j<?, ? super TranscodeType> j2, c.c.a.e e3, int n2, int n3, Executor executor) {
        Context context = this.E;
        c.c.a.d d3 = this.H;
        Object object2 = this.J;
        Class<TranscodeType> class_ = this.G;
        List<d<TranscodeType>> list = this.K;
        l l2 = d3.f;
        c.c.a.q.i.c c3 = j2.e;
        g g2 = new g(context, d3, object, object2, class_, a2, n2, n3, e3, e2, d2, list, c2, l2, c3, executor);
        return g2;
    }
}

