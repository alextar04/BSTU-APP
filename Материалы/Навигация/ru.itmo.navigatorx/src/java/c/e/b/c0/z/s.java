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

import c.e.b.a0;
import c.e.b.e0.c;
import c.e.b.j;
import c.e.b.w;
import c.e.b.z;

public class s
implements a0 {
    public final /* synthetic */ Class e;
    public final /* synthetic */ z f;

    public s(Class class_, z z2) {
        this.e = class_;
        this.f = z2;
    }

    public <T2> z<T2> a(j j2, c.e.b.d0.a<T2> a2) {
        final Class class_ = a2.a;
        if (!this.e.isAssignableFrom(class_)) {
            return null;
        }
        return new z<T1>(){

            @Override
            public T1 a(c.e.b.e0.a a2) {
                Object t2 = s.this.f.a(a2);
                if (t2 != null) {
                    if (class_.isInstance(t2)) {
                        return (T1)t2;
                    }
                    StringBuilder stringBuilder = c.b.a.a.a.c("Expected a ");
                    stringBuilder.append(class_.getName());
                    stringBuilder.append(" but was ");
                    stringBuilder.append(t2.getClass().getName());
                    throw new w(stringBuilder.toString());
                }
                return (T1)t2;
            }

            @Override
            public void b(c c2, T1 T1) {
                s.this.f.b(c2, T1);
            }
        };
    }

    public String toString() {
        StringBuilder stringBuilder = c.b.a.a.a.c("Factory[typeHierarchy=");
        stringBuilder.append(this.e.getName());
        stringBuilder.append(",adapter=");
        stringBuilder.append((Object)this.f);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

}

