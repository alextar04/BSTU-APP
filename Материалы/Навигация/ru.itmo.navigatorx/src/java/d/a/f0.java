/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package d.a;

import c.b.a.a.a;
import d.a.n0;
import d.a.z0;

public final class f0
implements n0 {
    public final boolean e;

    public f0(boolean bl) {
        this.e = bl;
    }

    @Override
    public boolean c() {
        return this.e;
    }

    @Override
    public z0 e() {
        return null;
    }

    public String toString() {
        StringBuilder stringBuilder = a.c("Empty{");
        String string = this.e ? "Active" : "New";
        stringBuilder.append(string);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

