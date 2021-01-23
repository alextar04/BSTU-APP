/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Float
 *  java.lang.Number
 *  java.lang.Object
 */
package c.e.b;

import c.e.b.e0.a;
import c.e.b.e0.b;
import c.e.b.e0.c;
import c.e.b.j;
import c.e.b.z;

public class f
extends z<Number> {
    public f(j j2) {
    }

    @Override
    public Object a(a a2) {
        if (a2.T() == b.m) {
            a2.P();
            return null;
        }
        return Float.valueOf((float)((float)a2.K()));
    }

    @Override
    public void b(c c2, Object object) {
        Number number = (Number)object;
        if (number == null) {
            c2.u();
            return;
        }
        j.a(number.floatValue());
        c2.M(number);
    }
}

