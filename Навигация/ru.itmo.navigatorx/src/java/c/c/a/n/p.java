/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.ArrayList
 *  java.util.Collections
 *  java.util.Iterator
 *  java.util.Map
 *  java.util.Set
 *  java.util.WeakHashMap
 */
package c.c.a.n;

import c.c.a.n.i;
import c.c.a.q.h.e;
import c.c.a.s.j;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

public final class p
implements i {
    public final Set<e<?>> e = Collections.newSetFromMap((Map)new WeakHashMap());

    @Override
    public void e() {
        Iterator iterator = ((ArrayList)j.f(this.e)).iterator();
        while (iterator.hasNext()) {
            ((e)iterator.next()).e();
        }
    }

    @Override
    public void i() {
        Iterator iterator = ((ArrayList)j.f(this.e)).iterator();
        while (iterator.hasNext()) {
            ((e)iterator.next()).i();
        }
    }

    @Override
    public void k() {
        Iterator iterator = ((ArrayList)j.f(this.e)).iterator();
        while (iterator.hasNext()) {
            ((e)iterator.next()).k();
        }
    }
}

