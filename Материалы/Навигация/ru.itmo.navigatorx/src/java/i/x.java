/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Collections
 *  java.util.LinkedHashMap
 *  java.util.List
 *  java.util.Map
 */
package i;

import f.b.k.h;
import i.d;
import i.f0.c;
import i.q;
import i.r;
import i.z;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class x {
    public final r a;
    public final String b;
    public final q c;
    public final z d;
    public final Map<Class<?>, Object> e;
    public volatile d f;

    public x(a a2) {
        this.a = a2.a;
        this.b = a2.b;
        q.a a3 = a2.c;
        if (a3 != null) {
            this.c = new q(a3);
            this.d = a2.d;
            this.e = c.r(a2.e);
            return;
        }
        throw null;
    }

    public d a() {
        d d2;
        d d3 = this.f;
        if (d3 != null) {
            return d3;
        }
        this.f = d2 = d.a(this.c);
        return d2;
    }

    public String toString() {
        StringBuilder stringBuilder = c.b.a.a.a.c("Request{method=");
        stringBuilder.append(this.b);
        stringBuilder.append(", url=");
        stringBuilder.append((Object)this.a);
        stringBuilder.append(", tags=");
        stringBuilder.append(this.e);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public static class a {
        public r a;
        public String b;
        public q.a c;
        public z d;
        public Map<Class<?>, Object> e = Collections.emptyMap();

        public a() {
            this.b = "GET";
            this.c = new q.a();
        }

        public a(x x2) {
            this.a = x2.a;
            this.b = x2.b;
            this.d = x2.d;
            Object object = x2.e.isEmpty() ? Collections.emptyMap() : new LinkedHashMap(x2.e);
            this.e = object;
            this.c = x2.c.e();
        }

        public a a(String string, String string2) {
            q.a a2 = this.c;
            if (a2 != null) {
                q.a(string);
                q.b(string2, string);
                a2.a.add((Object)string);
                a2.a.add((Object)string2.trim());
                return this;
            }
            throw null;
        }

        public x b() {
            if (this.a != null) {
                return new x(this);
            }
            throw new IllegalStateException("url == null");
        }

        public a c(String string, String string2) {
            q.a a2 = this.c;
            if (a2 != null) {
                q.a(string);
                q.b(string2, string);
                a2.b(string);
                a2.a.add((Object)string);
                a2.a.add((Object)string2.trim());
                return this;
            }
            throw null;
        }

        public a d(String string, z z2) {
            if (string.length() != 0) {
                if (z2 != null && !h.i.m1(string)) {
                    throw new IllegalArgumentException(c.b.a.a.a.k("method ", string, " must not have a request body."));
                }
                if (z2 == null) {
                    boolean bl = string.equals((Object)"POST") || string.equals((Object)"PUT") || string.equals((Object)"PATCH") || string.equals((Object)"PROPPATCH") || string.equals((Object)"REPORT");
                    if (bl) {
                        throw new IllegalArgumentException(c.b.a.a.a.k("method ", string, " must have a request body."));
                    }
                }
                this.b = string;
                this.d = z2;
                return this;
            }
            throw new IllegalArgumentException("method.length() == 0");
        }

        public a e(r r2) {
            if (r2 != null) {
                this.a = r2;
                return this;
            }
            throw new NullPointerException("url == null");
        }
    }

}

