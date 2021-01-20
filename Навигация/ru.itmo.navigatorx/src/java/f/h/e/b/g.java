/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Typeface
 *  android.os.Handler
 *  android.os.Looper
 *  java.lang.Object
 *  java.lang.Runnable
 */
package f.h.e.b;

import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;

public abstract class g {
    public final void a(final int n2, Handler handler) {
        if (handler == null) {
            handler = new Handler(Looper.getMainLooper());
        }
        handler.post(new Runnable(){

            public void run() {
                g.this.c(n2);
            }
        });
    }

    public final void b(final Typeface typeface, Handler handler) {
        if (handler == null) {
            handler = new Handler(Looper.getMainLooper());
        }
        handler.post(new Runnable(){

            public void run() {
                g.this.d(typeface);
            }
        });
    }

    public abstract void c(int var1);

    public abstract void d(Typeface var1);

}

