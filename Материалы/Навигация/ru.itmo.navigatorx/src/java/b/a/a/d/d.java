/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.SharedPreferences
 *  f.n.a0
 *  h.r.c
 *  java.lang.CharSequence
 *  java.lang.Float
 *  java.lang.Integer
 *  java.lang.Math
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Collections
 *  java.util.Comparator
 *  java.util.Iterator
 *  java.util.LinkedHashMap
 *  java.util.List
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.PriorityQueue
 *  java.util.Set
 */
package b.a.a.d;

import android.content.SharedPreferences;
import b.a.a.b.a.e;
import b.a.a.b.d;
import b.a.a.d.a;
import b.a.a.d.b;
import b.a.a.d.c;
import b.a.a.d.f;
import b.a.a.d.g;
import b.a.a.d.h;
import b.a.a.d.i;
import b.a.a.d.j;
import d.a.c0;
import d.a.e1;
import d.a.r0;
import d.a.x;
import d.a.y0;
import f.b.k.h;
import f.n.a0;
import h.k.f;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public final class d
extends a0 {
    public final b.a.a.b.b c;
    public final d.a.l1.d<j> d;
    public final d.a.l1.i<j> e;
    public final d.a.l1.c<a> f;
    public final d.a.l1.e<a> g;
    public final g h;
    public final e i;
    public final b.a.a.b.g j;

    public d(e e2, b.a.a.b.g g2) {
        b.a.a.b.b b22;
        block6 : {
            h.m.b.j.e(e2, "realmRepository");
            h.m.b.j.e(g2, "sharedPreferencesManager");
            this.i = e2;
            this.j = g2;
            int n2 = g2.a.getInt("selected_building_key", b.a.a.b.g.b.e);
            for (b.a.a.b.b b22 : b.a.a.b.b.values()) {
                boolean bl = b22.e == n2;
                if (!bl) {
                    continue;
                }
                break block6;
            }
            b22 = null;
        }
        if (b22 == null) {
            b22 = b.a.a.b.g.b;
        }
        this.c = b22;
        h.m.b.j.f((Object)this, "$this$viewModelScope");
        x x2 = (x)this.a("androidx.lifecycle.ViewModelCoroutineScope.JOB_KEY");
        if (x2 == null) {
            Object object = this.c("androidx.lifecycle.ViewModelCoroutineScope.JOB_KEY", (Object)new f.n.c(f.a.d(new e1(null), c0.a().N())));
            h.m.b.j.b(object, "setTagIfAbsent(JOB_KEY,\n\u2026patchers.Main.immediate))");
            x2 = (x)object;
        }
        h.i.O0(x2, null, null, new c(this, null), 3, null);
        h.c c2 = h.c.a;
        List<b.a.a.b.d> list = this.i.b.getValue().a;
        ArrayList arrayList = new ArrayList();
        for (Object object : list) {
            b.a.a.b.d d2 = (b.a.a.b.d)object;
            boolean bl = d2.e == 1 && d2.f == this.c;
            if (!bl) continue;
            arrayList.add(object);
        }
        ArrayList arrayList2 = new ArrayList(h.i.x(arrayList, 10));
        for (b.a.a.b.d d3 : arrayList) {
            b.a.a.a.a.j.c c3 = new b.a.a.a.a.j.c(d3, false, false, null, 14);
            arrayList2.add((Object)c3);
        }
        b.a.a.b.b b3 = this.c;
        j.a a2 = new j.a(c2, (List<b.a.a.a.a.j.c>)arrayList2, b3, 1, null, null, null, null);
        d.a.l1.j<j> j2 = new d.a.l1.j<j>(a2);
        this.d = j2;
        this.e = j2;
        d.a.l1.f<a> f2 = new d.a.l1.f<a>(1, 2, d.a.k1.a.e);
        this.f = f2;
        this.g = f2;
        this.f();
        this.h = new g(0.0f, 1);
    }

    public final List<b.a.a.b.d> d(String string, int n2) {
        String string2 = h.r.c.k((CharSequence)string).toString();
        List<b.a.a.b.d> list = this.i.b.getValue().a;
        ArrayList arrayList = new ArrayList();
        for (Object object : list) {
            boolean bl;
            block4 : {
                block6 : {
                    b.a.a.b.d d2;
                    block5 : {
                        String string3;
                        d2 = (b.a.a.b.d)object;
                        int n3 = d2.f.e;
                        bl = false;
                        if (n3 != n2) break block4;
                        if (!(d2 instanceof d.c)) break block5;
                        d.c c2 = d2;
                        h.m.b.j.e(c2, "roomMarker");
                        boolean bl2 = string2.length() == 0;
                        boolean bl3 = bl2 || h.r.c.a((CharSequence)c2.g, (CharSequence)string2, (boolean)true) || (string3 = c2.h.d) != null && h.r.c.a((CharSequence)string3, (CharSequence)string2, (boolean)true);
                        if (bl3) break block6;
                    }
                    boolean bl4 = d2 instanceof d.a;
                    bl = false;
                    if (!bl4) break block4;
                    d.a a2 = d2;
                    d.a$a a$a2 = a2.g;
                    d.a$a a$a3 = d.a$a.e;
                    bl = false;
                    if (a$a2 != a$a3) break block4;
                    h.m.b.j.e(a2, "entranceMarker");
                    boolean bl5 = string2.length() == 0;
                    boolean bl6 = bl5 || h.r.c.a((CharSequence)a2.h, (CharSequence)string2, (boolean)true);
                    bl = false;
                    if (!bl6) break block4;
                }
                bl = true;
            }
            if (!bl) continue;
            arrayList.add(object);
        }
        return arrayList;
    }

    public final void e(j.a a2, b.a.a.b.d d2, b.a.a.b.d d3) {
        int n2;
        Map<Integer, List<i>> map;
        int n3;
        d d4;
        b b2;
        j.a a3;
        block31 : {
            int n4;
            block23 : {
                block24 : {
                    b b3;
                    block22 : {
                        block30 : {
                            block29 : {
                                Map<String, b.a.a.b.e> map2;
                                List<b.a.a.b.e> list;
                                String string;
                                int n5;
                                LinkedHashMap linkedHashMap;
                                LinkedHashMap linkedHashMap2;
                                block21 : {
                                    b.a.a.b.d d5;
                                    String string2;
                                    d4 = this;
                                    n4 = 1;
                                    if (d2 == null || d3 == null) break block23;
                                    b.a.a.b.d d6 = a2.e;
                                    String string3 = d6 != null ? d6.a : null;
                                    if (h.m.b.j.a(string3, d2.a) && h.m.b.j.a(string2 = (d5 = a2.f) != null ? d5.a : null, d3.a)) {
                                        return;
                                    }
                                    b.a.a.b.c c2 = d4.i.b.getValue();
                                    g g2 = d4.h;
                                    Map<String, b.a.a.b.e> map3 = c2.b;
                                    Map<String, List<String>> map4 = c2.c;
                                    String string4 = d2.a;
                                    string = d3.a;
                                    if (g2 == null) break block24;
                                    h.m.b.j.e(map3, "pathDots");
                                    h.m.b.j.e(map4, "pathConnections");
                                    h.m.b.j.e(string4, "startDot");
                                    h.m.b.j.e(string, "finishDot");
                                    PriorityQueue priorityQueue = new PriorityQueue(128, new f());
                                    linkedHashMap2 = new LinkedHashMap();
                                    linkedHashMap = new LinkedHashMap();
                                    priorityQueue.add(new h.c<Float, String>(Float.valueOf((float)0.0f), string4));
                                    linkedHashMap2.put((Object)string4, (Object)Float.valueOf((float)0.0f));
                                    while (n4 ^ priorityQueue.isEmpty()) {
                                        block25 : {
                                            Object object = priorityQueue.poll();
                                            h.m.b.j.c(object);
                                            h.c c3 = (h.c)object;
                                            float f2 = ((Number)c3.e).floatValue();
                                            String string5 = (String)c3.f;
                                            if (h.m.b.j.a(string5, string)) {
                                                n5 = n4;
                                                map2 = map3;
                                                break block21;
                                            }
                                            Float f3 = (Float)linkedHashMap2.get((Object)string5);
                                            float f4 = f3 != null ? f3.floatValue() : Float.POSITIVE_INFINITY;
                                            if (f2 > f4) continue;
                                            List list2 = (List)map4.get((Object)string5);
                                            if (list2 == null) break block25;
                                            Iterator iterator = list2.iterator();
                                            while (iterator.hasNext()) {
                                                Map<String, List<String>> map5;
                                                float f5;
                                                g g3;
                                                String string6;
                                                Iterator iterator2;
                                                float f6;
                                                Map<String, b.a.a.b.e> map6;
                                                block28 : {
                                                    block27 : {
                                                        block26 : {
                                                            string6 = (String)iterator.next();
                                                            Float f7 = (Float)linkedHashMap2.get((Object)string6);
                                                            f6 = f7 != null ? f7.floatValue() : Float.POSITIVE_INFINITY;
                                                            h.m.b.j.e(string5, "dotId1");
                                                            h.m.b.j.e(string6, "dotId2");
                                                            b.a.a.b.e e2 = (b.a.a.b.e)map3.get((Object)string5);
                                                            if (e2 == null) break block26;
                                                            Object object2 = map3.get((Object)string6);
                                                            map5 = map4;
                                                            b.a.a.b.e e3 = (b.a.a.b.e)object2;
                                                            if (e3 == null) break block27;
                                                            iterator2 = iterator;
                                                            float f8 = e2.d != e3.d ? g2.a : 0.0f;
                                                            float f9 = e2.b;
                                                            g3 = g2;
                                                            double d7 = f9 - e3.b;
                                                            map6 = map3;
                                                            double d8 = 2;
                                                            f5 = f8 + (float)Math.pow((double)((float)Math.pow((double)d7, (double)d8) + (float)Math.pow((double)(e2.c - e3.c), (double)d8)), (double)0.5f);
                                                            break block28;
                                                        }
                                                        map5 = map4;
                                                    }
                                                    g3 = g2;
                                                    map6 = map3;
                                                    iterator2 = iterator;
                                                    f5 = Float.POSITIVE_INFINITY;
                                                }
                                                float f10 = f5 + f2;
                                                if (f10 < f6) {
                                                    linkedHashMap2.put((Object)string6, (Object)Float.valueOf((float)f10));
                                                    linkedHashMap.put((Object)string6, (Object)string5);
                                                    priorityQueue.add(new h.c<Float, String>(Float.valueOf((float)f10), string6));
                                                }
                                                iterator = iterator2;
                                                map4 = map5;
                                                g2 = g3;
                                                map3 = map6;
                                            }
                                        }
                                        Map<String, List<String>> map7 = map4;
                                        g g4 = g2;
                                        Map<String, b.a.a.b.e> map8 = map3;
                                        map4 = map7;
                                        g2 = g4;
                                        map3 = map8;
                                        n4 = 1;
                                    }
                                    map2 = map3;
                                    n5 = n4;
                                }
                                b.a.a.b.e[] arre = new b.a.a.b.e[n5];
                                Map<String, b.a.a.b.e> map9 = map2;
                                b.a.a.b.e e4 = (b.a.a.b.e)map9.get((Object)string);
                                if (e4 == null) break block29;
                                arre[0] = e4;
                                List<b.a.a.b.e> list3 = h.i.b1(arre);
                                while (linkedHashMap.containsKey((Object)h.i.f.a(list3).a)) {
                                    b.a.a.b.e e5 = (b.a.a.b.e)map9.get(linkedHashMap.get((Object)h.i.f.a(list3).a));
                                    if (e5 != null) {
                                        list3.add((Object)e5);
                                        continue;
                                    }
                                    n2 = 1;
                                    b3 = null;
                                    break block22;
                                }
                                h.m.b.j.e(list3, "$this$reversed");
                                if (list3.size() <= 1) {
                                    list = h.i.f.c(list3);
                                } else {
                                    list = h.i.f.e(list3);
                                    h.m.b.j.e(list, "$this$reverse");
                                    Collections.reverse(list);
                                }
                                LinkedHashMap linkedHashMap3 = new LinkedHashMap();
                                b.a.a.b.e[] arre2 = new b.a.a.b.e[]{(b.a.a.b.e)list.get(0)};
                                List<b.a.a.b.e> list4 = h.i.b1(arre2);
                                int n6 = list.size();
                                List<b.a.a.b.e> list5 = list4;
                                for (int i2 = 1; i2 < n6; ++i2) {
                                    b.a.a.b.e e6 = (b.a.a.b.e)list.get(i2);
                                    if (e6.d == ((b.a.a.b.e)list5.get((int)0)).d) {
                                        list5.add((Object)e6);
                                        continue;
                                    }
                                    if (!linkedHashMap3.containsKey((Object)((b.a.a.b.e)list5.get((int)0)).d)) {
                                        linkedHashMap3.put((Object)((b.a.a.b.e)list5.get((int)0)).d, (Object)new ArrayList());
                                    }
                                    Object object = linkedHashMap3.get((Object)((b.a.a.b.e)list5.get((int)0)).d);
                                    h.m.b.j.c(object);
                                    List list6 = (List)object;
                                    i.a a4 = e6.d > ((b.a.a.b.e)list5.get((int)0)).d ? i.a.f : i.a.g;
                                    list6.add((Object)new i(list5, a4));
                                    list5 = h.i.b1(e6);
                                }
                                n2 = 1;
                                if (!linkedHashMap3.containsKey((Object)((b.a.a.b.e)list5.get((int)0)).d)) {
                                    linkedHashMap3.put((Object)((b.a.a.b.e)list5.get((int)0)).d, (Object)new ArrayList());
                                }
                                Object object = linkedHashMap3.get((Object)((b.a.a.b.e)list5.get((int)0)).d);
                                h.m.b.j.c(object);
                                ((List)object).add((Object)new i(list5, i.a.e));
                                LinkedHashMap linkedHashMap4 = new LinkedHashMap();
                                Iterator iterator = linkedHashMap3.entrySet().iterator();
                                while (iterator.hasNext()) {
                                    for (i i3 : (List)((Map.Entry)iterator.next()).getValue()) {
                                        linkedHashMap4.put((Object)h.i.f.a(i3.a).a, (Object)i3.b);
                                    }
                                }
                                Float f11 = (Float)linkedHashMap2.get((Object)string);
                                if (f11 == null) break block30;
                                b3 = new b((Map<Integer, ? extends List<i>>)linkedHashMap3, f11.floatValue(), (Map<String, ? extends i.a>)linkedHashMap4);
                                break block22;
                            }
                            n2 = 1;
                        }
                        b3 = null;
                    }
                    d4 = this;
                    if (b3 == null) {
                        d4.f.a(a.b.a);
                    }
                    b2 = b3;
                    break block31;
                }
                throw null;
            }
            n2 = n4;
            b2 = null;
        }
        if (d2 != null) {
            n3 = d2.e;
            a3 = a2;
        } else {
            a3 = a2;
            n3 = a3.d;
        }
        d.a.l1.d<j> d9 = d4.d;
        h.c c4 = h.c.a;
        List<b.a.a.b.d> list = d4.i.b.getValue().a;
        ArrayList arrayList = new ArrayList();
        for (Object object : list) {
            b.a.a.b.d d10 = (b.a.a.b.d)object;
            int n7 = d10.f == a3.c && d10.e == n3 ? n2 : 0;
            if (n7 == 0) continue;
            arrayList.add(object);
        }
        ArrayList arrayList2 = new ArrayList(h.i.x(arrayList, 10));
        for (b.a.a.b.d d11 : arrayList) {
            Map<String, i.a> map10;
            String string;
            String string7;
            i.a a5 = b2 != null && (map10 = b2.b) != null ? (i.a)((Object)map10.get((Object)d11.a)) : null;
            String string8 = d4.g(a5);
            String string9 = d11.a;
            String string10 = d2 != null ? d2.a : null;
            int n8 = !h.m.b.j.a(string9, string10) && !h.m.b.j.a(string = d11.a, string7 = d3 != null ? d3.a : null) ? 0 : n2;
            arrayList2.add((Object)new b.a.a.a.a.j.c(d11, false, (boolean)n8, string8));
        }
        List list7 = b2 != null && (map = b2.a) != null ? (List)map.get((Object)n3) : null;
        d9.setValue(j.a.b(a2, c4, (List)arrayList2, null, n3, d2, d3, b2, list7, 4));
        if (d2 != null) {
            d4.f.a(new a.a(d2));
        }
    }

    public final void f() {
        j j2 = this.e.getValue();
        if (j2 instanceof j.a) {
            Object object2;
            block3 : {
                j.a a2 = j2;
                for (Object object2 : a2.b) {
                    b.a.a.b.d d2 = ((b.a.a.a.a.j.c)object2).a;
                    boolean bl = d2.f == a2.c && d2.e == a2.d && d2 instanceof d.a && (d2).g == d.a$a.e;
                    if (!bl) continue;
                    break block3;
                }
                object2 = null;
            }
            b.a.a.a.a.j.c c2 = (b.a.a.a.a.j.c)object2;
            if (c2 != null) {
                this.f.a(new a(c2.a){
                    public final b.a.a.b.d a;
                    {
                        h.m.b.j.e(d2, "marker");
                        super(null);
                        this.a = d2;
                    }
                });
            }
        }
    }

    public final String g(i.a a2) {
        block3 : {
            block4 : {
                block2 : {
                    if (a2 == null) break block2;
                    int n2 = a2.ordinal();
                    if (n2 == 1) break block3;
                    if (n2 == 2) break block4;
                }
                return null;
            }
            return "\u0412\u043d\u0438\u0437";
        }
        return "\u0412\u0432\u0435\u0440\u0445";
    }

    public final void h() {
        j j2 = this.e.getValue();
        if (j2 instanceof j.a) {
            d.a.l1.d<j> d2 = this.d;
            j.a a2 = j2;
            h.c c2 = h.c.a;
            List<b.a.a.a.a.j.c> list = a2.b;
            ArrayList arrayList = new ArrayList(h.i.x(list, 10));
            for (b.a.a.a.a.j.c c3 : list) {
                if (c3.b) {
                    c3 = b.a.a.a.a.j.c.a(c3, null, false, false, null, 13);
                }
                arrayList.add((Object)c3);
            }
            d2.setValue(j.a.b(a2, c2, (List)arrayList, null, 0, null, null, null, null, 252));
        }
    }
}

