/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Number
 *  java.lang.Object
 *  java.util.concurrent.atomic.AtomicLong
 */
package c.e.b;

import c.e.b.e0.a;
import c.e.b.e0.c;
import c.e.b.z;
import java.util.concurrent.atomic.AtomicLong;

public class h
extends z<AtomicLong> {
    public final /* synthetic */ z a;

    public h(z z2) {
        this.a = z2;
    }

    @Override
    public Object a(a a2) {
        return new AtomicLong(((Number)this.a.a(a2)).longValue());
    }

    @Override
    public void b(c c2, Object object) {
        AtomicLong atomicLong = (AtomicLong)object;
        this.a.b(c2, atomicLong.get());
    }
}

