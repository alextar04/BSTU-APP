/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.content.res.TypedArray
 *  android.util.AttributeSet
 *  android.util.TypedValue
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 */
package c.e.a.a.a0;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import c.b.a.a.a;
import c.e.a.a.b;
import c.e.a.a.k;

public final class j {
    public static final int[] a;
    public static final int[] b;

    public static {
        int[] arrn = new int[]{b.colorPrimary};
        a = arrn;
        int[] arrn2 = new int[]{b.colorPrimaryVariant};
        b = arrn2;
    }

    public static void a(Context context, AttributeSet attributeSet, int n2, int n3) {
        TypedArray typedArray = context.obtainStyledAttributes(attributeSet, k.ThemeEnforcement, n2, n3);
        boolean bl = typedArray.getBoolean(k.ThemeEnforcement_enforceMaterialTheme, false);
        typedArray.recycle();
        if (bl) {
            TypedValue typedValue = new TypedValue();
            if (!context.getTheme().resolveAttribute(b.isMaterialTheme, typedValue, true) || typedValue.type == 18 && typedValue.data == 0) {
                j.c(context, b, "Theme.MaterialComponents");
            }
        }
        j.c(context, a, "Theme.AppCompat");
    }

    public static /* varargs */ void b(Context context, AttributeSet attributeSet, int[] arrn, int n2, int n3, int ... arrn2) {
        boolean bl;
        TypedArray typedArray;
        block6 : {
            block8 : {
                block7 : {
                    typedArray = context.obtainStyledAttributes(attributeSet, k.ThemeEnforcement, n2, n3);
                    if (!typedArray.getBoolean(k.ThemeEnforcement_enforceTextAppearance, false)) {
                        typedArray.recycle();
                        return;
                    }
                    if (arrn2 == null || arrn2.length == 0) break block7;
                    TypedArray typedArray2 = context.obtainStyledAttributes(attributeSet, arrn, n2, n3);
                    int n4 = arrn2.length;
                    for (int i2 = 0; i2 < n4; ++i2) {
                        if (typedArray2.getResourceId(arrn2[i2], -1) != -1) continue;
                        typedArray2.recycle();
                        bl = false;
                        break block6;
                    }
                    typedArray2.recycle();
                    break block8;
                }
                int n5 = typedArray.getResourceId(k.ThemeEnforcement_android_textAppearance, -1);
                bl = false;
                if (n5 == -1) break block6;
            }
            bl = true;
        }
        typedArray.recycle();
        if (bl) {
            return;
        }
        throw new IllegalArgumentException("This component requires that you specify a valid TextAppearance attribute. Update your app theme to inherit from Theme.MaterialComponents (or a descendant).");
    }

    public static void c(Context context, int[] arrn, String string) {
        boolean bl;
        block2 : {
            TypedArray typedArray = context.obtainStyledAttributes(arrn);
            for (int i2 = 0; i2 < arrn.length; ++i2) {
                if (typedArray.hasValue(i2)) continue;
                typedArray.recycle();
                bl = false;
                break block2;
            }
            typedArray.recycle();
            bl = true;
        }
        if (bl) {
            return;
        }
        throw new IllegalArgumentException(a.k("The style on this component requires your app theme to be ", string, " (or a descendant)."));
    }

    public static /* varargs */ TypedArray d(Context context, AttributeSet attributeSet, int[] arrn, int n2, int n3, int ... arrn2) {
        j.a(context, attributeSet, n2, n3);
        j.b(context, attributeSet, arrn, n2, n3, arrn2);
        return context.obtainStyledAttributes(attributeSet, arrn, n2, n3);
    }
}

