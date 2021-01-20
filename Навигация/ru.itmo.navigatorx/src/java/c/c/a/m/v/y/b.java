/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  c.c.a.m.o
 *  c.c.a.m.v.g
 *  java.io.InputStream
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.HashSet
 *  java.util.Set
 */
package c.c.a.m.v.y;

import android.net.Uri;
import c.c.a.m.o;
import c.c.a.m.v.g;
import c.c.a.m.v.n;
import c.c.a.m.v.r;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class b
implements n<Uri, InputStream> {
    public static final Set<String> b = Collections.unmodifiableSet((Set)new HashSet((Collection)Arrays.asList((Object[])new String[]{"http", "https"})));
    public final n<g, InputStream> a;

    public b(n<g, InputStream> n2) {
        this.a = n2;
    }

    @Override
    public n.a a(Object object, int n2, int n3, o o2) {
        Uri uri = (Uri)object;
        return this.a.a(new g(uri.toString()), n2, n3, o2);
    }

    @Override
    public boolean b(Object object) {
        Uri uri = (Uri)object;
        return b.contains((Object)uri.getScheme());
    }

    public static class a
    implements c.c.a.m.v.o<Uri, InputStream> {
        @Override
        public n<Uri, InputStream> b(r r2) {
            return new b(r2.b(g.class, InputStream.class));
        }
    }

}

