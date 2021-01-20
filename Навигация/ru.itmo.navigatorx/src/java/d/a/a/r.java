/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  h.m.b.j
 *  java.lang.Comparable
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Arrays
 */
package d.a.a;

import d.a.a.s;
import h.m.b.j;
import java.util.Arrays;

public class r<T extends s & Comparable<? super T>> {
    public volatile int _size = 0;
    public T[] a;

    public final void a(T t2) {
        t2.c(this);
        Object[] arrobject = this.a;
        if (arrobject == null) {
            arrobject = new s[4];
            this.a = arrobject;
        } else if (this._size >= arrobject.length) {
            Object[] arrobject2 = Arrays.copyOf((Object[])arrobject, (int)(2 * this._size));
            j.d((Object)arrobject2, (String)"java.util.Arrays.copyOf(this, newSize)");
            arrobject = (s[])arrobject2;
            this.a = arrobject;
        }
        int n2 = this._size;
        this._size = n2 + 1;
        arrobject[n2] = t2;
        t2.a(n2);
        this.d(n2);
    }

    public final T b() {
        T[] arrT = this.a;
        if (arrT != null) {
            return arrT[0];
        }
        return null;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public final T c(int var1_1) {
        block5 : {
            var2_2 = this.a;
            j.c(var2_2);
            this._size = -1 + this._size;
            if (var1_1 >= this._size) break block5;
            this.e(var1_1, this._size);
            var4_3 = (var1_1 - 1) / 2;
            if (var1_1 <= 0) ** GOTO lbl-1000
            var14_4 = var2_2[var1_1];
            j.c(var14_4);
            var15_5 = (Comparable)var14_4;
            var16_6 = var2_2[var4_3];
            j.c(var16_6);
            if (var15_5.compareTo(var16_6) < 0) {
                this.e(var1_1, var4_3);
                this.d(var4_3);
            } else lbl-1000: // 3 sources:
            {
                while ((var5_7 = 1 + var1_1 * 2) < this._size) {
                    var6_8 = this.a;
                    j.c(var6_8);
                    var7_9 = var5_7 + 1;
                    if (var7_9 < this._size) {
                        var11_13 = var6_8[var7_9];
                        j.c(var11_13);
                        var12_14 = (Comparable)var11_13;
                        var13_15 = var6_8[var5_7];
                        j.c(var13_15);
                        if (var12_14.compareTo(var13_15) < 0) {
                            var5_7 = var7_9;
                        }
                    }
                    var8_10 = var6_8[var1_1];
                    j.c(var8_10);
                    var9_11 = (Comparable)var8_10;
                    var10_12 = var6_8[var5_7];
                    j.c(var10_12);
                    if (var9_11.compareTo(var10_12) <= 0) break;
                    this.e(var1_1, var5_7);
                    var1_1 = var5_7;
                }
            }
        }
        var3_16 = var2_2[this._size];
        j.c(var3_16);
        var3_16.c(null);
        var3_16.a(-1);
        var2_2[this._size] = null;
        return var3_16;
    }

    public final void d(int n2) {
        while (n2 > 0) {
            T[] arrT = this.a;
            j.c(arrT);
            int n3 = (n2 - 1) / 2;
            T t2 = arrT[n3];
            j.c(t2);
            Comparable comparable = (Comparable)t2;
            T t3 = arrT[n2];
            j.c(t3);
            if (comparable.compareTo(t3) <= 0) {
                return;
            }
            this.e(n2, n3);
            n2 = n3;
        }
        return;
    }

    public final void e(int n2, int n3) {
        T[] arrT = this.a;
        j.c(arrT);
        T t2 = arrT[n3];
        j.c(t2);
        T t3 = arrT[n2];
        j.c(t3);
        arrT[n2] = t2;
        arrT[n3] = t3;
        t2.a(n2);
        t3.a(n3);
    }
}

