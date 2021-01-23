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

public class r
implements a0 {
    public final /* synthetic */ Class e;
    public final /* synthetic */ Class f;
    public final /* synthetic */ z g;

    public r(Class class_, Class class_2, z z2) {
        this.e = class_;
        this.f = class_2;
        this.g = z2;
    }

    @Override
    public <T> z<T> a(j j2, c.e.b.d0.a<T> a2) {
        Class class_ = a2.a;
        if (class_ != this.e && class_ != this.f) {
            return null;
        }
        return this.g;
    }

    public String toString() {
        StringBuilder stringBuilder = a.c("Factory[type=");
        stringBuilder.append(this.e.getName());
        stringBuilder.append("+");
        stringBuilder.append(this.f.getName());
        stringBuilder.append(",adapter=");
        stringBuilder.append((Object)this.g);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}

