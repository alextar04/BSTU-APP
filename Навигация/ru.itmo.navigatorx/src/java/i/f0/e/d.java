/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.LinkedHashSet
 *  java.util.Set
 */
package i.f0.e;

import i.d0;
import java.util.LinkedHashSet;
import java.util.Set;

public final class d {
    public final Set<d0> a = new LinkedHashSet();

    public void a(d0 d02) {
        d d2 = this;
        synchronized (d2) {
            this.a.remove((Object)d02);
            return;
        }
    }
}

