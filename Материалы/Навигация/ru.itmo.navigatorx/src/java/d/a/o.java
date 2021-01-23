/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  c.b.a.a.a
 *  d.a.e
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
import d.a.e;
import h.h;
import h.m.a.l;
import h.m.b.j;

public final class o {
    public final Object a;
    public final e b;
    public final l<Throwable, h> c;
    public final Object d;
    public final Throwable e;

    public o(Object object, e e2, l<? super Throwable, h> l2, Object object2, Throwable throwable) {
        this.a = object;
        this.b = e2;
        this.c = l2;
        this.d = object2;
        this.e = throwable;
    }

    public o(Object object, e e2, l l2, Object object2, Throwable throwable, int n2) {
        if ((n2 & 2) != 0) {
            e2 = null;
        }
        if ((n2 & 4) != 0) {
            l2 = null;
        }
        if ((n2 & 8) != 0) {
            object2 = null;
        }
        if ((n2 & 16) != 0) {
            throwable = null;
        }
        this.a = object;
        this.b = e2;
        this.c = l2;
        this.d = object2;
        this.e = throwable;
    }

    public static o a(o o2, Object object, e e2, l l2, Object object2, Throwable throwable, int n2) {
        Object object3 = (n2 & 1) != 0 ? o2.a : null;
        if ((n2 & 2) != 0) {
            e2 = o2.b;
        }
        e e3 = e2;
        l<Throwable, h> l3 = (n2 & 4) != 0 ? o2.c : null;
        Object object4 = (n2 & 8) != 0 ? o2.d : null;
        if ((n2 & 16) != 0) {
            throwable = o2.e;
        }
        Throwable throwable2 = throwable;
        if (o2 != null) {
            o o3 = new o(object3, e3, l3, object4, throwable2);
            return o3;
        }
        throw null;
    }

    public boolean equals(Object object) {
        block2 : {
            block3 : {
                if (this == object) break block2;
                if (!(object instanceof o)) break block3;
                o o2 = (o)object;
                if (j.a((Object)this.a, (Object)o2.a) && j.a((Object)this.b, (Object)o2.b) && j.a(this.c, o2.c) && j.a((Object)this.d, (Object)o2.d) && j.a((Object)this.e, (Object)o2.e)) break block2;
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        Object object = this.a;
        int n2 = object != null ? object.hashCode() : 0;
        int n3 = n2 * 31;
        e e2 = this.b;
        int n4 = e2 != null ? e2.hashCode() : 0;
        int n5 = 31 * (n3 + n4);
        l<Throwable, h> l2 = this.c;
        int n6 = l2 != null ? l2.hashCode() : 0;
        int n7 = 31 * (n5 + n6);
        Object object2 = this.d;
        int n8 = object2 != null ? object2.hashCode() : 0;
        int n9 = 31 * (n7 + n8);
        Throwable throwable = this.e;
        int n10 = 0;
        if (throwable != null) {
            n10 = throwable.hashCode();
        }
        return n9 + n10;
    }

    public String toString() {
        StringBuilder stringBuilder = a.c((String)"CompletedContinuation(result=");
        stringBuilder.append(this.a);
        stringBuilder.append(", cancelHandler=");
        stringBuilder.append((Object)this.b);
        stringBuilder.append(", onCancellation=");
        stringBuilder.append(this.c);
        stringBuilder.append(", idempotentResume=");
        stringBuilder.append(this.d);
        stringBuilder.append(", cancelCause=");
        stringBuilder.append((Object)this.e);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

