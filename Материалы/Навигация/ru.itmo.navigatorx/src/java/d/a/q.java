/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  c.b.a.a.a
 *  h.h
 *  h.m.a.l
 *  h.m.b.j
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 */
package d.a;

import c.b.a.a.a;
import h.h;
import h.m.a.l;
import h.m.b.j;

public final class q {
    public final Object a;
    public final l<Throwable, h> b;

    public q(Object object, l<? super Throwable, h> l2) {
        this.a = object;
        this.b = l2;
    }

    public boolean equals(Object object) {
        block2 : {
            block3 : {
                if (this == object) break block2;
                if (!(object instanceof q)) break block3;
                q q2 = (q)object;
                if (j.a((Object)this.a, (Object)q2.a) && j.a(this.b, q2.b)) break block2;
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        Object object = this.a;
        int n2 = object != null ? object.hashCode() : 0;
        int n3 = n2 * 31;
        l<Throwable, h> l2 = this.b;
        int n4 = 0;
        if (l2 != null) {
            n4 = l2.hashCode();
        }
        return n3 + n4;
    }

    public String toString() {
        StringBuilder stringBuilder = a.c((String)"CompletedWithCancellation(result=");
        stringBuilder.append(this.a);
        stringBuilder.append(", onCancellation=");
        stringBuilder.append(this.b);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

