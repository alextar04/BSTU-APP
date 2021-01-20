/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.String
 */
package c.e.b;

import c.e.b.e0.a;
import c.e.b.e0.b;
import c.e.b.e0.c;
import c.e.b.z;

public class g
extends z<Number> {
    @Override
    public Object a(a a2) {
        if (a2.T() == b.m) {
            a2.P();
            return null;
        }
        return a2.M();
    }

    @Override
    public void b(c c2, Object object) {
        Number number = (Number)object;
        if (number == null) {
            c2.u();
            return;
        }
        c2.N(number.toString());
    }
}

