/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.Class
 *  java.lang.Comparable
 *  java.lang.Exception
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.Throwable
 *  java.nio.ByteBuffer
 *  java.security.SecureRandom
 *  java.util.Date
 *  java.util.concurrent.atomic.AtomicInteger
 */
package org.bson.types;

import f.b.k.h;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.security.SecureRandom;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public final class ObjectId
implements Comparable<ObjectId>,
Serializable {
    public static final int i;
    public static final short j;
    public static final AtomicInteger k;
    public static final char[] l;
    public final int e;
    public final int f;
    public final int g;
    public final short h;

    public static {
        k = new AtomicInteger(new SecureRandom().nextInt());
        l = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            SecureRandom secureRandom = new SecureRandom();
            i = secureRandom.nextInt(16777216);
            j = (short)secureRandom.nextInt(32768);
            return;
        }
        catch (Exception exception) {
            throw new RuntimeException((Throwable)exception);
        }
    }

    public ObjectId() {
        int n2 = (int)(new Date().getTime() / 1000L);
        int n3 = 16777215 & k.getAndIncrement();
        int n4 = i;
        short s2 = j;
        if ((-16777216 & n4) == 0) {
            this.e = n2;
            this.f = n3 & 16777215;
            this.g = n4;
            this.h = s2;
            return;
        }
        throw new IllegalArgumentException("The machine identifier must be between 0 and 16777215 (it must fit in three bytes).");
    }

    public ObjectId(byte[] arrby) {
        h.i.c1("bytes", arrby);
        int n2 = arrby.length;
        boolean bl = true;
        boolean bl2 = n2 == 12 ? bl : false;
        if (bl2) {
            ByteBuffer byteBuffer = ByteBuffer.wrap((byte[])arrby);
            h.i.c1("buffer", byteBuffer);
            if (byteBuffer.remaining() < 12) {
                bl = false;
            }
            h.i.L0("buffer.remaining() >=12", bl);
            this.e = ObjectId.b(byteBuffer.get(), byteBuffer.get(), byteBuffer.get(), byteBuffer.get());
            this.g = ObjectId.b((byte)0, byteBuffer.get(), byteBuffer.get(), byteBuffer.get());
            byte by = byteBuffer.get();
            byte by2 = byteBuffer.get();
            this.h = (short)((by & 255) << 8 | by2 & 255);
            this.f = ObjectId.b((byte)0, byteBuffer.get(), byteBuffer.get(), byteBuffer.get());
            return;
        }
        throw new IllegalArgumentException("state should be: bytes has length of 12");
    }

    public static int b(byte by, byte by2, byte by3, byte by4) {
        return by << 24 | (by2 & 255) << 16 | (by3 & 255) << 8 | by4 & 255;
    }

    public int a(ObjectId objectId) {
        if (objectId != null) {
            byte[] arrby = this.c();
            byte[] arrby2 = objectId.c();
            for (int i2 = 0; i2 < 12; ++i2) {
                if (arrby[i2] == arrby2[i2]) continue;
                if ((255 & arrby[i2]) < (255 & arrby2[i2])) {
                    return -1;
                }
                return 1;
            }
            return 0;
        }
        throw null;
    }

    public byte[] c() {
        ByteBuffer byteBuffer = ByteBuffer.allocate((int)12);
        h.i.c1("buffer", byteBuffer);
        boolean bl = byteBuffer.remaining() >= 12;
        h.i.L0("buffer.remaining() >=12", bl);
        byteBuffer.put((byte)(this.e >> 24));
        byteBuffer.put((byte)(this.e >> 16));
        byteBuffer.put((byte)(this.e >> 8));
        byteBuffer.put((byte)this.e);
        byteBuffer.put((byte)(this.g >> 16));
        byteBuffer.put((byte)(this.g >> 8));
        byteBuffer.put((byte)this.g);
        byteBuffer.put((byte)(this.h >> 8));
        byteBuffer.put((byte)this.h);
        byteBuffer.put((byte)(this.f >> 16));
        byteBuffer.put((byte)(this.f >> 8));
        byteBuffer.put((byte)this.f);
        return byteBuffer.array();
    }

    public String d() {
        char[] arrc = new char[24];
        byte[] arrby = this.c();
        int n2 = arrby.length;
        int n3 = 0;
        for (int i2 = 0; i2 < n2; ++i2) {
            byte by = arrby[i2];
            int n4 = n3 + 1;
            char[] arrc2 = l;
            arrc[n3] = arrc2[15 & by >> 4];
            n3 = n4 + 1;
            arrc[n4] = arrc2[by & 15];
        }
        return new String(arrc);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object != null) {
            if (ObjectId.class != object.getClass()) {
                return false;
            }
            ObjectId objectId = (ObjectId)object;
            if (this.f != objectId.f) {
                return false;
            }
            if (this.e != objectId.e) {
                return false;
            }
            if (this.g != objectId.g) {
                return false;
            }
            return this.h == objectId.h;
        }
        return false;
    }

    public int hashCode() {
        return 31 * (31 * (31 * this.e + this.f) + this.g) + this.h;
    }

    public String toString() {
        return this.d();
    }
}

