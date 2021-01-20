/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.Log
 *  c.c.a.g$d
 *  c.c.a.m.o
 *  c.c.a.m.r
 *  c.c.a.m.s
 *  c.c.a.m.u.e
 *  c.c.a.m.u.i
 *  c.c.a.m.u.i$b
 *  c.c.a.m.u.v
 *  c.c.a.m.u.y
 *  f.b.k.h
 *  java.io.IOException
 *  java.lang.Class
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.OutOfMemoryError
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.List
 */
package c.c.a.m.u;

import android.content.Context;
import android.util.Log;
import c.c.a.d;
import c.c.a.g;
import c.c.a.m.c;
import c.c.a.m.m;
import c.c.a.m.o;
import c.c.a.m.q;
import c.c.a.m.r;
import c.c.a.m.s;
import c.c.a.m.u.c0.b;
import c.c.a.m.u.e;
import c.c.a.m.u.h;
import c.c.a.m.u.i;
import c.c.a.m.u.k;
import c.c.a.m.u.v;
import c.c.a.m.u.w;
import c.c.a.m.u.y;
import c.c.a.m.v.n;
import c.c.a.p.f;
import f.b.k.h;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/*
 * Exception performing whole class analysis.
 */
public class j<DataType, ResourceType, Transcode> {
    public final Class<DataType> a;
    public final List<? extends q<DataType, ResourceType>> b;
    public final c.c.a.m.w.h.e<ResourceType, Transcode> c;
    public final f.h.k.c<List<Throwable>> d;
    public final String e;

    public j(Class<DataType> class_, Class<ResourceType> class_2, Class<Transcode> class_3, List<? extends q<DataType, ResourceType>> list, c.c.a.m.w.h.e<ResourceType, Transcode> e2, f.h.k.c<List<Throwable>> c2) {
        this.a = class_;
        this.b = list;
        this.c = e2;
        this.d = c2;
        StringBuilder stringBuilder = c.b.a.a.a.c("Failed DecodePath{");
        stringBuilder.append(class_.getSimpleName());
        stringBuilder.append("->");
        stringBuilder.append(class_2.getSimpleName());
        stringBuilder.append("->");
        stringBuilder.append(class_3.getSimpleName());
        stringBuilder.append("}");
        this.e = stringBuilder.toString();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public w<Transcode> a(c.c.a.m.t.e<DataType> e2, int n2, int n3, o o2, a<ResourceType> a2) {
        c.c.a.m.a a3;
        s s2;
        w w2;
        Class class_;
        boolean bl;
        e e3;
        boolean bl2;
        c c2;
        i i2;
        r r2;
        block13 : {
            boolean bl3;
            List<Throwable> list = this.d.b();
            h.i.p(list, "Argument must not be null");
            List<Throwable> list2 = list;
            w w3 = this.b(e2, n2, n3, o2, list2);
            i.b b2 = (i.b)a2;
            i2 = b2.b;
            a3 = b2.a;
            r2 = null;
            if (i2 == null) throw null;
            class_ = w3.b().getClass();
            if (a3 != c.c.a.m.a.h) {
                s s3 = i2.e.f(class_);
                w w4 = s3.b((Context)i2.l, w3, i2.p, i2.q);
                s2 = s3;
                w2 = w4;
            } else {
                w2 = w3;
                s2 = null;
            }
            if (!w3.equals(w2)) {
                w3.e();
            }
            if (bl3 = i2.e.c.b.d.a(w2.d()) != null) {
                r2 = i2.e.c.b.d.a(w2.d());
                if (r2 == null) throw new /* Unavailable Anonymous Inner Class!! */;
                c2 = r2.b(i2.s);
            } else {
                c2 = c.g;
            }
            break block13;
            finally {
                this.d.a(list2);
            }
        }
        h h2 = i2.e;
        m m2 = i2.B;
        List<n.a<?>> list = h2.c();
        int n4 = list.size();
        int n5 = 0;
        do {
            bl2 = false;
            if (n5 >= n4) break;
            if (((n.a)list.get((int)n5)).a.equals(m2)) {
                bl2 = true;
                break;
            }
            ++n5;
        } while (true);
        if (!i2.r.d(bl = bl2 ^ true, a3, c2)) return this.c.a(w2, o2);
        if (r2 == null) throw new /* Unavailable Anonymous Inner Class!! */;
        int n6 = c2.ordinal();
        if (n6 != 0) {
            if (n6 != 1) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unknown strategy: ");
                stringBuilder.append((Object)c2);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            b b3 = i2.e.c.a;
            m m3 = i2.B;
            m m4 = i2.m;
            int n7 = i2.p;
            int n8 = i2.q;
            o o3 = i2.s;
            e3 = new y(b3, m3, m4, n7, n8, s2, class_, o3);
        } else {
            e3 = new e(i2.B, i2.m);
        }
        w2 = v.f((w)w2);
        i.c c3 = i2.j;
        c3.a = e3;
        c3.b = r2;
        c3.c = w2;
        return this.c.a(w2, o2);
    }

    public final w<ResourceType> b(c.c.a.m.t.e<DataType> e2, int n2, int n3, o o2, List<Throwable> list) {
        int n4 = this.b.size();
        w w2 = null;
        for (int i2 = 0; i2 < n4; ++i2) {
            block8 : {
                void var10_10;
                q q2 = (q)this.b.get(i2);
                try {
                    if (q2.b(e2.a(), o2)) {
                        w2 = q2.a(e2.a(), n2, n3, o2);
                    }
                    break block8;
                }
                catch (OutOfMemoryError outOfMemoryError) {
                }
                catch (RuntimeException runtimeException) {
                }
                catch (IOException iOException) {
                    // empty catch block
                }
                if (Log.isLoggable((String)"DecodePath", (int)2)) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Failed to decode data for ");
                    stringBuilder.append((Object)q2);
                    Log.v((String)"DecodePath", (String)stringBuilder.toString(), (Throwable)var10_10);
                }
                list.add((Object)var10_10);
            }
            if (w2 != null) break;
        }
        if (w2 != null) {
            return w2;
        }
        throw new c.c.a.m.u.r(this.e, (List<Throwable>)new ArrayList(list));
    }

    public String toString() {
        StringBuilder stringBuilder = c.b.a.a.a.c("DecodePath{ dataClass=");
        stringBuilder.append(this.a);
        stringBuilder.append(", decoders=");
        stringBuilder.append(this.b);
        stringBuilder.append(", transcoder=");
        stringBuilder.append(this.c);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public static interface a<ResourceType> {
    }

}

