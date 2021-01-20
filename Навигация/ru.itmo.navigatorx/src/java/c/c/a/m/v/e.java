/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.Base64
 *  java.io.ByteArrayInputStream
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 */
package c.c.a.m.v;

import android.util.Base64;
import c.c.a.m.m;
import c.c.a.m.o;
import c.c.a.m.t.d;
import c.c.a.m.v.n;
import c.c.a.m.v.r;
import c.c.a.r.d;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class e<Model, Data>
implements n<Model, Data> {
    public final a<Data> a;

    public e(a<Data> a2) {
        this.a = a2;
    }

    @Override
    public n.a<Data> a(Model Model, int n2, int n3, o o2) {
        return new n.a<Data>(new d(Model), new b<Data>(Model.toString(), this.a));
    }

    @Override
    public boolean b(Model Model) {
        return Model.toString().startsWith("data:image");
    }

    public static final class b<Data>
    implements c.c.a.m.t.d<Data> {
        public final String e;
        public final a<Data> f;
        public Data g;

        public b(String string, a<Data> a2) {
            this.e = string;
            this.f = a2;
        }

        @Override
        public Class<Data> a() {
            if (this.f != null) {
                return InputStream.class;
            }
            throw null;
        }

        @Override
        public void b() {
            try {
                a<Data> a2 = this.f;
                Data Data = this.g;
                if (a2 != null) {
                    ((InputStream)Data).close();
                    return;
                }
                throw null;
            }
            catch (IOException iOException) {
                return;
            }
        }

        @Override
        public c.c.a.m.a c() {
            return c.c.a.m.a.e;
        }

        @Override
        public void cancel() {
        }

        @Override
        public void e(c.c.a.e e2, d.a<? super Data> a2) {
            a<Data> a3;
            String string;
            try {
                a3 = this.f;
                string = this.e;
            }
            catch (IllegalArgumentException illegalArgumentException) {
                a2.d((Exception)illegalArgumentException);
                return;
            }
            c.a a4 = a3;
            Object object = a4.a(string);
            this.g = object;
            a2.f(object);
        }
    }

    public static final class c<Model>
    implements c.c.a.m.v.o<Model, InputStream> {
        public final c.c.a.m.v.e$a<InputStream> a = new c.c.a.m.v.e$a<InputStream>(this){

            public Object a(String string) {
                if (string.startsWith("data:image")) {
                    int n2 = string.indexOf(44);
                    if (n2 != -1) {
                        if (string.substring(0, n2).endsWith(";base64")) {
                            return new ByteArrayInputStream(Base64.decode((String)string.substring(n2 + 1), (int)0));
                        }
                        throw new IllegalArgumentException("Not a base64 image data URL.");
                    }
                    throw new IllegalArgumentException("Missing comma in data URL.");
                }
                throw new IllegalArgumentException("Not a valid image data URL.");
            }
        };

        @Override
        public n<Model, InputStream> b(r r2) {
            return new e(this.a);
        }

    }

}

