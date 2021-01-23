/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Locale
 */
package f.h.j;

import android.text.TextUtils;
import java.util.Locale;

public final class e {
    public static final Locale a = new Locale("", "");

    public static int a(Locale locale) {
        return TextUtils.getLayoutDirectionFromLocale((Locale)locale);
    }
}

