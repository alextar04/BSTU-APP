/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.net.Uri
 *  c.c.a.m.o
 *  c.c.a.m.t.o.b
 *  c.c.a.m.t.o.b$a
 *  java.io.InputStream
 *  java.lang.Object
 *  java.util.List
 */
package c.c.a.m.v.y;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import c.c.a.m.m;
import c.c.a.m.o;
import c.c.a.m.t.o.b;
import c.c.a.m.v.n;
import c.c.a.m.v.r;
import c.c.a.r.d;
import f.b.k.h;
import java.io.InputStream;
import java.util.List;

public class c
implements n<Uri, InputStream> {
    public final Context a;

    public c(Context context) {
        this.a = context.getApplicationContext();
    }

    @Override
    public n.a a(Object object, int n2, int n3, o o2) {
        Uri uri = (Uri)object;
        if (h.i.K0(n2, n3)) {
            d d2 = new d((Object)uri);
            Context context = this.a;
            return new n.a(d2, b.d((Context)context, (Uri)uri, (c.c.a.m.t.o.c)new b.a(context.getContentResolver())));
        }
        return null;
    }

    @Override
    public boolean b(Object object) {
        Uri uri = (Uri)object;
        return h.i.J0(uri) && !uri.getPathSegments().contains((Object)"video");
    }

    public static class a
    implements c.c.a.m.v.o<Uri, InputStream> {
        public final Context a;

        public a(Context context) {
            this.a = context;
        }

        @Override
        public n<Uri, InputStream> b(r r2) {
            return new c(this.a);
        }
    }

}

