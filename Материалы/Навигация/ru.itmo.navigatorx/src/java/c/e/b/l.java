/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.List
 */
package c.e.b;

import c.e.b.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class l
extends o
implements Iterable<o> {
    public final List<o> e = new ArrayList();

    public boolean equals(Object object) {
        return object == this || object instanceof l && ((l)object).e.equals(this.e);
        {
        }
    }

    public int hashCode() {
        return this.e.hashCode();
    }

    public Iterator<o> iterator() {
        return this.e.iterator();
    }
}

