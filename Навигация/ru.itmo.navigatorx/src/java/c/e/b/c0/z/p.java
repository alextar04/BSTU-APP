/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package c.e.b.c0.z;

import c.b.a.a.a;
import c.e.b.a0;
import c.e.b.j;
import c.e.b.z;

public class p
implements a0 {
    public final /* synthetic */ Class e;
    public final /* synthetic */ z f;

    public p(Class class_, z z2) {
        this.e = class_;
        this.f = z2;
    }

    @Override
    public <T> z<T> a(j j2, c.e.b.d0.a<T> a2) {
        if (a2.a == this.e) {
            return this.f;
        }
        return null;
    }

    public String toString() {
        StringBuilder stringBuilder = a.c("Factory[type=");
        stringBuilder.append(this.e.getName());
        stringBuilder.append(",adapter=");
        stringBuilder.append((Object)this.f);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}

