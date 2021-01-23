/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.Class
 *  java.lang.Object
 *  java.util.Arrays
 */
package k.a.a1;

import java.io.Serializable;
import java.util.Arrays;

public class a
implements Serializable {
    public final byte e;
    public final byte[] f;

    public a(byte by, byte[] arrby) {
        this.e = by;
        this.f = (byte[])arrby.clone();
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object != null) {
            if (a.class != object.getClass()) {
                return false;
            }
            a a2 = (a)object;
            if (this.e != a2.e) {
                return false;
            }
            return Arrays.equals((byte[])this.f, (byte[])a2.f);
        }
        return false;
    }

    public int hashCode() {
        return 31 * this.e + Arrays.hashCode((byte[])this.f);
    }
}

