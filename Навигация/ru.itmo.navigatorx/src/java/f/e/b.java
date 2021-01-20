/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.UnsupportedOperationException
 *  java.util.Map
 */
package f.e;

import f.e.c;
import f.e.g;
import java.util.Map;

public class b
extends g<E, E> {
    public final /* synthetic */ c d;

    public b(c c2) {
        this.d = c2;
    }

    @Override
    public void a() {
        this.d.clear();
    }

    @Override
    public Object b(int n2, int n3) {
        return this.d.f[n2];
    }

    @Override
    public Map<E, E> c() {
        throw new UnsupportedOperationException("not a map");
    }

    @Override
    public int d() {
        return this.d.g;
    }

    @Override
    public int e(Object object) {
        return this.d.indexOf(object);
    }

    @Override
    public int f(Object object) {
        return this.d.indexOf(object);
    }

    @Override
    public void g(E e2, E e3) {
        this.d.add(e2);
    }

    @Override
    public void h(int n2) {
        this.d.f(n2);
    }

    @Override
    public E i(int n2, E e2) {
        throw new UnsupportedOperationException("not a map");
    }
}

