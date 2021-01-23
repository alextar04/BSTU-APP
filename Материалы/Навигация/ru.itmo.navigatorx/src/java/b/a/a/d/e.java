/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  f.n.a0
 *  f.n.d0
 *  java.lang.Class
 *  java.lang.Object
 */
package b.a.a.d;

import b.a.a.b.g;
import b.a.a.d.d;
import f.n.a0;
import f.n.d0;
import h.m.b.j;

public final class e
implements d0 {
    public static e c;
    public final b.a.a.b.a.e a;
    public final g b;

    public e(b.a.a.b.a.e e2, g g2) {
        j.e(e2, "realmRepository");
        j.e(g2, "sharedPreferencesManager");
        this.a = e2;
        this.b = g2;
    }

    public <T extends a0> T a(Class<T> class_) {
        j.e(class_, "modelClass");
        return (T)((Object)new d(this.a, this.b));
    }
}

