/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.content.res.TypedArray
 *  android.graphics.Color
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.util.TypedValue
 *  android.view.View
 *  java.lang.Class
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.ThreadLocal
 *  java.lang.Throwable
 */
package f.b.p;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import f.b.j;
import f.h.f.a;

public class r0 {
    public static final ThreadLocal<TypedValue> a = new ThreadLocal();
    public static final int[] b = new int[]{-16842910};
    public static final int[] c = new int[]{16842908};
    public static final int[] d = new int[]{16842919};
    public static final int[] e = new int[]{16842912};
    public static final int[] f = new int[0];
    public static final int[] g = new int[1];

    public static void a(View view, Context context) {
        TypedArray typedArray = context.obtainStyledAttributes(j.AppCompatTheme);
        try {
            if (!typedArray.hasValue(j.AppCompatTheme_windowActionBar)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("View ");
                stringBuilder.append((Object)view.getClass());
                stringBuilder.append(" is an AppCompat widget that can only be used with a Theme.AppCompat theme (or descendant).");
                Log.e((String)"ThemeUtils", (String)stringBuilder.toString());
            }
            return;
        }
        finally {
            typedArray.recycle();
        }
    }

    public static int b(Context context, int n2) {
        ColorStateList colorStateList = r0.d(context, n2);
        if (colorStateList != null && colorStateList.isStateful()) {
            return colorStateList.getColorForState(b, colorStateList.getDefaultColor());
        }
        TypedValue typedValue = (TypedValue)a.get();
        if (typedValue == null) {
            typedValue = new TypedValue();
            a.set((Object)typedValue);
        }
        context.getTheme().resolveAttribute(16842803, typedValue, true);
        float f2 = typedValue.getFloat();
        int n3 = r0.c(context, n2);
        return a.c(n3, Math.round((float)(f2 * (float)Color.alpha((int)n3))));
    }

    public static int c(Context context, int n2) {
        int[] arrn = g;
        arrn[0] = n2;
        TypedArray typedArray = context.obtainStyledAttributes(null, arrn);
        try {
            int n3 = typedArray.getColor(0, 0);
            return n3;
        }
        finally {
            typedArray.recycle();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static ColorStateList d(Context context, int n2) {
        ColorStateList colorStateList;
        TypedArray typedArray;
        Throwable throwable2;
        block2 : {
            int[] arrn = g;
            arrn[0] = n2;
            typedArray = context.obtainStyledAttributes(null, arrn);
            try {
                int n3;
                if (typedArray.hasValue(0) && (n3 = typedArray.getResourceId(0, 0)) != 0 && (colorStateList = f.b.l.a.a.a(context, n3)) != null) break block2;
                colorStateList = typedArray.getColorStateList(0);
            }
            catch (Throwable throwable2) {}
        }
        typedArray.recycle();
        return colorStateList;
        typedArray.recycle();
        throw throwable2;
    }
}

