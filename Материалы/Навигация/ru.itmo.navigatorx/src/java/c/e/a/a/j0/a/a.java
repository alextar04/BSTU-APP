/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.content.res.TypedArray
 *  android.util.AttributeSet
 *  java.lang.Object
 */
package c.e.a.a.j0.a;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import c.e.a.a.b;
import f.b.o.c;

public class a {
    public static final int[] a;
    public static final int[] b;

    public static {
        int[] arrn = new int[]{16842752, b.theme};
        a = arrn;
        int[] arrn2 = new int[]{b.materialThemeOverlay};
        b = arrn2;
    }

    public static Context a(Context context, AttributeSet attributeSet, int n2, int n3) {
        TypedArray typedArray = context.obtainStyledAttributes(attributeSet, b, n2, n3);
        int n4 = typedArray.getResourceId(0, 0);
        typedArray.recycle();
        boolean bl = context instanceof c && ((c)context).a == n4;
        if (n4 != 0) {
            if (bl) {
                return context;
            }
            c c2 = new c(context, n4);
            TypedArray typedArray2 = context.obtainStyledAttributes(attributeSet, a);
            int n5 = typedArray2.getResourceId(0, 0);
            int n6 = typedArray2.getResourceId(1, 0);
            typedArray2.recycle();
            if (n5 == 0) {
                n5 = n6;
            }
            if (n5 != 0) {
                c2.getTheme().applyStyle(n5, true);
            }
            return c2;
        }
        return context;
    }
}

