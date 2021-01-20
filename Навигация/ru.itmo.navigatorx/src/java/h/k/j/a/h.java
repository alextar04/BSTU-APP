/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  h.k.d
 *  h.m.b.g
 *  h.m.b.j
 *  h.m.b.o
 *  h.m.b.p
 *  java.lang.Object
 *  java.lang.String
 */
package h.k.j.a;

import h.k.d;
import h.k.j.a.a;
import h.k.j.a.c;
import h.m.b.g;
import h.m.b.j;
import h.m.b.o;
import h.m.b.p;

public abstract class h
extends c
implements g<Object>,
Object {
    public final int h;

    public h(int n2, d<Object> d2) {
        super(d2);
        this.h = n2;
    }

    public int b() {
        return this.h;
    }

    @Override
    public String toString() {
        if (this.e == null) {
            String string = o.a.a((g)this);
            j.d((Object)string, (String)"Reflection.renderLambdaToString(this)");
            return string;
        }
        return a.super.toString();
    }
}

