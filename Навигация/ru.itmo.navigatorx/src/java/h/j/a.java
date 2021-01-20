/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Comparable
 *  java.lang.Object
 *  java.util.Comparator
 */
package h.j;

import f.b.k.h;
import h.m.a.l;
import java.util.Comparator;

public final class a<T>
implements Comparator<T> {
    public final /* synthetic */ l[] e;

    public a(l[] arrl) {
        this.e = arrl;
    }

    public final int compare(T t2, T t3) {
        for (l l2 : this.e) {
            int n2 = h.i.y((Comparable)l2.f(t2), (Comparable)l2.f(t3));
            if (n2 == 0) continue;
            return n2;
        }
        return 0;
    }
}

