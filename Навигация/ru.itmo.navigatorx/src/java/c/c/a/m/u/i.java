/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.Log
 *  java.lang.Boolean
 *  java.lang.Class
 *  java.lang.Comparable
 *  java.lang.Enum
 *  java.lang.Exception
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Thread
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.List
 *  java.util.Map
 *  java.util.concurrent.Executor
 */
package c.c.a.m.u;

import android.os.Build;
import android.util.Log;
import c.c.a.m.m;
import c.c.a.m.n;
import c.c.a.m.o;
import c.c.a.m.r;
import c.c.a.m.s;
import c.c.a.m.t.e;
import c.c.a.m.u.b0;
import c.c.a.m.u.d0.a;
import c.c.a.m.u.g;
import c.c.a.m.u.h;
import c.c.a.m.u.j;
import c.c.a.m.u.k;
import c.c.a.m.u.l;
import c.c.a.m.u.m;
import c.c.a.m.u.q;
import c.c.a.m.u.u;
import c.c.a.m.u.v;
import c.c.a.m.u.w;
import c.c.a.m.u.x;
import c.c.a.m.v.n;
import c.c.a.s.k.a;
import c.c.a.s.k.d;
import f.b.k.h;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

/*
 * Exception performing whole class analysis.
 */
public class i<R>
implements g.a,
Runnable,
Comparable<i<?>>,
a.d {
    public Thread A;
    public m B;
    public m C;
    public Object D;
    public c.c.a.m.a E;
    public c.c.a.m.t.d<?> F;
    public volatile c.c.a.m.u.g G;
    public volatile boolean H;
    public volatile boolean I;
    public final h<R> e;
    public final List<Throwable> f;
    public final c.c.a.s.k.d g;
    public final d h;
    public final f.h.k.c<i<?>> i;
    public final c<?> j;
    public final e k;
    public c.c.a.d l;
    public m m;
    public c.c.a.e n;
    public c.c.a.m.u.o o;
    public int p;
    public int q;
    public k r;
    public o s;
    public a<R> t;
    public int u;
    public g v;
    public f w;
    public long x;
    public boolean y;
    public Object z;

    public i(d d2, f.h.k.c<i<?>> c2) {
        this.e = new h();
        this.f = new ArrayList();
        this.g = new c.c.a.s.k.d(){
            public volatile boolean a;

            public void a() {
                if (!this.a) {
                    return;
                }
                throw new IllegalStateException("Already released");
            }
        };
        this.j = }
    java.lang.IllegalStateException: Inner class got unexpected class file - revert this change
    
    