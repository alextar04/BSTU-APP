/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  f.p.d.m
 *  f.p.d.m$b
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
package b.a.a.a.a.j;

import b.a.a.a.a.j.c;
import f.p.d.m;
import h.m.b.j;
import java.util.List;

public final class d
extends m.b {
    public final List<c> a;
    public final List<c> b;

    public d(List<c> list, List<c> list2) {
        j.e(list, "oldMarkers");
        j.e(list2, "newMarkers");
        this.a = list;
        this.b = list2;
    }

    public boolean a(int n2, int n3) {
        c c2 = (c)this.a.get(n2);
        c c3 = (c)this.b.get(n3);
        return c2.b == c3.b && j.a(c2.d, c3.d) && j.a(c2.a, c3.a);
    }

    public boolean b(int n2, int n3) {
        return j.a(((c)this.a.get((int)n2)).a.a, ((c)this.b.get((int)n3)).a.a);
    }
}

