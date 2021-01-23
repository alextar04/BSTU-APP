/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.os.Build
 *  android.os.Build$VERSION
 *  java.lang.Object
 */
package f.h.d;

import android.app.Activity;
import android.os.Build;
import f.h.d.b;

public class a
extends f.h.e.a {
    public static void e(Activity activity) {
        activity.finishAffinity();
    }

    public static a f() {
        return null;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static void g(Activity activity) {
        if (Build.VERSION.SDK_INT < 28 && b.b(activity)) {
            return;
        }
        activity.recreate();
    }

}

