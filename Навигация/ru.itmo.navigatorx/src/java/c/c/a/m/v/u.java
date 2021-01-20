/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.res.AssetFileDescriptor
 *  android.net.Uri
 *  android.os.ParcelFileDescriptor
 *  android.text.TextUtils
 *  c.c.a.m.o
 *  java.io.File
 *  java.io.InputStream
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 */
package c.c.a.m.v;

import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import c.c.a.m.o;
import c.c.a.m.v.n;
import c.c.a.m.v.r;
import java.io.File;
import java.io.InputStream;

public class u<Data>
implements n<String, Data> {
    public final n<Uri, Data> a;

    public u(n<Uri, Data> n2) {
        this.a = n2;
    }

    @Override
    public n.a a(Object object, int n2, int n3, o o2) {
        Uri uri;
        block6 : {
            File file;
            block8 : {
                String string;
                block7 : {
                    block5 : {
                        string = (String)object;
                        if (!TextUtils.isEmpty((CharSequence)string)) break block5;
                        uri = null;
                        break block6;
                    }
                    if (string.charAt(0) != '/') break block7;
                    file = new File(string);
                    break block8;
                }
                uri = Uri.parse((String)string);
                if (uri.getScheme() != null) break block6;
                file = new File(string);
            }
            uri = Uri.fromFile((File)file);
        }
        n.a<Data> a2 = null;
        if (uri != null) {
            if (!this.a.b(uri)) {
                return null;
            }
            a2 = this.a.a(uri, n2, n3, o2);
        }
        return a2;
    }

    @Override
    public boolean b(Object object) {
        (String)object;
        return true;
    }

    public static final class a
    implements c.c.a.m.v.o<String, AssetFileDescriptor> {
        @Override
        public n<String, AssetFileDescriptor> b(r r2) {
            return new u<AssetFileDescriptor>(r2.b(Uri.class, AssetFileDescriptor.class));
        }
    }

    public static class b
    implements c.c.a.m.v.o<String, ParcelFileDescriptor> {
        @Override
        public n<String, ParcelFileDescriptor> b(r r2) {
            return new u<ParcelFileDescriptor>(r2.b(Uri.class, ParcelFileDescriptor.class));
        }
    }

    public static class c
    implements c.c.a.m.v.o<String, InputStream> {
        @Override
        public n<String, InputStream> b(r r2) {
            return new u<InputStream>(r2.b(Uri.class, InputStream.class));
        }
    }

}

