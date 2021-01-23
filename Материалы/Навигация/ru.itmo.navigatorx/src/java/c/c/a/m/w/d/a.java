/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.nio.Buffer
 *  java.nio.ByteBuffer
 */
package c.c.a.m.w.d;

import c.c.a.m.t.e;
import java.nio.Buffer;
import java.nio.ByteBuffer;

public class a
implements e<ByteBuffer> {
    public final ByteBuffer a;

    public a(ByteBuffer byteBuffer) {
        this.a = byteBuffer;
    }

    @Override
    public Object a() {
        this.a.position(0);
        return this.a;
    }

    @Override
    public void b() {
    }

    public static class a
    implements e.a<ByteBuffer> {
        @Override
        public Class<ByteBuffer> a() {
            return ByteBuffer.class;
        }

        @Override
        public e b(Object object) {
            return new a((ByteBuffer)object);
        }
    }

}

