/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  android.os.Bundle
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  androidx.fragment.app.Fragment
 *  androidx.recyclerview.widget.LinearLayoutManager
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$d
 *  androidx.recyclerview.widget.RecyclerView$l
 *  b.a.a.a.b.a
 *  b.a.a.d.d
 *  b.a.a.d.h$c
 *  b.a.a.d.j$a
 *  f.n.d0
 *  f.n.h0
 *  f.n.m
 *  f.n.n
 *  h.a
 *  h.h
 *  h.i.h
 *  h.k.d
 *  h.m.a.a
 *  h.m.a.p
 *  h.m.b.j
 *  h.m.b.o
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.HashMap
 *  java.util.List
 */
package b.a.a.a.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b.a.a.a.b.d;
import b.a.a.b.a.e;
import b.a.a.b.g;
import b.a.a.d.h;
import b.a.a.d.j;
import d.a.l1.i;
import d.a.x;
import f.b.k.h;
import f.n.d0;
import f.n.h0;
import f.n.m;
import f.n.n;
import h.h;
import h.m.a.p;
import h.m.b.o;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class d
extends c.e.a.a.p.d
implements b.a.a.a.b.c {
    public final h.a n0 = h.i.Q(this, o.a(b.a.a.d.d.class), (h.m.a.a<? extends h0>)new h.m.a.a<h0>((Fragment)this){
        public final /* synthetic */ Fragment f;
        {
            this.f = fragment;
            super(0);
        }

        public Object a() {
            f.l.d.e e2 = this.f.l0();
            h.m.b.j.b((Object)e2, (String)"requireActivity()");
            h0 h02 = e2.g();
            h.m.b.j.b((Object)h02, (String)"requireActivity().viewModelStore");
            return h02;
        }
    }, (h.m.a.a<? extends d0>)new h.m.a.a<d0>((Fragment)this){
        public final /* synthetic */ Fragment f;
        {
            this.f = fragment;
            super(0);
        }

        public Object a() {
            f.l.d.e e2 = this.f.l0();
            h.m.b.j.b((Object)e2, (String)"requireActivity()");
            d0 d02 = e2.k();
            h.m.b.j.b((Object)d02, (String)"requireActivity().defaultViewModelProviderFactory");
            return d02;
        }
    });
    public b.a.a.a.b.a o0;
    public RecyclerView.l p0;
    public HashMap q0;

    public View P(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        h.m.b.j.e((Object)layoutInflater, (String)"inflater");
        return layoutInflater.inflate(2131427381, viewGroup, false);
    }

    @Override
    public void R() {
        f.l.d.c.super.R();
        HashMap hashMap = this.q0;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    @Override
    public void e(b.a.a.b.b b2) {
        h.m.b.j.e((Object)((Object)b2), (String)"building");
        b.a.a.d.d d2 = (b.a.a.d.d)this.n0.getValue();
        if (d2 != null) {
            h.m.b.j.e((Object)((Object)b2), (String)"selectedBuilding");
            j j2 = (j)d2.e.getValue();
            if (j2 instanceof j.a) {
                j.a a2 = j2;
                if (b2 != a2.c) {
                    g g2 = d2.j;
                    if (g2 != null) {
                        h.m.b.j.e((Object)((Object)b2), (String)"building");
                        SharedPreferences.Editor editor = g2.a.edit();
                        editor.putInt("selected_building_key", b2.e);
                        editor.commit();
                        d.a.l1.d d3 = d2.d;
                        h.c c2 = h.c.a;
                        List<b.a.a.b.d> list = d2.i.b.getValue().a;
                        ArrayList arrayList = new ArrayList();
                        for (Object object : list) {
                            b.a.a.b.d d4 = (b.a.a.b.d)object;
                            b.a.a.b.b b3 = d4.f;
                            int n2 = 1;
                            if (b3 != b2 || d4.e != n2) {
                                n2 = 0;
                            }
                            if (n2 == 0) continue;
                            arrayList.add(object);
                        }
                        ArrayList arrayList2 = new ArrayList(h.i.x(arrayList, 10));
                        for (b.a.a.b.d d5 : arrayList) {
                            b.a.a.a.a.j.c c3 = new b.a.a.a.a.j.c(d5, false, false, null, 14);
                            arrayList2.add((Object)c3);
                        }
                        d3.setValue(a2.a((b.a.a.d.h)c2, (List)arrayList2, b2, 1, null, null, null, null));
                        d2.f();
                    } else {
                        throw null;
                    }
                }
            }
            this.B0();
            return;
        }
        throw null;
    }

    public void e0(View view, Bundle bundle) {
        View view2;
        h.m.b.j.e((Object)view, (String)"view");
        this.o0 = new b.a.a.a.b.a((List)h.i.h.e, (b.a.a.a.b.c)this);
        this.m0();
        this.p0 = new LinearLayoutManager(1, false);
        int n2 = b.a.a.c.recycler_view;
        if (this.q0 == null) {
            this.q0 = new HashMap();
        }
        if ((view2 = (View)this.q0.get((Object)n2)) == null) {
            View view3 = this.J;
            if (view3 == null) {
                view2 = null;
            } else {
                view2 = view3.findViewById(n2);
                this.q0.put((Object)n2, (Object)view2);
            }
        }
        RecyclerView recyclerView = (RecyclerView)view2;
        b.a.a.a.b.a a2 = this.o0;
        if (a2 != null) {
            recyclerView.setAdapter((RecyclerView.d)a2);
            RecyclerView.l l2 = this.p0;
            if (l2 != null) {
                recyclerView.setLayoutManager(l2);
                h.i.O0(n.a((m)this), null, null, (p)new p<x, h.k.d<? super h>, Object>(this, null){
                    public x i;
                    public Object j;
                    public Object k;
                    public int l;
                    public final /* synthetic */ d m;
                    {
                        this.m = d2;
                        super(2, (h.k.d<Object>)d3);
                    }

                    public final Object c(Object object, Object object2) {
                        h.k.d d2 = (h.k.d)object2;
                        h.m.b.j.e((Object)d2, (String)"completion");
                        p<x, h.k.d<? super h>, Object> p2 = new /* invalid duplicate definition of identical inner class */;
                        p2.i = (x)object;
                        return p2.i((Object)h.a);
                    }

                    public final h.k.d<h> g(Object object, h.k.d<?> d2) {
                        h.m.b.j.e(d2, (String)"completion");
                        p<x, h.k.d<? super h>, Object> p2 = new /* invalid duplicate definition of identical inner class */;
                        p2.i = (x)object;
                        return p2;
                    }

                    /*
                     * Enabled force condition propagation
                     * Lifted jumps to return sites
                     */
                    public final Object i(Object object) {
                        h.k.i.a a2 = h.k.i.a.e;
                        int n2 = this.l;
                        if (n2 != 0) {
                            if (n2 != 1) throw new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            (d.a.l1.a)this.k;
                            (x)this.j;
                            h.i.O1(object);
                            return h.a;
                        } else {
                            h.i.O1(object);
                            x x2 = this.i;
                            i i2 = ((b.a.a.d.d)this.m.n0.getValue()).e;
                            b.a.a.a.b.d$c$a a3 = new b.a.a.a.b.d$c$a(this);
                            this.j = x2;
                            this.k = i2;
                            this.l = 1;
                            if (i2.b(a3, this) != a2) return h.a;
                            return a2;
                        }
                    }
                }, 3, null);
                return;
            }
            h.m.b.j.j((String)"buildingLayoutManager");
            throw null;
        }
        h.m.b.j.j((String)"buildingAdapter");
        throw null;
    }

    @Override
    public int x0() {
        return 2131689481;
    }
}

