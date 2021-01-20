/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.ByteArrayInputStream
 *  java.io.InputStream
 *  java.lang.Class
 *  java.lang.Object
 *  java.nio.ByteBuffer
 */
package c.c.a.m.v;

import c.c.a.e;
import c.c.a.m.m;
import c.c.a.m.o;
import c.c.a.m.t.d;
import c.c.a.m.v.n;
import c.c.a.m.v.r;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;

public class b<Data>
implements n<byte[], Data> {
    public final b<Data> a;

    public b(b<Data> b2) {
        this.a = b2;
    }

    @Override
    public n.a a(Object object, int n2, int n3, o o2) {
        byte[] arrby = (byte[])object;
        return new n.a<Data>(new c.c.a.r.d(arrby), new c<Data>(arrby, this.a));
    }

    @Override
    public boolean b(Object object) {
        (byte[])object;
        return true;
    }

    public static class c.c.a.m.v.b$a
    implements c.c.a.m.v.o<byte[], ByteBuffer> {
        @Override
        public n<byte[], ByteBuffer> b(r r2) {
            return new b<ByteBuffer>(new b<ByteBuffer>(this){

                @Override
                public Class<ByteBuffer> a() {
                    return ByteBuffer.class;
                }

                @Override
                public Object b(byte[] arrby) {
                    return ByteBuffer.wrap((byte[])arrby);
                }
            });
        }

    }

    public static class c<Data>
    implements c.c.a.m.t.d<Data> {
        public final byte[] e;
        public final b<Data> f;

        public c(byte[] arrby, b<Data> b2) {
            this.e = arrby;
            this.f = b2;
        }

        @Override
        public Class<Data> a() {
            return this.f.a();
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

        @Override
        public void e(e e2, d.a<? super Data> a2) {
            a2.f(this.f.b(this.e));
        }
    }

    public static class d
    implements c.c.a.m.v.o<byte[], InputStream> {
        @Override
        public n<byte[], InputStream> b(r r2) {
            return new b<InputStream>(new b<InputStream>(this){

                @Override
                public Class<InputStream> a() {
                    return InputStream.class;
                }

                @Override
                public Object b(byte[] arrby) {
                    return new ByteArrayInputStream(arrby);
                }
            });
        }

    }

}

