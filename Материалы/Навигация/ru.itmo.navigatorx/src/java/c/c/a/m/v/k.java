/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.database.Cursor
 *  android.net.Uri
 *  android.text.TextUtils
 *  java.io.File
 *  java.io.FileNotFoundException
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package c.c.a.m.v;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import c.c.a.e;
import c.c.a.m.m;
import c.c.a.m.o;
import c.c.a.m.t.d;
import c.c.a.m.v.n;
import c.c.a.m.v.r;
import c.c.a.r.d;
import f.b.k.h;
import java.io.File;
import java.io.FileNotFoundException;

public final class k
implements n<Uri, File> {
    public final Context a;

    public k(Context context) {
        this.a = context;
    }

    @Override
    public n.a a(Object object, int n2, int n3, o o2) {
        Uri uri = (Uri)object;
        return new n.a<File>(new d((Object)uri), new b(this.a, uri));
    }

    @Override
    public boolean b(Object object) {
        return h.i.J0((Uri)object);
    }

    public static final class a
    implements c.c.a.m.v.o<Uri, File> {
        public final Context a;

        public a(Context context) {
            this.a = context;
        }

        @Override
        public n<Uri, File> b(r r2) {
            return new k(this.a);
        }
    }

    public static class b
    implements c.c.a.m.t.d<File> {
        public static final String[] g = new String[]{"_data"};
        public final Context e;
        public final Uri f;

        public b(Context context, Uri uri) {
            this.e = context;
            this.f = uri;
        }

        @Override
        public Class<File> a() {
            return File.class;
        }

        @Override
        public void b() {
        }

        @Override
        public c.c.a.m.a c() {
            return c.c.a.m.a.e;
        }

        @Override
        public void cancel() {
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public void e(e e2, d.a<? super File> a2) {
            String string;
            Cursor cursor = this.e.getContentResolver().query(this.f, g, null, null, null);
            string = null;
            if (cursor != null) {
                try {
                    boolean bl = cursor.moveToFirst();
                    string = null;
                    if (bl) {
                        string = cursor.getString(cursor.getColumnIndexOrThrow("_data"));
                    }
                }
                finally {
                    cursor.close();
                }
            }
            if (TextUtils.isEmpty(string)) {
                StringBuilder stringBuilder = c.b.a.a.a.c("Failed to find file path for: ");
                stringBuilder.append((Object)this.f);
                a2.d((Exception)new FileNotFoundException(stringBuilder.toString()));
                return;
            }
            a2.f((File)new File(string));
        }
    }

}

