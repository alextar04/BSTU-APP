/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  h.h
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 */
package d.a;

import c.b.a.a.a;
import d.a.d0;
import d.a.e;
import h.h;

public final class e0
extends e {
    public final d0 e;

    public e0(d0 d02) {
        this.e = d02;
    }

    public void a(Throwable throwable) {
        this.e.b();
    }

    public Object f(Object object) {
        (Throwable)object;
        this.e.b();
        return h.a;
    }

    public String toString() {
        StringBuilder stringBuilder = a.c("DisposeOnCancel[");
        stringBuilder.append((Object)this.e);
        stringBuilder.append(']');
        return stringBuilder.toString();
    }
}

