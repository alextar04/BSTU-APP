/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 *  android.content.res.Resources$NotFoundException
 *  android.net.Uri
 *  android.os.ParcelFileDescriptor
 *  android.util.Log
 *  c.c.a.m.o
 *  java.io.InputStream
 *  java.lang.Class
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 */
package c.c.a.m.v;

import android.content.res.Resources;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import c.c.a.m.o;
import c.c.a.m.v.n;
import c.c.a.m.v.r;
import c.c.a.m.v.v;
import java.io.InputStream;

public class s<Data>
implements n<Integer, Data> {
    public final n<Uri, Data> a;
    public final Resources b;

    public s(Resources resources, n<Uri, Data> n2) {
        this.b = resources;
        this.a = n2;
    }

    @Override
    public n.a a(Object object, int n2, int n3, o o2) {
        Uri uri;
        Integer n4 = (Integer)object;
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("android.resource://");
            stringBuilder.append(this.b.getResourcePackageName(n4.intValue()));
            stringBuilder.append('/');
            stringBuilder.append(this.b.getResourceTypeName(n4.intValue()));
            stringBuilder.append('/');
            stringBuilder.append(this.b.getResourceEntryName(n4.intValue()));
            uri = Uri.parse((String)stringBuilder.toString());
        }
        catch (Resources.NotFoundException notFoundException) {
            if (Log.isLoggable((String)"ResourceLoader", (int)5)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Received invalid resource id: ");
                stringBuilder.append((Object)n4);
                Log.w((String)"ResourceLoader", (String)stringBuilder.toString(), (Throwable)notFoundException);
            }
            uri = null;
        }
        if (uri == null) {
            return null;
        }
        return this.a.a(uri, n2, n3, o2);
    }

    @Override
    public boolean b(Object object) {
        (Integer)object;
        return true;
    }

    public static class b
    implements c.c.a.m.v.o<Integer, ParcelFileDescriptor> {
        public final Resources a;

        public b(Resources resources) {
            this.a = resources;
        }

        @Override
        public n<Integer, ParcelFileDescriptor> b(r r2) {
            return new s<ParcelFileDescriptor>(this.a, r2.b(Uri.class, ParcelFileDescriptor.class));
        }
    }

    public static class c
    implements c.c.a.m.v.o<Integer, InputStream> {
        public final Resources a;

        public c(Resources resources) {
            this.a = resources;
        }

        @Override
        public n<Integer, InputStream> b(r r2) {
            return new s<InputStream>(this.a, r2.b(Uri.class, InputStream.class));
        }
    }

    public static class d
    implements c.c.a.m.v.o<Integer, Uri> {
        public final Resources a;

        public d(Resources resources) {
            this.a = resources;
        }

        @Override
        public n<Integer, Uri> b(r r2) {
            return new s<Uri>(this.a, v.a);
        }
    }

}

