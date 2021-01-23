/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Long
 *  java.lang.Number
 *  java.lang.Object
 *  java.util.ArrayList
 *  java.util.concurrent.atomic.AtomicLongArray
 */
package c.e.b;

import c.e.b.e0.a;
import c.e.b.e0.c;
import c.e.b.z;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLongArray;

public class i
extends z<AtomicLongArray> {
    public final /* synthetic */ z a;

    public i(z z2) {
        this.a = z2;
    }

    @Override
    public Object a(a a2) {
        ArrayList arrayList = new ArrayList();
        a2.c();
        while (a2.v()) {
            arrayList.add((Object)((Number)this.a.a(a2)).longValue());
        }
        a2.m();
        int n2 = arrayList.size();
        AtomicLongArray atomicLongArray = new AtomicLongArray(n2);
        for (int i2 = 0; i2 < n2; ++i2) {
            atomicLongArray.set(i2, ((Long)arrayList.get(i2)).longValue());
        }
        return atomicLongArray;
    }

    @Override
    public void b(c c2, Object object) {
        AtomicLongArray atomicLongArray = (AtomicLongArray)object;
        c2.f();
        int n2 = atomicLongArray.length();
        for (int i2 = 0; i2 < n2; ++i2) {
            this.a.b(c2, atomicLongArray.get(i2));
        }
        c2.m();
    }
}

