/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.res.ColorStateList
 *  android.graphics.Color
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.Log
 *  java.lang.Object
 *  java.lang.String
 */
package c.e.a.a.d0;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.util.Log;

public class a {
    public static final boolean a = true;
    public static final int[] b = new int[]{16842910, 16842919};
    public static final String c = a.class.getSimpleName();

    public static ColorStateList a(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (Build.VERSION.SDK_INT <= 27 && Color.alpha((int)colorStateList.getDefaultColor()) == 0 && Color.alpha((int)colorStateList.getColorForState(b, 0)) != 0) {
                Log.w((String)c, (String)"Use a non-transparent color for the default color as it will be used to finish ripple animations.");
            }
            return colorStateList;
        }
        return ColorStateList.valueOf((int)0);
    }

    /*
     * Enabled aggressive block sorting
     */
    public static boolean b(int[] arrn) {
        int n2 = arrn.length;
        boolean bl = false;
        boolean bl2 = false;
        for (int i2 = 0; i2 < n2; ++i2) {
            int n3 = arrn[i2];
            if (n3 == 16842910) {
                bl = true;
                continue;
            }
            if (n3 != 16842908 && n3 != 16842919 && n3 != 16843623) continue;
            bl2 = true;
        }
        boolean bl3 = false;
        if (!bl) return bl3;
        bl3 = false;
        if (!bl2) return bl3;
        return true;
    }
}

