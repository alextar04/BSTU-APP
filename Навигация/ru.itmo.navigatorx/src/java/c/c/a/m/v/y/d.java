/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.net.Uri
 *  c.c.a.m.o
 *  c.c.a.m.t.o.b
 *  c.c.a.m.t.o.b$b
 *  java.io.InputStream
 *  java.lang.Long
 *  java.lang.Object
 *  java.util.List
 */
package c.c.a.m.v.y;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import c.c.a.m.m;
import c.c.a.m.n;
import c.c.a.m.o;
import c.c.a.m.t.o.b;
import c.c.a.m.t.o.c;
import c.c.a.m.v.n;
import c.c.a.m.v.r;
import c.c.a.m.w.c.x;
import f.b.k.h;
import java.io.InputStream;
import java.util.List;

public class d
implements c.c.a.m.v.n<Uri, InputStream> {
    public final Context a;

    public d(Context context) {
        this.a = context.getApplicationContext();
    }

    @Override
    public n.a a(Object object, int n2, int n3, o o2) {
        Long l2;
        boolean bl;
        Uri uri = (Uri)object;
        if (h.i.K0(n2, n3) && (bl = (l2 = (Long)o2.c(x.d)) != null && l2 == -1L)) {
            c.c.a.r.d d2 = new c.c.a.r.d((Object)uri);
            Context context = this.a;
            return new n.a(d2, b.d((Context)context, (Uri)uri, (c)new b.b(context.getContentResolver())));
        }
        return null;
    }

    @Override
    public boolean b(Object object) {
        Uri uri = (Uri)object;
        return h.i.J0(uri) && uri.getPathSegments().contains((Object)"video");
    }

    public static class a
    implements c.c.a.m.v.o<Uri, InputStream> {
        public final Context a;

        public a(Context context) {
            this.a = context;
        }

        @Override
        public c.c.a.m.v.n<Uri, InputStream> b(r r2) {
            return new d(this.a);
        }
    }

}

