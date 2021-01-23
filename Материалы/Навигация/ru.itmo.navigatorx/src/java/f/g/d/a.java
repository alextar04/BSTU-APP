/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  f.h.k.d
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.HashSet
 */
package f.g.d;

import f.e.h;
import f.h.k.c;
import f.h.k.d;
import java.util.ArrayList;
import java.util.HashSet;

public final class a<T> {
    public final c<ArrayList<T>> a = new d(10);
    public final h<T, ArrayList<T>> b = new h();
    public final ArrayList<T> c = new ArrayList();
    public final HashSet<T> d = new HashSet();

    public void a(T t2) {
        boolean bl = this.b.e(t2) >= 0;
        if (!bl) {
            this.b.put(t2, null);
        }
    }

    public final void b(T t2, ArrayList<T> arrayList, HashSet<T> hashSet) {
        if (arrayList.contains(t2)) {
            return;
        }
        if (!hashSet.contains(t2)) {
            hashSet.add(t2);
            ArrayList arrayList2 = this.b.getOrDefault(t2, null);
            if (arrayList2 != null) {
                int n2 = arrayList2.size();
                for (int i2 = 0; i2 < n2; ++i2) {
                    this.b(arrayList2.get(i2), arrayList, hashSet);
                }
            }
            hashSet.remove(t2);
            arrayList.add(t2);
            return;
        }
        throw new RuntimeException("This graph contains cyclic dependencies");
    }
}

