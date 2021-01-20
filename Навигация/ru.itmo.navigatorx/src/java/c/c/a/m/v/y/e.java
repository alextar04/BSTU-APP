/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.database.Cursor
 *  android.net.Uri
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Environment
 *  android.os.ParcelFileDescriptor
 *  android.provider.MediaStore
 *  android.text.TextUtils
 *  c.c.a.m.o
 *  java.io.File
 *  java.io.FileNotFoundException
 *  java.io.InputStream
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 */
package c.c.a.m.v.y;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.text.TextUtils;
import c.c.a.m.m;
import c.c.a.m.o;
import c.c.a.m.t.d;
import c.c.a.m.v.n;
import c.c.a.m.v.r;
import f.b.k.h;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

public final class e<DataT>
implements n<Uri, DataT> {
    public final Context a;
    public final n<File, DataT> b;
    public final n<Uri, DataT> c;
    public final Class<DataT> d;

    public e(Context context, n<File, DataT> n2, n<Uri, DataT> n3, Class<DataT> class_) {
        this.a = context.getApplicationContext();
        this.b = n2;
        this.c = n3;
        this.d = class_;
    }

    @Override
    public n.a a(Object object, int n2, int n3, o o2) {
        Uri uri = (Uri)object;
        c.c.a.r.d d2 = new c.c.a.r.d((Object)uri);
        d<DataT> d3 = new d<DataT>(this.a, this.b, this.c, uri, n2, n3, o2, this.d);
        return new n.a<DataT>(d2, d3);
    }

    @Override
    public boolean b(Object object) {
        Uri uri = (Uri)object;
        return Build.VERSION.SDK_INT >= 29 && h.i.J0(uri);
    }

    public static abstract class a<DataT>
    implements c.c.a.m.v.o<Uri, DataT> {
        public final Context a;
        public final Class<DataT> b;

        public a(Context context, Class<DataT> class_) {
            this.a = context;
            this.b = class_;
        }

        @Override
        public final n<Uri, DataT> b(r r2) {
            return new e<DataT>(this.a, r2.b(File.class, this.b), r2.b(Uri.class, this.b), this.b);
        }
    }

    public static final class d<DataT>
    implements c.c.a.m.t.d<DataT> {
        public static final String[] o = new String[]{"_data"};
        public final Context e;
        public final n<File, DataT> f;
        public final n<Uri, DataT> g;
        public final Uri h;
        public final int i;
        public final int j;
        public final o k;
        public final Class<DataT> l;
        public volatile boolean m;
        public volatile c.c.a.m.t.d<DataT> n;

        public d(Context context, n<File, DataT> n2, n<Uri, DataT> n3, Uri uri, int n4, int n5, o o2, Class<DataT> class_) {
            this.e = context.getApplicationContext();
            this.f = n2;
            this.g = n3;
            this.h = uri;
            this.i = n4;
            this.j = n5;
            this.k = o2;
            this.l = class_;
        }

        @Override
        public Class<DataT> a() {
            return this.l;
        }

        @Override
        public void b() {
            c.c.a.m.t.d<DataT> d2 = this.n;
            if (d2 != null) {
                d2.b();
            }
        }

        @Override
        public c.c.a.m.a c() {
            return c.c.a.m.a.e;
        }

        @Override
        public void cancel() {
            this.m = true;
            c.c.a.m.t.d<DataT> d2 = this.n;
            if (d2 != null) {
                d2.cancel();
            }
        }

        /*
         * Unable to fully structure code
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         * Lifted jumps to return sites
         */
        public final c.c.a.m.t.d<DataT> d() {
            block7 : {
                block6 : {
                    block8 : {
                        block5 : {
                            var1_1 = Environment.isExternalStorageLegacy();
                            var2_2 = null;
                            if (!var1_1) break block6;
                            var7_3 = this.f;
                            var8_4 = this.h;
                            var10_5 = this.e.getContentResolver().query(var8_4, d.o, null, null, null);
                            if (var10_5 == null) ** GOTO lbl23
                            if (!var10_5.moveToFirst()) ** GOTO lbl23
                            var14_6 = var10_5.getString(var10_5.getColumnIndexOrThrow("_data"));
                            if (TextUtils.isEmpty((CharSequence)var14_6)) break block5;
                            var15_7 = new File(var14_6);
                            var10_5.close();
                            var5_8 = var7_3.a(var15_7, this.i, this.j, this.k);
                            break block7;
                        }
                        try {
                            var16_9 = new StringBuilder();
                            var16_9.append("File path was empty in media store for: ");
                            var16_9.append((Object)var8_4);
                            throw new FileNotFoundException(var16_9.toString());
lbl23: // 2 sources:
                            var11_10 = new StringBuilder();
                            var11_10.append("Failed to media store entry for: ");
                            var11_10.append((Object)var8_4);
                            throw new FileNotFoundException(var11_10.toString());
                        }
                        catch (Throwable var9_11) {
                            var2_2 = var10_5;
                        }
                        break block8;
                        catch (Throwable var9_12) {
                            // empty catch block
                        }
                    }
                    if (var2_2 == null) throw var9_13;
                    var2_2.close();
                    throw var9_13;
                }
                var3_14 = this.e.checkSelfPermission("android.permission.ACCESS_MEDIA_LOCATION") == 0;
                var4_15 = var3_14 != false ? MediaStore.setRequireOriginal((Uri)this.h) : this.h;
                var5_8 = this.g.a(var4_15, this.i, this.j, this.k);
            }
            var6_16 = null;
            if (var5_8 == null) return var6_16;
            return var5_8.c;
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public void e(c.c.a.e e2, d.a<? super DataT> a2) {
            try {
                c.c.a.m.t.d<DataT> d2 = this.d();
                if (d2 == null) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Failed to build fetcher for: ");
                    stringBuilder.append((Object)this.h);
                    a2.d((Exception)new IllegalArgumentException(stringBuilder.toString()));
                    return;
                }
                this.n = d2;
                if (this.m) {
                    this.cancel();
                    return;
                }
                d2.e(e2, a2);
                return;
            }
            catch (FileNotFoundException fileNotFoundException) {
                a2.d((Exception)fileNotFoundException);
                return;
            }
        }
    }

}

