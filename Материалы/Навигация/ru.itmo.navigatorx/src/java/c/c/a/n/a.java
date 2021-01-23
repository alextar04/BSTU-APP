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

import c.c.a.n.h;
import c.c.a.n.i;
import c.c.a.s.j;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

public class a
implements h {
    public final Set<i> a = Collections.newSetFromMap((Map)new WeakHashMap());
    public boolean b;
    public boolean c;

    @Override
    public void a(i i2) {
        this.a.add((Object)i2);
        if (this.c) {
            i2.k();
            return;
        }
        if (this.b) {
            i2.i();
            return;
        }
        i2.e();
    }

    @Override
    public void b(i i2) {
        this.a.remove((Object)i2);
    }

    public void c() {
        this.c = true;
        Iterator iterator = ((ArrayList)j.f(this.a)).iterator();
        while (iterator.hasNext()) {
            ((i)iterator.next()).k();
        }
    }

    public void d() {
        this.b = true;
        Iterator iterator = ((ArrayList)j.f(this.a)).iterator();
        while (iterator.hasNext()) {
            ((i)iterator.next()).i();
        }
    }

    public void e() {
        this.b = false;
        Iterator iterator = ((ArrayList)j.f(this.a)).iterator();
        while (iterator.hasNext()) {
            ((i)iterator.next()).e();
        }
    }
}

