/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Float
 *  java.lang.Integer
 *  java.lang.Object
 *  java.util.List
 */
package f.h.e.b;

import java.util.List;

public final class f {
    public final int[] a;
    public final float[] b;

    public f(int n2, int n3) {
        this.a = new int[]{n2, n3};
        this.b = new float[]{0.0f, 1.0f};
    }

    public f(int n2, int n3, int n4) {
        this.a = new int[]{n2, n3, n4};
        this.b = new float[]{0.0f, 0.5f, 1.0f};
    }

    public f(List<Integer> list, List<Float> list2) {
        int n2 = list.size();
        this.a = new int[n2];
        this.b = new float[n2];
        for (int i2 = 0; i2 < n2; ++i2) {
            this.a[i2] = (Integer)list.get(i2);
            this.b[i2] = ((Float)list2.get(i2)).floatValue();
        }
    }
}

