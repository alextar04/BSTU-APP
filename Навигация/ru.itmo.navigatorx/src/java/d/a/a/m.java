/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  f.b.k.h
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package d.a.a;

import f.b.k.h;

public abstract class m {
    public abstract Object a(Object var1);

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getClass().getSimpleName());
        stringBuilder.append('@');
        stringBuilder.append(h.i.g0(this));
        return stringBuilder.toString();
    }
}

