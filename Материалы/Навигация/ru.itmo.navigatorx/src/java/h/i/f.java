/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  h.c
 *  h.i.e
 *  h.i.h
 *  h.m.b.j
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  java.util.NoSuchElementException
 */
package h.i;

import f.b.k.h;
import h.c;
import h.i.e;
import h.i.h;
import h.m.b.j;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class f
extends e {
    public static final <T> T a(List<? extends T> list) {
        j.e(list, (String)"$this$last");
        if (!list.isEmpty()) {
            return (T)list.get(h.i.i0(list));
        }
        throw new NoSuchElementException("List is empty.");
    }

    public static final <T, C extends Collection<? super T>> C b(Iterable<? extends T> iterable, C c2) {
        j.e(iterable, (String)"$this$toCollection");
        j.e(c2, (String)"destination");
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            c2.add(iterator.next());
        }
        return c2;
    }

    public static final <T> List<T> c(Iterable<? extends T> iterable) {
        j.e(iterable, (String)"$this$toList");
        if (iterable instanceof Collection) {
            Collection collection = (Collection)iterable;
            int n2 = collection.size();
            if (n2 != 0) {
                if (n2 != 1) {
                    j.e((Object)collection, (String)"$this$toMutableList");
                    return new ArrayList(collection);
                }
                Object object = iterable instanceof List ? ((List)iterable).get(0) : iterable.iterator().next();
                return h.i.R0(object);
            }
            return h.e;
        }
        return h.i.j1(f.e(iterable));
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M d(Iterable<? extends c<? extends K, ? extends V>> iterable, M m2) {
        j.e(iterable, (String)"$this$toMap");
        j.e(m2, (String)"destination");
        j.e(m2, (String)"$this$putAll");
        j.e(iterable, (String)"pairs");
        for (c c2 : iterable) {
            m2.put(c2.e, c2.f);
        }
        return m2;
    }

    public static final <T> List<T> e(Iterable<? extends T> iterable) {
        j.e(iterable, (String)"$this$toMutableList");
        if (iterable instanceof Collection) {
            Collection collection = (Collection)iterable;
            j.e((Object)collection, (String)"$this$toMutableList");
            return new ArrayList(collection);
        }
        ArrayList arrayList = new ArrayList();
        f.b(iterable, arrayList);
        return arrayList;
    }
}

