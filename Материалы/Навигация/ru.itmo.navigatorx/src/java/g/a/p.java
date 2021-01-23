/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.realm.internal.OsList
 *  java.lang.Class
 *  java.lang.Object
 */
package g.a;

import g.a.a;
import io.realm.internal.OsList;

public abstract class p<T> {
    public final a a;
    public final OsList b;
    public final Class<T> c;

    public p(a a2, OsList osList, Class<T> class_) {
        this.a = a2;
        this.c = class_;
        this.b = osList;
    }

    public abstract void a(Object var1);

    public abstract void b(Object var1);

    public abstract T c(int var1);

    public void d(int n2) {
        OsList osList = this.b;
        long l2 = n2;
        OsList.nativeInsertNull((long)osList.e, (long)l2);
    }

    public abstract void e(int var1, Object var2);

    public void f(int n2) {
        OsList osList = this.b;
        long l2 = n2;
        OsList.nativeSetNull((long)osList.e, (long)l2);
    }

    public abstract void g(int var1, Object var2);
}

