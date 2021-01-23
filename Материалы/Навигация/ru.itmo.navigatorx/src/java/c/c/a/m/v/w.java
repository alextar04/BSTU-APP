/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.res.AssetFileDescriptor
 *  android.net.Uri
 *  android.os.ParcelFileDescriptor
 *  c.c.a.m.o
 *  java.io.InputStream
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.HashSet
 *  java.util.Set
 */
package c.c.a.m.v;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import c.c.a.m.m;
import c.c.a.m.o;
import c.c.a.m.t.i;
import c.c.a.m.v.n;
import c.c.a.m.v.r;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class w<Data>
implements n<Uri, Data> {
    public static final Set<String> b = Collections.unmodifiableSet((Set)new HashSet((Collection)Arrays.asList((Object[])new String[]{"file", "android.resource", "content"})));
    public final c<Data> a;

    public w(c<Data> c2) {
        this.a = c2;
    }

    @Override
    public n.a a(Object object, int n2, int n3, o o2) {
        Uri uri = (Uri)object;
        return new n.a<Data>(new c.c.a.r.d((Object)uri), this.a.a(uri));
    }

    @Override
    public boolean b(Object object) {
        Uri uri = (Uri)object;
        return b.contains((Object)uri.getScheme());
    }

    public static final class a
    implements c.c.a.m.v.o<Uri, AssetFileDescriptor>,
    c<AssetFileDescriptor> {
        public final ContentResolver a;

        public a(ContentResolver contentResolver) {
            this.a = contentResolver;
        }

        @Override
        public c.c.a.m.t.d<AssetFileDescriptor> a(Uri uri) {
            return new c.c.a.m.t.a(this.a, uri);
        }

        @Override
        public n<Uri, AssetFileDescriptor> b(r r2) {
            return new w<AssetFileDescriptor>(this);
        }
    }

    public static class b
    implements c.c.a.m.v.o<Uri, ParcelFileDescriptor>,
    c<ParcelFileDescriptor> {
        public final ContentResolver a;

        public b(ContentResolver contentResolver) {
            this.a = contentResolver;
        }

        @Override
        public c.c.a.m.t.d<ParcelFileDescriptor> a(Uri uri) {
            return new i(this.a, uri);
        }

        @Override
        public n<Uri, ParcelFileDescriptor> b(r r2) {
            return new w<ParcelFileDescriptor>(this);
        }
    }

    public static class d
    implements c.c.a.m.v.o<Uri, InputStream>,
    c<InputStream> {
        public final ContentResolver a;

        public d(ContentResolver contentResolver) {
            this.a = contentResolver;
        }

        @Override
        public c.c.a.m.t.d<InputStream> a(Uri uri) {
            return new c.c.a.m.t.n(this.a, uri);
        }

        @Override
        public n<Uri, InputStream> b(r r2) {
            return new w<InputStream>(this);
        }
    }

}

