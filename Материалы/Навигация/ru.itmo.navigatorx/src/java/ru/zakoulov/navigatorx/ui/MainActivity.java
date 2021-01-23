/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.util.Log
 *  androidx.activity.ComponentActivity
 *  androidx.fragment.app.Fragment
 *  b.a.a.d.d
 *  b.a.a.d.h$a
 *  b.a.a.d.h$b
 *  b.a.a.d.h$c
 *  b.a.a.d.j$a
 *  f.l.d.r
 *  f.n.d0
 *  f.n.h0
 *  f.n.m
 *  f.n.n
 *  h.a
 *  h.b
 *  h.h
 *  h.k.d
 *  h.k.f
 *  h.k.j.a.e
 *  h.m.a.a
 *  h.m.a.p
 *  h.m.b.j
 *  h.m.b.o
 *  h.p.b
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  ru.zakoulov.navigatorx.ui.MainActivity$a
 *  ru.zakoulov.navigatorx.ui.MainActivity$b
 */
package ru.zakoulov.navigatorx.ui;

import android.os.Bundle;
import android.util.Log;
import androidx.activity.ComponentActivity;
import androidx.fragment.app.Fragment;
import b.a.a.d.d;
import b.a.a.d.h;
import b.a.a.d.j;
import d.a.l1.i;
import d.a.x;
import f.b.k.h;
import f.l.d.r;
import f.n.b0;
import f.n.d0;
import f.n.h0;
import f.n.m;
import f.n.n;
import h.h;
import h.k.f;
import h.k.j.a.e;
import h.m.a.p;
import h.m.b.o;
import ru.zakoulov.navigatorx.ui.MainActivity;

public final class MainActivity
extends f.b.k.e {
    public final h.a t;

    public MainActivity() {
        b b2 = new b(this);
        this.t = new b0(o.a(d.class), (h.m.a.a<? extends h0>)new a((ComponentActivity)this), (h.m.a.a<? extends d0>)b2);
    }

    public void onBackPressed() {
        block4 : {
            block5 : {
                block8 : {
                    boolean bl;
                    block7 : {
                        b.a.a.d.h h2;
                        block6 : {
                            d d2 = (d)this.t.getValue();
                            if (d2 == null) break block4;
                            StringBuilder stringBuilder = c.b.a.a.a.c("onBackPressed: ");
                            stringBuilder.append((Object)((j)d2.e.getValue()));
                            Log.d((String)"MainViewModel", (String)stringBuilder.toString());
                            j j2 = (j)d2.e.getValue();
                            if (!(j2 instanceof j.a)) break block5;
                            j.a a2 = j2;
                            h2 = a2.a;
                            if (!(h2 instanceof h.b) && !(h2 instanceof h.a)) break block6;
                            d2.d.setValue(j.a.b(a2, (b.a.a.d.h)h.c.a, null, null, (int)0, null, null, null, null, (int)254));
                            bl = true;
                            break block7;
                        }
                        if (!(h2 instanceof h.c)) break block8;
                        bl = false;
                    }
                    if (!bl) {
                        this.finish();
                    }
                    return;
                }
                throw new h.b();
            }
            throw new h.b();
        }
        throw null;
    }

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(2131427356);
        r r2 = this.m();
        if (r2 != null) {
            f.l.d.a a2 = new f.l.d.a(r2);
            a2.d(2131230838, (Fragment)new b.a.a.a.a.a(), null, 2);
            a2.c();
            h.i.O0(n.a((m)this), null, null, (p)new p<x, h.k.d<? super h>, Object>(this, null){
                public x i;
                public final /* synthetic */ MainActivity j;
                {
                    this.j = mainActivity;
                    super(2, (h.k.d<Object>)d2);
                }

                public final Object c(Object object, Object object2) {
                    h.k.d d2 = (h.k.d)object2;
                    h.m.b.j.e((Object)d2, (String)"completion");
                    MainActivity mainActivity = this.j;
                    d2.d();
                    (x)object;
                    h.i.O1((Object)h.a);
                    (d)mainActivity.t.getValue();
                    return h.a;
                }

                @Override
                public final h.k.d<h> g(Object object, h.k.d<?> d2) {
                    h.m.b.j.e(d2, (String)"completion");
                    p<x, h.k.d<? super h>, Object> p2 = new /* invalid duplicate definition of identical inner class */;
                    p2.i = (x)object;
                    return p2;
                }

                @Override
                public final Object i(Object object) {
                    h.i.O1(object);
                    (d)this.j.t.getValue();
                    return h.a;
                }
            }, 3, null);
            return;
        }
        throw null;
    }

}

