/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 *  h.k.f
 *  h.m.b.f
 *  h.m.b.j
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.System
 */
package d.a.j1;

import android.os.Handler;
import android.os.Looper;
import d.a.j1.b;
import d.a.y0;
import h.k.f;
import h.m.b.j;

public final class a
extends b {
    public volatile a _immediate;
    public final a f;
    public final Handler g;
    public final String h;
    public final boolean i;

    public a(Handler handler, String string, boolean bl) {
        a a2;
        super(null);
        this.g = handler;
        this.h = string;
        this.i = bl;
        a a3 = null;
        if (bl) {
            a3 = this;
        }
        if ((a2 = (this._immediate = a3)) == null) {
            this._immediate = a2 = new a(this.g, this.h, true);
        }
        this.f = a2;
    }

    @Override
    public void L(f f2, Runnable runnable) {
        this.g.post(runnable);
    }

    @Override
    public boolean M(f f2) {
        boolean bl = this.i;
        boolean bl2 = true;
        if (bl) {
            if (bl2 ^ j.a((Object)Looper.myLooper(), (Object)this.g.getLooper())) {
                return bl2;
            }
            bl2 = false;
        }
        return bl2;
    }

    @Override
    public y0 N() {
        return this.f;
    }

    public boolean equals(Object object) {
        return object instanceof a && ((a)object).g == this.g;
    }

    public int hashCode() {
        return System.identityHashCode((Object)this.g);
    }

    @Override
    public String toString() {
        String string = this.O();
        if (string != null) {
            return string;
        }
        String string2 = this.h;
        if (string2 == null) {
            string2 = this.g.toString();
        }
        if (this.i) {
            string2 = c.b.a.a.a.j(string2, ".immediate");
        }
        return string2;
    }
}

