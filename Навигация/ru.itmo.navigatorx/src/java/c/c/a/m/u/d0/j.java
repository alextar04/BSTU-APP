/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.ActivityManager
 *  android.content.Context
 *  android.content.res.Resources
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.text.format.Formatter
 *  android.util.DisplayMetrics
 *  android.util.Log
 *  c.c.a.m.u.d0.j$b
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package c.c.a.m.u.d0;

import android.app.ActivityManager;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;
import c.c.a.m.u.d0.j;

public final class j {
    public final int a;
    public final int b;
    public final Context c;
    public final int d;

    public j(a a2) {
        int n2;
        this.c = a2.a;
        int n3 = a2.b.isLowRamDevice() ? a2.h / 2 : a2.h;
        this.d = n3;
        ActivityManager activityManager = a2.b;
        float f2 = a2.f;
        float f3 = a2.g;
        int n4 = 1024 * (1024 * activityManager.getMemoryClass());
        boolean bl = activityManager.isLowRamDevice();
        float f4 = n4;
        if (bl) {
            f2 = f3;
        }
        int n5 = Math.round((float)(f4 * f2));
        DisplayMetrics displayMetrics = (a2.c).a;
        float f5 = 4 * (displayMetrics.widthPixels * displayMetrics.heightPixels);
        int n6 = Math.round((float)(f5 * a2.e));
        int n7 = Math.round((float)(f5 * a2.d));
        int n8 = n7 + n6;
        if (n8 <= (n2 = n5 - this.d)) {
            this.b = n7;
            this.a = n6;
        } else {
            float f6 = n2;
            float f7 = a2.e;
            float f8 = a2.d;
            float f9 = f6 / (f7 + f8);
            this.b = Math.round((float)(f8 * f9));
            this.a = Math.round((float)(f9 * a2.e));
        }
        if (Log.isLoggable((String)"MemorySizeCalculator", (int)3)) {
            StringBuilder stringBuilder = c.b.a.a.a.c("Calculation complete, Calculated memory cache size: ");
            stringBuilder.append(this.a(this.b));
            stringBuilder.append(", pool size: ");
            stringBuilder.append(this.a(this.a));
            stringBuilder.append(", byte array size: ");
            stringBuilder.append(this.a(this.d));
            stringBuilder.append(", memory class limited? ");
            boolean bl2 = n8 > n5;
            stringBuilder.append(bl2);
            stringBuilder.append(", max size: ");
            stringBuilder.append(this.a(n5));
            stringBuilder.append(", memoryClass: ");
            stringBuilder.append(a2.b.getMemoryClass());
            stringBuilder.append(", isLowMemoryDevice: ");
            stringBuilder.append(a2.b.isLowRamDevice());
            Log.d((String)"MemorySizeCalculator", (String)stringBuilder.toString());
        }
    }

    public final String a(int n2) {
        return Formatter.formatFileSize((Context)this.c, (long)n2);
    }

    /*
     * Exception performing whole class analysis.
     */
    public static final class a {
        public static final int i;
        public final Context a;
        public ActivityManager b;
        public c c;
        public float d;
        public float e;
        public float f;
        public float g;
        public int h;

        public static {
            int n2 = Build.VERSION.SDK_INT < 26 ? 4 : 1;
            i = n2;
        }

        public a(Context context) {
            this.d = 2.0f;
            this.e = i;
            this.f = 0.4f;
            this.g = 0.33f;
            this.h = 4194304;
            this.a = context;
            this.b = (ActivityManager)context.getSystemService("activity");
            this.c = new /* Unavailable Anonymous Inner Class!! */;
            if (Build.VERSION.SDK_INT >= 26 && this.b.isLowRamDevice()) {
                this.e = 0.0f;
            }
        }
    }

    public static interface c {
    }

}

