/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  c.c.a.m.o
 *  f.b.k.h
 *  java.lang.Class
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.List
 */
package c.c.a.m.u;

import c.b.a.a.a;
import c.c.a.m.o;
import c.c.a.m.t.e;
import c.c.a.m.u.j;
import c.c.a.m.u.r;
import c.c.a.m.u.w;
import f.b.k.h;
import f.h.k.c;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class u<Data, ResourceType, Transcode> {
    public final c<List<Throwable>> a;
    public final List<? extends j<Data, ResourceType, Transcode>> b;
    public final String c;

    public u(Class<Data> class_, Class<ResourceType> class_2, Class<Transcode> class_3, List<j<Data, ResourceType, Transcode>> list, c<List<Throwable>> c2) {
        this.a = c2;
        if (!list.isEmpty()) {
            this.b = list;
            StringBuilder stringBuilder = a.c("Failed LoadPath{");
            stringBuilder.append(class_.getSimpleName());
            stringBuilder.append("->");
            stringBuilder.append(class_2.getSimpleName());
            stringBuilder.append("->");
            stringBuilder.append(class_3.getSimpleName());
            stringBuilder.append("}");
            this.c = stringBuilder.toString();
            return;
        }
        throw new IllegalArgumentException("Must not be empty.");
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public w<Transcode> a(e<Data> e2, o o2, int n2, int n3, j.a<ResourceType> a2) {
        List<Throwable> list = this.a.b();
        h.i.p(list, "Argument must not be null");
        List<Throwable> list2 = list;
        try {
            int n4 = this.b.size();
            w w2 = null;
            for (int i2 = 0; i2 < n4; ++i2) {
                j j2 = (j)this.b.get(i2);
                try {
                    w w3;
                    w2 = w3 = j2.a(e2, n2, n3, o2, a2);
                }
                catch (r r2) {
                    list2.add((Object)r2);
                }
                if (w2 != null) break;
            }
            if (w2 != null) {
                return w2;
            }
            throw new r(this.c, (List<Throwable>)new ArrayList(list2));
        }
        finally {
            this.a.a(list2);
        }
    }

    public String toString() {
        StringBuilder stringBuilder = a.c("LoadPath{decodePaths=");
        stringBuilder.append(Arrays.toString((Object[])this.b.toArray()));
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

