/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.nio.ByteBuffer
 *  java.nio.ByteOrder
 *  java.util.concurrent.atomic.AtomicInteger
 */
package k.a;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.concurrent.atomic.AtomicInteger;

public class n0 {
    public ByteBuffer a;
    public final AtomicInteger b = new AtomicInteger(1);

    public n0(ByteBuffer byteBuffer) {
        this.a = byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    }

    public int a() {
        return this.a.position();
    }
}

