/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.res.AssetManager
 *  android.net.Uri
 *  android.os.ParcelFileDescriptor
 *  java.io.InputStream
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
package c.c.a.m.v;

import android.content.res.AssetManager;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import c.c.a.m.m;
import c.c.a.m.o;
import c.c.a.m.t.h;
import c.c.a.m.v.n;
import c.c.a.m.v.r;
import c.c.a.r.d;
import java.io.InputStream;
import java.util.List;

public class a<Data>
implements n<Uri, Data> {
    public final AssetManager a;
    public final a<Data> b;

    public a(AssetManager assetManager, a<Data> a2) {
        this.a = assetManager;
        this.b = a2;
    }

    @Override
    public n.a a(Object object, int n2, int n3, o o2) {
        Uri uri = (Uri)object;
        String string = uri.toString().substring(22);
        return new n.a<Data>(new d((Object)uri), this.b.a(this.a, string));
    }

    @Override
    public boolean b(Object object) {
        Uri uri = (Uri)object;
        boolean bl = "file".equals((Object)uri.getScheme());
        boolean bl2 = false;
        if (bl) {
            boolean bl3 = uri.getPathSegments().isEmpty();
            bl2 = false;
            if (!bl3) {
                boolean bl4 = "android_asset".equals(uri.getPathSegments().get(0));
                bl2 = false;
                if (bl4) {
                    bl2 = true;
                }
            }
        }
        return bl2;
    }

    public static class b
    implements c.c.a.m.v.o<Uri, ParcelFileDescriptor>,
    a<ParcelFileDescriptor> {
        public final AssetManager a;

        public b(AssetManager assetManager) {
            this.a = assetManager;
        }

        @Override
        public c.c.a.m.t.d<ParcelFileDescriptor> a(AssetManager assetManager, String string) {
            return new h(assetManager, string);
        }

        @Override
        public n<Uri, ParcelFileDescriptor> b(r r2) {
            return new a<ParcelFileDescriptor>(this.a, this);
        }
    }

    public static class c
    implements c.c.a.m.v.o<Uri, InputStream>,
    a<InputStream> {
        public final AssetManager a;

        public c(AssetManager assetManager) {
            this.a = assetManager;
        }

        @Override
        public c.c.a.m.t.d<InputStream> a(AssetManager assetManager, String string) {
            return new c.c.a.m.t.m(assetManager, string);
        }

        @Override
        public n<Uri, InputStream> b(r r2) {
            return new a<InputStream>(this.a, this);
        }
    }

}

