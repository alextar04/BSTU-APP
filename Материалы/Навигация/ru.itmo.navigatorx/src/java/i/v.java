/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package i;

import c.b.a.a.a;
import java.io.IOException;

public final class v
extends Enum<v> {
    public static final /* enum */ v f;
    public static final /* enum */ v g;
    public static final /* enum */ v h;
    public static final /* enum */ v i;
    public static final /* enum */ v j;
    public static final /* enum */ v k;
    public static final /* synthetic */ v[] l;
    public final String e;

    public static {
        v v2;
        f = new v("http/1.0");
        g = new v("http/1.1");
        h = new v("spdy/3.1");
        i = new v("h2");
        j = new v("h2_prior_knowledge");
        k = v2 = new v("quic");
        v[] arrv = new v[]{f, g, h, i, j, v2};
        l = arrv;
    }

    public v(String string2) {
        this.e = string2;
    }

    public static v a(String string) {
        v v2 = k;
        v v3 = h;
        v v4 = i;
        v v5 = j;
        v v6 = g;
        v v7 = f;
        if (string.equals((Object)v7.e)) {
            return v7;
        }
        if (string.equals((Object)v6.e)) {
            return v6;
        }
        if (string.equals((Object)v5.e)) {
            return v5;
        }
        if (string.equals((Object)v4.e)) {
            return v4;
        }
        if (string.equals((Object)v3.e)) {
            return v3;
        }
        if (string.equals((Object)v2.e)) {
            return v2;
        }
        throw new IOException(a.j("Unexpected protocol: ", string));
    }

    public static v valueOf(String string) {
        return (v)Enum.valueOf(v.class, (String)string);
    }

    public static v[] values() {
        return (v[])l.clone();
    }

    public String toString() {
        return this.e;
    }
}

