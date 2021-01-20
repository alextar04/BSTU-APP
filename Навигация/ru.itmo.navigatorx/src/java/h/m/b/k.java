/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  h.m.b.g
 *  h.m.b.j
 *  h.m.b.o
 *  h.m.b.p
 *  java.io.Serializable
 *  java.lang.Object
 *  java.lang.String
 */
package h.m.b;

import h.m.b.g;
import h.m.b.j;
import h.m.b.o;
import h.m.b.p;
import java.io.Serializable;

public abstract class k<R>
implements g<R>,
Serializable {
    public final int e;

    public k(int n2) {
        this.e = n2;
    }

    public int b() {
        return this.e;
    }

    public String toString() {
        String string = o.a.a((g)this);
        j.d((Object)string, (String)"Reflection.renderLambdaToString(this)");
        return string;
    }
}

