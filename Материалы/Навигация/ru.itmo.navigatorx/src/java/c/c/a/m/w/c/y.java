/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.media.MediaDataSource
 *  c.c.a.m.w.c.x
 *  c.c.a.m.w.c.x$d
 *  java.lang.Math
 *  java.nio.Buffer
 *  java.nio.ByteBuffer
 */
package c.c.a.m.w.c;

import android.media.MediaDataSource;
import c.c.a.m.w.c.x;
import java.nio.Buffer;
import java.nio.ByteBuffer;

public class y
extends MediaDataSource {
    public final /* synthetic */ ByteBuffer e;

    public y(x.d d2, ByteBuffer byteBuffer) {
        this.e = byteBuffer;
    }

    public void close() {
    }

    public long getSize() {
        return this.e.limit();
    }

    public int readAt(long l2, byte[] arrby, int n2, int n3) {
        if (l2 >= (long)this.e.limit()) {
            return -1;
        }
        this.e.position((int)l2);
        int n4 = Math.min((int)n3, (int)this.e.remaining());
        this.e.get(arrby, n2, n4);
        return n4;
    }
}

