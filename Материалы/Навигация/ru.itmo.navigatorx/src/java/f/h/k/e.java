/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  f.h.k.d
 *  java.lang.Object
 */
package f.h.k;

import f.h.k.d;

public class e<T>
extends d<T> {
    public final Object c = new Object();

    public e(int n2) {
        super(n2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean a(T t2) {
        Object object;
        Object object2 = object = this.c;
        synchronized (object2) {
            return super.a(t2);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public T b() {
        Object object;
        Object object2 = object = this.c;
        synchronized (object2) {
            Object object3 = super.b();
            return (T)object3;
        }
    }
}

