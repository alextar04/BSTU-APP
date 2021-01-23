/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  h.k.f
 *  h.m.b.j
 *  java.io.Closeable
 *  java.lang.Object
 *  java.lang.String
 */
package f.n;

import d.a.x;
import f.b.k.h;
import h.k.f;
import h.m.b.j;
import java.io.Closeable;

public final class c
implements Closeable,
x {
    public final f e;

    public c(f f2) {
        j.f((Object)f2, (String)"context");
        this.e = f2;
    }

    public void close() {
        h.i.j(this.e, null, 1, null);
    }

    @Override
    public f s() {
        return this.e;
    }
}

