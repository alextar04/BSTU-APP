/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Throwable
 */
package d.a;

import d.a.j;
import d.a.k;
import d.a.r0;
import d.a.u0;
import d.a.v0;

public final class e1
extends v0
implements r0 {
    public final boolean f;

    public e1(r0 r02) {
        super(true);
        this.C(r02);
        this.f = this.Q();
    }

    public final boolean Q() {
        k k2;
        v0 v02;
        j j2 = (j)this._parentHandle;
        if (!(j2 instanceof k)) {
            j2 = null;
        }
        if ((k2 = (k)j2) != null && (v02 = (v0)k2.h) != null) {
            j j3;
            k k3;
            do {
                if (v02.r()) {
                    return true;
                }
                j3 = (j)v02._parentHandle;
                if (j3 instanceof k) continue;
                j3 = null;
            } while ((k3 = (k)j3) != null && (v02 = (v0)k3.h) != null);
        }
        return false;
    }

    @Override
    public boolean l(Throwable throwable) {
        return false;
    }

    @Override
    public boolean r() {
        return this.f;
    }

    @Override
    public boolean t() {
        return true;
    }
}

