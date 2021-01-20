/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.os.SystemClock
 *  java.lang.Math
 *  java.lang.Object
 */
package c.c.a.s;

import android.annotation.TargetApi;
import android.os.SystemClock;

public final class f {
    public static final double a = 1.0 / Math.pow((double)10.0, (double)6.0);

    public static double a(long l2) {
        return (double)(SystemClock.elapsedRealtimeNanos() - l2) * a;
    }

    @TargetApi(value=17)
    public static long b() {
        return SystemClock.elapsedRealtimeNanos();
    }
}

