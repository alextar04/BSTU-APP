/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.Collections
 *  java.util.List
 *  java.util.Map
 *  java.util.Set
 *  java.util.WeakHashMap
 */
package c.c.a.n;

import c.c.a.q.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

public class n {
    public final Set<b> a = Collections.newSetFromMap((Map)new WeakHashMap());
    public final List<b> b = new ArrayList();
    public boolean c;

    public boolean a(b b2) {
        boolean bl = true;
        if (b2 == null) {
            return bl;
        }
        boolean bl2 = this.a.remove((Object)b2);
        if (!this.b.remove((Object)b2) && !bl2) {
            bl = false;
        }
        if (bl) {
            b2.clear();
        }
        return bl;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.toString());
        stringBuilder.append("{numRequests=");
        stringBuilder.append(this.a.size());
        stringBuilder.append(", isPaused=");
        stringBuilder.append(this.c);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

