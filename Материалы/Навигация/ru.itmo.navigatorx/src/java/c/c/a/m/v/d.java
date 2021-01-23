/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  java.io.File
 *  java.io.IOException
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.nio.ByteBuffer
 */
package c.c.a.m.v;

import android.util.Log;
import c.c.a.e;
import c.c.a.m.m;
import c.c.a.m.o;
import c.c.a.m.t.d;
import c.c.a.m.v.n;
import c.c.a.m.v.r;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

public class d
implements n<File, ByteBuffer> {
    @Override
    public n.a a(Object object, int n2, int n3, o o2) {
        File file = (File)object;
        return new n.a<ByteBuffer>(new c.c.a.r.d((Object)file), new a(file));
    }

    @Override
    public boolean b(Object object) {
        (File)object;
        return true;
    }

    public static final class a
    implements c.c.a.m.t.d<ByteBuffer> {
        public final File e;

        public a(File file) {
            this.e = file;
        }

        @Override
        public Class<ByteBuffer> a() {
            return ByteBuffer.class;
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
        public void e(e e2, d.a<? super ByteBuffer> a2) {
            ByteBuffer byteBuffer;
            try {
                byteBuffer = c.c.a.s.a.a(this.e);
            }
            catch (IOException iOException) {
                if (Log.isLoggable((String)"ByteBufferFileLoader", (int)3)) {
                    Log.d((String)"ByteBufferFileLoader", (String)"Failed to obtain ByteBuffer for file", (Throwable)iOException);
                }
                a2.d((Exception)iOException);
                return;
            }
            a2.f((ByteBuffer)byteBuffer);
        }
    }

    public static class b
    implements c.c.a.m.v.o<File, ByteBuffer> {
        @Override
        public n<File, ByteBuffer> b(r r2) {
            return new d();
        }
    }

}

