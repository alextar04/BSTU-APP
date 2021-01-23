/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  b.a.a.d.c$a
 *  b.a.a.d.d
 *  h.h
 *  h.k.d
 *  h.k.i.a
 *  h.k.j.a.e
 *  h.m.a.p
 *  h.m.b.j
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 */
package b.a.a.d;

import b.a.a.d.c;
import b.a.a.d.d;
import d.a.l1.b;
import d.a.l1.i;
import d.a.x;
import f.b.k.h;
import h.h;
import h.k.j.a.e;
import h.m.a.p;
import h.m.b.j;

@e(c="ru.zakoulov.navigatorx.viewmodel.MainViewModel$observeMapData$1", f="MainViewModel.kt", l={426}, m="invokeSuspend")
public final class c
extends h.k.j.a.h
implements p<x, h.k.d<? super h>, Object> {
    public x i;
    public Object j;
    public Object k;
    public int l;
    public final /* synthetic */ d m;

    public c(d d2, h.k.d d3) {
        this.m = d2;
        super(2, (h.k.d<Object>)d3);
    }

    public final Object c(Object object, Object object2) {
        h.k.d d2 = (h.k.d)object2;
        j.e((Object)d2, (String)"completion");
        c c2 = new c(this.m, d2);
        c2.i = (x)object;
        return c2.i((Object)h.a);
    }

    @Override
    public final h.k.d<h> g(Object object, h.k.d<?> d2) {
        j.e(d2, (String)"completion");
        c c2 = new c(this.m, d2);
        c2.i = (x)object;
        return c2;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public final Object i(Object object) {
        h.k.i.a a2 = h.k.i.a.e;
        int n2 = this.l;
        if (n2 != 0) {
            if (n2 != 1) throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            (d.a.l1.a)this.k;
            (x)this.j;
            h.i.O1(object);
            return h.a;
        } else {
            h.i.O1(object);
            x x2 = this.i;
            i<b.a.a.b.c> i2 = this.m.i.b;
            a a3 = new a(this);
            this.j = x2;
            this.k = i2;
            this.l = 1;
            if (i2.b((b<b.a.a.b.c>)a3, this) != a2) return h.a;
            return a2;
        }
    }
}

