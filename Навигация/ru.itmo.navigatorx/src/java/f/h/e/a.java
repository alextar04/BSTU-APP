/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.graphics.drawable.Drawable
 *  android.os.Bundle
 *  android.os.Process
 *  java.lang.Object
 *  java.lang.String
 */
package f.h.e;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Process;

public class a {
    public static final Object a = new Object();

    public static int a(Context context, String string) {
        return context.checkPermission(string, Process.myPid(), Process.myUid());
    }

    public static int b(Context context, int n2) {
        return context.getColor(n2);
    }

    public static Drawable c(Context context, int n2) {
        return context.getDrawable(n2);
    }

    public static boolean d(Context context, Intent[] arrintent, Bundle bundle) {
        context.startActivities(arrintent, bundle);
        return true;
    }
}

