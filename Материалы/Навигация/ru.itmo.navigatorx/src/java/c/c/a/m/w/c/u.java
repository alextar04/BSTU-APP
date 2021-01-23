/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  c.c.a.m.o
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.Object
 *  java.util.Queue
 */
package c.c.a.m.w.c;

import android.graphics.Bitmap;
import c.c.a.m.o;
import c.c.a.m.q;
import c.c.a.m.u.c0.b;
import c.c.a.m.u.w;
import c.c.a.m.w.c.j;
import c.c.a.m.w.c.s;
import c.c.a.s.d;
import c.c.a.s.h;
import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

public class u
implements q<InputStream, Bitmap> {
    public final j a;
    public final b b;

    public u(j j2, b b2) {
        this.a = j2;
        this.b = b2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    @Override
    public w a(Object object, int n2, int n3, o o2) {
        Queue<d> queue;
        boolean bl;
        s s2;
        InputStream inputStream = (InputStream)object;
        if (inputStream instanceof s) {
            s2 = (s)inputStream;
            bl = false;
        } else {
            s s3 = new s(inputStream, this.b);
            bl = true;
            s2 = s3;
        }
        Queue<d> queue2 = queue = d.g;
        // MONITORENTER : queue2
        d d2 = (d)((Object)d.g.poll());
        // MONITOREXIT : queue2
        if (d2 == null) {
            d2 = new d();
        }
        d2.e = s2;
        h h2 = new h(d2);
        a a2 = new a(s2, d2);
        try {
            w<Bitmap> w2 = this.a.b((InputStream)h2, n2, n3, o2, a2);
            return w2;
        }
        finally {
            d2.c();
            if (bl) {
                s2.f();
            }
        }
    }

    @Override
    public boolean b(Object object, o o2) {
        (InputStream)object;
        if (this.a != null) {
            return true;
        }
        throw null;
    }

    public static class a
    implements j.b {
        public final s a;
        public final d b;

        public a(s s2, d d2) {
            this.a = s2;
            this.b = d2;
        }

        @Override
        public void a(c.c.a.m.u.c0.d d2, Bitmap bitmap) {
            IOException iOException = this.b.f;
            if (iOException != null) {
                if (bitmap != null) {
                    d2.c(bitmap);
                }
                throw iOException;
            }
        }

        @Override
        public void b() {
            s s2;
            s s3 = s2 = this.a;
            synchronized (s3) {
                s2.g = s2.e.length;
                return;
            }
        }
    }

}

