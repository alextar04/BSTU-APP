/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.util.SparseIntArray
 *  f.t.a
 *  java.lang.Class
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.reflect.Method
 */
package f.t;

import android.os.Parcel;
import android.util.SparseIntArray;
import f.t.a;
import java.lang.reflect.Method;

public class b
extends a {
    public final SparseIntArray d = new SparseIntArray();
    public final Parcel e;
    public final int f;
    public final int g;
    public final String h;
    public int i = -1;
    public int j = 0;
    public int k = -1;

    public b(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "", new f.e.a<String, Method>(), new f.e.a<String, Method>(), new f.e.a<String, Class>());
    }

    public b(Parcel parcel, int n2, int n3, String string, f.e.a<String, Method> a2, f.e.a<String, Method> a3, f.e.a<String, Class> a4) {
        super(a2, a3, a4);
        this.e = parcel;
        this.f = n2;
        this.g = n3;
        this.j = n2;
        this.h = string;
    }

    public void a() {
        int n2 = this.i;
        if (n2 >= 0) {
            int n3 = this.d.get(n2);
            int n4 = this.e.dataPosition();
            int n5 = n4 - n3;
            this.e.setDataPosition(n3);
            this.e.writeInt(n5);
            this.e.setDataPosition(n4);
        }
    }

    public a b() {
        Parcel parcel = this.e;
        int n2 = parcel.dataPosition();
        int n3 = this.j;
        if (n3 == this.f) {
            n3 = this.g;
        }
        b b2 = new b(parcel, n2, n3, c.b.a.a.a.l(new StringBuilder(), this.h, "  "), this.a, this.b, this.c);
        return b2;
    }

    public boolean h(int n2) {
        while (this.j < this.g) {
            int n3 = this.k;
            if (n3 == n2) {
                return true;
            }
            if (String.valueOf((int)n3).compareTo(String.valueOf((int)n2)) > 0) {
                return false;
            }
            this.e.setDataPosition(this.j);
            int n4 = this.e.readInt();
            this.k = this.e.readInt();
            this.j = n4 + this.j;
        }
        return this.k == n2;
    }

    public void l(int n2) {
        this.a();
        this.i = n2;
        this.d.put(n2, this.e.dataPosition());
        this.e.writeInt(0);
        this.e.writeInt(n2);
    }
}

